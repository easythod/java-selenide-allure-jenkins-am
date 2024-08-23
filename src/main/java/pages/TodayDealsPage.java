package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.selector.ByAttribute;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class TodayDealsPage {

    private ElementsCollection listAllDeals = $$(new ByAttribute("data-testid", "deal-card"));
    private ElementsCollection listDeals = $$(".overflow-hidden");

    @Step("Select product category from the list by index:{categoryNumber}")
    public void selectProductCategory(int categoryNumber){
        this.listAllDeals.get(categoryNumber).click();
    }

    @Step("Select first deal from deals list")
    public void selectFirstDeal(){
        this.listDeals.first().click();
    }

}
