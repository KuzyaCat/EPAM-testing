package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SignInPage;
import service.UserCreator;

public class AuthorizationTests extends CommonConditions {
    private User user;

    @Test(description = "Test sign in with right data")
    public void signInWithRightDataTest() {
        user = UserCreator.withCredentialsFromProperty();

        SignInPage signInPage = new SignInPage(driver)
                .openPage();

        signInPage
            .enterEmailToInput(user.getEmail())
            .clickConfirmEmailButton()
            .enterPasswordToInput(user.getPassword())
            .clickConfirmPasswordButton();

        boolean haveBeenSignedIn = signInPage.getCabinetControlsElements().size() > 0;
        Assert.assertTrue(haveBeenSignedIn);
    }

    @Test(description = "Test sign in with wrong password")
    public void signInWithWrongPasswordTest() {
        user = UserCreator.withWrongPassword();

        SignInPage signInPage = new SignInPage(driver)
                .openPage();

        signInPage
                .enterEmailToInput(user.getEmail())
                .clickConfirmEmailButton()
                .enterPasswordToInput(user.getPassword())
                .clickConfirmPasswordButton();

        boolean haveErrors = signInPage.getInputErrorsElements().size() > 0;
        Assert.assertTrue(haveErrors);
    }

    @Test(description = "Test sign in with wrong email")
    public void signInWithWrongEmailTest() {
        user = UserCreator.withWrongEmail();

        SignInPage signInPage = new SignInPage(driver)
                .openPage();

        signInPage
                .enterEmailToInput(user.getEmail())
                .clickConfirmEmailButton()
                .enterPasswordToInput(user.getPassword())
                .clickConfirmPasswordButton();

        boolean haveErrors = signInPage.getInputErrorsElements().size() > 0;
        Assert.assertTrue(haveErrors);
    }

    @Test(description = "Test sign in with wrong format email")
    public void signInWithWrongFormatEmailTest() {
        user = UserCreator.withWrongFormatEmail();

        SignInPage signInPage = new SignInPage(driver)
                .openPage();

        signInPage
                .enterEmailToInput(user.getEmail())
                .clickConfirmEmailButton();

        boolean haveErrors = signInPage.getEmailErrorsElements().size() > 0;
        Assert.assertTrue(haveErrors);
    }
}
