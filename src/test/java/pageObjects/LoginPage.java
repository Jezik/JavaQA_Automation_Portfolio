package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "/html/body/section/div/div/div[3]/div/h2")
    private WebElement registrationHeader;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputNewName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement inputNewEmail;

    public LoginPage() {
        PageFactory.initElements(this.driver, this);
    }

    public WebElement getRegistrationHeader() {
        return this.registrationHeader;
    }

    public WebElement getInputNewName() {
        return this.inputNewName;
    }

    public WebElement getInputNewEmail() {
        return this.inputNewEmail;
    }
}
