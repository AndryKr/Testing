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
        driver.manage().timeouts().pageLoadTimeout(47, TimeUnit.SECONDS);
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

        String forCompanyLinkXPass = "//div[@class='h3 adv-analytics-navigation-line2-link']/a[normalize-space()='Компаниям']";
        WebElement webElement = driver.findElement(By.xpath(forCompanyLinkXPass));
        webElement.click();

        Assert.assertEquals("Заголовок отсутствует | Не соответствует требуемому",
                "Корпоративное страхование для компаний | Росгосстрах", driver.getTitle());

        String healthcareLinkXPass = "//div[@class='list-group list-group-rgs-menu collapse']/a[normalize-space()='Здоровье']";
        WebElement healthcare = driver.findElement(By.xpath(healthcareLinkXPass));
        healthcare.click();

        Assert.assertEquals("Заголовок отсутствует | Не соответствует требуемому",
                "ДМС для сотрудников - добровольное медицинское страхование от Росгосстраха", driver.getTitle());

        String dmsLinkXPass = "//a[normalize-space()='Добровольное медицинское страхование']";
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
        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "LastName"))), "Иванов");
        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "FirstName"))), "Пётр");
        String selectXPath = "//select";
        selectField(driver.findElement(By.xpath(selectXPath)), "Москва");
        String phoneXPath = "//label[text()='Телефон']/..//input";
        fillPhoneField(driver.findElement(By.xpath(phoneXPath)), "9998887799");
        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "Email"))), "qwreqwrwqrwe");
        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "ContactDate"))), "19.08.2022");
        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "Comment"))), "Я согласен на обработку");
        fillCheckBox(driver.findElement(By.xpath("//*[@class='checkbox']")), "on");


        driver.findElement(By.xpath("//*[@id='button-m']")).click();

        String errorMsg = driver.findElement(By.xpath("//*[@name='Email']/..//span")).getText();
        Assert.assertEquals("У поля Email присутствует сообщение об ошибке",
                "Введите адрес электронной почты", errorMsg);
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

    private void fillPhoneField(WebElement webElement, String value) {
        scrollToElementJs(webElement);
        waitUtilElementToBeClickable(webElement);
        webElement.click();
        webElement.sendKeys(value);
    }

    private void fillCheckBox(WebElement webElement, String value) {
        scrollToElementJs(webElement);
        webElement.click();
        webElement.sendKeys(value);
        Assert.assertEquals("Поле было заполнено не корректно", value, webElement.getAttribute("value"));
    }

    private void selectField(WebElement webElement, String value) {
        scrollToElementJs(webElement);
        waitUtilElementToBeClickable(webElement);
        webElement.click();
        String fieldXPass = "//option[text()='%s']";
        WebElement region = driver.findElement(By.xpath(String.format(fieldXPass, value)));
        region.click();
    }

}