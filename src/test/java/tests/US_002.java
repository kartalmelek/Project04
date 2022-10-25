package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_002 extends TestBaseRapor {
    SpendinggoodPage spendinGoodPage = new SpendinggoodPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void SupporTicketsFollowingsVeLogoutOlmaliTest() throws InterruptedException {
        extentTest = extentReports.createTest("Support tickets, followings ve log out olmali","Support tickets, follwings ve log out gorunur");
        extentTest.info("Email ve Sifre girilerek Siteye girilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        Thread.sleep(1500);
        extentTest.info("SignIn Buttonuna click yapar");
        spendinGoodPage.signIn.click();
        Thread.sleep(1500);
        extentTest.info("Email ve Password girip SIGN IN Buttonuna click yapar");
        spendinGoodPage.UserName.click();
        Thread.sleep(2000);
        actions.sendKeys("yoesfsimsek@gmail.com").
                sendKeys(Keys.TAB).sendKeys("Team04").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.pass("Giris yapilip MyAccount yazısı gorulmeli");
        Thread.sleep(1500);
        spendinGoodPage.MyAccount.click();
        Assert.assertTrue(spendinGoodPage.MyAccountYazisi.isDisplayed());

        Driver.closeDriver();

    }
}
