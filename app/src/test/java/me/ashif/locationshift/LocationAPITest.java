package me.ashif.locationshift;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import me.ashif.locationshift.api.RESTService;
import me.ashif.locationshift.model.DistanceResponse;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okio.BufferedSource;
import okio.Okio;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ashif on 9/10/2017.
 */

@RunWith(JUnit4.class)
public class LocationAPITest {

  private RESTService restService;
  private MockWebServer mockWebServer;
  private String testAddress = "65/4A, 4th Main Rd, Govindaraja Nagar Ward, Priyadarshini Layout, Vijaya Nagar, Bengaluru, Karnataka 560079, India";


  @Before public void createService() throws IOException {
    mockWebServer = new MockWebServer();
    restService = new Retrofit.Builder().baseUrl(mockWebServer.url(" ").toString())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RESTService.class);
  }

  @After public void teardown() throws IOException {
    mockWebServer.shutdown();
  }

  @Test public void getLocationDetailsNotEmpty() throws IOException {
    BufferedSource source = enqueueResponse("response.json");
    mockWebServer.enqueue(new MockResponse().setBody(source.readString(StandardCharsets.UTF_8)));

    Call<DistanceResponse> call = restService.getRouteDetails("foo","foo","foo","foo");

    Assert.assertTrue(call.execute() != null);
  }

  @Test public void getStatusOK() throws IOException {
    BufferedSource source = enqueueResponse("response.json");
    mockWebServer.enqueue(new MockResponse().setBody(source.readString(StandardCharsets.UTF_8)));

    Call<DistanceResponse> call = restService.getRouteDetails("foo","foo","foo","foo");

    Assert.assertEquals("OK",
        call.execute().body().getStatus());
  }

  @Test
  public void getAddressShouldMatchMockAddress() throws IOException {
    BufferedSource source = enqueueResponse("response.json");
    mockWebServer.enqueue(new MockResponse().setBody(source.readString(StandardCharsets.UTF_8)));

    Call<DistanceResponse> call = restService.getRouteDetails("foo","foo","foo","foo");

    Assert.assertEquals(testAddress,call.execute().body().getRoutes().get(0).getLegs().get(0).getEnd_address());
  }

  private BufferedSource enqueueResponse(String fileName) throws IOException {
    InputStream inputStream =
        getClass().getClassLoader().getResourceAsStream("api-response/" + fileName);
    BufferedSource source = Okio.buffer(Okio.source(inputStream));

    return source;
  }
}
