package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {

    @Test
    public void searchTest() {
        // Step 1: Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Step 2: Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Step 3: Maximize browser
        driver.manage().window().maximize();

        // Step 4: Open Google
        driver.get("https://www.google.com");

        // Step 5: Locate search box using NAME locator
        WebElement searchBox = driver.findElement(By.name("q"));

        // Step 6: Enter text using sendKeys()
        searchBox.sendKeys("Selenium WebDriver");

        // Step 7: Locate search box using CSS Selector
        WebElement search = driver.findElement(
            By.cssSelector("textarea[name='q'], input[name='q']")
        );

        // Step 8: Press ENTER to search
        search.sendKeys(Keys.ENTER);

        // Step 9: Print page title
        System.out.println("Title: " + driver.getTitle());

        // Step 10: Close browser
        driver.quit();
    }
}
