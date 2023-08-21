package stepDefinitions.ui;

import Pages.SignUpPage;
import io.cucumber.java.en.Given;

public class SignUpStepDefs {
    @Given("I click on the SignUp link and fill out SignUpPage")
    public void i_click_on_the_sign_up_link() throws InterruptedException {
        new SignUpPage().fillOutSignUpPage();
    }

    @Given("I can sign up multiple times for the application and verify on the data base")
    public void iCanSignUpMultipleTimesForTheApplication() throws InterruptedException {
        new SignUpPage().createMultipleSignUps(3);
    }
}
