package stepDefinitions;

import Pages.ApplicationListPage;
import Pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ApplicationListStepDef {



    @When("I click on dropdown menu")
    public void i_click_on_dropdown_menu() {
        LoginPage login = new LoginPage();
        login.adminLogin();

        ApplicationListPage dropdownmenu = new ApplicationListPage();
        dropdownmenu.getApplicationList().click();
        dropdownmenu.getDropdownMenu().click();
    }

@Then ("I see four options to select from")
public void i_see_four_options_to_select_from() {
    ApplicationListPage dropdownOptions = new ApplicationListPage();
    Select dropdown = new Select(dropdownOptions.getDropdownMenu());
    List< WebElement> options = dropdown.getOptions();
int expected = 4;
Assert.assertEquals(" Not applicable number of options", expected, options.size());
}


    @Then("I see options of how many entries to show on the page")
    public void i_see_options_of_how_many_entries_to_show_on_the_page() {
        ApplicationListPage dropdownOptions = new ApplicationListPage();
        Select dropdown = new Select(dropdownOptions.getDropdownMenu());
        List< WebElement> options = dropdown.getOptions();
        Assert.assertEquals("Option not found", "10", options.get(0).getAttribute("value"));
        Assert.assertEquals("Option not found", "25", options.get(1).getAttribute("value"));
        Assert.assertEquals("Option not found", "50", options.get(2).getAttribute("value"));
        Assert.assertEquals("Option not found", "100", options.get(3).getAttribute("value"));

    }

}
