package ru.appline.test.base;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(47, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10, 1000);
    }

    @AfterAll
    static void afterAll() {
        driver.quit();
    }

    @BeforeEach
    void beforeEach() {
        String baseURL = "https://www.sberbank.ru/ru/person";
        driver.get(baseURL);
    }
}
