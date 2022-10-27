package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.Random;

public class US_13_14_15 extends TestBaseRapor {
    @Test
    public static  void US013() throws InterruptedException, IOException {

        Actions actions=new Actions(Driver.getDriver());

        SpendinggoodPage spendinggoodPages = new SpendinggoodPage();
        Faker faker= new Faker();
        extentTest = extentReports.
                createTest("Pozitif Test",
                        "Kullanici ekranda takipcilerin isim, mail ve islemlerini gorur.");

        // Vendor "https://spendinggood.com/"  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));

        extentTest.info("'https://spendinggood.com/' adresine gidildi.");

        // Vendor "SIGN IN" butonuna tiklar
        spendinggoodPages.signIn.click();

        extentTest.info("'Sign in' butonuna tiklandi.");

        // Vendor "Username or email address" inputuna gecerli Email giriniz
        spendinggoodPages.userName.sendKeys(ConfigReader.getProperty("emailAddress"));

        extentTest.info("Gecerli bir 'email address' girildi.");

        // Vendor "Password" inputuna  gecerli parolayi giriniz
        spendinggoodPages.passWord.sendKeys(ConfigReader.getProperty("password"));

        extentTest.info("Gecerli bir 'Password' girildi.");

        // Vendor "SIGN IN" butonuna tiklayiniz
        spendinggoodPages.submit.click();
        ReusableMethods.waitFor(3);
        extentTest.info("'Sign in' butonuna tiklandi.");

        // Vendor "My Account" butonuna tiklayiniz
        spendinggoodPages.myAccount.click();
        ReusableMethods.waitFor(3);

        extentTest.info("Ana sayfada 'My Account' kismina tiklandi");

        // Vendor "Store Manager" butonuna tiklayiniz
        spendinggoodPages.storeManager.click();

        extentTest.info("Acilan sayfada 'Store Manager' butonuna tiklandi.");

        //  Vendor "Coupons"  butonuna tiklayiniz
        //  sayfayi asagi indriniz
        //  Vendor Coupons sayfasindan "Add New" butonuna tiklayiniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(5);
        actions.moveToElement(spendinggoodPages.coupons).moveToElement(spendinggoodPages.AddNew)
                .click().perform();
        extentTest.info("Coupns bolumunden AddNew'e gidildi");

        // sayfazi asagi indirin
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Vendor "Code" satirina uniq bir deger girerek Enter'a tıklayiniz
        spendinggoodPages.code.sendKeys(faker.number().digits(5));
        extentTest.info("Uniq bir code girildi");

        // Vendor "Description" satirina bir tanimlama girer
        spendinggoodPages.Description.sendKeys("aciklama yazisi" + Keys.TAB);
        extentTest.info("description'a caiklama yazisi yazildi");

        //Vendor "Discount Type" ta bir Dropdown secer
        Select select=new Select(spendinggoodPages.DiscountType);
        Random random =new Random();
        select.selectByVisibleText("Fixed Product Discount");
        extentTest.info("Discount Type'da dropdwon secildi");

        //Vendor "Coupon Amount" satirina bir kupon tutari giriniz
        actions.sendKeys(Keys.TAB).sendKeys(faker.number().digits(2)).sendKeys(Keys.TAB).perform();
        extentTest.info("coupn tutari girildi");

        //Vendor "Coupon expiry date" satirina YYYY-MM-DD olacak sekilde gecerli bir tarih girer
        actions.sendKeys(Keys.TAB);
        spendinggoodPages.CouponExpirydate.click();
        spendinggoodPages.tarihSecimi.click();
        extentTest.info("Coupon expiry'a tarih girldi");

        //Vendor "Allow free shipping" secenegini isaretler
        actions.sendKeys(Keys.TAB);
        spendinggoodPages.AllowFreeshipping.click();
        extentTest.info("Allow free sipping secildi");

        // Vendor "Show on store" secenegini isaretler
        actions.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(4);
        spendinggoodPages.ShowOnstore.click();
        ReusableMethods.waitFor(2);
        extentTest.info("show on store secildi");

           //----------------------------------------------------------------------//

        // Vendor "Minimum spend" bolumune en az alma miktarini giriniz
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPages.minInput.sendKeys("5");

        extentTest.info("minumum deger girildi");

        // Vendor "Maximum spend" bolumune en az alma miktarini giriniz
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPages.maxInput.sendKeys("6");

        extentTest.info("maxsimum deger girildi");

        // Vendor "Individual use only" secenegini isaretleyiniz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        ReusableMethods.jsclick(spendinggoodPages.IndividualUseonly);
        ReusableMethods.waitFor(3);

        extentTest.info("individual use only isaretlendi");

        // Vendor "Exclude sale items" secenegini isaretleyiniz
        spendinggoodPages.ExcludeSaleitems.click();
        ReusableMethods.waitFor(3);

        extentTest.info("exclude sale items isaretlendi");

        // Vendor "Exclude categories" dan random bir kategori seciniz
        actions.click(spendinggoodPages.ExcludeCategories).
                sendKeys("Boys" + Keys.TAB).sendKeys(Keys.ENTER).perform();

        actions.sendKeys("Girls" + Keys.TAB).sendKeys(Keys.ENTER).perform();

        extentTest.info("exclude categories'den random kategori secildi");


        //-----------------------------------------------------------------------//

        // Vendor "Limit" butonuna tiklayiniz
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.jsclick(spendinggoodPages.Limit);
        ReusableMethods.waitFor(2);
        extentTest.info("Limit butonuna basildi");

        // Vendor "Usage limit per coupon" a kupon basina kullanım limiti icin deger giriniz
        actions.sendKeys(Keys.TAB);
        spendinggoodPages.UsageLimit.sendKeys("2");
        extentTest.info("Usage limit per coupon deger girildi");

        // Vendor "Limit usage to X items" a kupon kullanım limiti icin deger giriniz
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.TAB);
        spendinggoodPages.UsagetoXitems.sendKeys("3");
        extentTest.info("Limit usage to X items coupon deger girildi");

        // Vendor "Usage limit per user" a kupon kullanım limiti icin deger giriniz
        ReusableMethods.waitFor(3);
        spendinggoodPages.UsagelimitPerUser.sendKeys("4");
        extentTest.info("Limit per user coupon deger girildi");

        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Submit butonuna tiklatiniz
        spendinggoodPages.submit1.sendKeys(Keys.ENTER);
        extentTest.info("Submit butonuna basildi");

        //  Vendor "Coupon Successfully Published." yazisinin görünüyor oldugunu test ediniz
        ReusableMethods.waitForVisibility(spendinggoodPages.BasariliYazisi,15);
        extentTest.info("Coupon Successfully Published yazisi test edildi");

        // ReusableMethods.getScreenshotWebElement("Bararili yazisi",spendinggoodPages.BasariliYazisi);
        ReusableMethods.waitFor(4);
        Assert.assertTrue(spendinggoodPages.BasariliYazisi.isEnabled());
        extentTest.info("Test basarili yazisi dogrulandi");




    }
}
