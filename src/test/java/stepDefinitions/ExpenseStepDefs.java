package stepDefinitions;

import Pages.ExpensePage;
import io.cucumber.java.en.Given;

public class ExpenseStepDefs {

    @Given("I fill out the expenses page")
    public void i_fill_out_the_expenses_page() {
     new ExpensePage().validExpensesInfo();
    }
}
