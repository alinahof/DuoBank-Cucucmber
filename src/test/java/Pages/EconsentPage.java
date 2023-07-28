package Pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class EconsentPage {

    public EconsentPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = " //div[@class='form-group']//input[@name=' eConsent_declarer_FirstName']")
    private WebElement firstName;

    @FindBy(id = "eConsentdeclarerLastName")
    private WebElement lastName;

    @FindBy(id = "eConsentdeclarerEmail")
    private WebElement email;

    @FindBy(xpath = "//label[@for='agree']")
    private WebElement agreeButton;

    @FindBy(xpath = "//label[@for='dontagree']")
    private WebElement dontagreeButton;

    @FindBy(xpath = " //a[@href='#next']")
    private WebElement nextButton;

    @FindBy(id = "eConsentdeclarerFirstName-error")
    private WebElement errorFirstName;

    @FindBy(id = "eConsentdeclarerLastName-error")
    private WebElement errorLasttName;

    @FindBy(id = "eConsentdeclarerEmail-error")
    private WebElement errorEmail;

    @FindBy(id = "consentagree-error")
    private WebElement errorRadioButton;

}

