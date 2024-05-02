package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class RegistrationStep {
    private MainPage mainPage;
    private LoginPage loginPage;

    @Given("User is on main page")
    public void user_is_on_Main_Page() {
        mainPage = new MainPage();
        mainPage.openURL(mainPage.getUrl());
    }

    @When("^User clicks on Login/Registration link$")
    public void user_clicks_on_login_link() {
        mainPage.clickLink(mainPage.getLoginLink());
    }

    @Then("User is on Login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage();
        Assert.assertNotNull(loginPage.getRegistrationHeader());
    }
}
