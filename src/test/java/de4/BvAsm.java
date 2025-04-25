package de4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BvAsm {
    private WebDriver driver;
    private WebDriver driver2;

    private static final String BASE_URL = "https://siu.edu.vn/wp-admin";
    private static final String BASE_URL_2 = "https://www.mns.com";

    private static final By USERNAME_INPUT = By.id("user_login");
    private static final By PASSWORD_INPUT = By.id("user_pass");
    private static final By LOGIN_BUTTON = By.id("wp-submit");
    //-------------------------------
    private static final By SEARCH_BUTTON_BF = By.cssSelector("body > main > section.nav_logo_layout > button.search_icon");

    private static final By SEARCH_INPUT = By.cssSelector("#search_kw_n");
    private static final By SEARCH_BUTTON_AT = By.cssSelector("#generalsearch_n > div > button");

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver2 = new EdgeDriver();
        driver.manage().window().maximize();
        driver2.manage().window().maximize();
    }

    @BeforeMethod
    public void login() {
        driver.get(BASE_URL);
        driver2.get(BASE_URL_2);
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginTestData() {
        return new Object[][]{
                {"ps39159", "123456789@"},
                {"ps39152", "123456789"},
                {"ps39151", "123456789"},
                {"ps39152", "123456789@"},
        };
    }

    @DataProvider(name = "DataEdge")
    public Object[][] dataEdge() {
        return new Object[][]{
                {"Việt Nam"},
        };
    }

    @Test(dataProvider = "LoginData", description = "Đăng nhập")
    public void testLogin(String username, String password) {
        // Mở trang đăng nhập
        driver.get(BASE_URL);

        // Nhập MSSV vào ô Username
        WebElement usernameField = driver.findElement(USERNAME_INPUT);
        usernameField.clear();
        usernameField.sendKeys(username);

        // Nhập mật khẩu vào ô Password
        WebElement passwordField = driver.findElement(PASSWORD_INPUT);
        passwordField.clear();
        passwordField.sendKeys(password);

        // Nhấn nút Log in
        WebElement loginButton = driver.findElement(LOGIN_BUTTON);
        loginButton.click();
    }

    @Test(dataProvider = "DataEdge", description = "Tìm kiếm")
    public void testSearch(String key) {
        // Truy cập trang mns.com
        driver2.get(BASE_URL_2);

        // Click vào biểu tượng kính lúp tìm kiếm
        WebDriverWait wait = new WebDriverWait(driver2, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(SEARCH_BUTTON_BF)).click();

        // Nhập từ khóa tìm kiếm
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_INPUT));
        searchInput.clear();
        searchInput.sendKeys(key);

        // Click nút tìm kiếm
        WebElement searchButton = driver2.findElement(SEARCH_BUTTON_AT);
        searchButton.click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null && driver2 != null) {
            driver.quit();
            driver2.quit();
        }
    }
}
