package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLink;

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void openMainPage(String url) {
        driver.get(url);
    }

    public void goToLoginPage() {
        this.loginLink.click();
    }
}
