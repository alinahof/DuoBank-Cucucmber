package stepDefinitions;

import Pages.PreaaprovalInquiryPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class CreditReportStepDefs {

    @When("I choose credit report option")
    public void i_choose_credit_report_option() throws InterruptedException {
        Pages.PreaaprovalInquiryPage preaaprovalInquiryPage = new Pages.PreaaprovalInquiryPage();
        preaaprovalInquiryPage.fillOutApplication("Jane","Doe","jane@gmail.com", "12-12-2000", "123-12-1215", "123-123-1234", "123-123-1234");
        Thread.sleep(2000);

        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();",
                preaaprovalInquiryPage.getNoReport());
        preaaprovalInquiryPage.getNextButton().click();


    }
    @Then("I'm redirected to the Econsent page")
    public void i_m_redirected_to_the_ecosent_page() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("eConsent"));


    }

   @Then("I fill out credit report")
        public void i_fill_out_credit_page(){
                WebDriver driver = Driver.getDriver();
                PreaaprovalInquiryPage preapprovalInquiryPage = new PreaaprovalInquiryPage();

                // Wait for the "No Report" element to be available
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
                WebElement noReportElement = wait.until(ExpectedConditions.elementToBeClickable(preapprovalInquiryPage.getNoReport()));

                // Click on the "No Report" element using JavaScriptExecutor
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", noReportElement);

                // Click on the "Next" button
                new PreaaprovalInquiryPage().getNextButton().click();
            }
        }





