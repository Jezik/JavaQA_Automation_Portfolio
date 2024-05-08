package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BasePage {
    protected static WebDriver driver;
    protected static Wait<WebDriver> wait;

    public static void setDriver(WebDriver webDriver, int seconds) {
        driver = webDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public static Wait<WebDriver> getWait() {
        return wait;
    }
}
