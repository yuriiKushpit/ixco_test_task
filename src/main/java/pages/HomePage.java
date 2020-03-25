package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    @FindBy (className = "search-icon")
    private WebElement searchIcon;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchPage navigateToSearchPage(){
        clickOnElement(searchIcon);
        return PageFactory.initElements(webDriver, SearchPage.class);
    }

}
