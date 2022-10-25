package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US_015 {

    @Test
    public static void US013() throws InterruptedException, IOException {

        Actions actions = new Actions(Driver.getDriver());
        SpendinggoodPage spendinggoodPages = new SpendinggoodPage();
        Faker faker = new Faker();

        // Vendor "https://spendinggood.com/"  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));

        // Vendor "SIGN IN" butonuna tiklar
        spendinggoodPages.signIn.click();

        // Vendor "Username or email address" inputuna gecerli Email giriniz
        spendinggoodPages.userName.sendKeys(ConfigReader.getProperty("userEmail"));

        // Vendor "Password" inputuna  gecerli parolayi giriniz
        spendinggoodPages.passWord.sendKeys(ConfigReader.getProperty("pass"));

        // Vendor "SIGN IN" butonuna tiklayiniz
        spendinggoodPages.submit.click();
        ReusableMethods.waitFor(3);

        // Vendor "My Account" butonuna tiklayiniz
        spendinggoodPages.myAccount.click();
        ReusableMethods.waitFor(3);

        // Vendor "Store Manager" butonuna tiklayiniz
        spendinggoodPages.storeManager.click();

        //  Vendor "Coupons"  butonuna tiklayiniz
        //  sayfayi asagi indriniz
        //  Vendor Coupons sayfasindan "Add New" butonuna tiklayiniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        actions.moveToElement(spendinggoodPages.coupons).moveToElement(spendinggoodPages.AddNew)
                .click().perform();

        //---------------------------------------------------------//

        // Vendor "Limit" butonuna tiklayiniz
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.jsclick(spendinggoodPages.Limit);
        ReusableMethods.waitFor(2);

        // Vendor "Usage limit per coupon" a kupon basina kullanım limiti icin deger giriniz
        actions.sendKeys(Keys.TAB);
        spendinggoodPages.UsageLimit.sendKeys("2");

        // Vendor "Limit usage to X items" a kupon kullanım limiti icin deger giriniz
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.TAB);
        spendinggoodPages.UsagetoXitems.sendKeys("3");

        // Vendor "Usage limit per user" a kupon kullanım limiti icin deger giriniz
        ReusableMethods.waitFor(3);
        spendinggoodPages.UsagelimitPerUser.sendKeys("4");

        // Vendor "Code" satirina uniq bir deger girerek Enter'a tıklayiniz
        spendinggoodPages.code.sendKeys(faker.number().digits(5) + Keys.ENTER);

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //  Vendor "Coupon Successfully Published." yazisinin görünüyor oldugunu test ediniz
        ReusableMethods.waitForVisibility(spendinggoodPages.BasariliYazisi,15);

        // ReusableMethods.getScreenshotWebElement("Bararili yazisi",spendinggoodPages.BasariliYazisi);
        ReusableMethods.waitFor(4);
        Assert.assertTrue(spendinggoodPages.BasariliYazisi.isEnabled());

    }
}
