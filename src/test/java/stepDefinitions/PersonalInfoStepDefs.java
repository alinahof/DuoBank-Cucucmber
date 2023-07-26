package stepDefinitions;

import Pages.PersonalPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;

public class PersonalInfoStepDefs {
    Faker faker = new Faker();

    @Given("I fill out personal information section")
    public void i_fill_out_personal_information_section() {
        new PersonalPage().validInfoFillout();
    }
}
