package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.waiter.JSWaiter;

import java.time.Duration;
import java.util.List;

public abstract class Page {
    protected WebDriver driver;
    private JavascriptExecutor jsExecutor;

    Wait<WebDriver> wait;
    private final long SECONDS_TO_WAIT = 10;
    private final long POLLING_SECONDS = 1;

    protected abstract Page openPage();

    protected Page(WebDriver driver) {
        this.driver = driver;
        jsExecutor = (JavascriptExecutor) driver;

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(SECONDS_TO_WAIT))
                .pollingEvery(Duration.ofSeconds(POLLING_SECONDS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Timeout was exceeded!");

        PageFactory.initElements(driver, this);
    }

    protected WebElement getWebElement(By locator) {
        return wait
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator))
                .get(0);
    }

    protected List<WebElement> getWebElementsList(By locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected Page waitUntilJSReady() {
        wait.until(JSWaiter.waitUntilJSReady());
        return this;
    }
}
