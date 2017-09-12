package me.ashif.locationshift.model;

/**
 * Created by Ashif on 12/9/17,September,2017
 * github.com/SheikhZayed
 */

public interface APIFactory {
  DistanceResponse getRouteDetails(String units, String origin, String destination, String mode);
}
