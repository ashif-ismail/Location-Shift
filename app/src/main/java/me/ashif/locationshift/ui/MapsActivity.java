package me.ashif.locationshift.ui;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.location.DetectedActivity;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import io.nlopez.smartlocation.OnActivityUpdatedListener;
import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.providers.LocationGooglePlayServicesProvider;
import java.util.ArrayList;
import java.util.List;
import me.ashif.locationshift.R;
import me.ashif.locationshift.model.DataManager;
import me.ashif.locationshift.model.DistanceResponse;
import me.ashif.locationshift.utils.ConnectionUtils;
import me.ashif.locationshift.utils.DialogUtils;

import static me.ashif.locationshift.utils.MapUtils.decodePoly;

/**
 * @author Ashif Ismail
 */

public class MapsActivity extends FragmentActivity
    implements OnMapReadyCallback, OnLocationUpdatedListener, OnActivityUpdatedListener,
    DataManager.OnResponseCompleted {

  private static final int LOCATION_PERMISSION_ID = 007;
  private static final String TAG = MapsActivity.class.getSimpleName();
  @BindView(R.id.button_start) Button mStartButton;
  @BindView(R.id.button_stop) Button mStopButton;
  private GoogleMap mMap;
  private DialogUtils mDialogUtils;
  private double mCurrentLat, mCurrentLong;
  private double mFinalLat, mFinalLong;
  private DataManager mDataManager;
  private Polyline mPolyline;
  private ArrayList<LatLng> mMarkerpointList;
  private ConnectionUtils mConnectionUtils;
  private boolean mIsMapReady;
  private DistanceResponse mDistanceResponse;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maps);
    ButterKnife.bind(this);
    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    SupportMapFragment mapFragment =
        (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);

    initViews();
    initObjects();

    if (ContextCompat.checkSelfPermission(MapsActivity.this,
        Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
      ActivityCompat.requestPermissions(MapsActivity.this,
          new String[] { Manifest.permission.ACCESS_FINE_LOCATION }, LOCATION_PERMISSION_ID);
      return;
    }
  }

  private boolean checkIfLocationEnabled() {
    LocationManager locationManager =
        (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
    boolean gpsEnabled = false;

    try {
      gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    } catch (Exception ex) {
    }
    if (!gpsEnabled) {
      mDialogUtils.showGenericDialog("Hmm,smells like Location is disabled", "Error",
          (d, i) -> openLocationSettings());
    }
    return gpsEnabled;
  }

  private void openLocationSettings() {
    Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
    startActivity(myIntent);
  }

  private void setCamera(double lat, double lng) {
    mDialogUtils.ShowProgressDialog(getString(R.string.text_progress));
    final Handler handler = new Handler();
    final Runnable runnable = () -> mDialogUtils.dismissProgress();
    handler.postDelayed(runnable, 3000);

    LatLng currentLatLng = new LatLng(lat, lng);
    mMap.addMarker(new MarkerOptions().position(currentLatLng));
    CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(mCurrentLat, mCurrentLong));
    CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
    mMap.moveCamera(center);
    mMap.animateCamera(zoom);
    mMarkerpointList.add(currentLatLng);
  }

  private void initObjects() {
    mDialogUtils = new DialogUtils(MapsActivity.this);
    mDataManager = new DataManager(this);
    mMarkerpointList = new ArrayList<>();
    mConnectionUtils = new ConnectionUtils(MapsActivity.this);
  }

  private void initViews() {
    //disabling the stop button initially
    mStopButton.setEnabled(false);
  }

  @Override public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;
    mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    mMap.setTrafficEnabled(false);
    mIsMapReady = true;
  }

  @OnClick(R.id.button_start) public void onStartLocationClicked() {
    // TODO: 9/13/2017 check required
    if (mPolyline != null) {
      mPolyline.remove();
    }
    startLocationTrack();
    //disable this button and enable stop button
    mStartButton.setEnabled(false);
    mStopButton.setEnabled(true);

    //todo check required
    if (mMarkerpointList.size() > 2) {
      mMap.clear();
      mMarkerpointList.clear();
      mMap.addMarker(new MarkerOptions().position(new LatLng(mFinalLat, mFinalLong)));
    }

  }

  @OnClick(R.id.button_stop) public void onStopLocationClicked() {

    stopLocationTrack();

    //disable this button and enable start button
    mStopButton.setEnabled(false);
    mStartButton.setEnabled(true);
  }

  private void stopLocationTrack() {
    //stop location tracking
    SmartLocation.with(MapsActivity.this).location().stop();
    if (!mConnectionUtils.isNetworkAvailable()) {
      mDialogUtils.showGenericDialog("Hmm,smells like there's no Data Connection", "Error",
          (d, i) -> openDataSettings());
    } else {
      getETADetails();
    }
  }

  private void openDataSettings() {
    Intent intent = new Intent(Intent.ACTION_MAIN);
    intent.setComponent(new ComponentName("com.android.settings",
        "com.android.settings.Settings$DataUsageSummaryActivity"));
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
    startActivity(intent);
  }

  private void startLocationTrack() {
    LocationGooglePlayServicesProvider provider = new LocationGooglePlayServicesProvider();
    provider.setCheckLocationSettings(true);
    SmartLocation smartLocation = new SmartLocation.Builder(this).logging(false).build();
    smartLocation.location(provider).start(this);
    smartLocation.activity().start(this);

    if (mIsMapReady && getLastKnownLocation() != null) {
      mCurrentLat = getLastKnownLocation().getLatitude();
      mCurrentLong = getLastKnownLocation().getLongitude();
      setCamera(mCurrentLat, mCurrentLong);
      mIsMapReady = false;
    }
  }

  @Override public void onLocationUpdated(Location location) {
    mFinalLat = location.getLatitude();
    mFinalLong = location.getLongitude();
  }

  @Override public void onActivityUpdated(DetectedActivity detectedActivity) {

  }

  public void getETADetails() {
    mDataManager.getRouteDetails("metric",
        String.valueOf(mCurrentLat) + "," + String.valueOf(mCurrentLong),
        String.valueOf(mFinalLat) + "," + String.valueOf(mFinalLong), "walking");
    mDialogUtils.ShowProgressDialog(getString(R.string.text_progress));
  }

  private void setFinalMarker() {
    LatLng finalLatLong = new LatLng(mFinalLat, mFinalLong);
    MarkerOptions markerOptions = new MarkerOptions();
    markerOptions.position(finalLatLong);
    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
    Marker finalLocationMarker = mMap.addMarker(markerOptions);

    mMarkerpointList.add(finalLatLong);
  }

  private void addPolyline(DistanceResponse distanceResponse) {
    try {
      if (mPolyline != null) {
        mPolyline.remove();
      }
      for (int i = 0; i < distanceResponse.getRoutes().size(); i++) {
        String distance =
            distanceResponse.getRoutes().get(i).getLegs().get(i).getDistance().getText();
        String time = distanceResponse.getRoutes().get(i).getLegs().get(i).getDuration().getText();
        mDialogUtils.showETADetails(distance, time);
        String encodedString =
            distanceResponse.getRoutes().get(0).getOverview_polyline().getPoints();
        List<LatLng> list = decodePoly(encodedString);
        mPolyline = mMap.addPolyline(
            new PolylineOptions().addAll(list).width(20).color(Color.RED).geodesic(true));
      }
    } catch (Exception e) {
      e.printStackTrace();
      Log.d(TAG, "addPolyline: " + e.getMessage());
    }
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    if (requestCode == LOCATION_PERMISSION_ID
        && grantResults.length > 0
        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
      startLocationTrack();
    }
  }

  private Location getLastKnownLocation() {
    LocationManager LocationManager =
        (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
    List<String> providers = LocationManager.getProviders(true);
    Location bestLocation = null;
    for (String provider : providers) {
      Location l = LocationManager.getLastKnownLocation(provider);
      if (l == null) {
        continue;
      }
      if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
        // Found best last known location: %s", l);
        bestLocation = l;
      }
    }
    return bestLocation;
  }

  @Override public void responseCompleted(DistanceResponse distanceResponse) {
    //network call completed
    setFinalMarker();
    addPolyline(distanceResponse);
    //dismiss the dialog,if any
    mDialogUtils.dismissProgress();
  }
}
