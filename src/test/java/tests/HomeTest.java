package tests;

import java.util.List;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends BaseTest {

    @Test
    public void amountSortingTest() throws InterruptedException {
        
		LoginPage loginPage = new LoginPage(driver);
        loginPage.login("any", "thing");

        HomePage homePage = new HomePage(driver);
        homePage.clickAmountHeader();

        List<Double> amounts = homePage.getAmountValues();
        Assert.assertTrue(homePage.isSortedAscending(amounts), "Amounts are not sorted!");
  Thread.sleep(3000);
    }
}

