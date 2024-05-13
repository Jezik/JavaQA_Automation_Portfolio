package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage extends BasePage {

    @FindBy(xpath = "//h2[@style='color: green;']")
    private WebElement header;

    @FindBy(xpath = "/html/body/section/div/div/div/p[1]")
    private WebElement firstParagraph;

    @FindBy(xpath = "/html/body/section/div/div/div/p[2]")
    private WebElement secondParagraph;

    public AccountDeletedPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getHeader() {
        return header;
    }

    public String getTextFirstParagraph() {
        return this.firstParagraph.getText();
    }

    public String getTextSecondParagraph() {
        return this.secondParagraph.getText();
    }
}
