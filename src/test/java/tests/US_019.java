package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_019 extends TestBaseRapor {

    SpendinggoodPage spendinggoodPage = new SpendinggoodPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_001() throws InterruptedException {

        extentTest = extentReports.
        createTest("Pozitif Test", "Kullanici ekranda takipcilerin isim, mail ve islemlerini gorur.");

        //1.Vendor "https://spendinggood.com/" adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        extentTest.info("'https://spendinggood.com/' adresine gidildi.");
        Thread.sleep(2000);

        //2."Sign in" butonuna tiklar
        spendinggoodPage.signIn.click();
        extentTest.info("'Sign in' butonuna tiklandi.");
        Thread.sleep(2000);

        //3.Gecerli bir "email address" girer (gecerli email address : yoesfsimsek@gmail.com)
        spendinggoodPage.userName.clear();
        spendinggoodPage.userName.sendKeys(ConfigReader.getProperty("emailAddress"));
        extentTest.info("Gecerli bir 'email address' girildi.");
        Thread.sleep(2000);

        //4.Gecerli bir "Password" girer (gecerli password : Team04)
        spendinggoodPage.passWord.clear();
        spendinggoodPage.passWord.sendKeys(ConfigReader.getProperty("password"));
        extentTest.info("Gecerli bir 'Password' girildi.");
        Thread.sleep(2000);

        //5."Sign in" butonuna tiklar
        spendinggoodPage.submit.click();
        extentTest.info("'Sign in' butonuna tiklandi.");
        Thread.sleep(2000);

        //6.Ana sayfada "My Account" kismina tiklar
        spendinggoodPage.myAccount.click();
        extentTest.info("Ana sayfada 'My Account' kismina tiklandi");
        Thread.sleep(2000);

        //7.Acilan sayfada "Store Manager" butonuna tiklar
        spendinggoodPage.storeManager.click();
        extentTest.info("Acilan sayfada 'Store Manager' butonuna tiklandi.");
        Thread.sleep(2000);

        //8."My Store" bolumunden "Followers" butonuna tiklar
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.followersButton.click();
        extentTest.info("'My Store' bolumunden 'Followers' butonuna tiklandi.");
        Thread.sleep(2000);

        //9.Ekranda takipcilerin isim, mail ve islemlerini gorur.
        Assert.assertTrue(spendinggoodPage.emptyTable.isDisplayed(), "Ekranda takipcilerin isim, mail ve islemleri gorulemedi");
        extentTest.pass("Ekranda takipcilerin isim, mail ve islemleri gorunmedi.");

        //10.Sayfayi kapatir
        Driver.closeDriver();
    }
}
