package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(id = "header-search-bar")
    private WebElement searchField;

    @FindBy (css = "form button[aria-label=\"Search\"]")
    private WebElement searchButton;

    @FindBy (css = ".cnn-search__no-results h3")
    private WebElement errorMessageNoResults;


    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void searchForData(String searchData) {
        sendTextToElement(searchField, searchData);
        clickOnElement(searchButton);
    }

    public boolean checkForErrorMessage(){
        return elementIsDisplayed(errorMessageNoResults);
    }

    public String getErrorMessageText(){
        return getTextFromElement(errorMessageNoResults);
    }
}
