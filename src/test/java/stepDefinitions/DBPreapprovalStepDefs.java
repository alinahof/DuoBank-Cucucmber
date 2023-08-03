package stepDefinitions;

import io.cucumber.java.en.Then;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import utils.DBUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DBPreapprovalStepDefs {

    @Then("My info stored in the database should be the following")
    public void my_info_stored_in_the_database_should_be_the_following(List<Map<String, String>> expected) {

        Map<String, String> expectedData = expected.get(0);
       String expectedRstatus = expectedData.get("realtor_status");
        String expectedRinfo = expectedData.get("realtor_info");
        String expectedLOstatus = expectedData.get("loan_officer_status");
        String expectedPurposeLoan = expectedData.get("purpose_loan");
        String expectedPurchPrice = expectedData.get("est_purchase_price");
        String expectedDownPmnt = expectedData.get("down_payment");
        String expectedDownPmntPercent = expectedData.get("down_payment_percent");
        String expectedTotalLoanAm = expectedData.get("total_loan_amount");
        String expectedSrcDownPmnt = expectedData.get("src_down_payment");
        String expectedAddFunds = expectedData.get("add_fund_available");

        List<Map<String, Object>> listOfMaps = DBUtils.getQueryResultListOfMaps("select realtor_status, realtor_info, loan_officer_status, purpose_loan, est_purchase_price, down_payment, down_payment_percent, total_loan_amount, src_down_payment, add_fund_available from tbl_mortagage where b_lastName=\"Doe\"");

        Map<String, Object> actualDBData = listOfMaps.get(0);

            Assert.assertEquals(expectedRstatus, actualDBData.get("realtor_status").toString());
            Assert.assertEquals(expectedRinfo, actualDBData.get("realtor_info"));
            Assert.assertEquals(expectedLOstatus, actualDBData.get("loan_officer_status").toString());
            Assert.assertEquals(expectedPurposeLoan, actualDBData.get("purpose_loan"));
            Assert.assertEquals(expectedPurchPrice, actualDBData.get("est_purchase_price"));
            Assert.assertEquals(expectedDownPmnt, actualDBData.get("down_payment"));
            Assert.assertEquals(expectedDownPmntPercent, actualDBData.get("down_payment_percent"));
            Assert.assertEquals(expectedTotalLoanAm, actualDBData.get("total_loan_amount"));
            Assert.assertEquals(expectedSrcDownPmnt, actualDBData.get("src_down_payment"));
       // Assert.assertEquals(expectedAddFunds, actualDBData.get("add_fund_available").toString());


    }

    @Then("The values of the following fields are stored as integers")
    public void the_values_of_the_following_fields_are_stored_as_integers(List<Map<String, Integer>> expected) {
        Map<String, Integer> expectedData = expected.get(0);
        Integer expectedRstatus = expectedData.get("realtor_status");
        Integer expectedLOstatus = expectedData.get("loan_officer_status");
        List<Map<String, Object>> listOfMaps = DBUtils.getQueryResultListOfMaps("select realtor_status, loan_officer_status from tbl_mortagage where b_lastName=\"Doe\"" );
        Map<String, Object> actualDBData = listOfMaps.get(0);
        Assert.assertEquals(expectedRstatus, actualDBData.get("realtor_status"));
        Assert.assertEquals(expectedLOstatus, actualDBData.get("loan_officer_status"));
    }

    @Then("The values of the following fields are stored as string")
    public void the_values_of_the_following_fields_are_stored_as_string(List<Map<String, String>> expected) {
        Map<String, String> expectedData = expected.get(0);
        String expectedRinfo = expectedData.get("realtor_info");
        String expectedPurposeLoan = expectedData.get("purpose_loan");
        String expectedSrcDownPmnt = expectedData.get("src_down_payment");
        List<Map<String, Object>> listOfMaps = DBUtils.getQueryResultListOfMaps("select realtor_info, purpose_loan, src_down_payment from tbl_mortagage where b_lastName=\"Doe\"");
        Map<String, Object> actualDBData = listOfMaps.get(0);
        Assert.assertEquals(expectedRinfo, actualDBData.get("realtor_info"));
        Assert.assertEquals(expectedPurposeLoan, actualDBData.get("purpose_loan"));
        Assert.assertEquals(expectedSrcDownPmnt, actualDBData.get("src_down_payment"));

    }

    @Then("The values of the these fields are stored as integers")
    public void the_values_of_the_these_fields_are_stored_as_integers(List<Map<String, Integer>> expected) {
        Map<String, Integer> expectedData = expected.get(0);
        Integer expectedPurchPrice = expectedData.get("est_purchase_price");
        Integer expectedDownPmnt = expectedData.get("down_payment");
        Integer expectedDownPmntPercent = expectedData.get("down_payment_percent");
        Integer expectedTotalLoanAm = expectedData.get("total_loan_amount");
        Integer expectedAddFunds = expectedData.get("add_fund_available");
        List<Map<String, Object>> listOfMaps = DBUtils.getQueryResultListOfMaps("select est_purchase_price, down_payment, down_payment_percent, total_loan_amount, add_fund_available from tbl_mortagage where b_lastName=\"Doe\"");

        Map<String, Object> actualDBData = listOfMaps.get(0);
        Assert.assertEquals(expectedPurchPrice, actualDBData.get("est_purchase_price"));
        Assert.assertEquals(expectedDownPmnt, actualDBData.get("down_payment"));
        Assert.assertEquals(expectedDownPmntPercent, actualDBData.get("down_payment_percent"));
        Assert.assertEquals(expectedTotalLoanAm, actualDBData.get("total_loan_amount"));
        Assert.assertEquals(expectedAddFunds, actualDBData.get("add_fund_available"));
    }


}
