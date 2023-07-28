package Pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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

    public void valideConsentInfo() throws InterruptedException {
        Thread.sleep(2000);
        Faker fake = new Faker();
        getFirstName().sendKeys(fake.name().firstName());
        getLastName().sendKeys(fake.name().lastName());
        getEmail().sendKeys(fake.internet().emailAddress());

        // Click on the "Agree" radio button using JavaScriptExecutor
        WebDriver driver = Driver.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", getAgreeButton());

        getNextButton().click();
    }
}
