package stepDefinitions.API;

import io.cucumber.java.en.And;
import stepDefinitions.SharedData;

import java.util.List;

import static org.hamcrest.Matchers.hasKey;

public class US8GetApplicationsStepDefs {
    SharedData sharedData;

    public US8GetApplicationsStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }


    @And("the JWT token is set in the header")
    public void theJWTTokenIsSetInTheHeader() {
        sharedData.getRequestSpecification().header("Authorization", sharedData.getJwtToken());
    }

    @And("the response should contain a list of all applicants with the following fields")
    public void theResponseShouldContainAListOfAllApplicantsWithTheFollowingFields(List<String> expectedKeys) {
        for (String key : expectedKeys) {
            sharedData.getResponse().then().body("$", hasKey(key));
        }
    }
}
