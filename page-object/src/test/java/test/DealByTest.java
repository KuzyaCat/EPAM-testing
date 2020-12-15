package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ManSneakersPage;
import page.WristWatchPage;

public class DealByTest extends CommonConditions {
    private final String EXPECTED_ITEM_TITLE_VALUE = "Мужские часы AMST AM 3003 (Коричневый)";
    private final String FILTER_VALUE = "reebo";

    @Test (description = "Test add to basket")
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

    @Test (description = "Test filter sneakers by producer")
    public void filterSneakersByProducerTest() {
        boolean areProducerListItemValuesMatchInputValue =  new ManSneakersPage(driver)
                .openPage()
                .fillFilterInput(FILTER_VALUE)
                .waitUntilJSReady()
                .getProducerListItemValues()
                .stream()
                .allMatch(itemValue -> itemValue.contains(FILTER_VALUE));

        Assert.assertTrue(areProducerListItemValuesMatchInputValue);
    }
}

