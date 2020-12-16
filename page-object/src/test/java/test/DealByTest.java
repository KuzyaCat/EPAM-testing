package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CatalogPage;
import page.ItemPage;

public class DealByTest extends CommonConditions {
    private final String SNEAKERS_CATALOG_PAGE_URL = "/Krossovki-muzhskie.html";
    private final String WRIST_WATCH_ITEM_PAGE_URL = "/p106387137-muzhskie-chasy-amst.html";

    private final String EXPECTED_ITEM_TITLE_VALUE = "Мужские часы AMST AM 3003 (Коричневый)";
    private final String FILTER_VALUE = "reebo";

    @Test (description = "Test add to basket")
    public void addProductToBasketTest() {
        ItemPage dealByItemPage = new ItemPage(driver, WRIST_WATCH_ITEM_PAGE_URL)
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

    @Test (description = "Test filter sneakers by producer")
    public void filterSneakersByProducerTest() {
        boolean areProducerListItemValuesMatchInputValue = new CatalogPage(driver, SNEAKERS_CATALOG_PAGE_URL)
                .openPage()
                .fillFilterInput(FILTER_VALUE)
                .waitUntilJSReady()
                .getProducerListItemValues()
                .stream()
                .allMatch(itemValue -> itemValue.contains(FILTER_VALUE));

        Assert.assertTrue(areProducerListItemValuesMatchInputValue);
    }
}

