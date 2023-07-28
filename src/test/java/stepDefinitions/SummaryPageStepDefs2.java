package stepDefinitions;

import Pages.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import utils.Driver;

public class SummaryPageStepDefs2 {

    @When("I choose summary section")
    public void i_choose_summary_section() {
        Pages.PreaaprovalInquiryPage preaaprovalInquiryPage = new Pages.PreaaprovalInquiryPage();
        preaaprovalInquiryPage.fillOutApplication("Jane","Doe","jane@gmail.com", "12-12-2000", "123-12-1215", "123-123-1234", "123-123-1234");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();",
                preaaprovalInquiryPage.getNoReport());
        preaaprovalInquiryPage.getNextButton().click();
    }
    @Then("I'm able to edit any section of the application")
    public void i_m_able_to_edit_any_section_of_the_application() {
        PreApprovalPage pre = new PreApprovalPage();
        SummaryPage2 sum= new SummaryPage2();
        PersonalInformationPage pi= new PersonalInformationPage();
        ExpensePage exp= new ExpensePage();
        EmploymentandIncomePage empInc= new EmploymentandIncomePage();
        EconsentPage econsentPage= new EconsentPage();

        //preApproval edit page
        sum.getSummarySection().click();
        sum.getPreApprovalEditButton().click();
        pre.getDownpayment().sendKeys("543210");

        sum.getSummarySection().click();

        //personalInfo edit page
        sum.getPersonalDetailsEditButton().click();
        pi.getCellphoneBorrower().sendKeys("0987654321");

        //expenses edit page
        sum.getSummarySection().click();
        exp.getMonthlypaymentlabel().sendKeys("654321");

        //employment and income edit page
        sum.getSummarySection().click();
        Faker faker= new Faker();
        empInc.getEmployerName().sendKeys(faker.name().fullName());

        //credit report edit page
        sum.getCreditReportSection().click();
        sum.getCreditNoButton().click();

        //eConsent edit page
        sum.getSummarySection().click();
        sum.getEConsentEditButton().click();
        econsentPage.getFirstName().sendKeys(faker.name().firstName());

        //save changes
        sum.getSummarySection().click();
        sum.getSaveButton().click();








    }
    @Then("I'm able to submit the application")
    public void i_m_able_to_submit_the_application() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
