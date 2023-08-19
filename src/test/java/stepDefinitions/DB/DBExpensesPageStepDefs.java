package stepDefinitions.DB;

import Pages.ExpensePage;
import Pages.LoginPage;
import Pages.PersonalInformationPage;
import Pages.PreapprovalDetailsPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import stepDefinitions.SharedData;
import utils.DBUtils;
import utils.Driver;

import java.sql.*;

public class DBExpensesPageStepDefs {


    SharedData sharedData;

    public DBExpensesPageStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    ExpensePage expensePage= new ExpensePage();
    WebElement expensePageSection= Driver.getDriver().findElement(By.xpath("//a[@id='steps-uid-0-t-2']//span[@class='d-block']"));

    Connection connection;
    Statement statement;




    @Given("I log in with a valid credentials")
    public void iLogInWithAValidCredentials() {
//        LoginPage loginPage= new LoginPage();
//        loginPage.loginWithValidCredentials();
        Pages.LoginPage loginPage = new Pages.LoginPage();
        loginPage.loginWithValidCredentials();
//        Driver.getDriver().findElement(By.xpath("//a[@href='mortgage.php']//span[@class='menu-item']")).click();
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


        expensePage.getRentalpayment().sendKeys("1000");
        expensePage.getNextButton().click();

        Pages.BorrowerEmploymentPage borrowerEmploymentPage = new Pages.BorrowerEmploymentPage();
        borrowerEmploymentPage.borrowPageInfo();
    }
    @Then("I navigate to Expenses Page")
    public void iNavigateToExpensesPage() {
        expensePageSection.click();

    }

    @Given("I am on the Expenses page")
    public void i_am_on_the_expenses_page() throws InterruptedException {

        expensePageSection.click();

    }
    @When("I update my living situation")
    public void i_update_my_living_situation_as() {

        expensePage.getOwncheckbox().click();

    }

    @When("I update my living situation to rental")
    public void iUpdateMyLivingSituationToRental() {

        expensePage.getRentcheckbox().click();
    }
    @When("I enter my monthly rental payment as {string}")
    public void i_enter_my_monthly_rental_payment_as(String value) {

        expensePage.getRentalpayment().sendKeys(value);
    }

    @When("I save the information")
    public void i_save_the_information() {

        expensePage.getNextButton().click();
    }
    @Then("the information should be stored in the database")
    public void the_information_should_be_stored_in_the_database() throws SQLException {
        String insertQuery = "INSERT INTO tbl_mortgage (rent_own_status, monthly_rental_payment) VALUES ('renter', '1000')";
//        String rentOwnStatus = "renter";
//        String monthlyRentalPayment = "1000";
        ResultSet resultSet = statement.executeQuery(insertQuery);
    }


    @And("rent_own_status field should only allow two values, {string} and {string}")
    public void rent_own_statusFieldShouldOnlyAllowTwoValuesAnd(String checkBox1, String checkBox2) {
        expensePageSection.click();
        WebElement expenseCheckBoxValues= Driver.getDriver().findElement(By.xpath("//fieldset[@id='steps-uid-0-p-2']//ul[@class='list-unstyled mb-0'] "));

        String actualValue = expenseCheckBoxValues.getAttribute("value");

        Assert.assertTrue(actualValue.equalsIgnoreCase(checkBox1) || actualValue.equalsIgnoreCase(checkBox2));
    }



    @When("I enter a positive numeric value {string} into the monthly_rental_payment field")
    public void iEnterAPositiveNumericValueIntoTheMonthly_rental_paymentField(String value) {

        expensePage.getRentcheckbox().click();
        expensePage.getRentalpayment().sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,value);
    }
    @And("I enter a positive numeric value {string} into the first_mortgage_total_payment field")
    public void iEnterAPositiveNumericValueIntoTheFirst_mortgage_total_paymentField(String value2) {


        expensePage.getOwncheckbox().click();
        expensePage.getFirstMortgagePayment().sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE,Keys.BACK_SPACE,value2);

    }


    @Then("the monthly_rental_payment field should only contain a positive numeric value")
    public void theMonthly_rental_paymentFieldShouldOnlyContainAPositiveNumericValue() {

        String paymentValue= expensePage.getRentalpayment().getAttribute("value");

        try {
            double numericValue = Double.parseDouble(paymentValue);
            Assert.assertTrue("Field value should be a positive numeric value", numericValue > 0);
        } catch (NumberFormatException e) {
            Assert.fail("Field value should be a positive numeric value");
        }
    }

    @And("the first_mortgage_total_payment field should only contain a positive numeric value")
    public void theFirst_mortgage_total_paymentFieldShouldOnlyContainAPositiveNumericValue() {
        String paymentValue= expensePage.getFirstMortgagePayment().getAttribute("value");

        try {
            double numericValue = Double.parseDouble(paymentValue);
            Assert.assertTrue("Field value should be a positive numeric value", numericValue > 0);
        } catch (NumberFormatException e) {
            Assert.fail("Field value should be a positive numeric value");
        }

    }

    @When("the user enters valid data into the Expenses form fields")
    public void the_user_enters_valid_data_into_the_expenses_form_fields() {
        expensePage.getRentalpayment().sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,"1000");
    }
    @When("the user submits the form")
    public void the_user_submits_the_form() {
        expensePage.getNextButton().click();
    }
    @Then("the data from the form fields should be correctly mapped to the tbl_mortgage table in the database")
    public void theDataFromTheFormFieldsShouldBeCorrectlyMappedToTheTbl_mortgageTableInTheDatabase() throws SQLException {
        String dbUrl = "apps-database.cb72canasobc.us-east-2.rds.amazonaws.com";
        String dbUser = "duotech";
        String dbPassword = "duotech2023";
         connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
         statement = connection.createStatement();

        String query= "SELECT * FROM tbl_mortgage WHERE monthly_payment_column = 1000.0 AND mortgage_payment_column = 2000.0";
        ResultSet resultSet = statement.executeQuery(query);

    }


}
