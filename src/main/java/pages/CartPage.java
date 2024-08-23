package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private SelenideElement titleProductOnPage = $(".a-truncate-cut");
    private SelenideElement priceProductOnPage = $(".sc-product-price");
    private SelenideElement qtyProductOnPage = $("#sc-subtotal-label-activecart");
    private SelenideElement subtotalProductOnPage = $("#sc-subtotal-amount-activecart");

    @Step("Verify correct item name of the item added to the cart is displayed correctly")
    public void checkTitleItem(String titleItem){
        this.titleProductOnPage.shouldHave(text(titleItem));
    }

    @Step("Verify correct item price of the item added to the cart is displayed correctly")
    public void checkPriceProduct(String priceProduct){
        this.priceProductOnPage.shouldHave(text(priceProduct));
    }

    @Step("Verify correct item qty of the item added to the cart is displayed correctly")
    public void checkQutSelectedProduct(String qtyProduct){
        this.qtyProductOnPage.shouldHave(text(qtyProduct));
    }

    @Step("Verify correct item subtotal of the item added to the cart is displayed correctly")
    public void checkSubtotalProduct(String priceProduct, String qtyProduct){
        int qty = Integer.parseInt(qtyProduct.trim());
        double price = Double.parseDouble(priceProduct);
        double subtotal = price * qty;
        this.subtotalProductOnPage.shouldHave(text(String.format("%.2f",subtotal)));
    }
}
