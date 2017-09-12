package me.ashif.locationshift.api;

import me.ashif.locationshift.model.DistanceResponse;
import me.ashif.locationshift.utils.AppConstants;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ashif on 12/9/17,September,2017
 * github.com/SheikhZayed
 */

public interface RESTService {
  @GET("api/directions/json?key="+ AppConstants.API_KEY) Call<DistanceResponse> getRouteDetails(@Query("units") String units, @Query("origin") String origin,
      @Query("destination") String destination, @Query("mode") String mode);
}
