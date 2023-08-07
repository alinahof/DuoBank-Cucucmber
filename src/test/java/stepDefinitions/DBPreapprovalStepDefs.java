package stepDefinitions;

import io.cucumber.java.en.Then;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import utils.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBPreapprovalStepDefs {

    SharedData sharedData;

    public DBPreapprovalStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Then("My info stored in the database should be the following")
    public void my_info_stored_in_the_database_should_be_the_following(List<String> expected) {
        List<List<Object>> list = DBUtils.getQueryResultAsListOfLists("describe tbl_mortagage" );

        sharedData.setDbColumnNames(new ArrayList<>());

        for (int i = 0; i < 11; i++) {
            sharedData.getDbColumnNames().add((String) list.get(i).get(0));
        }
            Assert.assertEquals(expected, sharedData.getDbColumnNames());

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
    public void the_values_of_the_following_fields_are_stored_as_string() {
        List<List<Object>> list = DBUtils.getQueryResultAsListOfLists("describe tbl_mortagage" );
        String str = (String)list.get(4).get(1);
        Assert.assertTrue(str.contains("varchar"));
        String str2 = (String)list.get(9).get(1);
        Assert.assertTrue(str2.contains("varchar"));
        String str3 = (String)list.get(2).get(1);
        Assert.assertTrue(str3.contains("text"));
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


    @Then("id column is stored as an auto-incremented primary key")
    public void idColumnIsStoredAsAnAutoIncrementedPrimaryKey() {

        List<List<Object>> list = DBUtils.getQueryResultAsListOfLists("describe tbl_mortagage" );
        String keyExpected = "PRI";
        String autoincrExpected = "auto_increment";

        Assert.assertEquals(keyExpected,((String)list.get(0).get(3) ));
        Assert.assertEquals(autoincrExpected,((String)list.get(0).get(5) ));
    }
}
