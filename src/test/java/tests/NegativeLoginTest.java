package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class NegativeLoginTest extends BaseTest {

    @Test
    public void verifyInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalidUser", "wrongPassword");

        String actualErrorMessage = loginPage.getErrorMessage();
        String expectedErrorMessage =
            "Epic sadface: Username and password do not match any user in this service";

        Assert.assertEquals(
            actualErrorMessage,
            expectedErrorMessage,
            "Error message does not match!"
        );

        Assert.assertFalse(
            driver.getCurrentUrl().contains("inventory.html"),
            "User should not be logged in!"
        );
    }
}
