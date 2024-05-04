package pageObjects;

import org.openqa.selenium.WebDriver;
import stepsDefinitions.Hooks;

abstract public class BasePage {
    WebDriver driver;

    public BasePage() {
        this.driver = Hooks.getDriver();
    }

    public String getURL() {
        return this.driver.getCurrentUrl();
    }
}
