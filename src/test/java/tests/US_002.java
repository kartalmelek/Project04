package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_002 extends TestBaseRapor {
    SpendinggoodPage spendinGoodPage = new SpendinggoodPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test (groups = "group02")
    public void SupporTicketsFollowingsVeLogoutOlmaliTest() {
        extentTest = extentReports.createTest("Support tickets, followings ve log out olmali","Support tickets, follwings ve log out gorunur");
        extentTest.info("Email ve Sifre girilerek Siteye girilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        ReusableMethods.waitFor(10);
        extentTest.info("SignIn Buttonuna click yapar");
        ReusableMethods.jsclick(spendinGoodPage.signIn1);
        ReusableMethods.waitFor(3);
        extentTest.info("Email ve Password girip SIGN IN Buttonuna click yapar");
        ReusableMethods.waitFor(3);
        actions.click(spendinGoodPage.userName).sendKeys("yoesfsimsek@gmail.com").
                sendKeys(Keys.TAB).sendKeys("Team04").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.pass("Giris yapilip MyAccount yazısı gorulmeli");
        ReusableMethods.waitFor(3);
        ReusableMethods.jsclick(spendinGoodPage.MyAccount);
        Assert.assertTrue(spendinGoodPage.MyAccountYazisi.isDisplayed());

        Driver.closeDriver();

    }
}
