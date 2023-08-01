package stepDefinitions;

import Pages.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SummaryPageStepDefs2 {

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


}
