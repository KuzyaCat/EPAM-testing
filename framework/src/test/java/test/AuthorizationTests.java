package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SignInPage;

public class AuthorizationTests extends CommonConditions {
    @Test(description = "Test sign in with right data")
    public void signInWithRightDataTest() {
        SignInPage signInPage = new SignInPage(driver)
                .openPage();

        signInPage
            .enterEmailToInput("lizerd34@mail.ru")
            .clickConfirmEmailButton()
            .enterPasswordToInput("12563478")
            .clickConfirmPasswordButton();

        boolean haveBeenSignedIn = signInPage.getCabinetControlsElements().size() > 0;
        Assert.assertTrue(haveBeenSignedIn);
    }

    @Test(description = "Test sign in with wrong password")
    public void signInWithWrongPasswordTest() {
        SignInPage signInPage = new SignInPage(driver)
                .openPage();

        signInPage
                .enterEmailToInput("lizerd34@mail.ru")
                .clickConfirmEmailButton()
                .enterPasswordToInput("kek")
                .clickConfirmPasswordButton();

        boolean haveErrors = signInPage.getInputErrorsElements().size() > 0;
        Assert.assertTrue(haveErrors);
    }

    @Test(description = "Test sign in with wrong email")
    public void signInWithWrongEmailTest() {
        SignInPage signInPage = new SignInPage(driver)
                .openPage();

        signInPage
                .enterEmailToInput("kek@mail.ru")
                .clickConfirmEmailButton()
                .enterPasswordToInput("12563478")
                .clickConfirmPasswordButton();

        boolean haveErrors = signInPage.getInputErrorsElements().size() > 0;
        Assert.assertTrue(haveErrors);
    }

    @Test(description = "Test sign in with wrong email format")
    public void signInWithWrongEmailFormatTest() {
        SignInPage signInPage = new SignInPage(driver)
                .openPage();

        signInPage
                .enterEmailToInput("kek")
                .clickConfirmEmailButton();

        boolean haveErrors = signInPage.getEmailErrorsElements().size() > 0;
        Assert.assertTrue(haveErrors);
    }
}
