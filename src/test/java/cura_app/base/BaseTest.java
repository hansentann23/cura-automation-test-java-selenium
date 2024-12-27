package cura_app.base;

import base.LandingPage;
import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static base.BasePage.delay;
import static utilities.Utility.setUtilityDriver;

public class BaseTest {
    private WebDriver driver;
    protected BasePage basePage;
    protected LandingPage landingPage;
    private String CURAAPP_URL = "https://katalon-demo-cura.herokuapp.com/";

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication(){
        driver.get(CURAAPP_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtilityDriver();
        landingPage = new LandingPage();
        String username = "John Doe";
        String password = "ThisIsNotAPassword";
        var loginPage = landingPage.goToLoginPage();
        loginPage.clickLoginButton();
        loginPage.fillUserNameField(username);
        loginPage.fillPasswordField(password);
        loginPage.clickLoginButton();
    }

    @AfterClass
    public void tearDown(){
        delay(3000);
        driver.quit();
    }
}
