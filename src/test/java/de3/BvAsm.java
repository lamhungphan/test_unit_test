package de3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BvAsm {
    private WebDriver driver;

    private static final String BASE_URL = "https://duckduckgo.com/";
    private static final By SEARCH_FIELD = By.id("searchbox_input");

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testSearch() {
        driver.get(BASE_URL);

        WebElement searchField = driver.findElement(SEARCH_FIELD);
        searchField.sendKeys("alibaba");
        searchField.submit();

        // Chờ trang kết quả hiển thị
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.titleContains("alibaba"));

        // Kiểm tra title chứa "alibaba"
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("alibaba"));
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
