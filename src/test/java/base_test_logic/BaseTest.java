package base_test_logic;

import driver.DriverHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class BaseTest {
    private WebDriver webDriver;

    protected HomePage homePage;

     protected static final String cnnWebSite = "http://www.cnn.com/";

    @BeforeTest
    public void setup() throws Exception {
        webDriver = DriverHandler.getDriverInstance();
        webDriver.get(cnnWebSite);
        homePage = PageFactory.initElements(webDriver, HomePage.class);
    }

    @AfterTest
    public void tearDown() {
        webDriver.quit();
    }
}
