package stepDefinitions.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import stepDefinitions.SharedData;
import utils.DBUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class US5StepDefs {
    SharedData sharedData;
    List<String> newList;

    List<String> newList2;
    Set<String> set;

    public US5StepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @When("I retrieve the column names from the {string} table")
    public void i_retrieve_the_column_names_from_the_table(String tableName) {

        List<List<Object>> list = DBUtils.getQueryResultAsListOfLists("describe " + tableName);
        System.out.println(list);

        sharedData.setDbColumnNames(new ArrayList<>());
        for (int i = 35; i < 62; i++) {
            sharedData.getDbColumnNames().add((String) list.get(i).get(0));
        }
    }
    @Then("it should have the following")
    public void it_should_have_the_following(List<String> expected) {
        Assert.assertEquals(expected, sharedData.getDbColumnNames());
    }

    @When("I send a query to retrieve {string} from the db")
    public void iSendAQueryToRetrieveFromTheDb(String str) {
        List<List<Object>> list = DBUtils.getQueryResultAsListOfLists("select "+ str +" from tbl_mortagage GROUP BY "+str);
        sharedData.setIncome_source(DBUtils.getColumnData(list, 0));

        newList= new ArrayList<>();
        for (List<Object> innerList : list) {
            for (Object obj : innerList) {
                newList.add(obj.toString());
            }
        }
        List<String> list2=new ArrayList<>();
        for (int i = 1; i < newList.size(); i++) {
            String [] parts = newList.get(i).substring(1,newList.get(i).length()-1).split(",");
            for (String part : parts) {
                    list2.add(part.replace("\"", ""));
            }
        }
        this.set = new HashSet<>(list2);
        set.removeIf(s -> s.isEmpty());
        System.out.println(set);


    }
    @Then("The result should contain the following sources")
    public void the_result_should_contain_the_following_sources(List<String> expected) {
        List<String> actual = new ArrayList<>(set);
        Assert.assertTrue(expected.containsAll(actual));
    }

    @When("I send a query to retrieve {string} from DB")
    public void iSendAQueryToRetrieveFromDB(String column) {
        List<List<Object>> list = DBUtils.getQueryResultAsListOfLists("select "+column+" from tbl_mortagage");
        sharedData.setColumn(DBUtils.getColumnData(list, 0));
    }
    @Then("These columns should not be empty")
    public void these_columns_should_not_be_empty() {
        for (String str: sharedData.getColumn()) {
            Assert.assertTrue(!str.equals("") && !str.equals("[\"\"]") );
        }
    }



}
