package ru.company.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This class contains example TestNG tests that use the Selenium
 */
public class ExampleTestngSeleniumTest {
    @Test
    public void chromeShouldSearchMoscowInGoogle() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        WebElement searchInputBar = driver.findElement(By.xpath("//input[@aria-label='Найти']"));
        String cityNameToSearch = "Moscow";
        searchInputBar.sendKeys(cityNameToSearch);
        searchInputBar.submit();
        String currentPageTitle = driver.getTitle();
        Assert.assertEquals(currentPageTitle.contains(cityNameToSearch), true);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (driver != null) {
            driver.quit();
        }
    }
}
