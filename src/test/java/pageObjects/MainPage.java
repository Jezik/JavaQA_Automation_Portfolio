package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    private final String url;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLink;

    public MainPage() {
        this.url = "https://www.automationexercise.com/";
        PageFactory.initElements(this.driver, this);
    }

    public String getUrl() {
        return this.url;
    }

    public WebElement getLoginLink() {
        return this.loginLink;
    }
}
