package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.Utils;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;

public class ProductInfoPage {

    private SelenideElement selectQty = $(By.name("quantity"));
    private SelenideElement buttonAddToCart = $("#atc-declarative");
    private SelenideElement buttonNoThanks = $("#attachSiNoCoverage");
    private SelenideElement productName = $("#productTitle");
    private SelenideElement productPrice = $("#corePrice_feature_div");

    Utils utils = new Utils();

    @Step("Choose the quantity of goods:{qty}")
    public void selectQty(int qty){
        this.selectQty.selectOptionByValue(String.valueOf(qty));
    }

    @Step("Add item to cart")
    public void buttonAddToCart(){
        this.buttonAddToCart.click();
    }

    @Step("Disclaim warranty")
    public void disclaimWarranty(){
        this.buttonNoThanks.click();
    }

    @Step("Get information about item")
    public HashMap getInfoItem() throws FileNotFoundException {

        Map<String, String> map = new HashMap<>();
        map.put("productTitle", productName.getText());
        map.put("productPrice", productPrice.getText().replaceAll("[^0-9.]", ""));
        map.put("qty", utils.getDataFromConfig("PRODUCT_QTY"));
        return (HashMap) map;
    }
}
