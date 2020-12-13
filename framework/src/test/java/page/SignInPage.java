package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignInPage extends Page {
    private final String PAGE_URL = "https://my.deal.by/cabinet/sign-in";

    private final String EMAIL_INPUT_ID = "phone_email";
    private final String CONFIRM_EMAIL_BUTTON_ID = "phoneEmailConfirmButton";

    private final By PASSWORD_INPUT_LOCATOR = By.id("enterPassword");
    private final By CONFIRM_PASSWORD_BUTTON_LOCATOR = By.id("enterPasswordConfirmButton");
    private final By CABINET_CONTROLS_LOCATOR = By.className("b-header__controls-item");

    @FindBy(id = EMAIL_INPUT_ID)
    private WebElement emailInput;

    @FindBy(id = CONFIRM_EMAIL_BUTTON_ID)
    private WebElement confirmEmailButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage enterEmailToInput(String email) {
        emailInput.sendKeys(email);
        logger.info("Enter email to input: " + email);
        return this;
    }

    public SignInPage enterPasswordToInput(String password) {
        getWebElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
        logger.info("Enter email to input: " + password);
        return this;
    }

    public SignInPage clickConfirmEmailButton() {
        confirmEmailButton.click();
        logger.info("Click on confirm email button");
        return this;
    }

    public SignInPage clickConfirmPasswordButton() {
        getWebElement(CONFIRM_PASSWORD_BUTTON_LOCATOR).click();
        logger.info("Click on confirm password button");
        return this;
    }

    public List<WebElement> getCabinetControlsElement() {
        logger.info("Get My cabinet controls element");
        return getWebElementsList(CABINET_CONTROLS_LOCATOR);
    }

    public SignInPage openPage() {
        driver.get(PAGE_URL);
        logger.info("Open page: " + PAGE_URL);
        return this;
    }
}
