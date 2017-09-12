package me.ashif.locationshift.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static me.ashif.locationshift.utils.AppConstants.BASE_URL;

/**
 * Created by Ashif on 12/9/17,September,2017
 * github.com/SheikhZayed
 */

public class APIManager {

  private static RESTService retrofit = null;

  public static RESTService getClient() {
    if (retrofit==null) {
      retrofit = new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build()
          .create(RESTService.class);
    }
    return retrofit;
  }
}
