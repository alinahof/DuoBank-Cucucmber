package stepDefinitions.ui;

import Pages.PreApprovalPage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.Driver;



public class PreapprovalStepDefs {
    Faker faker = new Faker();
    @When("I click on the mortgage application")
    public void i_click_on_the_mortgage_application() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(2000);
        WebElement mortgageAppLink = Driver.getDriver().findElement(By.xpath("//span[@class='menu-item'][.='Mortgage Application']"));
        js.executeScript("arguments[0].click();", mortgageAppLink);
        Thread.sleep(2000);
    }

    @Then("I fill out preapproval section")
    public void i_fill_out_preapproval_section() {
        PreApprovalPage pre = new PreApprovalPage();
        pre.getRealtorinfo().sendKeys(faker.name().firstName() + "," + faker.phoneNumber().phoneNumber() + "," + faker.internet().emailAddress());
        pre.getEstimatedprice().sendKeys("123123");
        pre.getDownpayment().sendKeys("123");
        pre.getNextbutton().click();
    }

}