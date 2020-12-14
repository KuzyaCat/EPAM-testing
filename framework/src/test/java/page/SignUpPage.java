package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignUpPage extends Page {
    private final String BASE_PAGE_URL = "https://deal.by/join-customer";

    private final String EMAIL_INPUT__XPATH = "//input[(@class='lp-vertical-form__input') and (@data-qaid='email')]";
    private final String SUBMIT_BUTTON_XPATH = "//button[@data-qaid='submit']";

    private final By ERRORS_LOCATOR = By.xpath("//div//p[@class='lp-error-line']");

    @FindBy(xpath = EMAIL_INPUT__XPATH)
    private WebElement emailInput;

    @FindBy(xpath = SUBMIT_BUTTON_XPATH)
    private WebElement submitButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage enterValueToEmailInput(String value) {
        logger.info("Enter value to email input: " + value);
        emailInput.sendKeys(value);
        return this;
    }

    public SignUpPage clickSubmitButton() {
        logger.info("Click submit button");
        submitButton.click();
        return this;
    }

    public List<WebElement> getErrorsElements() {
        logger.info("Get errors element");
        return getWebElementsList(ERRORS_LOCATOR);
    }

    public SignUpPage openPage() {
        logger.info("Open page: " + BASE_PAGE_URL);
        driver.get(BASE_PAGE_URL);
        return this;
    }
}
