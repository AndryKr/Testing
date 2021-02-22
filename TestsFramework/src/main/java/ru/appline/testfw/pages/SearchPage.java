package ru.appline.testfw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.appline.testfw.model.Product;

import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//div[@class='catalog-products view-simple']//a[@class='catalog-product__name ui-link ui-link_black']")
    private List<WebElement> elementsOnPage;

    /**
     * findElementOnPage - метод производит клик по строке поиска "Поиск по сайту" и вводит поисковый запрос
     * @param value - наименование искомого продукта
     */
    public ProductPage findElementOnPage(String value) {
        for (WebElement webElement : elementsOnPage) {
            if (webElement.getText().toLowerCase().contains(value.toLowerCase())) {
                scrollToElementJs(webElement);
                elementToBeClickable(webElement);
                webElement.click();
            }
        }
        return new ProductPage();
    }

}
