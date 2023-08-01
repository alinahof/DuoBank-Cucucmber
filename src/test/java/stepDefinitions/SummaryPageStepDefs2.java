package stepDefinitions;

import Pages.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import utils.Driver;

public class SummaryPageStepDefs2 {

//    @When("I choose summary section")
//    public void i_choose_summary_section() {
//        Pages.PreaaprovalInquiryPage preaaprovalInquiryPage = new Pages.PreaaprovalInquiryPage();
//        preaaprovalInquiryPage.fillOutApplication("Jane","Doe","jane@gmail.com", "12-12-2000", "123-12-1215", "123-123-1234", "123-123-1234");
//        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
//                preaaprovalInquiryPage.getNoReport());
//        preaaprovalInquiryPage.getNextButton().click();
//    }
//    @Then("I'm able to edit any section of the application")
//    public void i_m_able_to_edit_any_section_of_the_application() {
//        PreApprovalPage pre = new PreApprovalPage();
//        SummaryPage2 sum= new SummaryPage2();
//        PersonalInformationPage pi= new PersonalInformationPage();
//        ExpensePage exp= new ExpensePage();
//        EmploymentandIncomePage empInc= new EmploymentandIncomePage();
//        EconsentPage econsentPage= new EconsentPage();
//
//        //preApproval edit page
//        sum.getSummarySection().click();
//        sum.getPreApprovalEditButton().click();
//        pre.getDownpayment().sendKeys("543210");
//
//        sum.getSummarySection().click();
//
//        //personalInfo edit page
//        sum.getPersonalDetailsEditButton().click();
//        pi.getCellphoneBorrower().sendKeys("0987654321");
//
//        //expenses edit page
//        sum.getSummarySection().click();
//        exp.getMonthlypaymentlabel().sendKeys("654321");
//
//        //employment and income edit page
//        sum.getSummarySection().click();
//        Faker faker= new Faker();
//        empInc.getEmployerName().sendKeys(faker.name().fullName());
//
//        //credit report edit page
//        sum.getCreditReportSection().click();
//        sum.getCreditNoButton().click();
//
//        //eConsent edit page
//        sum.getSummarySection().click();
//        econsentPage.getFirstName().sendKeys(faker.name().firstName());
//        econsentPage.getLastName().sendKeys(faker.name().lastName());
//        econsentPage.getEmail().sendKeys(faker.internet().emailAddress());
//        sum.getEConsentEditButton().click();
//
//        //save changes
//        sum.getSummarySection().click();
//        sum.getSaveButton().click();
//
//    }

    //=============

    SummaryPage2 summaryPage2= new SummaryPage2();

    @Given("I click on the PreApproval edit button")
    public void i_click_on_the_pre_approval_edit_button() {
        summaryPage2.getSummarySection().click();
        summaryPage2.getPreApprovalEditButton().click();
    }

    @Then("I make necessary changes in PreApproval")
    public void i_make_necessary_changes_in_pre_approval() {
        PreApprovalPage pre = new PreApprovalPage();
        pre.getDownpayment().sendKeys("543210");
    }

    //=============

    @Given("I click on Personal Details edit button")
    public void i_click_on_personal_details_edit_button() {
        summaryPage2.getSummarySection().click();
        summaryPage2.getPersonalDetailsEditButton().click();
    }

    @Then("I make necessary changes in Personal Details")
    public void i_make_necessary_changes_in_personal_details() {
        PersonalInformationPage pi= new PersonalInformationPage();
        pi.getCellphoneBorrower().sendKeys("0987654321");
    }

    //=============

    @Given("I click on Expenses edit button")
    public void i_click_on_expenses_edit_button() {
        summaryPage2.getSummarySection().click();
        summaryPage2.getExpensesEditButton().click();
    }

    @Then("I make necessary changes in Expenses")
    public void i_make_necessary_changes_in_expenses() {
        ExpensePage exp= new ExpensePage();
        exp.getMonthlypaymentlabel().sendKeys("654321");
    }

    //=============

    @Given("I click on Employment & Income edit button")
    public void i_click_on_employment_income_edit_button() {
        summaryPage2.getSummarySection().click();
        summaryPage2.getEmploymentAndIncomeEditButton().click();
    }

    @Then("I make necessary changes in Employment & Income")
    public void i_make_necessary_changes_in_employment_income() {
        EmploymentandIncomePage empInc= new EmploymentandIncomePage();
        Faker faker= new Faker();
        empInc.getEmployerName().sendKeys(faker.name().fullName());
    }

    //=============

    @Given("I click on Order Credit edit button")
    public void i_click_on_order_credit_edit_button() {
        summaryPage2.getSummarySection().click();
        summaryPage2.getOrderCreditEditButton().click();
    }

    @Then("I make necessary changes in Order Credit")
    public void i_make_necessary_changes_in_order_credit() {
        summaryPage2.getCreditNoButton().click();
    }

    //=============

    @Given("I click on eConsent edit button")
    public void i_click_on_e_consent_edit_button() {
        summaryPage2.getSummarySection().click();
        summaryPage2.getEConsentEditButton().click();
    }

    @Then("I make necessary changes in eConsent")
    public void i_make_necessary_changes_in_e_consent() {
        EconsentPage econsentPage= new EconsentPage();
        Faker faker= new Faker();
        econsentPage.getFirstName().sendKeys(faker.name().firstName());
    }

    @Then("I am able to submit the application")
    public void i_am_able_to_submit_the_application() {
        summaryPage2.getSummarySection().click();
        summaryPage2.getSummarySection().click();
        summaryPage2.getSaveButton().click();
    }

    //==============================




//    @Then("I'm able to submit the application")
//    public void i_m_able_to_submit_the_application() throws InterruptedException {
//        SummaryPage2 sum= new SummaryPage2();
//        //submit or save changes
//        sum.getSummarySection().click();
//        sum.getSaveButton().click();
//    }

}
