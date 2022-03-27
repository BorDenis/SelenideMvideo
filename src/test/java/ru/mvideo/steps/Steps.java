package ru.mvideo.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.mvideo.pages.ProductListPage;

public class Steps {

    private String url = "https://www.mvideo.ru/product-list-page?q=%D1%85%D0%BE%D0%BB%D0%BE%D0%B4%D0%B8%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA&category=holodilniki-i-morozilnye-kamery-159";

    private ProductListPage productListPage;

    /**
     * Меняет вид представления товаров на список
     */
    public void switchToListView(){
        productListPage.switchViewTo("list").click();
    }

    /**
     * Меняет вид представления товаров на сетку
     */
    public void switchToGridView(){
        productListPage.switchViewTo("grid").click();
    }

    public void findProduct(String productName){
        productListPage.getProductCard(productName).scrollIntoView(false);
    }

//    @BeforeClass
//    public void bClass(){
//        Configuration.holdBrowserOpen = true;
//    }
//
//    @Test
//    public void test(){
//        Selenide.open(url);
//        switchToListView();
//        findProduct("Холодильник Indesit ITS 4200 W");
//    }

    public Steps (){
        Selenide.open(url);
        productListPage = ProductListPage.getProductListPage();
        WebDriverRunner.closeWebDriver();
    }
}
