package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DealByWristWatchPage extends Page {
    private final String PAGE_URL = "https://cutt.ly/IhmH8m3"; // short link

    @FindBy(className = "js-product-buy-button")
    private WebElement buyButton;

    @FindBy(className = "x-header__controls-counter")
    private WebElement basketItemsCounter;

    @FindBy(className = "x-shc-item__title-link")
    private WebElement itemTitle;

    public DealByWristWatchPage(WebDriver driver) {
        super(driver);
    }

    public DealByWristWatchPage clickBuyButton() {
        buyButton.click();
        return this;
    }

    public int getBasketItemsCounterValue() {
        return Integer.parseInt(basketItemsCounter.getText());
    }

    public String getItemTitleText() {
        return itemTitle.getText();
    }

    public DealByWristWatchPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }
}
