import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DataProvider(name = "searchData")
    public Object[][] searchData() {
        return new Object[][] {
                {"Java"},
                {"Selenium"},
                {"TestNG"}
        };
    }

    @Test(dataProvider = "searchData")
    public void testGoogleSearch(String query) {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(query);
        searchBox.submit();

        Assert.assertTrue(driver.getTitle().contains(query),
                "Page title does not contain: " + query);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
