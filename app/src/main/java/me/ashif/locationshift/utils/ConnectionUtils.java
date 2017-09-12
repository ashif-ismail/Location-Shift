package me.ashif.locationshift.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Ashif on 12/9/17,September,2017
 * github.com/SheikhZayed
 */

public class ConnectionUtils {

  private Context mContext;

  public ConnectionUtils(Context mContext) {
    this.mContext = mContext;
  }

  public boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager
        = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = null;
    if (connectivityManager != null) {
      activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    }
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }
}
