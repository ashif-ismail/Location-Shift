package me.ashif.locationshift.model;

import me.ashif.locationshift.api.APIManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ashif on 12/9/17,September,2017
 * github.com/SheikhZayed
 */

public class DataManager implements DataFactory {

  private static final String TAG = DataManager.class.getSimpleName();
  private OnResponseCompleted onResponseCompleted;

  public DataManager(OnResponseCompleted onResponseCompleted) {
    this.onResponseCompleted = onResponseCompleted;
  }

  @Override
  public void getRouteDetails(String units, String origin, String destination, String mode) {
    APIManager.getClient()
        .getRouteDetails(units, origin, destination, mode)
        .enqueue(new Callback<DistanceResponse>() {
          @Override
          public void onResponse(Call<DistanceResponse> call, Response<DistanceResponse> response) {
            if (response.isSuccessful()) {
              onResponseCompleted.responseCompleted(response.body());
            }
          }

          @Override public void onFailure(Call<DistanceResponse> call, Throwable t) {
            t.printStackTrace();
          }
        });
  }

  public interface OnResponseCompleted {
    void responseCompleted(DistanceResponse distanceResponse);
  }
}

