package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.BasePage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.RegistrationPage;
import testDataTypes.MockUser;

public class RegistrationStep {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    @Given("User is on main page")
    public void user_is_on_Main_Page() {
        mainPage = new MainPage();
        mainPage.openMainPage(FileReaderManager.getPropertiesFileReader().getBaseURL());
    }

    @When("^User clicks on Login/Registration link$")
    public void user_clicks_on_login_link() {
        mainPage.goToLoginPage();
    }

    @Then("User is on Login page")
    public void user_is_on_Login_Page() {
        loginPage = new LoginPage();
        BasePage.getWait().until(ExpectedConditions.visibilityOf(loginPage.getRegistrationHeader()));
        Assert.assertEquals(loginPage.getURL(), FileReaderManager.getPropertiesFileReader().getLoginPageURL());
    }

    @When("User provides new registration data")
    public void new_user_registration() {
        MockUser user = FileReaderManager.getJsonFileReader().getMockUsersFromJSON().getFirst();
        loginPage.registerNewUser(user);
    }

    @Then("User is on Registration page")
    public void user_is_on_Registration_Page() {
        registrationPage = new RegistrationPage();
        BasePage.getWait().until(ExpectedConditions.visibilityOf(registrationPage.getRegistrationHeader()));
        Assert.assertEquals(registrationPage.getURL(), FileReaderManager.getPropertiesFileReader().getRegistrationPageURL());
    }
}
