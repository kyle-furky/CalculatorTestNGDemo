package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button.radius");
    private By flashMessage = By.id("flash");



    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getFlashMessage() {
        return driver.findElement(flashMessage).getText();
    }

    public void login(String username, String password){ 
        setUsername(username); 
        setPassword(password);
        clickLogin();
    }
}
