package ru.appline.testfw.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class='cart-items__product']")
    List<WebElement> productsInCart;

    @FindBy(xpath = "//div[@class = 'total-amount__label']")
    WebElement cartTotal;

    @FindBy(xpath = "//div[@class = 'total-amount__label']//div[contains(@class,'price__block')]/span[@class='price__current']")
    WebElement totalPrice;

    @FindBy(xpath = "//div[@class = 'total-amount__label']//div[@class='total-amount__count']")
    WebElement productQuantity;


    public Integer getProductPrice(String productName) {
        return null;
    }


    public Integer getTotalPrice() {
        return null;
    }

    public CartPage verifyCorrectnessPricesAndAmounts() {
        return null;
    }

    public CartPage deleteProduct(String productName) {
        return null;
    }


    public Integer productAmount(String productName) {
        return null;
    }

    public boolean productIsPresent(String productName) {
        return false;
    }

    public CartPage increaseNumberOfProduct(String productName) {
        return null;
    }

    public CartPage restoreLastRemoved() {
        return null;
    }

}
