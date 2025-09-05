package com.mcmaster.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class McMasterCarrTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Adjust path to your chromedriver as needed
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Verify that 'Fastening & Joining' category loads and contains expected subcategories.")
    public void testFasteningAndJoiningCategory() {
        // Navigate to the main page
        driver.get("https://www.mcmaster.com/");

        // Click on the "Fastening & Joining" category link
        WebElement fasteningCategory = driver.findElement(
                By.linkText("Fastening & Joining")
        );
        Assert.assertTrue(fasteningCategory.isDisplayed(), "Fastening & Joining category should be visible on the home page.");
        fasteningCategory.click();

        // Wait for page to load (simple sleep; for real use, replace with WebDriverWait)
        try { Thread.sleep(2000); } catch (InterruptedException e) { /* ignore */ }

        // Check the heading or breadcrumbs show "Fastening & Joining"
        WebElement heading = driver.findElement(
                By.tagName("h1")
        );
        Assert.assertTrue(
                heading.getText().contains("Fastening & Joining"),
                "Page heading should contain 'Fastening & Joining'; found: " + heading.getText()
        );

        // Check presence of a known subcategory, e.g. "Screws & Bolts"
        WebElement screwsLink = driver.findElement(
                By.linkText("Screws & Bolts")
        );
        Assert.assertTrue(
                screwsLink.isDisplayed(),
                "'Screws & Bolts' should be visible in the Fastening & Joining category."
        );
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
