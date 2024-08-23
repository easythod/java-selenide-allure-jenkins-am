package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import steps.HomeSteps;
import steps.SignInSteps;
import steps.TodayDealsSteps;
import utils.SetupAndTeardown;
import utils.Utils;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.*;

public class AmazonTest extends SetupAndTeardown {

    Utils utils = new Utils();

    @Severity(SeverityLevel.MINOR)
    @Description("Verify user can’t login with valid but not registered email")
    @Story("Sign in")
    @Test(enabled = true, description = "Verify user. Check not registered email")
    void chooseNewGender() throws FileNotFoundException {

        open(Configuration.baseUrl);
        new SignInSteps().signInWithNoRegistrationEmail(utils.getDataFromConfig("EMAIL_NOT_REGISTERED_IN_AMAZON"),
                                                        utils.getDataFromConfig("ERROR_MESSAGE"));
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Verify that Items are added to cart correctly")
    @Story("Cart")
    @Test(enabled = true, description = "Cart. Verify Items in cart")
    void RecentSecurityActivity() throws FileNotFoundException, InterruptedException {

        open(Configuration.baseUrl);
        new TodayDealsSteps().addProductToCart(Integer.parseInt(utils.getDataFromConfig("CATEGORY_NUMBER")),
                                               Integer.parseInt(utils.getDataFromConfig("PRODUCT_QTY")));
    }

    @Severity(SeverityLevel.MINOR)
    @Description("Verify that you cannot see “Your Orders” and “Your Addresses” pages if you are not logged in. But you can see “Your Lists” intro screen")
    @Story("Sign in")
    @Test(enabled = true, description = "Account$Lists. Check the display Contacts page")
    void OpenContactsPage() {

        open(Configuration.baseUrl);

        HomeSteps homeSteps = new HomeSteps();
        homeSteps.goToYourOrdersPageWhenUserNoAuthorized();
        homeSteps.goToYourAddressesPageWhenUserNoAuthorized();
        homeSteps.goToYourListsPageWhenUserNoAuthorized();
    }

}
