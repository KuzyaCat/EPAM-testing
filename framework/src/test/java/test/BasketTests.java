package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ItemPage;

public class BasketTests extends CommonConditions {
    private final String EXPECTED_ITEM_TITLE_VALUE = "Мужские часы AMST AM 3003 (Коричневый)";
    private final String WRIST_WATCH_PAGE_URL = "/p106387137-muzhskie-chasy-amst.html";

    @Test(description = "Test add to basket")
    public void addProductToBasketTest() {
        ItemPage dealByItemPage = new ItemPage(driver, WRIST_WATCH_PAGE_URL)
                .openPage();

        int expectedBasketItemsCounterValue = dealByItemPage.getBasketItemsCounterValue() + 1;
        int actualBasketItemsCounterValueAfterClick = dealByItemPage
                .clickBuyButton()
                .selectBasketItemsCounter()
                .getBasketItemsCounterValue();

        String actualItemTitle = dealByItemPage
                .selectItemTitle()
                .getItemTitleText();

        Assert.assertEquals(expectedBasketItemsCounterValue, actualBasketItemsCounterValueAfterClick);
        Assert.assertEquals(actualItemTitle, EXPECTED_ITEM_TITLE_VALUE);
    }
}
