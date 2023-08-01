package Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class SummaryPage2 {

    public SummaryPage2(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a//span[@class='d-block'][.='Summary']")
    private WebElement summarySection;

    @FindBy (xpath = "//a[@id='PreApprovalEdit']")
    private WebElement preApprovalEditButton;

    @FindBy (xpath = "//a[@id='PersonalnformationEdit']")
    private WebElement personalDetailsEditButton;

    @FindBy (xpath = "//a[@id='ExpenseEdit']")
    private WebElement expensesEditButton;

    @FindBy (xpath = "//a[@id='EmploymentIncomeEdit']")
    private WebElement employmentAndIncomeEditButton;

    @FindBy (xpath = "//a[@id='OrderCreditEdit']")
    private WebElement orderCreditEditButton;

    @FindBy (xpath = "//a[@id='eConsentEdit']")
    private WebElement eConsentEditButton;

    @FindBy (xpath = "//a[@id='steps-uid-0-t-4']//span[@class='d-block']")
    private WebElement creditReportSection;

    @FindBy (xpath = "//label[@for='creditreport2']")
    private WebElement creditNoButton;

    @FindBy (xpath = "//a[@href='#finish']")
    private WebElement saveButton;

//    @Given("I log in with valid credentials")
//    public void i_log_in_with_valid_credentials() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("I click on the mortgage application section")
//    public void i_click_on_the_mortgage_application_section() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("I fill out preapproval details section")
//    public void i_fill_out_preapproval_details_section() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("I fill out the expenses section")
//    public void i_fill_out_the_expenses_section() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("I fill out Employment & Income section")
//    public void i_fill_out_employment_income_section() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("I fill out credit report section")
//    public void i_fill_out_credit_report_section() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("I can fill out eConsent section")
//    public void i_can_fill_out_e_consent_section() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();}

}
