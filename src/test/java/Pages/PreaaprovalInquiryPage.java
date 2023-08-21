package Pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Driver;

@Data
public class PreaaprovalInquiryPage {
    public PreaaprovalInquiryPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='creditreport1']")
    //(xpath = "//label[@for='creditreport1']")
    private WebElement orderReport;

    @FindBy(xpath = "//input[@id='creditreport2']")

    private WebElement noReport;

    @FindBy(xpath = " //a[@href='#finish']")
    private WebElement saveButton;

    @FindBy(xpath = " //a[@href='#next']")
    private WebElement nextButton;


    public void fillOutApplication(String firstName,
                                   String lastName,
                                   String email,
                                   String dob,
                                   String ssn,
                                   String cellPhone,
                                   String homePhone) {
        Pages.LoginPage loginPage = new Pages.LoginPage();
        loginPage.loginWithValidCredentials();
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getRealtorInfo().sendKeys("John Smith, 412-123-1234, john@gmail.com");
        preapprovalDetailsPage.getEstPrice().sendKeys("10000");
        preapprovalDetailsPage.getDownPayment().sendKeys("1000");
        preapprovalDetailsPage.getNextButton().click();

        PersonalInformationPage personalInformationPage = new PersonalInformationPage();
        personalInformationPage.getNoCheckBox();
        personalInformationPage.getFirstNameField().sendKeys(firstName);
        personalInformationPage.getLastNameField().sendKeys(lastName);
        personalInformationPage.getEmailFieldBorrower().sendKeys(email);
        personalInformationPage.getDobBorrower().sendKeys(dob);
        personalInformationPage.getSsnFieldBorrower().sendKeys(ssn);

        Select status = new Select(personalInformationPage.getMaritalField2());
        status.selectByIndex(2);
        personalInformationPage.getCellphoneBorrower().sendKeys(cellPhone);
        personalInformationPage.getHomephoneBorrower().sendKeys(homePhone);
        personalInformationPage.getNextButton().click();

        ExpensePage expensesPage = new ExpensePage();
        expensesPage.getRentalpayment().sendKeys("1000");
        expensesPage.getNextButton().click();

        Pages.BorrowerEmploymentPage borrowerEmploymentPage = new Pages.BorrowerEmploymentPage();
        borrowerEmploymentPage.borrowPageInfo();
    }
    public void fillOutApplicationNoLogin(String firstName,
                                   String lastName,
                                   String email,
                                   String dob,
                                   String ssn,
                                   String cellPhone,
                                   String homePhone) {
        PreapprovalDetailsPage preapprovalDetailsPage = new PreapprovalDetailsPage();
        preapprovalDetailsPage.getPApage();
        preapprovalDetailsPage.getRealtorInfo().sendKeys("John Smith, 412-123-1234, john@gmail.com");
        preapprovalDetailsPage.getEstPrice().sendKeys("10000");
        preapprovalDetailsPage.getDownPayment().sendKeys("1000");
        preapprovalDetailsPage.getNextButton().click();

        PersonalInformationPage personalInformationPage = new PersonalInformationPage();
        personalInformationPage.getNoCheckBox();
        personalInformationPage.getFirstNameField().sendKeys(firstName);
        personalInformationPage.getLastNameField().sendKeys(lastName);
        personalInformationPage.getEmailFieldBorrower().sendKeys(email);
        personalInformationPage.getDobBorrower().sendKeys(dob);
        personalInformationPage.getSsnFieldBorrower().sendKeys(ssn);

        Select status = new Select(personalInformationPage.getMaritalField2());
        status.selectByIndex(2);
        personalInformationPage.getCellphoneBorrower().sendKeys(cellPhone);
        personalInformationPage.getHomephoneBorrower().sendKeys(homePhone);
        personalInformationPage.getNextButton().click();

        ExpensePage expensesPage = new ExpensePage();
        expensesPage.getRentalpayment().sendKeys("1000");
        expensesPage.getNextButton().click();

        Pages.BorrowerEmploymentPage borrowerEmploymentPage = new Pages.BorrowerEmploymentPage();
        borrowerEmploymentPage.borrowPageInfo();
    }
}
