package stepDefinitions.API;

import io.cucumber.java.en.And;
import stepDefinitions.SharedData;

public class APIUS2STepDefs {
    SharedData sharedData;

    public APIUS2STepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @And("the request {string} query parameter is set to {string}")
    public void theRequestQueryParameterIsSetTo(String key, String value) {

        sharedData.getRequestSpecification().queryParam(key, value);
    }
}

