package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.lessThan;

public class APIUS1StepDefs {
    SharedData sharedData;

    public APIUS1StepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }


    @Given("The base uri is set")
    public void the_base_uri_is_set() {

    }

    @Then("you verify that the JSON has following fileds")
    public void you_verify_that_the_json_has_following_fileds(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, Object>> users = sharedData.getResponse().jsonPath().getList("");
        Map<String, Object> firstUser = users.get(0);

        List<String> expectedColumns = dataTable.asList(String.class);

        for (String columnName : expectedColumns) {
            assertThat(firstUser, hasKey(columnName));
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

