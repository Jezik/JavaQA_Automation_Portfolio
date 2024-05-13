package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.*;
import testDataTypes.PageTexts;
import testDataTypes.MockUser;

public class RegistrationStep {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private final PageObjectManager pageManager = new PageObjectManager();
    private final MockUser user = FileReaderManager.getJsonFileReader().getMockUsersFromJSON().getFirst();
    private final PageTexts expectedAccountCreatedPageTexts = FileReaderManager.getJsonFileReader().getAccountCreatedTexts().getFirst();
    private final PageTexts expectedAccountRemovedPageTexts = FileReaderManager.getJsonFileReader().getAccountCreatedTexts().getLast();

    @Given("User is on main page")
    public void user_is_on_Main_Page() {
        mainPage = pageManager.getMainPage();
        mainPage.openMainPage(FileReaderManager.getPropertiesFileReader().getBaseURL());
    }

    @When("^User clicks on Login/Registration link$")
    public void user_clicks_on_login_link() {
        mainPage.goToLoginPage();
    }

    @Then("User is on Login page")
    public void user_is_on_Login_Page() {
        loginPage = pageManager.getLoginPage();
        BasePage.getWait().until(ExpectedConditions.visibilityOf(loginPage.getRegistrationHeader()));
        Assert.assertEquals(loginPage.getURL(), FileReaderManager.getPropertiesFileReader().getLoginPageURL());
    }

    @When("User provides registration data")
    public void new_user_registration() {
        loginPage.registerNewUser(user);
    }

    @Then("User is on Registration page")
    public void user_is_on_Registration_Page() {
        registrationPage = pageManager.getRegistrationPage();
        BasePage.getWait().until(ExpectedConditions.visibilityOf(registrationPage.getRegistrationHeader()));
        Assert.assertEquals(registrationPage.getURL(), FileReaderManager.getPropertiesFileReader().getRegistrationPageURL());
    }

    @When("User fills in all necessary data")
    public void user_fills_form() {
        registrationPage = pageManager.getRegistrationPage();
        try {
            registrationPage.fillRegistrationForm(user);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("Registration should be successful")
    public void check_successful_registration() {
        AccountCreatedPage accountCreatedPage = pageManager.getAccountCreatedPage();
        BasePage.getWait().until(ExpectedConditions.visibilityOf(accountCreatedPage.getHeader()));
        Assert.assertEquals(accountCreatedPage.getURL(), FileReaderManager.getPropertiesFileReader().getAccountCreatedPageURL());
        Assert.assertEquals(accountCreatedPage.getTextFirstParagraph(), expectedAccountCreatedPageTexts.first_paragraph);
        Assert.assertEquals(accountCreatedPage.getTextSecondParagraph(), expectedAccountCreatedPageTexts.second_paragraph);
    }

    @Then("The message about existing email should be shown")
    public void existing_email_message_shown() {
        loginPage = pageManager.getLoginPage();
        Assert.assertTrue(loginPage.getEmailExist().isDisplayed());
    }

    @When("User logs in")
    public void user_logs_in() {
        loginPage = pageManager.getLoginPage();
        loginPage.loginIntoAccount(user);
    }

    @Then("Main menu has an option to delete account")
    public void check_main_menu() {
        mainPage = pageManager.getMainPage();
        Assert.assertTrue(mainPage.getDeleteAccount().isDisplayed());
    }

    @When("User removes account")
    public void user_removes_account() {
        mainPage = pageManager.getMainPage();
        mainPage.removeAccount();
    }

    @Then("Account successfully removed")
    public void account_removed() {
        AccountDeletedPage accountDeletedPage = pageManager.getAccountDeletedPage();
        BasePage.getWait().until(ExpectedConditions.visibilityOf(accountDeletedPage.getHeader()));
        Assert.assertEquals(accountDeletedPage.getURL(), FileReaderManager.getPropertiesFileReader().getAccountDeletedPageURL());
        Assert.assertEquals(accountDeletedPage.getTextFirstParagraph(), expectedAccountRemovedPageTexts.first_paragraph);
        Assert.assertEquals(accountDeletedPage.getTextSecondParagraph(), expectedAccountRemovedPageTexts.second_paragraph);
    }
}
