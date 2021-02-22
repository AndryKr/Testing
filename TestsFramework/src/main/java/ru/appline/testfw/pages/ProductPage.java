package ru.appline.testfw.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[@class='product-card-price__current']")
    private WebElement price;

    @FindBy(xpath = "//select[@class='ui-input-select product-warranty__select']")
    private List<WebElement> additionalGuarantee;

    @FindBy(xpath = "//span[@class='product-card-price__current product-card-price__current_active']")
    private WebElement priceWithAdditionalGuarantee;

    @FindBy(xpath = "//button[@class='button-ui buy-btn button-ui_brand button-ui_passive']")
    private WebElement buttonBuy;

    public void savePrice() {
        Integer sum = Integer.parseInt(price.getText().trim().replace("₽", ""));
    }

    public ProductPage selectAdditionalGuarantee() {
        return null;
    }

    public int getPrice() {
        return Integer.parseInt(price.getText().trim().replaceAll("\\D", ""));
    }

    public ProductPage buy() {
        return null;
    }
}
