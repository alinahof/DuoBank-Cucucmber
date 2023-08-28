package stepDefinitions.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.hamcrest.Matchers;
import org.junit.Assert;
import pojos.User;
import stepDefinitions.SharedData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class US7LoginStepDefs {

    SharedData sharedData;

    public US7LoginStepDefs (SharedData sharedData) {
        this.sharedData = sharedData;
    }


    @Given("the API endpoint accepts a {string} request to {string} resource")
    public void theAPIEndpointAcceptsARequestToResource(String method, String endpoint) {
        switch (method) {
            case "GET" -> sharedData.setResponse(sharedData.getRequestSpecification().when().log().all().get(endpoint));
            case "POST" ->
                    sharedData.setResponse(sharedData.getRequestSpecification().when().log().all().post(endpoint));
            case "PUT" -> sharedData.setResponse(sharedData.getRequestSpecification().when().log().all().put(endpoint));
            case "PATCH" ->
                    sharedData.setResponse(sharedData.getRequestSpecification().when().log().all().patch(endpoint));
            case "DELETE" ->
                    sharedData.setResponse(sharedData.getRequestSpecification().when().log().all().delete(endpoint));
            default -> throw new IllegalArgumentException(method + ": This request method is invalid.");
        }
    }
    @Given("the API requires authentication via API key")
    public void the_api_requires_authentication_via_api_key() {
        sharedData.getRequestSpecification().
                queryParam("api_key", "invalidKey");
    }
    @Given("the request contains a body payload with valid user {string} and {string}")
    public void the_request_contains_a_body_payload_with_valid_user_email_and_password(String email, String password) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("email", email);
        payload.put("password", password);

        given().contentType(ContentType.JSON).body(payload);
    }
    @When("the user makes a {string} request to {string}")
    public void theUserMakesARequestTo(String method, String endpoint) {
        switch (method) {
            case "GET" -> sharedData.setResponse(sharedData.getRequestSpecification().when().log().all().get(endpoint));
            case "POST" ->
                    sharedData.setResponse(sharedData.getRequestSpecification().when().log().all().post(endpoint));
            case "PUT" -> sharedData.setResponse(sharedData.getRequestSpecification().when().log().all().put(endpoint));
            case "PATCH" ->
                    sharedData.setResponse(sharedData.getRequestSpecification().when().log().all().patch(endpoint));
            case "DELETE" ->
                    sharedData.setResponse(sharedData.getRequestSpecification().when().log().all().delete(endpoint));
            default -> throw new IllegalArgumentException(method + ": This request method is invalid.");
        }
    }

//    @Then("the response status code should be {int}")
//    public void the_response_status_code_should_be(Integer statusCode) {
//        sharedData.getResponse().then().statusCode(statusCode);
//    }
//    @Then("the response {string} header should be {string}")
//    public void the_response_content_type_header_should_be(String key, String value) {
//        sharedData.getResponse().then().header(key, value);
//    }
    @And("the response log should contain {string}: true")
    public void theResponseLogShouldContainTrue() {
        User user =  sharedData.getResponse().as(User.class);
        System.out.println(user.getModified_at());
    }
    @Then("the response body should contain a non-empty {string} field")
    public void the_response_body_should_contain_a_non_empty_field(String fieldName) {
        String responseBody = sharedData.getResponse().getBody().asString();
        String fieldValue = JsonPath.from(responseBody).getString(fieldName);
        Assert.assertNotNull(fieldValue);
        Assert.assertFalse(fieldValue.isEmpty());
    }
    @Then("the response body should contain {string}: {string}")
    public void the_response_body_should_contain(String key, String value) {
        String responseBody = sharedData.getResponse().getBody().asString();
        String actualValue = JsonPath.from(responseBody).getString(key);
        Assert.assertEquals(value, actualValue);
    }
    @Then("the response body should contain {string} field")
    public void the_response_body_should_contain_field(String fieldName) {
        String responseBody = sharedData.getResponse().getBody().asString();
        sharedData.getResponse().then().assertThat().body(fieldName, Matchers.notNullValue());
    }
    @And("the response time is less than {int} ms")
    public void theResponseTimeIsLessThanMs(Long ms) {
        sharedData.getResponse().then().time(Matchers.lessThan(ms));
    }

    @When("the user makes a {string} request to {string} without an API key")
    public void theUserMakesARequestToWithoutAnAPIKey(String arg0, String arg1) {
    }

    @And("the response body should contain {string} message: {string}")
    public void theResponseBodyShouldContainMessage(String key, String value) {
        sharedData.getResponse().then().body(key, equalTo(value));

    }

    @And("the request contains a body payload with invalid email format")
    public void theRequestContainsABodyPayloadWithInvalidEmailFormat() {
        String invalidPayload = "{\"email\":\"invalid_email\",\"password\":\"securePassword\"}";
        given().body(invalidPayload);   
    }


    @And("the request contains a body payload with missing email or password fields")
    public void theRequestContainsABodyPayloadWithMissingEmailOrPasswordFields() {
        Map<String, Object> invalidPayload = new HashMap<>();
        invalidPayload.put("email", "");
        invalidPayload.put("password", "abcdef1234");

        given().body(invalidPayload);
    }

    @And("the request contains a body payload with correct email but incorrect password")
    public void theRequestContainsABodyPayloadWithCorrectEmailButIncorrectPassword() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("email", "johnD@example.com");
        payload.put("password", "123455....");

        given().body(payload);
    }

    @And("the request contains a body payload with correct password but incorrect email")
    public void theRequestContainsABodyPayloadWithCorrectPasswordButIncorrectEmail() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("email", "john.com");
        payload.put("password", "JohnDoe123!");

        given().body(payload);
    }


    @And("there's an error on the server side")
    public void thereSAnErrorOnTheServerSide() {
        int statusCode = sharedData.getResponse().getStatusCode();
        Assert.assertTrue(statusCode > 500);
    }


    @And("the request contains a body payload with valid user email and password")
    public void theRequestContainsABodyPayloadWithValidUserEmailAndPassword() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("email", "valid@example.com");
        payload.put("password", "securePassword");

        given().body(payload);
    }
}
