package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testDataTypes.MockUser;

public class RegistrationPage extends BasePage{

    @FindBy(xpath = "/html/body/section/div/div/div/div[1]/h2")
    private WebElement registrationHeader;

    @FindBy(xpath = "//*[@id='uniform-id_gender1']")
    private WebElement radioButtonMr;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id='days']")
    private WebElement selectDayBirth;

    @FindBy(xpath = "//*[@id='months']")
    private WebElement selectMonthBirth;

    @FindBy(xpath = "//*[@id='years']")
    private WebElement selectYearBirth;

    @FindBy(xpath = "//*[@id='first_name']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//*[@id='last_name']")
    private WebElement inputLastName;

    @FindBy(xpath = "//*[@id='company']")
    private WebElement inputCompanyName;

    @FindBy(xpath = "//*[@id='address1']")
    private WebElement inputAddressFirstLine;

    @FindBy(xpath = "//*[@id='address2']")
    private WebElement inputAddressSecondLine;

    @FindBy(xpath = "//*[@id='country']")
    private WebElement selectCountry;

    @FindBy(xpath = "//*[@id='state']")
    private WebElement inputState;

    @FindBy(xpath = "//*[@id='city']")
    private WebElement inputCity;

    @FindBy(xpath="//*[@id='zipcode']")
    private WebElement inputPostalCode;

    @FindBy(xpath = "//*[@id='mobile_number']")
    private WebElement inputMobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement buttonCreateAccount;

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    public WebElement getRegistrationHeader() {
        return this.registrationHeader;
    }

    public void fillRegistrationForm(MockUser user) throws InterruptedException {
        radioButtonMr.click();
        inputPassword.sendKeys(user.password);
        String[] birthday = user.birthday.split("/");
        new Select(selectDayBirth).selectByVisibleText(birthday[0]);
        new Select(selectMonthBirth).selectByVisibleText(birthday[1]);
        new Select(selectYearBirth).selectByVisibleText(birthday[2]);
        inputFirstName.sendKeys(user.first_name);
        inputLastName.sendKeys(user.last_name);
        inputCompanyName.sendKeys(user.company);
        inputAddressFirstLine.sendKeys(user.address);
        inputAddressSecondLine.sendKeys(user.address_line2);
        new Select(selectCountry).selectByVisibleText(user.country);
        inputState.sendKeys(user.state);
        inputCity.sendKeys(user.city);
        inputPostalCode.sendKeys(user.postal_code);
        inputMobileNumber.sendKeys(user.phone_number);
        buttonCreateAccount.click();
    }
}
