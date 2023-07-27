package Pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class ExpensePage {
    public ExpensePage(){

        PageFactory.initElements(Driver.getDriver(), this); // this line initializes all @FindBy annotated variables
    }
    @FindBy(xpath = "//label[@id='monthlyrentalpayment-error']")
    private WebElement monthlypaymenterror;
    @FindBy (xpath = "//label[@for='expense1']")
    private WebElement rentcheckbox;
    @FindBy(xpath = "//label[@for='expense2']")
    private WebElement owncheckbox;
    @FindBy (xpath = "//input[@id='monthlyrentalpayment']")
    private WebElement rentalpayment;
    @FindBy (xpath = "//input[@id='firtmortagagetotalpayment']")
    private WebElement Mortgagepayment;
    @FindBy (xpath = "//label[@for='firtmortagagetotalpayment']")
    private WebElement mortgagepaymentlabel;
    @FindBy (xpath = "//label[@for='monthlyrentalpayment'][1]")
    private WebElement monthlypaymentlabel;
    @FindBy (xpath = "//a[@href='#previous']")
    private WebElement previousbutton;
    @FindBy (xpath = "//a[@href='#finish']")
    private WebElement savebutton;
    @FindBy (xpath = "//label[@id='firtmortagagetotalpayment-error']")
    private WebElement mortgagepaymenterror;
    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;



    public void validExpensesInfo(){
        Faker faker = new Faker();
        getRentalpayment().sendKeys(String.valueOf(faker.random().nextInt(1000, 3000)));
        getNextButton().click();
    }
}


