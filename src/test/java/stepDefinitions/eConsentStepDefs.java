package stepDefinitions;

import Pages.EconsentPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.util.List;

public class eConsentStepDefs {

    @When("I Leave the first name, last name, email fields field empty")
    public void i_leave_the_first_name_last_name_email_fields_field_empty(){
        EconsentPage econsentPage = new EconsentPage();
        econsentPage.getNextButton().click();
    }
    @Then("I should see a warning message")
    public void i_should_see_a_warning_message() throws InterruptedException {
        EconsentPage econsentPage = new EconsentPage();
        Thread.sleep(2000);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(econsentPage.getErrorLasttName().isDisplayed());
        softAssertions.assertThat(econsentPage.getErrorFirstName().isDisplayed());
        softAssertions.assertThat(econsentPage.getErrorEmail().isDisplayed());
        softAssertions.assertAll();
    }


    @When("I enter invalid {string}  format")
    public void i_enter_invalid_format(String string) {
        EconsentPage econsentPage = new EconsentPage();
        econsentPage.getEmail().sendKeys(string, Keys.TAB);

    }

    @Then("I should see a email warning message")
    public void i_should_see_a_email_warning_message() {
        EconsentPage econsentPage = new EconsentPage();
        Assert.assertTrue(econsentPage.getErrorEmail().isDisplayed());
    }

    @When("I enter numbers in first name, last name fields")
    public void i_enter_numbers_in_first_name_last_name_fields() {
        EconsentPage econsentPage = new EconsentPage();
        econsentPage.getFirstName().sendKeys("1234");
        econsentPage.getLastName().sendKeys("1234");

    }
    @Then("I should see first name, last name warning messages")
    public void i_should_see_first_name_last_name_warning_messages() {
        EconsentPage econsentPage = new EconsentPage();
        Assert.assertEquals("",econsentPage.getFirstName().getText());
        Assert.assertEquals("",econsentPage.getLastName().getText());
    }

    @Then("I should see correct placeholders")
    public void i_should_see_correct_placeholders() {
        EconsentPage econsentPage = new EconsentPage();
        Assert.assertEquals("First", econsentPage.getFirstName().getAttribute("placeholder") );
        Assert.assertEquals("Last", econsentPage.getLastName().getAttribute("placeholder"));
        Assert.assertEquals("Email", econsentPage.getEmail().getAttribute("placeholder") );
    }

    @Then("I should see two radio buttons Agree and Don't Agree")
    public void i_should_see_two_radio_buttons_agree_and_don_t_agree() {
        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//input[@type='radio']"));
        Assert.assertEquals(2, elements.size());
        Assert.assertEquals(new EconsentPage().getAgreeButton().getText(), "Agree");
        Assert.assertEquals(new EconsentPage().getDontagreeButton().getText(), "Don't Agree");
    }

    @When("I'm on the Econsent page")
    public void i_m_on_the_econsent_page() {
        EconsentPage econsentPage = new EconsentPage();
        econsentPage.getFirstName().sendKeys("John");
        econsentPage.getLastName().sendKeys("Smith");
        econsentPage.getEmail().sendKeys("john@gmail.com");
    }

    @Then("Agree should be selected")
    public void agree_should_be_selected() {
        EconsentPage econsentPage = new EconsentPage();
        Assert.assertTrue(econsentPage.getAgreeDefault().isSelected());
    }

    @When("I select agree and Next")
    public void i_select_agree_and_next(){
        EconsentPage econsentPage = new EconsentPage();
        econsentPage.getFirstName().sendKeys("John");
        econsentPage.getLastName().sendKeys("Smith");
        econsentPage.getEmail().sendKeys("john@gmail.com");
        econsentPage.getAgreeButton().click();
        econsentPage.getNextButton().click();

    }
    @Then("I should be redirected to the next page")
    public void i_should_be_redirected_to_the_next_page() {
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Proposed Property Details"));
    }

    @When("I select don't agree and Next")
    public void i_select_don_t_agree_and_next() {
        EconsentPage econsentPage = new EconsentPage();
        econsentPage.getFirstName().sendKeys("John");
        econsentPage.getLastName().sendKeys("Smith");
        econsentPage.getEmail().sendKeys("john@gmail.com");
        econsentPage.getDontagreeButton().click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @Then("I should be redirected to the main application page")
    public void i_should_be_redirected_to_the_main_application_page() {
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php",
                Driver.getDriver().getCurrentUrl());
    }




}
