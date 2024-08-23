package steps;

import com.codeborne.selenide.Configuration;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;

public class HomeSteps {

    HomePage homePage = new HomePage();

    public void goToYourOrdersPageWhenUserNoAuthorized() {
        homePage.goToYourOrdersPage();
        webdriver().shouldHave(urlStartingWith(Configuration.baseUrl + "ap/signin"));
        webdriver().driver().executeJavaScript("window.history.go(-1)");
    }

    public void goToYourAddressesPageWhenUserNoAuthorized() {
        homePage.goToYourAddressesPage();
        webdriver().shouldHave(urlStartingWith(Configuration.baseUrl + "ap/signin"));
        webdriver().driver().executeJavaScript("window.history.go(-1)");
    }

    public void goToYourListsPageWhenUserNoAuthorized() {
        homePage.goToYourListsPage();
        webdriver().shouldHave(urlStartingWith(Configuration.baseUrl + "hz/wishlist/intro"));
        webdriver().driver().executeJavaScript("window.history.go(-1)");
    }
}
