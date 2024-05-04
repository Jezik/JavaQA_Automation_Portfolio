package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.RegistrationPage;

public class RegistrationStep {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    @Given("User is on main page")
    public void user_is_on_Main_Page() {
        mainPage = new MainPage();
        mainPage.openMainPage();
    }

    @When("^User clicks on Login/Registration link$")
    public void user_clicks_on_login_link() {
        mainPage.goToLoginPage();
    }

    @Then("User is on Login page")
    public void user_is_on_Login_Page() {
        loginPage = new LoginPage();
        Assert.assertEquals(loginPage.getURL(), "https://www.automationexercise.com/login");
        Assert.assertTrue(loginPage.getRegistrationHeader().isDisplayed());
    }

    @When("User provides new registration data")
    public void new_user_registration() {
        loginPage.registerNewUser("wstock0", "wstock0@globo.com");
    }

    @Then("User is on Registration page")
    public void user_is_on_Registration_Page() {
        registrationPage = new RegistrationPage();
        Assert.assertEquals(registrationPage.getURL(), "https://www.automationexercise.com/signup");
        Assert.assertTrue(registrationPage.getRegistrationHeader().isDisplayed());
    }
}
