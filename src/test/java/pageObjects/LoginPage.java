package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testDataTypes.MockUser;

public class LoginPage extends BasePage {

    @FindBy(xpath = "/html/body/section/div/div/div[3]/div/h2")
    private WebElement registrationHeader;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement inputNewName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement inputNewEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement inputLoginEmail;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputLoginPassword;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[@style='color: red;']")
    private WebElement emailExist;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getRegistrationHeader() {
        return this.registrationHeader;
    }

    public WebElement getEmailExist() {
        return this.emailExist;
    }

    public void registerNewUser(MockUser user) {
        inputNewName.sendKeys(user.username);
        inputNewEmail.sendKeys(user.email);
        signupButton.click();
    }

    public void loginIntoAccount(MockUser user) {
        inputLoginEmail.sendKeys(user.email);
        inputLoginPassword.sendKeys(user.password);
        loginButton.click();
    }
}
