package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {
        InventoryPage inventoryPage =
            new LoginPage(driver)
                .login("standard_user", "secret_sauce");

        Assert.assertTrue(
            inventoryPage.isLoaded(),
            "Inventory page was not loaded"
        );

        Assert.assertEquals(
            inventoryPage.getPageTitle(),
            "Products",
            "Incorrect page title"
        );
    }
}
