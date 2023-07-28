package stepDefinitions;

import Pages.EmploymentandIncomePage;
import io.cucumber.java.en.Given;

public class EmploymentandIncomeStepDefs {
    @Given("I fill out Employment&Income page")
    public void i_fill_out_employment_and_income_page() {
        new EmploymentandIncomePage().validEandIPage();

    }
}
