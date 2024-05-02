package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import stepsDefinitions.Hooks;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = Hooks.getDriver();
    }

    public void openURL(String url) {
        this.driver.get(url);
    }

    public void clickLink(WebElement link) {
        link.click();
    }
}
