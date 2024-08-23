package steps;

import pages.HomePage;
import pages.SignInPage;

public class SignInSteps {

    HomePage homePage = new HomePage();
    SignInPage signInPage = new SignInPage();

    public void signInWithNoRegistrationEmail(String email, String errorMessage) {
        homePage.buttonSignIn();
        signInPage.enterEmail(email);
        signInPage.goToPasswordForm();
        signInPage.checkErrorMassage(errorMessage);
    }

}
