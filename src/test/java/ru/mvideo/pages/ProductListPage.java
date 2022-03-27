package ru.mvideo.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class ProductListPage {

    private static ProductListPage productListPage;
    private SelenideElement productCard;

    @FindBy(xpath = "//mvid-view-switcher")
    private SelenideElement viewSwitcher;
    @FindBy(xpath = "//div[contains(@class, 'product-cards-layout--list')]")
    private SelenideElement cardsList;
    @FindBy(xpath = "//mvid-filters-list")
    private SelenideElement filtersList;

    private final String XPATH_VIEW_BUTTON_CONTAINER = ".//mvid-button[contains(@class, 'listing-view-switcher__button--%s')]";
    private final String XPATH_PRODUCT_CARD_CONTAINER = ".//mvid-plp-product-title[.//a[text() = ' %s ']]";

    public ProductListPage(){
    }

    /**
     * Инициальзация PageObject
     * @return
     */
    public static ProductListPage getProductListPage(){
        if (Objects.isNull(productListPage)) productListPage = Selenide.page(new ProductListPage());
        return productListPage;
    }

    /**
     * Возвращает кнопку для смены вида отображения товаров
     * @param view
     * @return
     */
    public SelenideElement switchViewTo(String view){
        String viewButton = String.format(XPATH_VIEW_BUTTON_CONTAINER, view);
        return viewSwitcher.$x(viewButton);
    }

    /**
     * Инициализация карточки продукта
     * @return
     */
    public SelenideElement getProductCard(String productName){
        String titleContainerPath = String.format(XPATH_PRODUCT_CARD_CONTAINER, productName);
        return cardsList.$x(titleContainerPath);
    }

    /**
     * Возвращает кнопку "Показать еще" для расширения списка товаров на странице
     */
    public SelenideElement getShowMoreButton(){
        return Selenide.$x("//button/span[text()= 'Показать ещё']");
    }

//    public SelenideElement getCategory(String categoryName){
//        return filtersList.$x(".//span[text()=' Категория '].//a[text() = ' %s ']");
//    }

}
