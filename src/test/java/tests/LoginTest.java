package tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testValidLogin(){
        loginPage.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(loginPage.getFlashMessage().contains("You logged into a secure area!"));
    }

    @Test
    public void testInvalidLogin(){
        loginPage.login("wrongUser", "wrongPass");
        Assert.assertTrue(loginPage.getFlashMessage().contains("Your username is invalid!"));
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
