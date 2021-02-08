import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FormTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "src/webdriver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10, 1000);

        String baseUrl = "http://www.rgs.ru";

        driver.get(baseUrl);
    }

    @Test
    public void testScenario() {
        String menuLinkXPass = "//a[@data-toggle='dropdown' and @class='hidden-xs']";
        List<WebElement> webElementLists = driver.findElements(By.xpath(menuLinkXPass));
        if (!webElementLists.isEmpty()) {
            webElementLists.get(0).click();
        }

        String forCompanyLinkXPass = "//a[@href='https://www.rgs.ru/products/juristic_person/index.wbp']";
        WebElement webElement = driver.findElement(By.xpath(forCompanyLinkXPass));
        webElement.click();

        Assert.assertEquals("Заголовок отсутствует | Не соответствует требуемому",
                "Корпоративное страхование для компаний | Росгосстрах", driver.getTitle());

        String healthcareLinkXPass = "//a[@href='/products/juristic_person/health/index.wbp']";
        WebElement healthcare = driver.findElement(By.xpath(healthcareLinkXPass));
        healthcare.click();

        Assert.assertEquals("Заголовок отсутствует | Не соответствует требуемому",
                "ДМС для сотрудников - добровольное медицинское страхование от Росгосстраха", driver.getTitle());

        String dmsLinkXPass = "//a[@href='/products/juristic_person/health/dms/index.wbp']";
        WebElement dms = driver.findElement(By.xpath(dmsLinkXPass));
        dms.click();

        String h1 = "Добровольное медицинское страхование";
        WebElement h1Element = driver.findElement(By.xpath("//h1"));
        Assert.assertEquals("Заголовок h1 отсутствует | Не соответствует требуемому", h1, h1Element.getText());

        String buttonXPass = "//a[@class='btn btn-default text-uppercase hidden-xs adv-analytics-navigation-desktop-floating-menu-button']";
        WebElement buttonElement = driver.findElement(By.xpath(buttonXPass));
        buttonElement.click();

        String modalTitleXPass = "//b[@data-bind='text: options.title']";
        WebElement modalTitleElement = driver.findElement(By.xpath(modalTitleXPass));
        Assert.assertEquals("Заголовок h1 отсутствует | Не соответствует требуемому",
                "Заявка на добровольное медицинское страхование", modalTitleElement.getText());


        String fieldXPass = "//*[@name='%s']";
        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "LastName"))), "IVANOV");
        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "FirstName"))), "IVAN");

        String phoneXPath = "//div[@class='form-group col-md-6 col-xs-12 validation-group-has-error']//input";
        selectField(driver.findElement(By.xpath(phoneXPath)), "Москва");

        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "Email"))), "qwreqwrwqrwe");
        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "ContactDate"))), "19.08.1992");
        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "Comment"))), "Я согласен на обработку");
        fillInputField(driver.findElement(By.xpath("//*[@class='checkbox']")), "true");


        // Нажать на кнопку "Отправить"
        driver.findElement(By.xpath("//*[@id='button-m']")).click();
    }


    @After
    public void after() {
        driver.quit();
    }

    private void scrollToElementJs(WebElement webElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    private void waitUtilElementToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    private void fillInputField(WebElement webElement, String value) {
        scrollToElementJs(webElement);
        waitUtilElementToBeClickable(webElement);
        webElement.click();
        webElement.sendKeys(value);
        Assert.assertEquals("Поле было заполнено не корректно", value, webElement.getAttribute("value"));
    }

    private void selectField(WebElement webElement, String value) {
        scrollToElementJs(webElement);
        waitUtilElementToBeClickable(webElement);
        webElement.click();
        String fieldXPass = "//*[contains(@name, 'Region')]//*[contains(string(), '%S')]";
        WebElement region = driver.findElement(By.xpath(String.format(fieldXPass, value)));
        region.click();
    }

}