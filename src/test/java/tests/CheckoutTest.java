package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyCheckoutFlow() {
        InventoryPage inventoryPage =
            new LoginPage(driver)
                .login("standard_user", "secret_sauce");

        inventoryPage.addBackpackToCart();
        CartPage cartPage = inventoryPage.goToCart();
        CheckoutPage checkoutPage = cartPage.clickCheckout();

        checkoutPage.enterCustomerDetails("Muskaan", "Gulrajani", "400706");

        Assert.assertTrue(
            driver.getCurrentUrl().contains("checkout-step-two"),
            "User was not redirected to checkout step two"
        );
    }
}
