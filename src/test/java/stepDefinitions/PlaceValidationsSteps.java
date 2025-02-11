package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import ui.GooglePageObject;
import ui.Utils;
import ui.pojo.Location;
import ui.pojo.RequestPostGoogleMaps;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PlaceValidationsSteps extends Utils {

    RequestSpecification res;
    ResponseSpecification responseReq;
    Response response;

    GooglePageObject googlePageObject = new GooglePageObject();

    @Given("Add Place Payload")
    public void addPlacePayload() {
        res = given().spec(requestSpecification()).body(googlePageObject.addPlacePayload());
    }

    @When("User calls {string} with Post http request")
    public void userCallsWithPostHttpRequest(String arg0) {

        responseReq = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        response = res.when().post(" /maps/api/place/add/json").then().spec(responseReq).extract().response();
    }

    @Then("The API call got success with status code is {int}")
    public void theAPICallGotSuccessWithStatusCodeIs(int arg0) {
        assertEquals(response.getStatusCode(),200);

    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String key, String value) {
        String statusCode = response.asString();
        JsonPath js = new JsonPath(statusCode);
        assertEquals(js.get(key).toString(), value);
    }


}
