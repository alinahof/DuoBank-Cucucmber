package Pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

@Data
public class PreaaprovalInquiryPage {
    public PreaaprovalInquiryPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='creditreport1']")
    //(xpath = "//label[@for='creditreport1']")
    private WebElement orderReport;

    @FindBy(xpath = "//label[@for='creditreport2']")
    private WebElement noReport;

    @FindBy(xpath = " //a[@href='#finish']")
    private WebElement saveButton;
}
