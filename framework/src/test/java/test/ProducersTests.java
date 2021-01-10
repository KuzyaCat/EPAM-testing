package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CatalogPage;

public class ProducersTests extends CommonConditions {
    private final String FILTER_VALUE = "reebo";
    private final String SNEAKERS_CATALOG_PAGE_URL = "/Krossovki-muzhskie.html";

    @Test (description = "Test filter sneakers by producer")
    public void filterSneakersByProducerTest() {
        boolean areProducerListItemValuesMatchInputValue =  new CatalogPage(driver, SNEAKERS_CATALOG_PAGE_URL)
                .openPage()
                .enterValueToFilterInput(FILTER_VALUE)
                .getProducerListItemValues()
                .stream()
                .allMatch(itemValue -> itemValue.contains(FILTER_VALUE));

        Assert.assertTrue(areProducerListItemValuesMatchInputValue);
    }
}
