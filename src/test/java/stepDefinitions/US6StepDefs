package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.DBUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class US6StepDefs {

    SharedData sharedData;

    public US6StepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

//    select column_name
//    from information_schema.columns
//    where table_name = 'tbl_mortagage';


    @When("I retrieve the column names from the {string} tables")
    public void i_retrieve_the_column_names_from_the_tables(String tableName) {

        List<List<Object>> list = DBUtils.getQueryResultAsListOfLists("describe " + tableName);
        System.out.println(list);

        sharedData.setDbColumnNames(new ArrayList<>());


        for (List<Object> each : list) {

            sharedData.getDbColumnNames().add((String) each.get(0));

        }


    }

    @Then("it should have the followings")
    public void it_should_have_the_followings(List<String> expected) {
        Assert.assertEquals(expected, sharedData.getDbColumnNames());
    }

    @When("I retrieve the user id from the database")
    public void iRetrieveTheUserIdFromTheDatabase() {
        List<List<Object>> queryResult = DBUtils.getQueryResultAsListOfLists("""
                select user_id
                from tbl_mortagage
                where user_id = 460;""");

        if (!queryResult.isEmpty()) {
            Integer userId = (Integer) queryResult.get(0).get(0);

            String userIdAsString = userId.toString();

            sharedData.setUser_id(userIdAsString);
        }
    }


    @Then("is should match the following")
    public void itShouldMatchTheFollowing(List<String> expectedUserIds) {
        String actualUserId = sharedData.getUser_id();
        String expectedUserId = expectedUserIds.get(0);

        Assert.assertEquals("Expected user_id does not match actual", expectedUserId, actualUserId);
    }

    @When("I retrieve the timestamps column from the DB")
    public void iRetrieveTheColumnFromTheDB() {
        List<List<Object>> queryResult = DBUtils.getQueryResultAsListOfLists("""
            select created_on
            from tbl_mortagage
            where eConsent_declarer_LastName = 'hauck';""");

        if (!queryResult.isEmpty()) {
            String timestamp = queryResult.get(0).get(0).toString();

            sharedData.setTimestamp(timestamp);
        }

    }

    @Then("it should match the following timestamp")
    public void itShouldMatchTheFollowingTimestamp(List<String> timestamp) {
        String actualTimestamp = sharedData.getTimestamp();
        String expectedTimestamp = timestamp.get(0);

        Assert.assertEquals("Expected user_id does not match actual", expectedTimestamp, actualTimestamp);
    }

    @Given("you have the correct fields from the data base and they contain information")
    public void youHaveTheCorrectFieldsFromTheDataBase() {
        List<Map<String, Object>> queryResult = DBUtils.getQueryResultListOfMaps("""
            select eConsent_declarer_firstname,
            eConsent_declarer_lastname,
            eConsent_declarer_email
            from tbl_mortagage;""");

        if (queryResult.isEmpty()) {
            Assert.fail("No data found in the database.");
        }

    }
}



