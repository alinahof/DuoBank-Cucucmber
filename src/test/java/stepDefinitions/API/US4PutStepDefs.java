package stepDefinitions.API;

import io.cucumber.java.en.And;
import stepDefinitions.SharedData;

import java.util.Map;

public class US4PutStepDefs {

    SharedData sharedData;

    public US4PutStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

//    @And("the request {string} query parameter is set to {string}")
//    public void theRequestQueryParameterIsSetTo(String key, String value) {
//
//        sharedData.getRequestSpecification().queryParam(key, value);
//    }

    @And("the request body is set to the following payload as map")
    public void theRequestBodyIsSetToTheFollowingPayloadAsMap(Map<String, Object> payload) {
        sharedData.getRequestSpecification().body(payload);
    }

    @And("the response body should have {string} field with value")
    public void theResponseBodyShouldHaveFieldWithValue(String modified) {
        sharedData.getResponse().then().extract().as(Map.class).get(modified);
    }
}
