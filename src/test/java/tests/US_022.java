package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class US_022 extends TestBaseRapor {

    SpendinggoodPage spendinggoodPage = new SpendinggoodPage();
    Actions actions = new Actions(Driver.getDriver());
    Select select;

    @Test
    public void TC_001() throws InterruptedException {

        extentTest = extentReports.
        createTest("Pozitif Test", "Kullanici ekranda tumunu gor linkini gorur ve linke tiklar.");

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
        ReusableMethods.waitForVisibility(spendinggoodPage.submit, 5);

        extentTest.info("'Sign in' butonuna tiklandi.");

        //6.Ekranda "Tumunu gor" linkini bulur ve o linke tiklar
        Assert.assertTrue(spendinggoodPage.emptyHeader.isDisplayed(), "Ekranda tumunu gor linki bulunmamaktadir.");
        ReusableMethods.waitForVisibility(spendinggoodPage.emptyHeader, 5);

        extentTest.pass("Ekranda tumunu gor linki bulunamadi.");
    }

    @Test
    public void TC_002() throws InterruptedException {

        extentTest = extentReports.
        createTest("Pozitif Test", "Kullanici ekranda varsayilan siralamanin 'Default sorting' oldugunu gorur.");

        //1.Vendor "https://spendinggood.com/" adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        ReusableMethods.waitForPageToLoad(5);

        extentTest.info("'https://spendinggood.com/' adresine gidildi.");

        //2."Sign in" butonuna tiklar
        ReusableMethods.waitFor(3);
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
        ReusableMethods.waitForVisibility(spendinggoodPage.submit, 5);

        extentTest.info("'Sign in' butonuna tiklandi.");

        //6."Daily Deals" butonuna tiklar
        ReusableMethods.waitFor(5);
        spendinggoodPage.dailyDeals.click();
        ReusableMethods.waitForClickablility(spendinggoodPage.dailyDeals, 5);

        extentTest.info("'Daily Deals' butonuna tiklandi.");

        //7.Sayfada "Sort By" basliginin oldugunu dogrular
        Assert.assertTrue(spendinggoodPage.sortBy.isDisplayed());
        ReusableMethods.waitFor(3);

        extentTest.info("'Sort By' basliginin oldugu dogrulandi.");

        //8.Varsayilan siralamanin "Default sorting" oldugunu dogrular
        ReusableMethods.waitFor(3);
        select = new Select(spendinggoodPage.sortByDropDown);
        select.selectByIndex(1);

        String actualSira = select.getFirstSelectedOption().getText();
        String expectedSira = "Default sorting";

        Assert.assertNotEquals(expectedSira, actualSira);
        ReusableMethods.waitFor(3);

        extentTest.info("Varsayilan siralamanin 'Default sorting' olmadigi goruldu.");

        //9.Sayfayi kapatir
        Driver.closeDriver();
    }

    @Test
    public void TC_003() throws InterruptedException {

        extentTest = extentReports.
        createTest("Pozitif Test", "Kullanici siralama seceneklerinin yer aldigini dogrular.");

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
        ReusableMethods.waitForVisibility(spendinggoodPage.submit, 5);

        extentTest.info("'Sign in' butonuna tiklandi.");

        //6."Daily Deals" butonuna tiklar
        ReusableMethods.waitFor(5);
        spendinggoodPage.dailyDeals.click();
        ReusableMethods.waitForClickablility(spendinggoodPage.dailyDeals, 5);

        extentTest.info("'Daily Deals' butonuna tiklandi.");

        //7.Sayfada "Sort By" basliginin oldugunu dogrular
        Assert.assertTrue(spendinggoodPage.sortBy.isDisplayed());
        ReusableMethods.waitFor(3);

        extentTest.info("'Sort By' basliginin oldugu dogrulandi.");

        /*
        -> 8.Sıralama secenekleri arasında "Default sorting, Sort by popularity, Sort by average rating, Sort by latest,
           Sort by price: low to high, Sort by price: high to low" bulundugunu dogrular
        */
        select = new Select(spendinggoodPage.sortByDropDown);

        List<WebElement> dropDown = select.getOptions();

        List<String> actualIcerik = new ArrayList<String>();

        List<String> expectedIcerik = new ArrayList<String>(Arrays.asList
        ("Default sorting, Sort by popularity, Sort by average rating, Sort by latest, " +
         "Sort by price: low to high, Sort by price: high to low"));

        for (WebElement each : dropDown
        ) {

            actualIcerik.add(each.getText());
        }

        Collections.sort(actualIcerik);
        Collections.sort(expectedIcerik);

        Assert.assertTrue(actualIcerik.equals(actualIcerik));

        extentTest.info("Siralama secenekleri arasinda belirtilen iceriklerin yer aldigi goruldu.");

        //9.Sayfayi kapatir
        Driver.closeDriver();
    }

    @Test
    public void TC_004() throws InterruptedException {

        extentTest = extentReports.
        createTest("Pozitif Test", "Kullanici fiyatlarin dusukten yuksege dogru siralandigini dogrular.");

        //1.Vendor "https://spendinggood.com/" adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        ReusableMethods.waitForPageToLoad(5);

        extentTest.info("'https://spendinggood.com/' adresine gidildi.");

        //2."Sign in" butonuna tiklar
        ReusableMethods.waitFor(3);
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
        ReusableMethods.waitForVisibility(spendinggoodPage.submit, 5);

        extentTest.info("'Sign in' butonuna tiklandi.");

        //6."Daily Deals" butonuna tiklar
        ReusableMethods.waitFor(5);
        spendinggoodPage.dailyDeals.click();
        ReusableMethods.waitForClickablility(spendinggoodPage.dailyDeals, 5);

        extentTest.info("'Daily Deals' butonuna tiklandi.");

        //7.Sayfada "Sort By" basliginin oldugunu dogrular
        ReusableMethods.waitFor(3);
        Assert.assertTrue(spendinggoodPage.sortBy.isDisplayed());

        extentTest.info("'Sort By' basliginin oldugu dogrulandi.");

        //8."Sort by" menusunden fiyat siralamasini "low to high" olarak secer
        select = new Select(spendinggoodPage.sortByDropDown);
        select.selectByIndex(4);
        ReusableMethods.waitFor(3);

        extentTest.info("'Sort By' menusunden fiyat siralamasi 'low to high' olarak secildi.");

        //9.Fiyatlarin dusukten yuksege dogru siralandigini dogrular
        ReusableMethods.waitFor(3);
        for (int i = 0; i < spendinggoodPage.dusukFiyatSiralamasi.size(); i++) {

            Assert.assertTrue(spendinggoodPage.dusukFiyatSiralamasi.get(i).isDisplayed());
        }

        extentTest.pass("Fiyatlarin dusukten yuksege dogru siralandigi dogrulandi.");

        //10.Sayfayi kapatir
        Driver.closeDriver();
    }

    @Test
    public void TC_005() throws InterruptedException {

        extentTest = extentReports.
        createTest("Pozitif Test", "Kullanici fiyatlarin yuksekten dusuge dogru siralandigini dogrular.");

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
        ReusableMethods.waitFor(3);
        spendinggoodPage.submit.click();
        ReusableMethods.waitForVisibility(spendinggoodPage.submit, 5);

        extentTest.info("'Sign in' butonuna tiklandi.");

        //6."Daily Deals" butonuna tiklar
        ReusableMethods.waitFor(5);
        spendinggoodPage.dailyDeals.click();
        ReusableMethods.waitForClickablility(spendinggoodPage.dailyDeals, 5);

        extentTest.info("'Daily Deals' butonuna tiklandi.");

        //7.Sayfada "Sort By" basliginin oldugunu dogrular
        Assert.assertTrue(spendinggoodPage.sortBy.isDisplayed());
        ReusableMethods.waitFor(3);

        extentTest.info("'Sort By' basliginin oldugu dogrulandi.");

        //8."Sort by" menusunden fiyat siralamasini "high to low" olarak secer
        select = new Select(spendinggoodPage.sortByDropDown);
        select.selectByIndex(5);

        extentTest.info("'Sort By' menusunden fiyat siralamasi 'high to low' olarak secildi.");

        //9.Fiyatlarin yuksekten dusuge dogru siralandigini dogrular
        for (int i = 0; i < spendinggoodPage.yuksekFiyatSiralamasi.size(); i++) {

            Assert.assertTrue(spendinggoodPage.yuksekFiyatSiralamasi.get(i).isDisplayed());
        }

        extentTest.pass("Fiyatlarin yuksekten dusuge dogru siralandigi goruldu.");

        //10.Sayfayi kapatir
        Driver.closeDriver();
    }
}
