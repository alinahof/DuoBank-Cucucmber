package Pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;



@Data
public class SignUpPage {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public SignUpPage() {
        PageFactory.initElements(Driver.getDriver(), this); // this line initializes all @FindBy annotated variables
        Faker fake = new Faker();
        this.firstName = fake.name().firstName();
        this.lastName = fake.name().lastName();
        this.email = fake.internet().emailAddress();
        this.password = "Password123";
    }

    @FindBy(xpath = "//a[@href='register.php']")
    private WebElement signUpLink;

    @FindBy(xpath = "//input[@id='inputfirstname4']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='inputlastname4']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='exampleInputPassword1']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='register']")
    private WebElement signUpButton;

    public String getFirstNameValue() {
        return this.firstName;
    }

    public String getLastNameValue() {
        return this.lastName;
    }

    public String getEmailValue() {
        return this.email;
    }

    public String getPasswordValue() {
        return this.password;
    }

    public void fillOutSignUpPage() throws InterruptedException {
        signUpLink.click();
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signUpButton.click();
        Thread.sleep(2000);
    }
}
