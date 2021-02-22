package ru.appline.testfw.managers;

import ru.appline.testfw.pages.CartPage;
import ru.appline.testfw.pages.ProductPage;
import ru.appline.testfw.pages.SearchPage;
import ru.appline.testfw.pages.StartPage;

public class PageManager {

    private static PageManager pageManager;

    private PageManager () {
    }

    private StartPage startPage;
    private ProductPage productPage;
    private SearchPage searchPage;
    private CartPage cartPage;

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }
    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }
    public SearchPage getSearchPage() {
        if (searchPage == null) {
            searchPage = new SearchPage();
        }
        return searchPage;
    }
    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }
        return cartPage;
    }


}
