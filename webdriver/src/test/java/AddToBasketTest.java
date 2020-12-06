import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddToBasketTest {
    private final String CHROME_DRIVER_PATH = "/drivers/chromedriver";
    private final String PAGE_URL = "https://cutt.ly/IhmH8m3"; // short link
    private final String BUY_BUTTON_CLASSNAME = "js-product-buy-button";
    private final String BASKET_ITEMS_COUNTER_CLASSNAME = "x-header__controls-counter";
    private final String ITEM_TITLE_CLASSNAME = "x-shc-item__title-link";
    private final String ITEM_TITLE_VALUE = "НАРУЧНЫЕ ЧАСЫ AMST";

    private final long SECONDS_TO_WAIT = 10;
    private final long POLLING_SECONDS = 1;
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;

    @BeforeTest(alwaysRun = true)
    public void initBrowserDriver() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + CHROME_DRIVER_PATH);

        driver = new ChromeDriver();
        jsExecutor = (JavascriptExecutor) driver;
    }

    @Test (description = "Test add to basket")
    public void TestAddProductToBasket() {
        driver.get(PAGE_URL);

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(SECONDS_TO_WAIT))
                .pollingEvery(Duration.ofSeconds(POLLING_SECONDS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Timeout was exceeded!");

        System.out.println("Enter 0");

        WebElement buyButton = wait
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.className(BUY_BUTTON_CLASSNAME))).get(0);

        System.out.println("buyButton: " + buyButton);

        List<WebElement> basketItemsCounters = driver.findElements(By.className(BASKET_ITEMS_COUNTER_CLASSNAME));
        Integer basketItemsCounterValue = 0;
        if (basketItemsCounters.size() != 0) {
            basketItemsCounterValue = Integer.parseInt(basketItemsCounters.get(0).getText());
        }

        System.out.println("basketItemsCounterValue: " + basketItemsCounterValue);

        buyButton.click();

        System.out.println("Enter 1");

        WebElement basketItemsCounter = wait
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.className(BASKET_ITEMS_COUNTER_CLASSNAME))).get(0);

        System.out.println("Enter 2");

        Integer basketItemsCounterValueAfterAdding = Integer.parseInt(basketItemsCounter.getText());

        WebElement itemTitle = wait
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.className(ITEM_TITLE_CLASSNAME))).get(0);

        System.out.println("Enter 3");

        Assert.assertEquals(basketItemsCounterValue + 1, (int) basketItemsCounterValueAfterAdding);
        Assert.assertEquals(itemTitle.getText(), ITEM_TITLE_VALUE);
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
        driver = null;
    }
}
