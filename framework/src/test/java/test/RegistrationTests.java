package test;

import model.RegistrationData;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.SignUpPage;
import service.RegistrationDataCreator;

public class RegistrationTests extends CommonConditions {
    private RegistrationData registrationData;

    @Test(description = "Test sign up with existing email")
    public void signUpWithExistingEmailTest() {
        registrationData = RegistrationDataCreator.withEmailOnlyFromProperty();

        boolean haveErrors = new SignUpPage(driver)
                .openPage()
                .enterValueToEmailInput(registrationData.getEmail())
                .clickSubmitButton()
                .getErrorsElements()
                .size() > 0;

        Assert.assertTrue(haveErrors);
    }
}
