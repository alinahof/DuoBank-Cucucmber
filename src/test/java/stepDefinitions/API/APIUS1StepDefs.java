package stepDefinitions.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import stepDefinitions.SharedData;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class APIUS1StepDefs {
    SharedData sharedData;

    public APIUS1StepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }


    @Given("The base uri is set")
    public void the_base_uri_is_set() {

    }

    @Then("the response should contain a list of all users with the following fields")
    public void the_response_should_contain_a_list_of_all_users_with_the_following_fields(List<String> expectedKeys) {

        for (String key : expectedKeys) {
            sharedData.getResponse().then().body("[0]", hasKey(key));
        }
    }

    @Given("{string} header is set to {string}")
    public void header_is_set_to(String key, String value) {
        sharedData.getRequestSpecification().
                header(key, value);

    }
    @Given("{string} path Parameter is set to {string}")
    public void path_parameter_is_set_to(String key, String value) {
        sharedData.getRequestSpecification().pathParam(key, value);

    }
    @Given("{string} query Parameter is set to {string}")
    public void query_parameter_is_set_to(String key, String value) {
        sharedData.getRequestSpecification().queryParam(key, value);
    }


    @When("I send a {string} request to endpoint {string}")
    public void i_send_a_request_to_endpoint(String requestMethod, String endpoint) {
        sharedData.setResponse(sharedData.getRequestSpecification().when().log().all().get(endpoint));


    }
    @Then("the status code should be {int}")
    public void the_status_code_should_be(Integer status) {
        sharedData.getResponse().then(). log().all().
                assertThat().
                statusCode((status));

    }
    @Then("response time should be less than {long} ms")
    public void response_time_should_be_less_than_ms(Long time) {
        sharedData.getResponse().then(). log().all().
                assertThat().
                time(lessThan(time));
    }
}

