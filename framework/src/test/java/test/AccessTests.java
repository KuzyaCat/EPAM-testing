package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.WristWatchPage;

public class AccessTests extends CommonConditions {
    private final String WRIST_WATCH_PAGE_URL = "/p106387137-muzhskie-chasy-amst.html";

    @Test(description = "Being unauthorized try to add ite to favorites")
    public void addToFavoritesBeingUnauthorized() {
        WristWatchPage dealByWristWatchPage = new WristWatchPage(driver, WRIST_WATCH_PAGE_URL)
                .openPage();

        boolean isSuggestingToRegister = dealByWristWatchPage
                .clickFavoriteButton()
                .getRegisterModalElements()
                .size() > 0;

        Assert.assertTrue(isSuggestingToRegister);
    }
}
