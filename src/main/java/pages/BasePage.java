package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public abstract class BasePage {

    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    protected WebDriver getDriver() {
        return webDriver;
    }

    protected void clickOnElement(WebElement element) {
        element.click();
    }

    protected void sendTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected boolean elementIsDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        }catch (NoSuchElementException ex){
            return false;
        }
    }

    protected String getTextFromElement(WebElement element){
        return element.getText();
    }
}
