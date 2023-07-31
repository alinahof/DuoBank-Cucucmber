package Pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.ConfigReader;

@Data
public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "exampleInputEmail1")
    private WebElement emailAddress;

    @FindBy(id = "exampleInputPassword1") private WebElement password;

    @FindBy(xpath = "//button[@type='submit']") private WebElement signInButton;

    @FindBy(xpath = "//span[@class='menu-item'][.='Mortgage Application']") private WebElement mortgageApp;

    @FindBy(xpath = "//a[@class='dropdown-toggle nav-link dropdown-user-link']") private WebElement username;

    @FindBy(xpath = "//a[@href='logout.php']") private WebElement logoutButton;

    @FindBy (xpath = "//small[@class='mr-25']") private WebElement Alreadyhaveaccount;

    @FindBy(xpath = "//span[@class='menu-title']") private WebElement dashBoardtitle;


    public void loginWithValidCredentials(){
        login(ConfigReader.getProperty("email"),ConfigReader.getProperty("password"));
    }
    public void login(String email, String password){
        emailAddress.sendKeys(email, Keys.TAB, password, Keys.ENTER);
    }

    public void validLogIn() {
        emailAddress.sendKeys(ConfigReader.getProperty("valid"), Keys.TAB, ConfigReader.getProperty("passcode"), Keys.ENTER);
    }

    public void adminLogin() {
        emailAddress.sendKeys(ConfigReader.getProperty("admin"), Keys.TAB, ConfigReader.getProperty("code"), Keys.ENTER);
    }

    public void validLoginInfo() throws InterruptedException {
        getEmailAddress().sendKeys("rschwand0@soundcloud.com");
        getPassword().sendKeys("aD2Z_oq+k'2b");
        getSignInButton().click();
        Thread.sleep(1500);
        getMortgageApp().click();
    }

    public boolean isButtonDisabledSignInWithEmailOnly(WebElement button ){
        return button.isEnabled();
    }


}

