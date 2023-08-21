package stepDefinitions.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import stepDefinitions.SharedData;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class US3PostStepDefs {

    SharedData sharedData;

    public US3PostStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("the request is authenticated with a valid API key")
    public void the_request_is_authenticated_with_a_valid_api_key() {
        sharedData.getRequestSpecification().
                queryParam("api_key", ConfigReader.getProperty("API_KEY"));

    }
    @Then("the response log should be displayed")
    public void the_response_log_should_be_displayed() {
        sharedData.getResponse().then().log().all();
    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer code) {
        sharedData.getResponse().then().statusCode(code);
    }

    @Given("the request is not authenticated with a valid API key")
    public void theRequestIsNotAuthenticatedWithAValidAPIKey() {
        sharedData.getRequestSpecification().
                queryParam("api_key", "invalidKey");
    }

    @Then("the response body should have {string} field with value {string}")
    public void theResponseBodyShouldHaveFieldWithValue(String key, String value) {
        sharedData.getResponse().then().body(key, equalTo(value));
    }

    @And("the request {string} header is set to {string}")
    public void theRequestHeaderIsSetTo(String key, String value) {
        sharedData.getRequestSpecification().header(key, value);
    }

    @Given("the request body is set to the following payload")
    public void the_request_body_is_set_to_the_following_payload(String body) {
        sharedData.getRequestSpecification().body(body);
    }

    @Then("the response {string} header should be {string}")
    public void the_response_header_should_be(String key, String value) {
        sharedData.getResponse().then().header(key, value);
    }
    @Then("the response time should be less than {int} ms")
    public void the_response_time_should_be_less_than_ms(Long ms) {
        sharedData.getResponse().then().time(lessThan(ms));

    }
    @Then("I delete the created user")
    public void i_delete_the_created_user() {
        Integer userId =   sharedData.getResponse().path("user_id");

        sharedData.setRequestSpecification(given().queryParam("id", userId).queryParam("api_key", ConfigReader.getProperty("API_KEY")));

        sharedData.getRequestSpecification().when().log().all().delete("/user").then().log().all().assertThat().statusCode(200);


    }
}
