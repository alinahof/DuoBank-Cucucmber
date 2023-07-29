package stepDefinitions;

import Pages.EconsentPage;
import Pages.EmploymentandIncomePage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.Driver;

public class EmploymentandIncomeStepDefs {
    @Given("I fill out Employment&Income page")
    public void i_fill_out_employment_and_income_page() {
        new EmploymentandIncomePage().validEandIPage();

    }
    @Then("I can fill out eConsent with javascript")
    public void valideConsentInfo() throws InterruptedException {
        EconsentPage econsentPage = new EconsentPage();
        Thread.sleep(2000);
        Faker fake = new Faker();
        econsentPage.getFirstName().sendKeys(fake.name().firstName());
        econsentPage.getLastName().sendKeys(fake.name().lastName());
        econsentPage.getEmail().sendKeys(fake.internet().emailAddress());


        WebDriver driver = Driver.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", econsentPage.getAgreeButton());

        econsentPage.getNextButton().click();
    }
}
