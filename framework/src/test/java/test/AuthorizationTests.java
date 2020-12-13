package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SignInPage;

public class AuthorizationTests extends CommonConditions {
    @Test(description = "Test sign in")
    public void signInTest() {
        SignInPage signInPage = new SignInPage(driver)
                .openPage();

        signInPage
            .enterEmailToInput("lizerd34@mail.ru")
            .clickConfirmEmailButton()
            .enterPasswordToInput("12563478")
            .clickConfirmPasswordButton();

        boolean haveBeenSignedIn = signInPage.getCabinetControlsElement().size() > 0;
        Assert.assertTrue(haveBeenSignedIn);
    }
}
