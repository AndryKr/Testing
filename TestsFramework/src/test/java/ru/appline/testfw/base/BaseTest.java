package ru.appline.testfw.base;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.testfw.managers.InitManager;
import ru.appline.testfw.managers.PageManager;
import ru.appline.testfw.managers.TestPropManager;

import java.util.concurrent.TimeUnit;

import static ru.appline.testfw.managers.DriverManager.getDriver;
import static ru.appline.testfw.managers.DriverManager.quitDriver;
import static ru.appline.testfw.util.PropConst.APP_URL;

public class BaseTest {

    protected WebDriverWait wait;
    protected PageManager app = PageManager.getPageManager();

    @BeforeAll
    public void beforeAll() {
        InitManager.initFramework();
    }

    @AfterAll
    public void afterAll() {
        InitManager.quitFramework();
    }

    @BeforeEach
    public void beforeEach() {
        getDriver().get(TestPropManager.getTestPropManager().getProperty(APP_URL));
    }
}