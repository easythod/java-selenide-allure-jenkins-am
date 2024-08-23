package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByAttribute;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private SelenideElement buttonSignIn = $("#nav-signin-tooltip");
    private SelenideElement buttonCart = $("#nav-cart");
    private SelenideElement hrefTodayDeals = $(new ByAttribute("data-csa-c-content-id", "nav_cs_gb"));
    private SelenideElement menuAccountList = $("#nav-link-accountList");
    private SelenideElement linkYourOrders = $("#nav_prefetch_yourorders");
    private SelenideElement linkYouAddresses = $("#nav_prefetch_youraddresses");
    private SelenideElement linkYourList = $("#nav-al-your-account > a:nth-child(5)");

    @Step("Press to Sign In button on Home page")
    public void buttonSignIn(){
        this.buttonSignIn.click();
    }

    @Step("Go to Today's Deals page from header")
    public void goToTodayDealsPage(){
        this.hrefTodayDeals.click();
    }

    @Step("Go to Cart page from header")
    public void goToCartPage(){
        this.buttonCart.click();
    }

    @Step("Go to Your Orders page from Account&List menu")
    public void goToYourOrdersPage(){
        this.menuAccountList.hover();
        this.linkYourOrders.click();
    }

    @Step("Go to Your Addresses page from Account&List menu")
    public void goToYourAddressesPage(){
        this.menuAccountList.hover();
        this.linkYouAddresses.click();
    }

    @Step("Go to Your Lists page from Account&List menu")
    public void goToYourListsPage(){
        this.menuAccountList.hover();
        this.linkYourList.click();
    }

}
