package stepDefinitions.ui;

import Pages.LoginPage;
import io.cucumber.java.en.Given;

public class LoginStepDefs {
    @Given("I log in with credentials")
    public void i_log_in_with_credentials() throws InterruptedException {
      new LoginPage().loginWithValidCredentials();

    }

}
