package stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.BasePage;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void startTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        BasePage.setDriver(driver, FileReaderManager.getPropertiesFileReader().getImplicitlyWaitSeconds());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
