package stepDefinitions;

import Pages.EconsentPage;
import io.cucumber.java.en.Given;

public class eConsentstepDefs {

    @Given("I fill out eConsent page")
        public void i_fill_out_eConsent_page() throws InterruptedException {
        new EconsentPage().valideConsentInfo();
    }
}
