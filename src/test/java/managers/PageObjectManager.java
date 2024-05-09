package managers;

import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.RegistrationPage;

public class PageObjectManager {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

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
}
