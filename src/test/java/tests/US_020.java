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

import java.util.Set;

public class US_020 extends TestBaseRapor {

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
        ReusableMethods.waitForVisibility(spendinggoodPage.userName, 5);

        extentTest.info("Gecerli bir 'email address' girildi.");

        //4.Gecerli bir "Password" girer (gecerli password : Team04)
        spendinggoodPage.passWord.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.waitForVisibility(spendinggoodPage.userName, 5);

        extentTest.info("Gecerli bir 'Password' girildi.");

        //5."Sign in" butonuna tiklar
        spendinggoodPage.submit.click();
        ReusableMethods.waitFor(5);

        extentTest.info("'Sign in' butonuna tiklandi.");

        //6.Ana sayfada "My Account" kismina tiklar
        spendinggoodPage.myAccount.click();
        ReusableMethods.waitFor(5);

        extentTest.info("Ana sayfada 'My Account' kismina tiklandi");

        //7.Acilan sayfada "Store Manager" butonuna tiklar
        spendinggoodPage.storeManager.click();
        ReusableMethods.waitForClickablility(spendinggoodPage.storeManager, 5);

        extentTest.info("Acilan sayfada 'Store Manager' butonuna tiklandi.");

        //8."My Store" bölümünden "Products" butonuna tıklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.productsButton.click();
        ReusableMethods.waitForClickablility(spendinggoodPage.productsButton, 5);

        extentTest.info("Acilan sayfada 'Products' butonuna tiklandi.");

        //9.Ekranda cikan ilk urune tiklar
        String ilkWindowHandle = Driver.getDriver().getWindowHandle();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.ilkUrun.click();
        ReusableMethods.waitFor(5);

        extentTest.info("Ekranda cikan ilk urune tiklandi.");

        //10.Ekranin sag alt kisminda bulunan "View" butonuna tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        ReusableMethods.jsclick(spendinggoodPage.viewButton);

        extentTest.info("Ekranin sag alt kisminda bulunan 'View' butonuna tiklandi.");

        //11.Acilan yeni pencerede "Customer Reviews" kismina tiklar
        Set<String> windowHandleSet = Driver.getDriver().getWindowHandles();
        String ikinciWindowHandle = "";

        for (String each : windowHandleSet
        ) {

            if (!each.contains(ilkWindowHandle)) {

                ikinciWindowHandle = each;
            }
        }

        Driver.getDriver().switchTo().window(ikinciWindowHandle);
        ReusableMethods.waitForPageToLoad(5);

        ReusableMethods.jsclick(spendinggoodPage.customerReviewsButton);
        ReusableMethods.waitFor(5);

        extentTest.info("Acilan yeni pencerede 'Customer Reviews' kismina tiklandi.");

        //12.Ekranda "Kullanici bilgisi, Yazmis oldugu comment, Verdigi rate ve Comment tarihi" gorur
        Assert.assertTrue(spendinggoodPage.commentText.isDisplayed());
        ReusableMethods.waitForVisibility(spendinggoodPage.commentText, 5);

        extentTest.pass("Ekranda 'Kullanici bilgisi, Yazmis oldugu comment, Verdigi rate ve Comment tarihi' gorundu.");

        //13.Sayfayi kapatir
        Driver.closeDriver();
    }
}
