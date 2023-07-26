package stepDefinitions;

import java.sql.Driver;

public class CreditReportStepDefs {

    @When("I choose credit report option")
    public void i_choose_credit_report_option() {
        Pages.PreaaprovalInquiryPage preaaprovalInquiryPage = new Pages.PreaaprovalInquiryPage();
        preaaprovalInquiryPage.fillOutApplication("Jane","Doe","jane@gmail.com", "12-12-2000", "123-12-121", "123-123-1234", "123-123-1234");
        preaaprovalInquiryPage.getNoReport();
        preaaprovalInquiryPage.getSaveButton().click();


    }
    @Then("I'm redirected to the Econsent page")
    public void i_m_redirected_to_the_ecosent_page() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("eConsent"));
    }



}
