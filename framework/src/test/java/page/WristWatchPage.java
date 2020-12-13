package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WristWatchPage extends Page {
    private final String BASE_PAGE_URL = "https://deal.by";
    private String pageUrl;

    private final String BUY_BUTTON_CLASSNAME = "js-product-buy-button";
    private final String FAVORITE_BUTTON_CLASSNAME = "x-product-conversion__favourite";
    private final By BASKET_ITEMS_COUNTER_LOCATOR = By.className("x-header__controls-counter");
    private final By ITEM_TITLE_LOCATOR = By.className("x-shc-item__title-link");
    private final By REGISTER_MODAL_LOCATOR = By.className("registration__wrapper--1W6P8");

    @FindBy(className = BUY_BUTTON_CLASSNAME)
    private WebElement buyButton;

    @FindBy(className = FAVORITE_BUTTON_CLASSNAME)
    private WebElement favoriteButton;

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

    public WristWatchPage clickFavoriteButton() {
        favoriteButton.click();
        logger.info("Click on favorite button");
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

    public List<WebElement> getRegisterModalElements() {
        logger.info("Get register modal element");
        return getWebElementsList(REGISTER_MODAL_LOCATOR);
    }

    public WristWatchPage openPage() {
        logger.info("Open page: " + pageUrl);
        driver.get(pageUrl);
        return this;
    }
}
