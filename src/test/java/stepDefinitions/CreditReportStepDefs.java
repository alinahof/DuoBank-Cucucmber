package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import org.openqa.selenium.JavascriptExecutor;
import utils.Driver;

public class CreditReportStepDefs {

    @When("I choose credit report option")
    public void i_choose_credit_report_option() throws InterruptedException {
        Pages.PreaaprovalInquiryPage preaaprovalInquiryPage = new Pages.PreaaprovalInquiryPage();
        preaaprovalInquiryPage.fillOutApplication("Jane","Doe","jane@gmail.com", "12-12-2000", "123-12-1215", "123-123-1234", "123-123-1234");
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();",
                preaaprovalInquiryPage.getNoReport());
        preaaprovalInquiryPage.getNextButton().click();


    }
    @Then("I'm redirected to the Econsent page")
    public void i_m_redirected_to_the_ecosent_page() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("eConsent"));


    }



}
