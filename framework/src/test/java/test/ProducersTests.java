package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ManSneakersPage;

public class ProducersTests extends CommonConditions {
    private final String FILTER_VALUE = "reebo";

    @Test (description = "Test filter sneakers by producer")
    public void filterSneakersByProducerTest() {
        boolean areProducerListItemValuesMatchInputValue =  new ManSneakersPage(driver)
                .openPage()
                .enterValueToFilterInput(FILTER_VALUE)
                .waitUntilJSReady()
                .getProducerListItemValues()
                .stream()
                .allMatch(itemValue -> itemValue.contains(FILTER_VALUE));

        Assert.assertTrue(areProducerListItemValuesMatchInputValue);
    }
}
