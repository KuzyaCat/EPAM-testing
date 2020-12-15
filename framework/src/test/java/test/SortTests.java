package test;

import com.google.common.collect.Ordering;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.ManSneakersPage;

import java.util.List;

public class SortTests extends CommonConditions {
    @Test(description = "Test sort ascending catalog items by price")
    public void sortAscendingCatalogItemsByPriceTest() {
        List<Double> catalogItemsPriceList =  new ManSneakersPage(driver)
                .openPage()
                .clickExpensiveButton()
                .waitUntilJSReady()
                .getCatalogItemsPrices();

        boolean areCatalogItemsSortedByPrice = Ordering.natural().reverse().isOrdered(catalogItemsPriceList);

        Assert.assertTrue(areCatalogItemsSortedByPrice);
    }

    @Test(description = "Test sort descending catalog items by price")
    public void sortDescendingCatalogItemsByPriceTest() {
        List<Double> catalogItemsPriceList =  new ManSneakersPage(driver)
                .openPage()
                .clickCheapButton()
                .waitUntilJSReady()
                .getCatalogItemsPrices();

        boolean areCatalogItemsSortedByPrice = Ordering.natural().isOrdered(catalogItemsPriceList);

        Assert.assertTrue(areCatalogItemsSortedByPrice);
    }
}
