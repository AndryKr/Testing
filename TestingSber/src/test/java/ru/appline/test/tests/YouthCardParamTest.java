package ru.appline.test.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.appline.test.base.BaseTests;

import java.util.List;

@DisplayName("Параметризированный класс для тестирования формы заявки на Молодёжную карту")
public class YouthCardParamTest extends BaseTests {

    @ParameterizedTest(name = "Запуск теста с параметрами = {0} {1} {2} {3}")
    @MethodSource("ru.appline.test.data.DataClass#getData")
    public void testScenario(String lastName, String firstName, String middleName, String cardName) {

        //Нажимаем на меню - "Карты"
        String cardsLinkXPass = "//a[@aria-label='Карты']";
        WebElement cardsLink = driver.findElement(By.xpath(cardsLinkXPass));
        wait.until(ExpectedConditions.elementToBeClickable(cardsLink));
        cardsLink.click();

        //Выбераем подменю "Дебетовые карты"
        String debitCardsLinkXPass = "//a[@data-cga_click_top_menu='Карты_Дебетовые карты_type_important']";
        WebElement debitCardsLink = driver.findElement(By.xpath(debitCardsLinkXPass));
        wait.until(ExpectedConditions.elementToBeClickable(debitCardsLink));
        debitCardsLink.click();

        //Проверяем наличие на страницы заголовка "Дебетовые карты"
        String h1 = "Дебетовые карты";
        WebElement h1Element = driver.findElement(By.xpath("//h1"));
        Assertions.assertEquals(h1, h1Element.getText(), "Заголовок " + h1 + " отсутствует | Не соответствует требуемому");

        //Прод заголовком из представленных карт находим "Моложёжные карты" и кликаем на кнопку даной карты "Заказато онлайн"
        String h2YouthCardXPass = "//h2[text()='Молодёжная карта']";
        WebElement h2YouthCard = driver.findElement(By.xpath(h2YouthCardXPass));
        scrollToElementJs(h2YouthCard);
        String orderButtonXPass = h2YouthCardXPass + "/../..//" +
                "div[@class='product-catalog__buttons']/..//a/..//span[text()='Заказать онлайн']";
        WebElement orderButton = driver.findElement(By.xpath(orderButtonXPass));
        wait.until(ExpectedConditions.elementToBeClickable(orderButton));
        orderButton.click();

        //Проверяем наличие на странице заголовка "Молодёжная карта"
        String h1YouthCard = "Молодёжная карта";
        WebElement h1YouthCardElement = driver.findElement(By.xpath("//h1[text()='Молодёжная карта']"));
        scrollToElementJs(h1YouthCardElement);
        Assertions.assertEquals(h1YouthCard, h1YouthCardElement.getText(), "Заголовок " + h1YouthCard + " отсутствует | " +
                "Не соответствует требуемому");

        //Кликаем по кнопке "Оформить онлайн" под заголовоком
        String arrangeButtonXPass = "//h1[text()='Молодёжная карта']/../..//div[@class='page-teaser-dict__button']" +
                "/..//a[@data-test-id='PageTeaserDict_button']";
        WebElement arrangeButton = driver.findElement(By.xpath(arrangeButtonXPass));
        wait.until(ExpectedConditions.elementToBeClickable(arrangeButton));
        arrangeButton.click();

        //Заполняем поля согласно заданию, в методе fillInputField проверяем корректность заполнения
        String fieldXPass = "//input[@data-name='%s']";

        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "lastName"))), lastName);
        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "firstName"))), firstName);
        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "middleName"))), middleName);

        WebElement webElement = driver.findElement(By.xpath(String.format(fieldXPass, "cardName")));
        Assertions.assertEquals(webElement.getAttribute("value"), cardName);

        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "birthDate"))), "11.02.1990");
        fillInputField(driver.findElement(By.xpath(String.format(fieldXPass, "email"))), "petrov@gmail.com");
        fillPhoneField(driver.findElement(By.xpath(String.format(fieldXPass, "phone"))), "9207775544");

        //Кликаем по кнопке "Далее"
        WebElement nextButton = driver.findElement(By.xpath("//span[text()='Далее']/.."));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();

        //Проверка наличия сообщения "Обязательное поле" у незаполненных полей
        List<WebElement> listErrorWebElements = driver.findElements(By.xpath("//div[text()='Обязательное поле']"));
        Assertions.assertEquals(3, listErrorWebElements.size(),"Найдено неверное количество сообщений ошибки заполнения данных");
        String errorFieldXPath = "//label[text()='%s']/..//div[text()='Обязательное поле']";
        Assertions.assertAll(
                ()-> Assertions.assertEquals("Обязательное поле", driver.findElement(By.xpath(String.format(errorFieldXPath, "Серия"))).getText()),
                ()-> Assertions.assertEquals("Обязательное поле", driver.findElement(By.xpath(String.format(errorFieldXPath, "Номер"))).getText()),
                ()-> Assertions.assertEquals("Обязательное поле", driver.findElement(By.xpath(String.format(errorFieldXPath, "Дата выдачи"))).getText()));
    }

    private void waitUtilElementToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    private void fillInputField(WebElement webElement, String value) {
        scrollToElementJs(webElement);
        waitUtilElementToBeClickable(webElement);
        webElement.click();
        webElement.sendKeys(Keys.CONTROL + "a");
        webElement.sendKeys(Keys.DELETE);
        webElement.sendKeys(value);
        Assertions.assertEquals(value, webElement.getAttribute("value"), "Поле было заполнено не корректно");
    }

    private void fillPhoneField(WebElement webElement, String value) {
        scrollToElementJs(webElement);
        waitUtilElementToBeClickable(webElement);
        webElement.click();
        webElement.sendKeys(Keys.CONTROL + "a");
        webElement.sendKeys(Keys.DELETE);
        webElement.sendKeys(value);
        String phoneMask = "+7 (" + value.substring(0, 3) + ") " + value.substring(3, 6) + "-" + value.substring(6, 8) +
                "-" + value.substring(8);
        Assertions.assertEquals(webElement.getAttribute("value"), phoneMask);
    }

    private void scrollToElementJs(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
