package Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class SummaryPage2 {

    public SummaryPage2(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a//span[@class='d-block'][.='Summary']")
    private WebElement summarySection;

    @FindBy (xpath = "//div[@class='PreApprovalDetails']//a[@href='javascript:void(0)']")
    private WebElement preApprovalEditButton;

    @FindBy (xpath = "//div[@class='Personalnformation']//a[@id='PersonalnformationEdit']")
    private WebElement personalDetailsEditButton;

    @FindBy (xpath = "//div[@class='Expenses']//a[@id='ExpenseEdit']")
    private WebElement expensesEditButton;

    @FindBy (xpath = "//div[@class='EmploymentIncome']//a[@id='EmploymentIncomeEdit']")
    private WebElement employmentAndIncomeEditButton;

    @FindBy (xpath = "//div[@class='OrderCredit']//a[@id='OrderCreditEdit']")
    private WebElement orderCreditEditButton;

    @FindBy (xpath = "//div[@class='eConsent']//a[@id='eConsentEdit']")
    private WebElement eConsentEditButton;

    @FindBy (xpath = "//a[@id='steps-uid-0-t-4']//span[@class='d-block']")
    private WebElement creditReportSection;

    @FindBy (xpath = "//label[@for='creditreport2']")
    private WebElement creditNoButton;

    @FindBy (xpath = "//a[@href='#finish']")
    private WebElement saveButton;


//================



}
