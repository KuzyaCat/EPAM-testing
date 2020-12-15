package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.WristWatchPage;

public class BasketTests extends CommonConditions {
    private final String EXPECTED_ITEM_TITLE_VALUE = "Мужские часы AMST AM 3003 (Коричневый)";

    @Test(description = "Test add to basket")
    public void addProductToBasketTest() {
        WristWatchPage dealByWristWatchPage = new WristWatchPage(driver)
                .openPage();

        int expectedBasketItemsCounterValue = dealByWristWatchPage.getBasketItemsCounterValue() + 1;
        int actualBasketItemsCounterValueAfterClick = dealByWristWatchPage
                .clickBuyButton()
                .selectBasketItemsCounter()
                .getBasketItemsCounterValue();

        String actualItemTitle = dealByWristWatchPage
                .selectItemTitle()
                .getItemTitleText();

        Assert.assertEquals(expectedBasketItemsCounterValue, actualBasketItemsCounterValueAfterClick);
        Assert.assertEquals(actualItemTitle, EXPECTED_ITEM_TITLE_VALUE);
    }
}
