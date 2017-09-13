package me.ashif.locationshift;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import me.ashif.locationshift.ui.MapsActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Ashif on 13/9/17,September,2017
 * github.com/SheikhZayed
 */

@RunWith(AndroidJUnit4.class)
public class MapsActivityTest {
  @Rule public ActivityTestRule<MapsActivity> activityRule =
      new ActivityTestRule<>(MapsActivity.class, true, true);


  /**
   * testing if the map is visible on load or not
   */
  @Test
  public void testIsMapVisibleOnLoad(){
    SystemClock.sleep(3000);
    onView(withId(R.id.map)).check(matches(isDisplayed()));
  }
}
