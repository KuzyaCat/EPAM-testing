package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class WristWatchPage extends Page {
    private final String BASE_PAGE_URL = "https://deal.by";
    private String pageUrl;

    private final String BUY_BUTTON_CLASSNAME = "js-product-buy-button";
    private final By BASKET_ITEMS_COUNTER_LOCATOR = By.className("x-header__controls-counter");
    private final By ITEM_TITLE_LOCATOR = By.className("x-shc-item__title-link");

    @FindBy(className = BUY_BUTTON_CLASSNAME)
    private WebElement buyButton;

    private WebElement basketItemsCounter;
    private WebElement itemTitle;

    public WristWatchPage(WebDriver driver, String url) {
        super(driver);
        pageUrl = BASE_PAGE_URL + url;
    }

    public WristWatchPage clickBuyButton() {
        buyButton.click();
        logger.info("Click on \"Buy\" button");
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
        logger.info("Get count of items from basket counter element:");
        try {
            int basketItemsCounterValue = Integer.parseInt(basketItemsCounter.getText());
            logger.info(basketItemsCounterValue + " items");
            return basketItemsCounterValue;
        } catch (NoSuchElementException exception) {
            logger.info( "No item basket counter element found");
            return 0;
        }
    }

    public String getItemTitleText() {
        String itemTitleText = itemTitle.getText();
        logger.info("Get text from item title element: " + itemTitleText);
        return itemTitleText;
    }

    public WristWatchPage openPage() {
        logger.info("Open page: " + pageUrl);
        driver.get(pageUrl);
        return this;
    }
}
