package Pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class BorrowerEmploymentPage {
    Faker faker = new Faker();

    public BorrowerEmploymentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='employername1']")
    private WebElement EmployerName;
    @FindBy(xpath = "//input[@id='position1']")
    private WebElement Position;
    @FindBy(xpath = "//input[@id='city']")
    private WebElement City;
    @FindBy(xpath = "//input[@id='state1']")
    private WebElement State; //Drop down
    @FindBy(xpath = "//input[@id='start_date1']")
    private WebElement StartDate;
    @FindBy(xpath = "//input[@id='end_date1']")
    private WebElement EndDate;
    @FindBy(xpath = "//button[@id='addemployer']")
    private WebElement AddAnotherEmployer;
    @FindBy(xpath = "//input[@id='employername2']")
    private WebElement EmployerName2;
    @FindBy(xpath = "//input[@id='position2']")
    private WebElement Position2;
    @FindBy(xpath = "//input[@id='city2']")
    private WebElement City2;
    @FindBy(xpath = "//input[@id='state2']")
    private WebElement State2;
    @FindBy(xpath = "//input[@id='start_date2']")
    private WebElement StartDate2;
    @FindBy(xpath = "//input[@id='end_date2']")
    private WebElement EndDate2;
    @FindBy(xpath = "//input[@id='grossmonthlyincome']")
    private WebElement GrossMonthlyIncome;
    @FindBy(xpath = "//input[@id='monthlyovertime']")
    private WebElement MonthlyOvertime;
    @FindBy(xpath = "//input[@id='monthlybonuses']")
    private WebElement MonthlyBonuses;
    @FindBy(xpath = "//input[@id='monthlycommission']")
    private WebElement MonthlyComissions;
    @FindBy(xpath = "//input[@id='monthlydividents']")
    private WebElement MonthlyDividents;
    @FindBy(xpath = "//select[@id='incomesource1']")
    private WebElement IncomeSource;
    @FindBy(xpath = "//select[@id='incomesource2']")
    private WebElement IncomeSource2;
    @FindBy(xpath = "//select[@id='incomesource3']")
    private WebElement IncomeSource3;
    @FindBy(xpath = "//input[@id='amount1']")
    private WebElement Amount;
    @FindBy(xpath = "//input[@id='amount2']")
    private WebElement Amount2;
    @FindBy(xpath = "//input[@id='amount3']")
    private WebElement Amount3;
    @FindBy(xpath = "//a[@href='#next']")
    private WebElement NextButton;
    @FindBy(xpath = "//a[@href='#previous']")
    private WebElement PreviousButton;
    @FindBy(xpath = "//a[@href='#finish']")
    private WebElement SaveButton;
    @FindBy(xpath = "//div[@class='Employer']//a[@id='clear2']")
    private WebElement clear2button;
    @FindBy(xpath = "//div[@class='Employer']//a[@id='clear1']")
    private WebElement clearbutton;
    @FindBy(xpath = "//div[@class='Employer']//a[@id='remove2']")
    private WebElement removebutton;
    @FindBy(xpath = "//div[@class='swal2-actions']//button[@class='swal2-confirm btn btn-warning']")
    private WebElement confirmYesPopupActionbuton;
    @FindBy(xpath = "//div[@class='swal2-actions']//button[@class='swal2-cancel btn btn-danger ml-1']")
    private WebElement cancelPopupActionbutton;


    // Values to use for state can be 2 letter abbreviation e.g "CA" can be California
    public WebElement getState(String value){
        String xpath = "//select[@id='state1']//option[@value='"+ value +"']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }
    public WebElement getState2(String value){
        String xpath = "//select[@id='state2']//option[@value='"+ value +"']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    // Vaules for income source to use = "Alimony/Child Support" , "Social Security/Disability Income" , "Unemployment Benefits" , "Interest and Dividends" , "VA Compensation" , "Royalty Payments" , "Other Types of Income"
    public WebElement getIncomeSource(String value) {
        String xpath = "//select[@id='incomesource1']//option[@value='"+ value +"']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }
    public WebElement getIncomeSource2(String value) {
        String xpath = "//select[@id='incomesource2']//option[@value='"+ value +"']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }
    public WebElement getIncomeSource3(String value) {
        String xpath = "//select[@id='incomesource3']//option[@value='" + value + "']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }
    public void borrowPageInfo(){

        getEmployerName().sendKeys(faker.name().firstName());
        getPosition().sendKeys(faker.job().position());
        getCity().sendKeys(faker.address().city());
        getState("AK").click();
        getStartDate().sendKeys(faker.date().toString());
        getGrossMonthlyIncome().sendKeys(String.valueOf(faker.random().nextInt(901) + 100));
        getMonthlyOvertime().sendKeys(String.valueOf(faker.random().nextInt(901) + 100));
        getMonthlyBonuses().sendKeys(String.valueOf(faker.random().nextInt(901)+100));
        getMonthlyComissions().sendKeys(String.valueOf(faker.random().nextInt(901)+100));
        getMonthlyDividents().sendKeys(String.valueOf(faker.random().nextInt(901)+100));
        getIncomeSource("Alimony/Child Support").click();
        getAmount().sendKeys(String.valueOf(faker.random().nextInt(901)+100));
        getIncomeSource2("Unemployment Benefits").click();
        getAmount2().sendKeys(String.valueOf(faker.random().nextInt(901)+100));
        getIncomeSource3("Royalty Payments").click();
        getAmount3().sendKeys(String.valueOf(faker.random().nextInt(901)+100));
        getNextButton().click();
    }
}
