package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WristWatchPage extends Page {
    private final String PAGE_URL = "https://cutt.ly/IhmH8m3"; // short link
    private final String BUY_BUTTON_CLASSNAME = "js-product-buy-button";
    private final String BASKET_ITEMS_COUNTER_CLASSNAME = "x-header__controls-counter";
    private final String ITEM_TITLE_CLASSNAME = "x-shc-item__title-link";

    Wait<WebDriver> wait;
    private final long SECONDS_TO_WAIT = 10;
    private final long POLLING_SECONDS = 1;


    @FindBy(className = BUY_BUTTON_CLASSNAME)
    private WebElement buyButton;

    private WebElement basketItemsCounter;
    private WebElement itemTitle;

    public WristWatchPage(WebDriver driver) {
        super(driver);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(SECONDS_TO_WAIT))
                .pollingEvery(Duration.ofSeconds(POLLING_SECONDS))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Timeout was exceeded!");
    }

    public WristWatchPage clickBuyButton() {
        buyButton.click();
        return this;
    }

    public WristWatchPage selectBasketItemsCounter() {
        basketItemsCounter = wait
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.className(BASKET_ITEMS_COUNTER_CLASSNAME))).get(0);
        return this;
    }

    public WristWatchPage selectItemTitle() {
        itemTitle = wait
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.className(ITEM_TITLE_CLASSNAME))).get(0);
        return this;
    }

    public int getBasketItemsCounterValue() {
        try {
            return Integer.parseInt(basketItemsCounter.getText());
        } catch (NoSuchElementException exception) {
            return 0;
        }
    }

    public String getItemTitleText() {
        return itemTitle.getText();
    }

    public WristWatchPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }
}
