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

    @Given("I click on the personal")
    public void iClickOnThePersonal() {
        sum.clickPersonalInfoEditButton();
        sum.clickSummaryTabButton();
    }

    @Given("I click on the expense")
    public void iClickOnTheExpense() {
        sum.clickExpenseEditButton();
        sum.clickSummaryTabButton();
    }

    @Given("I click on the Employment and Income")
    public void iClickOnTheEmploymentAndIncome() {
        sum.clickEmploymentAndIncomeEditButton();
        sum.clickSummaryTabButton();
    }

    @Given("I click on the Credit Report")
    public void iClickOnTheCreditReport() {
        sum.clickOrderCreditEditButton();
        sum.clickSummaryTabButton();
    }

    @Given("I click on the eConsent")
    public void iClickOnTheEConsent() {
        sum.clickeConsentEditButton();
        sum.clickSummaryTabButton();
    }
}
