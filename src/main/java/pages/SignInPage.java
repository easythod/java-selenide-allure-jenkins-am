package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    private SelenideElement fieldEmail = $("#ap_email");
    private SelenideElement buttonContinueOnEmailForm = $("#continue");
    private SelenideElement errorMassage = $("#auth-error-message-box");

    @Step("Enter email to field")
    public void enterEmail(String Email){
        this.fieldEmail.sendKeys(Email);
    }

    @Step("Press button Continue on Email form")
    public void goToPasswordForm(){
        this.buttonContinueOnEmailForm.click();
    }

    @Step("Check error message")
    public void checkErrorMassage(String errorMessage){
        errorMassage.shouldHave(text(errorMessage));
    }
}
