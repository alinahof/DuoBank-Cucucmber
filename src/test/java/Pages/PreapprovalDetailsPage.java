package Pages;

import utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreapprovalDetailsPage {
    public PreapprovalDetailsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//label[@for='realtor1']")
    private WebElement hasRealtor;

    @FindBy(xpath = "//label[@for='realtor2']")
    private WebElement noRealtor;

    @FindBy(id = "realtorinfo")
    private WebElement realtorInfo;

    @FindBy(xpath = "//label[@for='loanofficer1']")
    private WebElement hasLoanOfficer;

    @FindBy(xpath = "//label[@for='loanofficer2']")
    private WebElement noLoanOfficer;

    @FindBy(xpath = "//select[@name='purpose_loan']")
    private WebElement loanPurpose;

    @FindBy(id = "estimatedprice")
    private WebElement estPrice;

    @FindBy(id = "downpayment")
    private WebElement downPayment;

    @FindBy(id = "downpaymentpercentage")
    private WebElement downPaymentPercent;

    @FindBy(xpath = "//div[@class='loanamount']")
    private WebElement loanAmount;

    @FindBy(xpath = "//select[@name='src_down_payment']")
    private WebElement srcDownPayment;

    @FindBy(xpath = "//input[@name='add_fund_available']")
    private WebElement additionalFunds;

    @FindBy(xpath = "//a[@href='#next']")
    private WebElement nextButton;

    @FindBy(xpath = "//label[@for='proposalTitle1']")
    private WebElement nextPage;

    @FindBy(id = "estimatedprice-error")
    private WebElement estPriceError;

    @FindBy(id = "downpayment-error")
    private WebElement downPmntError;


    @FindBy(id = "additionalfunds-error")
    private WebElement additionalFundsError;


    @FindBy(id = "downpaymentpercentage-error")
    private WebElement downPmntPercentageError;

    public WebElement getAdditionalFundsError() {
        return additionalFundsError;
    }

    public WebElement getDownPmntPercentageError() {
        return downPmntPercentageError;
    }

    public WebElement getDownPmntError() {
        return downPmntError;
    }

    public WebElement getEstPriceError() {
        return estPriceError;
    }

    public WebElement getNextPage() {
        return nextPage;
    }

    public WebElement getHasRealtor() {
        return hasRealtor;
    }

    public WebElement getNoRealtor() {
        return noRealtor;
    }

    public WebElement getRealtorInfo() {
        return realtorInfo;
    }

    public WebElement getHasLoanOfficer() {
        return hasLoanOfficer;
    }

    public WebElement getNoLoanOfficer() {
        return noLoanOfficer;
    }

    public WebElement getLoanPurpose() {
        return loanPurpose;
    }

    public WebElement getEstPrice() {
        return estPrice;
    }

    public WebElement getDownPayment() {
        return downPayment;
    }

    public WebElement getDownPaymentPercent() {
        return downPaymentPercent;
    }

    public WebElement getLoanAmount() {
        return loanAmount;
    }

    public WebElement getSrcDownPayment() {
        return srcDownPayment;
    }

    public WebElement getAdditionalFunds() {
        return additionalFunds;
    }

    public WebElement getNextButton() {
        return nextButton;
    }

    public void getPApage(){
        Driver.getDriver().findElement(By.linkText("Mortgage Application")).click();
    }

public void getAppListPage(){
    Driver.getDriver().findElement(By.linkText("Application List")).click();
}


}
