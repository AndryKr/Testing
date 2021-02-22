package ru.appline.testfw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
* StartPage - стартовая страница https://www.sberbank.ru/ru/person
*/
public class StartPage extends BasePage {

    @FindBy(xpath = "//input[@type='search' and @placeholder='Поиск по сайту']")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@data-cga_click_top_menu='Карты_Дебетовые карты_type_important']")
    private WebElement debitCardsLink;

    /**
     * clickSearchInput - метод производит клик по строке поиска "Поиск по сайту" и вводит поисковый запрос
     * @param value - поисковый запрос
     */
    public SearchPage clickSearchInput(String value) {
        elementToBeClickable(searchInput);
        searchInput.click();
        searchInput.sendKeys(value);
        return new SearchPage();
    }


}
