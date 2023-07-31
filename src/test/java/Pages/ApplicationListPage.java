package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class ApplicationListPage {

    public ApplicationListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@class='menu-item'][contains(text(), \"Application List\")]")
    private WebElement applicationList;

    @FindBy (xpath = "//select[@name='DataTables_Table_0_length']")
    private WebElement dropdownMenu;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchBar;


public void navigateToApplicationListPage(){
    LoginPage login = new LoginPage();
    login.adminLogin();
   getApplicationList();
}





    public WebElement getApplicationList() {
        return applicationList;
    }

    public WebElement getDropdownMenu() {
        return dropdownMenu;
    }

    public WebElement getSearchBar() {
        return searchBar;
    }
}
