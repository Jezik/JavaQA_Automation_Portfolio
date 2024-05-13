package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[@href='/delete_account']")
    private WebElement deleteAccount;

    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void openMainPage(String url) {
        driver.get(url);
    }

    public void goToLoginPage() {
        this.loginLink.click();
    }

    public WebElement getDeleteAccount() {
        return this.deleteAccount;
    }

    public void removeAccount() {
        this.deleteAccount.click();
    }
}
