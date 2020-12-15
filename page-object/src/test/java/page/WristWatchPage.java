package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class WristWatchPage extends Page {
    private final String BASE_PAGE_URL = "https://deal.by/p106387137-muzhskie-chasy-amst.html";

    private final String BUY_BUTTON_CLASSNAME = "js-product-buy-button";
    private final By BASKET_ITEMS_COUNTER_LOCATOR = By.className("x-header__controls-counter");
    private final By ITEM_TITLE_LOCATOR = By.className("x-shc-item__title-link");

    @FindBy(className = BUY_BUTTON_CLASSNAME)
    private WebElement buyButton;

    private WebElement basketItemsCounter;
    private WebElement itemTitle;

    public WristWatchPage(WebDriver driver) {
        super(driver);
    }

    public WristWatchPage clickBuyButton() {
        buyButton.click();
        return this;
    }

    public WristWatchPage selectBasketItemsCounter() {
        basketItemsCounter = getWebElement(BASKET_ITEMS_COUNTER_LOCATOR);
        return this;
    }

    public WristWatchPage selectItemTitle() {
        itemTitle = getWebElement(ITEM_TITLE_LOCATOR);
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
        driver.get(BASE_PAGE_URL);
        return this;
    }
}
