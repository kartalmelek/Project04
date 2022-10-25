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

import java.io.IOException;
import java.util.Random;


public class US_013 {
    @Test
    public static  void US013() throws InterruptedException, IOException {

        Actions actions=new Actions(Driver.getDriver());
        SpendinggoodPage spendinggoodPages = new SpendinggoodPage();
        Faker faker= new Faker();

        // Vendor "https://spendinggood.com/"  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));

        // Vendor "SIGN IN" butonuna tiklar
        spendinggoodPages.signIn.click();

        // Vendor "Username or email address" inputuna gecerli Email giriniz
        spendinggoodPages.userName.sendKeys(ConfigReader.getProperty("emailAddress"));

        // Vendor "Password" inputuna  gecerli parolayi giriniz
        spendinggoodPages.passWord.sendKeys(ConfigReader.getProperty("password"));

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
        ReusableMethods.waitFor(5);
        actions.moveToElement(spendinggoodPages.coupons).moveToElement(spendinggoodPages.AddNew)
                .click().perform();

        // sayfazi asagi indirin
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        // Vendor "Code" satirina uniq bir deger girerek Enter'a tıklayiniz
        spendinggoodPages.code.sendKeys(faker.number().digits(5));

        // Vendor "Description" satirina bir tanimlama girer
        spendinggoodPages.Description.sendKeys("aciklama yazisi" + Keys.TAB);

        //Vendor "Discount Type" ta bir Dropdown secer
        Select select=new Select(spendinggoodPages.DiscountType);
        Random random =new Random();
        select.selectByVisibleText("Fixed Product Discount");
        //Vendor "Coupon Amount" satirina bir kupon tutari giriniz
        actions.sendKeys(Keys.TAB).sendKeys(faker.number().digits(2)).sendKeys(Keys.TAB).perform();

        //Vendor "Coupon expiry date" satirina YYYY-MM-DD olacak sekilde gecerli bir tarih girer
        actions.sendKeys(Keys.TAB);
        spendinggoodPages.CouponExpirydate.click();
        spendinggoodPages.tarihSecimi.click();

        //Vendor "Allow free shipping" secenegini isaretler
        actions.sendKeys(Keys.TAB);
        spendinggoodPages.AllowFreeshipping.click();

        // Vendor "Show on store" secenegini isaretler
        actions.sendKeys(Keys.TAB);
        ReusableMethods.waitFor(4);
        spendinggoodPages.ShowOnstore.click();
        ReusableMethods.waitFor(2);

        // Submit butonuna tiklatiniz
        spendinggoodPages.submit1.sendKeys(Keys.ENTER);

       //  Vendor "Coupon Successfully Published." yazisinin görünüyor oldugunu test ediniz
        ReusableMethods.waitForVisibility(spendinggoodPages.BasariliYazisi,15);

       // ReusableMethods.getScreenshotWebElement("Bararili yazisi",spendinggoodPages.BasariliYazisi);
        ReusableMethods.waitFor(4);
        Assert.assertTrue(spendinggoodPages.BasariliYazisi.isEnabled());




    }
}