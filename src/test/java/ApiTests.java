import io.restassured.http.ContentType;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class ApiTests {

  private static final String SPACEX_URL = "https://api.spacex.land/graphql";
  private static final String GET_LAUNCHES_FILE_PATH = "src/test/resources/api/getAllLaunches.json";
  private static final String GET_LIMITED_LAUNCHES_FILE_PATH = "src/test/resources/api/getLimitedLaunches.json";
  private static final String GET_LAUNCHES_WITH_OFFSET = "src/test/resources/api/getLaunchesWithOffset.json";

  /**
   * Write a test that queries the API for all launches and returns the number of launches
   *   * Assert status code is 200
   *   * Assert mission name object is not empty
   *   * Assert that the number of launches is greater than 0
   *   * Assert that that the number of ships is greater than 0
   *   * Assert the first stage & second stage are not null
   *
   */
  @Test(description = "Get all launches")
  public void getAllLaunches() throws JSONException {
    String response = getResponse(GET_LAUNCHES_FILE_PATH);
    validateResponse(response);
  }

  /**
   * Write a test to update the limit parameter and returns the number of launches Ex: limit=2
   *   * Assert status code is 200
   *   * Assert mission name object is not empty
   *   * Assert that the number of launches is greater than 0
   *   * Assert that that the number of ships is greater than 0
   *   * Assert the first stage & second stage are not null
   */
  @Test(description = "Get launches with limit")
  public void getLimitedLaunches() throws JSONException {
    String response = getResponse(GET_LIMITED_LAUNCHES_FILE_PATH);
    validateResponse(response);
  }

  /**
   * Write a test to update the offset parameter and returns the number of launches Ex: offset=2
   *   * Assert status code is 200
   *   * Assert mission name object is not empty
   *   * Assert that the number of launches is greater than 0
   *   * Assert that that the number of ships is greater than 0
   *   * Assert the first stage & second stage are not null
   */
  @Test(description = "Get launches with offset")
  public void getLaunchesWithOffset() throws JSONException {
    String response = getResponse(GET_LAUNCHES_WITH_OFFSET);
    validateResponse(response);
  }

  private void validateResponse(String response) throws JSONException {
    JSONObject data = new JSONObject(response);
    JSONArray launches = data.getJSONObject("data").getJSONArray("launches");
//    Assert that the number of launches is greater than 0
    Assert.assertTrue(launches.length() > 0);
    for (int i = 0; i < launches.length(); i++) {
      JSONObject launch = launches.getJSONObject(i);
//      Assert that that the number of ships is greater than 0
      Assert.assertTrue(launch.getJSONArray("ships").length() > 0);
//      Assert mission name object is not empty
      Assert.assertNotNull(launch.getString("mission_name"));
      Assert.assertNotEquals(launch.getString("mission_name"), "");
      JSONObject rocket = launch.getJSONObject("rocket");
//      Assert the first stage & second stage are not null
      Assert.assertNotNull(rocket.getJSONObject("first_stage"));
      Assert.assertNotNull(rocket.getJSONObject("second_stage"));
    }
  }

  private String getResponse(String inputFile) {
    File inputObject = new File(inputFile);
    return given()
        .body(inputObject)
        .contentType(ContentType.JSON)
        .expect()
//         Assert status code is 200
        .statusCode(200)
        .when()
        .post(SPACEX_URL).getBody().asString();
  }
}