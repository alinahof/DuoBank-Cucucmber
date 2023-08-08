package stepDefinitions;

import Pages.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.Driver;

public class EndToEndTesting {

    SharedData sharedData;

    public EndToEndTesting(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("I sign up as a new user")
    public void i_sign_up_as_a_new_user() {

        SignUpPage signUpPage= new SignUpPage();
        Faker faker = new Faker();
        sharedData.setFirstNameEE(faker.name().firstName());
        sharedData.setLastNameEE(faker.name().lastName());
        sharedData.setEmailEE(faker.name().username().replace(".","")+"@"+faker.internet().domainName());
        sharedData.setPasswordEE(faker.internet().password(8,50,true,true,true));
        Driver.getDriver().findElement(By.linkText("Sign up")).click();
        signUpPage.getFirstNameField().sendKeys(sharedData.getFirstNameEE());
        signUpPage.getLastNameField().sendKeys(sharedData.getLastNameEE());
        signUpPage.getEmailField().sendKeys(sharedData.getEmailEE());
        signUpPage.getPasswordField().sendKeys(sharedData.getPasswordEE());
        signUpPage.getSignUpButton().click();
    }
    @Given("I log in with new credentials")
    public void i_log_in_with_new_credentials() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(sharedData.getEmailEE(), sharedData.getPasswordEE());


    }
    @When("I fill out the application completely and submit it")
    public void i_fill_out_the_application_completely_and_submit_it() throws InterruptedException {

        PreaaprovalInquiryPage preaaprovalInquiryPage = new PreaaprovalInquiryPage();
        preaaprovalInquiryPage.fillOutApplicationNoLogin("Jane","Doe","jane@gmail.com", "12-12-2000", "123-12-1215", "123-123-1234", "123-123-1234");
        Thread.sleep(2000);

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                preaaprovalInquiryPage.getNoReport());
        preaaprovalInquiryPage.getNextButton().click();
        EconsentPage econsentPage = new EconsentPage();
        econsentPage.getFirstName().sendKeys("John");
        econsentPage.getLastName().sendKeys("Smith");
        econsentPage.getEmail().sendKeys("john@gmail.com");
        econsentPage.getAgreeButton().click();
        econsentPage.getNextButton().click();
        SummaryPage2 summaryPage2= new SummaryPage2();
        summaryPage2.getSummarySection().click();
        summaryPage2.getSummarySection().click();
        summaryPage2.getSaveButton().click();

    }

    @Then("I can verify the submission")
    public void i_can_verify_the_submission() {

        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getAppListPage();
        Assert.assertTrue(Driver.getDriver().findElement(By.linkText(sharedData.getFirstNameEE()+" "+sharedData.getLastNameEE())).isDisplayed());
    }
    @Then("I log out")
    public void i_log_out() {

        LoginPage loginPage = new LoginPage();
        loginPage.getUserNameEE().click();
        loginPage.getLogoutButton().click();
    }
}
