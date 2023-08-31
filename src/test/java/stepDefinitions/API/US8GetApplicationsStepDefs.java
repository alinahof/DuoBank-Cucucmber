package stepDefinitions.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import stepDefinitions.SharedData;
import utils.DBUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasKey;

public class US8GetApplicationsStepDefs {
    SharedData sharedData;

    public US8GetApplicationsStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }


    @And("the JWT token is set in the header")
    public void theJWTTokenIsSetInTheHeader() {
        sharedData.getRequestSpecification().header("Authorization", sharedData.getJWTToken());
    }

    @And("the response should contain a list of all applicants with the following fields")
    public void theResponseShouldContainAListOfAllApplicantsWithTheFollowingFields(List<String> expectedKeys) {

        for (String key : expectedKeys) {
            sharedData.getResponse().then().body("mortagage_applications[0]", hasKey(key));

        }
    }

    @Then("the response should contain a list of all applications' {string}")
    public void the_response_should_contain_a_list_of_all_applications(String id) {

        sharedData.setIdList(sharedData.getResponse().path("mortagage_applications."+id));

    }


}

