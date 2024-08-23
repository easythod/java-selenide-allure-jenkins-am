package steps;

import pages.CartPage;
import pages.HomePage;
import pages.ProductInfoPage;
import pages.TodayDealsPage;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class TodayDealsSteps {

    HomePage homePage = new HomePage();
    TodayDealsPage todayDealsPage = new TodayDealsPage();
    ProductInfoPage productInfoPage = new ProductInfoPage();
    CartPage cartPage = new CartPage();

    public void addProductToCart(int categoryNumber, int productQty) throws FileNotFoundException, InterruptedException {
        HashMap infoItem;

        homePage.goToTodayDealsPage();
        todayDealsPage.selectProductCategory(categoryNumber);
        todayDealsPage.selectFirstDeal();
        productInfoPage.selectQty(productQty);
        infoItem = productInfoPage.getInfoItem();
        productInfoPage.buttonAddToCart();
        productInfoPage.disclaimWarranty();
        homePage.goToCartPage();

        cartPage.checkTitleItem((String) infoItem.get("productTitle"));
        cartPage.checkPriceProduct((String) infoItem.get("productPrice"));
        cartPage.checkQutSelectedProduct(String.valueOf(productQty));
        cartPage.checkSubtotalProduct((String) infoItem.get("productPrice"), String.valueOf(productQty));
    }

}
