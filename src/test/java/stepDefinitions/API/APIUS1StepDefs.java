package stepDefinitions.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import stepDefinitions.SharedData;
import utils.ConfigReader;
import org.json.simple.JSONObject;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APIUS1StepDefs {
    SharedData sharedData;

    public APIUS1StepDefs(SharedData sharedData) {
        this.sharedData = sharedData;

    }


    @Given("the request {string} header is set to {string}")
    public void the_header_is_set_to(String key, String value) {
        sharedData.getRequestSpecification().header(key, value);
    }

    @When("I send a {string} request to the endpoint {string}")
    public void i_send_a_request_to_the_endpoint(String method, String endpoint) {
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

    @Then("the response log should be displayed")
    public void the_response_log_should_be_displayed() {
        sharedData.getResponse().then().log().all();
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        sharedData.getResponse().then().statusCode(statusCode);
    }

    @Then("the response {string} header should be {string}")
    public void the_response_header_should_be(String key, String value) {
        sharedData.getResponse().then().header(key, value);
    }

    @Then("the response time should be less than {long} ms")
    public void the_response_time_should_be_less_than_ms(Long ms) {
        sharedData.getResponse().then().time(lessThan(ms));
    }

    @Then("the users amount should be {int}")
    public void the_users_amount_should_be(int amount) {
//        List<Map<String, Object>> users  = sharedData.getResponse().then().
//                extract().path("$");
//
//        Assert.assertEquals(amount, users.size());

        sharedData.getResponse().then().body("$", hasSize(amount));
    }

    @Then("the response should contain a list of all users with the following fields")
    public void the_response_should_contain_a_list_of_all_users_with_the_following_fields(List<String> expectedKeys) {

        for (String key : expectedKeys) {
            sharedData.getResponse().then().body("[0]", hasKey(key));
        }

    }

    @Then("the response body should have {string} field with value {string}")
    public void theResponseBodyShouldHaveFieldWithValue(String key, String value) {
        sharedData.getResponse().then().body(key, equalTo(value));
    }

    @Given("the request is not authenticated with a valid API key")
    public void theRequestIsNotAuthenticatedWithAValidAPIKey() {

        sharedData.getRequestSpecification().
                queryParam("api_key", "invalidKey");
    }

    @Given("the request is authenticated with a valid API key")
    public void the_request_is_authenticated_with_a_valid_api_key() {
        sharedData.getRequestSpecification().
                queryParam("api_key", ConfigReader.getProperty("api.key.duobank"));

    }

    @Given("the JWT token is generated and stored")
    public void the_JWT_token_is_generated_and_stored() {
        RestAssured.baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";


        JSONObject jsonBody = new JSONObject();
        jsonBody.put("username", "coolguy");
        jsonBody.put("email", "coolguy@mail.com");
        jsonBody.put("password", "coolGuy123!");

        // Send the login request and extract the access token
        String access_token = given()
                .queryParam("api_key", ConfigReader.getProperty("api.key.duobank"))
                .header("Accept", "application/json")
                .header("Content-type", "application/json")
                .body(jsonBody.toString())
                .when().log().all()
                .post("/login")
                .then().log().all().statusCode(200)
                .extract().path("access_token");

        // Store the access token in the shared data instance
        sharedData.setJWTToken(access_token);
    }

        @Given("the request Authorization header is set to a valid JWT token")
        public void the_request_header_is_set_to_a_valid_jwt_token (){
            // JWT token should have been generated and stored previously in shared data
            sharedData.getRequestSpecification()
                    .header("Authorization", "Bearer " + sharedData.getJWTToken());
        }

        @Given("the request \"Content-type\" header is set to \"application/json\"")
        public void the_request_Content_type_header_is_set_to_application_json () {
            sharedData.getRequestSpecification()
                    .header("Content-type", "application/json");
        }

        @Then("the response \"Content-Type\" header should be \"application/json; charset=UTF-8\"")
        public void the_response_Content_Type_header_should_be_application_json_charset_UTF_8 () {
            sharedData.getResponse().then().header("Content-Type", "application/json; charset=UTF-8");
        }
    }


