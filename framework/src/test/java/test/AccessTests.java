package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.WristWatchPage;

public class AccessTests extends CommonConditions {
    @Test(description = "Being unauthorized try to add ite to favorites")
    public void addToFavoritesBeingUnauthorized() {
        WristWatchPage dealByWristWatchPage = new WristWatchPage(driver)
                .openPage();

        boolean isSuggestingToRegister = dealByWristWatchPage
                .clickFavoriteButton()
                .getRegisterModalElements()
                .size() > 0;

        Assert.assertTrue(isSuggestingToRegister);
    }
}
