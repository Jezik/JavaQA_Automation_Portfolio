package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage{

    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/h2")
    private WebElement registrationHeader;

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getRegistrationHeader() {
        return this.registrationHeader;
    }
}
