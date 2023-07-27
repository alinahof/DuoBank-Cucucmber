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

    @FindBy(id = "eConsentdeclarerFirstName")
    private WebElement firstName;

    @FindBy(id = "eConsentdeclarerLastName")
    private WebElement lastName;

    @FindBy(id = "eConsentdeclarerEmail")
    private WebElement email;

    @FindBy(id = "agree")
    private WebElement agreeButton;

    @FindBy(id = "dontagree")
    private WebElement dontagreeButton;

    @FindBy(xpath = " //a[@href='#next']")
    private WebElement nextButton;
}
