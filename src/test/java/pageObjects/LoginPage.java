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

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signupButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getRegistrationHeader() {
        return this.registrationHeader;
    }

    public void registerNewUser(String username, String email) {
        inputNewName.sendKeys(username);
        inputNewEmail.sendKeys(email);
        signupButton.click();
    }
}
