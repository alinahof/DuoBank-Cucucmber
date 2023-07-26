package Pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class PreApprovalPage {
    public PreApprovalPage(){
        PageFactory.initElements(Driver.getDriver(), this); // this line initializes all @FindBy annotated variables
    }


    @FindBy(xpath = "//input[@id='realtorinfo']")
    private WebElement realtorinfo;
    @FindBy (xpath = "//input[@id='loanofficer2']")
    private WebElement LOfficerNoBox;
    @FindBy (xpath = "//input[@id='estimatedprice']")
    private WebElement estimatedprice;
    @FindBy (xpath = "//input[@id='downpayment']")
    private WebElement downpayment;
    @FindBy (xpath = "//input[@id='downpaymentpercentage']")
    private WebElement dpPercentage;
    @FindBy (xpath = "//a[@href='#next']")
    private WebElement nextbutton;

    public void validPreApprovalInfo(){
        Faker faker = new Faker();
        getRealtorinfo().sendKeys(faker.name().firstName());
        getEstimatedprice().sendKeys(String.valueOf(faker.random().nextInt(100, 5000000)));
        getDownpayment().sendKeys(String.valueOf(faker.random().nextInt(100, 10000)));
        getDpPercentage().sendKeys(String.valueOf(faker.random().nextInt(1, 100)));
        getNextbutton().click();
    }
}
