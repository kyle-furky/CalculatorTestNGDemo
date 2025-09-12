package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    @Test
    public void wikipediaSearchTest() {
        driver.get("https://www.wikipedia.org/");


        WebElement searchBox = driver.findElement(By.id("searchInput"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        String pageTitle=driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Selenium"),
                "Page title does not contain Selenium. Actual title: " +pageTitle);
    }
}
