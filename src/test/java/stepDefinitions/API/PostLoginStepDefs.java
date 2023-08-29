package stepDefinitions.API;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import stepDefinitions.SharedData;

public class PostLoginStepDefs {

    SharedData sharedData;

    public PostLoginStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

//    @Then("the response access token is stored")
//    public void the_response_access_token_is_stored() {
//        String token = sharedData.getResponse().path("access_token");
//        sharedData.setJWTToken(token);
//    }

    @Then("the response access token is stored")
    public void the_response_access_token_is_stored() {
        String token = sharedData.getResponse().path("access_token");
        sharedData.setJWTToken(token);
    }

}
