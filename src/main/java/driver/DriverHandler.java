package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverHandler {

    public static final int defaultTime = 3;
    private static WebDriver webDriver;

    private DriverHandler() {

    }

    // Create chrome instance
    public static WebDriver getDriverInstance() throws Exception {
        if (webDriver == null) {
            setChromeDriver();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(defaultTime, TimeUnit.SECONDS);
        }

        return webDriver;
    }

    // Choose driver depends on OS
    private static void setChromeDriver() throws Exception {
        String osName = System.getProperty("os.name").toLowerCase();
        StringBuffer chromeBinaryPath = new StringBuffer(
                "src/main/resources/drivers/");

        if (osName.startsWith("win")) {
            chromeBinaryPath.append("chrome-win/chromedriver.exe");
        } else if (osName.startsWith("lin")) {
            chromeBinaryPath.append("chrome-lin/chromedriver");
        } else if (osName.startsWith("mac")) {
            chromeBinaryPath.append("chrome-mac/chromedriver");
        } else
            throw new Exception("Your OS is invalid for webdriver tests");

        System.setProperty("webdriver.chrome.driver",
                chromeBinaryPath.toString());
    }


}
