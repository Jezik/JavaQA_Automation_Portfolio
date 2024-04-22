package stepdefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSteps {

    private WebDriver driver;

    @Given("User launches Chrome")
    public void launchChromeDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @When("User goes to main url")
    public void openURL() {
        driver.get("https://www.automationexercise.com/");
    }

    @Then("The main page is opened successfully")
    public void checkOpenedURL() {
        assertEquals(driver.getTitle(), "Automation Exercise");
    }

    @After
    public void closeBrowser() {
        driver.close();
    }
}
