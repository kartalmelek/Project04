package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Set;

public class US_020 {

    SpendinggoodPage spendinggoodPage = new SpendinggoodPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_001() throws InterruptedException {

        //1.Vendor "https://spendinggood.com/" adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        Thread.sleep(2000);

        //2."Sıgn ın" butonuna tiklar
        spendinggoodPage.signIn.click();
        Thread.sleep(2000);

        //3.Gecerli bir "email address" girer (gecerli email address : yoesfsimsek@gmail.com)
        spendinggoodPage.userName.clear();
        spendinggoodPage.userName.sendKeys(ConfigReader.getProperty("emailAddress"));
        Thread.sleep(2000);

        //4.Gecerli bir "Password" girer (gecerli password : Team04)
        spendinggoodPage.passWord.clear();
        spendinggoodPage.passWord.sendKeys(ConfigReader.getProperty("password"));
        Thread.sleep(2000);

        //5."Sıgn ın" butonuna tiklar
        spendinggoodPage.submit.click();
        Thread.sleep(2000);

        //6.Ana sayfada "My Account" kismina tiklar
        spendinggoodPage.myAccount.click();
        Thread.sleep(2000);

        //7.Acilan sayfada "Store Manager" butonuna tiklar
        spendinggoodPage.storeManager.click();
        Thread.sleep(2000);

        //8."My Store" bölümünden "Products" butonuna tıklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.productsButton.click();
        Thread.sleep(2000);

        //9.Ekranda cikan ilk urune tiklar
        String ilkWindowHandle = Driver.getDriver().getWindowHandle();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.ilkUrun.click();

        //10.Ekranin sag alt kisminda bulunan "View" butonuna tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.viewButton.click();

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

        spendinggoodPage.customerReviewsButton.click();

        //12.Ekranda "Kullanici bilgisi, Yazmis oldugu comment, Verdigi rate ve Comment tarihi" gorur
        Assert.assertTrue(spendinggoodPage.commentText.isDisplayed());

        //13.Sayfayi kapatir
        Driver.closeDriver();
    }
}
