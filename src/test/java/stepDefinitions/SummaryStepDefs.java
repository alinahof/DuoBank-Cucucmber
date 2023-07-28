package stepDefinitions;

import Pages.SummaryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class SummaryStepDefs {
    SummaryPage sum = new SummaryPage();



    @Given("I click on the Preapproval")
    public void i_click_on_the_preapproval() throws InterruptedException {
       sum.clickPreApprovalEditButton();
       sum.clickSummaryTabButton();

    }

    @Then("I save loan application")
    public void i_save_loan_application() {
     sum.clickSaveButton();
     WebElement successmessage = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-succes']"));
        Assert.assertTrue("Success message is not displayed.", successmessage.isDisplayed());
    }
}
