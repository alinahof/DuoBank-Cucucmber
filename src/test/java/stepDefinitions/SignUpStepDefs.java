package stepDefinitions;

import Pages.SignUpPage;
import io.cucumber.java.en.Given;

public class SignUpStepDefs {
    @Given("I click on the SignUp link and fill out SignUpPage")
    public void i_click_on_the_sign_up_link() throws InterruptedException {
        new SignUpPage().fillOutSignUpPage();
    }
}
