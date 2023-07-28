package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;


public class SummaryPage {
    public SummaryPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@id='PreApprovalEdit']")
    private WebElement PreApprovalEditbutton;
    @FindBy(xpath = "//a[@id='PersonalnformationEdit']")
    private WebElement PersonalInfoEditbutton;
    @FindBy(xpath = "//a[@id='ExpenseEdit']")
    private WebElement ExpenseEditbutton;
    @FindBy(xpath = "//a[@id='EmploymentIncomeEdit']")
    private WebElement EmploymentandIncomeEditbutton;
    @FindBy(xpath = "//a[@id='OrderCreditEdit']")
    private WebElement OrderCreditEditbutton;
    @FindBy(xpath = "//a[@id='eConsentEdit']")
    private WebElement eConsentEditbutton;
    @FindBy(xpath = "//a[@href='#finish']")
    private WebElement Savebutton;
    @FindBy(xpath = "//a[@href='#previous']")
    private WebElement Previousbutton;
    @FindBy(xpath = "//a[@href='#steps-uid-0-h-6']")
    private WebElement SummaryTabButton;


    public void clickPreApprovalEditButton() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", PreApprovalEditbutton);
    }

    public void clickPersonalInfoEditButton() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", PersonalInfoEditbutton);
    }

    public void clickExpenseEditButton() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", ExpenseEditbutton);
    }

    public void clickEmploymentAndIncomeEditButton() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", EmploymentandIncomeEditbutton);
    }

    public void clickOrderCreditEditButton() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", OrderCreditEditbutton);
    }

    public void clickeConsentEditButton() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", eConsentEditbutton);
    }

    public void clickSaveButton() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", Savebutton);
    }

    public void clickPreviousButton() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", Previousbutton);
    }

    public void clickSummaryTabButton() {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", SummaryTabButton);
    }
}


