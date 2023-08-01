package stepDefinitions;

import Pages.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

public class SummaryPageStepDefs2 {

    //=============

    SummaryPage2 summaryPage2= new SummaryPage2();

    @Given("I log in with valid credentials")
    public void iLogInWithValidCredentials() throws InterruptedException {
//        LoginPage loginPage= new LoginPage();
//        loginPage.loginWithValidCredentials();
        Pages.LoginPage loginPage = new Pages.LoginPage();
        loginPage.loginWithValidCredentials();
//        Driver.getDriver().findElement(By.xpath("//a[@href='mortgage.php']")).click();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        Faker faker= new Faker();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getRealtorInfo().sendKeys("John Smith, 412-123-1234, john@gmail.com");
        preapprovalDetailsPage.getEstPrice().sendKeys("10000");
        preapprovalDetailsPage.getDownPayment().sendKeys("1000");
        preapprovalDetailsPage.getNextButton().click();

        PersonalInformationPage personalInformationPage = new PersonalInformationPage();
        personalInformationPage.getNoCheckBox();
        personalInformationPage.getFirstNameField().sendKeys(faker.name().firstName());
        personalInformationPage.getLastNameField().sendKeys(faker.name().lastName());
        personalInformationPage.getEmailFieldBorrower().sendKeys(faker.name().firstName()+"@gmail.com");
        personalInformationPage.getDobBorrower().sendKeys("03221990");
        personalInformationPage.getSsnFieldBorrower().sendKeys("123456789");

        Select status = new Select(personalInformationPage.getMaritalField2());
        status.selectByIndex(2);
        personalInformationPage.getCellphoneBorrower().sendKeys("1234567890");
        personalInformationPage.getHomephoneBorrower().sendKeys("1234567890");
        personalInformationPage.getNextButton().click();

        ExpensePage expensesPage = new ExpensePage();
        expensesPage.getRentalpayment().sendKeys("1000");
        expensesPage.getNextButton().click();

        Pages.BorrowerEmploymentPage borrowerEmploymentPage = new Pages.BorrowerEmploymentPage();
        borrowerEmploymentPage.borrowPageInfo();
    }

    @Then("I navigate to Summary Page")
    public void iNavigateToSummaryPage() {
        summaryPage2.getSummarySection().click();
    }

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
        exp.getMonthlypaymentlabel().clear();
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
        empInc.getEmployerName().clear();
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
        summaryPage2.getCreditNoButton().clear();
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
        econsentPage.getFirstName().clear();
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
