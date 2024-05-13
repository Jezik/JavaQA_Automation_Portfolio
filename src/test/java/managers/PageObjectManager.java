package managers;

import pageObjects.*;

public class PageObjectManager {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private AccountCreatedPage accountCreatedPage;
    private AccountDeletedPage accountDeletedPage;

    public PageObjectManager() {}

    public MainPage getMainPage() {
        return (mainPage == null) ? mainPage = new MainPage() : mainPage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
    }

    public RegistrationPage getRegistrationPage() {
        return (registrationPage == null) ? registrationPage = new RegistrationPage() : registrationPage;
    }

    public AccountCreatedPage getAccountCreatedPage() {
        return (accountCreatedPage == null) ? accountCreatedPage = new AccountCreatedPage() : accountCreatedPage;
    }

    public AccountDeletedPage getAccountDeletedPage() {
        return (accountDeletedPage == null) ? accountDeletedPage = new AccountDeletedPage() : accountDeletedPage;
    }
}
