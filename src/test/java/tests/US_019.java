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

public class US_019 extends TestBaseRapor {

    SpendinggoodPage spendinggoodPage = new SpendinggoodPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_001() throws InterruptedException {

        extentTest = extentReports.
        createTest("Pozitif Test", "Kullanici ekranda takipcilerin isim, mail ve islemlerini gorur.");

        //1.Vendor "https://spendinggood.com/" adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        ReusableMethods.waitForPageToLoad(5);

        extentTest.info("'https://spendinggood.com/' adresine gidildi.");

        //2."Sign in" butonuna tiklar
        spendinggoodPage.signIn.click();
        ReusableMethods.waitForClickablility(spendinggoodPage.signIn, 5);

        extentTest.info("'Sign in' butonuna tiklandi.");

        //3.Gecerli bir "email address" girer (gecerli email address : yoesfsimsek@gmail.com)
        spendinggoodPage.userName.sendKeys(ConfigReader.getProperty("emailAddress"));
        ReusableMethods.waitFor(3);

        extentTest.info("Gecerli bir 'email address' girildi.");

        //4.Gecerli bir "Password" girer (gecerli password : Team04)
        spendinggoodPage.passWord.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.waitFor(3);

        extentTest.info("Gecerli bir 'Password' girildi.");

        //5."Sign in" butonuna tiklar
        spendinggoodPage.submit.click();
        ReusableMethods.waitFor(3);

        extentTest.info("'Sign in' butonuna tiklandi.");

        //6.Ana sayfada "My Account" kismina tiklar
        spendinggoodPage.myAccount.click();
        ReusableMethods.waitForClickablility(spendinggoodPage.myAccount, 5);

        extentTest.info("Ana sayfada 'My Account' kismina tiklandi");

        //7.Acilan sayfada "Store Manager" butonuna tiklar
        spendinggoodPage.storeManager.click();
        ReusableMethods.waitForClickablility(spendinggoodPage.storeManager, 5);

        extentTest.info("Acilan sayfada 'Store Manager' butonuna tiklandi.");

        //8."My Store" bolumunden "Followers" butonuna tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        spendinggoodPage.followersButton.click();
        ReusableMethods.waitForClickablility(spendinggoodPage.followersButton, 5);

        extentTest.info("'My Store' bolumunden 'Followers' butonuna tiklandi.");

        //9.Ekranda takipcilerin isim, mail ve islemlerini gorur.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitForVisibility(spendinggoodPage.emptyTable, 5);
        Assert.assertTrue(spendinggoodPage.emptyTable.isDisplayed(), "Ekranda takipcilerin isim, mail ve islemleri gorulemedi");

        extentTest.pass("Ekranda takipcilerin isim, mail ve islemleri gorunmedi.");

        //10.Sayfayi kapatir
        Driver.closeDriver();
    }
}
