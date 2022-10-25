package tests;

import pages.SpendinggoodPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US_012 extends TestBaseRapor {
    private static Logger logger = LogManager.getLogger(US_011.class.getName());
    //https://spendinggood.com adresine gider
    //Sing butonu'na tiklar
    //Valid User name girer
    // Valid Password girer
    // My accuont'a tiklar
    // Dashboard'a tiklar
    //Orders'a tiklar
    // Orders bolumunden siparislerin  gorunulurlugunui dogrular
    WebDriver driver = Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());
    SpendinggoodPage spendinggoodPage = new SpendinggoodPage();


    @Test
    public void TC001_Order() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("Pozitif Test,Siparis edilen urun sayfasinin gosterilmesi");
        ReusableMethods.waitFor(2);
        //https://spendinggood.com adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        extentTest.info("Spendinggoog sitesine gildildi");
        //spendinggoodPage.signButton.click();
        //extentTest.info("Sing in butonuna basildi");
        //My accuont'a tiklar
        actions.sendKeys(spendinggoodPage.myaccaunt, Keys.ENTER).perform();
        extentTest.info("My accuont butonuna basildi");
        Thread.sleep(2000);
        // Valid User name girer
        // Valid Password girer
        ReusableMethods.waitFor(2);
        spendinggoodPage.userrEmail.sendKeys(ConfigReader.getProperty("useEmail"));
        spendinggoodPage.password.sendKeys(ConfigReader.getProperty("sifremiz"), Keys.ENTER);
        extentTest.info("Dogru kullanici email ve password girildi");
        Thread.sleep(2000);
        extentTest.info("Orders url'sine gidildi");
        Driver.getDriver().get(ConfigReader.getProperty("OrdersUrl"));
        extentTest.info("sayfa sonuna inildi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        extentTest.info("orders sayfasinin gorunulurlugu  dogrulandi");
        //Orders bolumunden siparislerin  gorunulurlugunui dogrular
        Assert.assertTrue(spendinggoodPage.Ordertable.isDisplayed());
        Thread.sleep(2000);
        extentTest.info("Cikan listenin ekran goruntusu alindi");
        ReusableMethods.getScreenshot("spendinggood");
        //  driver.close();
    }


    @Test

    public void TC002_Coupons() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("Pozitif Test,indirimli urun syfasinin  gosterilmesi");
        ReusableMethods.waitFor(2);
        //https://spendinggood.com adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        extentTest.info("Spendinggoog sitesine gildildi");
        //spendinggoodPage.signButton.click();
        //extentTest.info("Sing in butonuna basildi");
        //My accuont'a tiklar
        actions.sendKeys(spendinggoodPage.myaccaunt, Keys.ENTER).perform();
        extentTest.info("My accuont butonuna basildi");
        Thread.sleep(2000);
        // Valid User name girer
        // Valid Password girer
        ReusableMethods.waitFor(2);
        spendinggoodPage.userrEmail.sendKeys(ConfigReader.getProperty("useEmail"));
        spendinggoodPage.password.sendKeys(ConfigReader.getProperty("sifremiz"), Keys.ENTER);
        extentTest.info("Dogru kullanici email ve password girildi");
        Thread.sleep(2000);
        extentTest.info("coupons url'sine gidildi");
        Driver.getDriver().get(ConfigReader.getProperty("couponsUrl"));
        extentTest.info("sayfa sonuna inildi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        extentTest.info("Coupons sayfasinin gorunulurlugu  dogrulandi");
        spendinggoodPage.showalltype.sendKeys(Keys.TAB);
        // spendinggoodPage.showalltype.click();
        Assert.assertTrue(spendinggoodPage.urunlistesi.isEnabled());
        extentTest.info("urun  sayfasinin gorunulurlugu  dogrulandi");
        Thread.sleep(2000);
        extentTest.info("Cikan sayfanin ekran goruntusu alindi");
        ReusableMethods.getScreenshot("spendinggood");
        //  driver.close();
    }

    @Test
    public void Adress() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("Pozitif Test,Adres gosterme ayarlarindaki bolumlerin gosterilmesi");
        ReusableMethods.waitFor(2);
        //https://spendinggood.com adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        extentTest.info("Spendinggoog sitesine gildildi");
        extentTest.info("My accaunt butonuna basildi");
        //My accuont'a tiklar
        actions.sendKeys(spendinggoodPage.myaccaunt, Keys.ENTER).perform();
        extentTest.info("My accuont butonuna basildi");
        Thread.sleep(2000);
        // Valid User name girer
        // Valid Password girer
        ReusableMethods.waitFor(2);
        spendinggoodPage.userrEmail.sendKeys(ConfigReader.getProperty("useEmail"));
        spendinggoodPage.password.sendKeys(ConfigReader.getProperty("sifremiz"), Keys.ENTER);
        extentTest.info("Dogru kullanici email ve password girildi");
        extentTest.info("adres butonuna tiklandi");
        actions.clickAndHold(spendinggoodPage.Adress).doubleClick().perform();
        extentTest.info("adres sayfasi acilanca billing ve shipping sayfasi gorunululugu dogrulandi");
        Assert.assertTrue(spendinggoodPage.Billingveshipping.isEnabled());


    }

    @Test
    public void HesapDetaylari() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("Pozitif Test,Hesap bilgisi ve email adresi bolumlerin gosterilmesi");
        //https://spendinggood.com adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        extentTest.info("Spendinggoog sitesine gildildi");
        spendinggoodPage.signButton.click();
        extentTest.info("Sing butonuna tiklandi ");
        ReusableMethods.waitFor(2);
        spendinggoodPage.userrEmail.sendKeys(ConfigReader.getProperty("useEmail"));
        spendinggoodPage.password.sendKeys(ConfigReader.getProperty("sifremiz"), Keys.ENTER);
        extentTest.info("Dogru kullanici email ve password girildi");
        ReusableMethods.waitFor(2);
        actions.sendKeys(spendinggoodPage.myaccaunt, Keys.ENTER).perform();
        extentTest.info("My accuont butonuna tiklandi");
        ReusableMethods.waitFor(2); // Store manager'a tiklar
        spendinggoodPage.stromanager.click();
        extentTest.info("Store manager a gidildi");
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Sayfa sonuna inildi");
        ReusableMethods.waitFor(2);
        spendinggoodPage.Customer.click();
        extentTest.info("Customer butonuna tiklandi");
        ReusableMethods.waitFor(5);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(4);
        spendinggoodPage.editcustomerbutton.click();
        extentTest.info("edit custemer butonuna basildi diger sayfaya gecildi");
        ReusableMethods.waitFor(5);
        spendinggoodPage.Email.sendKeys(Keys.ENTER);
        extentTest.info("Edit customer sayfasinin acildigi ve ve Email kisminin aktif oldugu dogrulandi");
        Assert.assertTrue(spendinggoodPage.edit.isDisplayed());
        Assert.assertTrue(spendinggoodPage.Email.isDisplayed());

    }
}