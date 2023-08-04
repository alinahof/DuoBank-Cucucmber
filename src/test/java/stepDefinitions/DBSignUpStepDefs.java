package stepDefinitions;

import Pages.SignUpPage;
import com.beust.ah.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import utils.DBUtils;
import java.sql.SQLException;
import java.util.*;

public class DBSignUpStepDefs extends SignUpPage {


    SharedData sharedData;

    public DBSignUpStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Then("I retrieve the email")
    public void i_retrieve_the_email() throws SQLException {

        String email = "test@email.com";

        List<Map<String, Object>> listOfMaps = DBUtils.getQueryResultListOfMaps("SELECT email, first_name FROM tbl_user where email = '" + email + "'");

        System.out.println(listOfMaps);

    }

    @Then("I verify the information is correct")
    public void i_verify_the_information_is_correct() {


        String email = "test@email.com";

        List<Map<String, Object>> listOfMaps = DBUtils.getQueryResultListOfMaps("SELECT email, first_name FROM tbl_user where email = '" + email + "'");

        String expectedEmail = "test@email.com";
        String expectedFirstName = "testy";

        Assert.assertEquals(expectedEmail, listOfMaps.get(0).get("email"));
        Assert.assertEquals(expectedFirstName, listOfMaps.get(0).get("first_name"));
    }

    @Given("I retrieve the columns from Data Base")
    public void iRetrieveTheColumnsFromDataBase() {

        List<Map<String, Object>> mapList = DBUtils.getQueryResultListOfMaps("""
                select column_name
                from information_schema.columns
                where table_name = 'tbl_user';""");
        System.out.println(mapList);

    }

    @Then("I verify the columns")
    public void iVerifyTheColumns() {
        String[] expectedColumns = {
                "id", "email", "password", "first_name", "last_name", "phone", "image",
                "type", "created_at", "modified_at", "zone_id", "church_id", "country_id", "active"
        };

        List<Map<String, Object>> mapList = DBUtils.getQueryResultListOfMaps("""
                SELECT COLUMN_NAME
                FROM INFORMATION_SCHEMA.COLUMNS
                WHERE TABLE_NAME = 'tbl_user';""");

        List<String> actualColumns = new ArrayList<>();
        for (Map<String, Object> map : mapList) {
            actualColumns.add(map.get("COLUMN_NAME").toString());
        }

        for (String expectedColumn : expectedColumns) {
            Assert.assertTrue("Column '" + expectedColumn + "' is missing in the database",
                    actualColumns.contains(expectedColumn));
        }
    }


    @Given("I retrieve the timestamp column from the DB")
    public void iRetrieveTheTimestampColumnFromTheDB() {

        List<Map<String, Object>> mapList = DBUtils.getQueryResultListOfMaps("select created_at from tbl_user");
        System.out.println(mapList);

    }

    @Then("I verify that the TimeStamp column is functioning properly")
    public void iVerifyThatTheTimeStampColumnIsFunctioningProperly() {
        List<Map<String, Object>> mapList = DBUtils.getQueryResultListOfMaps("select created_at, email from tbl_user where email = 'test@email.com';");

        String timestamp = "2023-08-03 01:41:30";

        Assert.assertEquals(timestamp, mapList.get(0).get("created_at"));
    }

    @Given("I retrieve the emails from Data Base and verify there arent duplicates")
    public void iRetrieveTheEmailsFromDataBase() {
        List<List<Object>> list = DBUtils.getQueryResultAsListOfLists("select email,count(*) from tbl_user group by email having count(*)>1;");
        System.out.println(list);

    }


    @Given("I retrieve password from database and verify its encrypted")
    public void iRetrievePasswordFromDatabaseAndVerifyItsEncrypted() {

            String pass = "User123!";
            sharedData.setPassword(pass);
            sharedData.setPassMD5(DigestUtils.md5Hex(pass));

        Map<String, Object> password = DBUtils.getQueryResultListOfMaps("select password from tbl_user where email= 'useru@user.com'").get(0);

        String password1 = password.get("password").toString();
        Assert.assertEquals(sharedData.getPassMD5(),password1);
        }
    }





