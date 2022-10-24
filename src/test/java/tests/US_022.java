package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class US_022 {

    SpendinggoodPage spendinggoodPage = new SpendinggoodPage();
    Actions actions = new Actions(Driver.getDriver());
    Select select;

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

        //6.Ekranda "Tumunu gor" linkini bulur ve o linke tiklar
        Assert.assertTrue(spendinggoodPage.emptyHeader.isDisplayed(), "Ekranda tumunu gor linki bulunmamaktadir.");
    }

    @Test
    public void TC_002() throws InterruptedException {

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

        //6."Daily Deals" butonuna tiklar
        spendinggoodPage.dailyDeals.click();

        //7.Sayfada "Sort By" basliginin oldugunu dogrular
        Assert.assertTrue(spendinggoodPage.sortBy.isDisplayed());

        //8.Varsayilan siralamanin "Default sorting" oldugunu dogrular
        select = new Select(spendinggoodPage.sortByDropDown);
        select.selectByIndex(0);

        String actualSira = select.getFirstSelectedOption().getText();
        String expectedSira = "Sort By";

        Assert.assertNotEquals(expectedSira, actualSira);

        //9.Sayfayi kapatir
        Driver.closeDriver();
    }

    @Test
    public void TC_003() throws InterruptedException {

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

        //6."Daily Deals" butonuna tiklar
        spendinggoodPage.dailyDeals.click();

        //7.Sayfada "Sort By" basliginin oldugunu dogrular
        Assert.assertTrue(spendinggoodPage.sortBy.isDisplayed());

        /*
        -> 8.Sıralama secenekleri arasında "Default Sorting, Sort by popularity, Sort by average rating, Sort by latest,
           Sort by latest, Sort by price: low to high, Sort by price: high to low" bulundugunu dogrular
        */
        select = new Select(spendinggoodPage.sortByDropDown);

        List<WebElement> dropDown = select.getOptions();

        List<String> actualIcerik = new ArrayList<String>();

        List<String> expectedIcerik = new ArrayList<String>(Arrays.asList
        ("Default Sorting, Sort by popularity, Sort by average rating, Sort by latest," +
         "Sort by latest, Sort by price: low to high, Sort by price: high to low"));

        for (WebElement each : dropDown
        ) {

            actualIcerik.add(each.getText());
        }

        Collections.sort(actualIcerik);
        Collections.sort(expectedIcerik);

        Assert.assertEquals(expectedIcerik, actualIcerik);

        //9.Sayfayi kapatir
        Driver.closeDriver();
    }

    @Test
    public void TC_004() throws InterruptedException {

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

        //6."Daily Deals" butonuna tiklar
        spendinggoodPage.dailyDeals.click();

        //7.Sayfada "Sort By" basliginin oldugunu dogrular
        Assert.assertTrue(spendinggoodPage.sortBy.isDisplayed());

        //8."Sort by" menusunden fiyat siralamasini "low to high" olarak secer
        select = new Select(spendinggoodPage.sortByDropDown);
        select.selectByIndex(4);

        //9.Fiyatlarin dusukten yuksege dogru siralandigini dogrular
        for (int i = 0; i < spendinggoodPage.dusukFiyatSiralamasi.size(); i++) {

            Assert.assertTrue(spendinggoodPage.dusukFiyatSiralamasi.get(i).isDisplayed());
        }

        //10.Sayfayi kapatir
        Driver.closeDriver();
    }

    @Test
    public void TC_005() throws InterruptedException {

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

        //6."Daily Deals" butonuna tiklar
        spendinggoodPage.dailyDeals.click();

        //7.Sayfada "Sort By" basliginin oldugunu dogrular
        Assert.assertTrue(spendinggoodPage.sortBy.isDisplayed());

        //8."Sort by" menusunden fiyat siralamasini "high to low" olarak secer
        select = new Select(spendinggoodPage.sortByDropDown);
        select.selectByIndex(5);

        //9.Fiyatlarin yuksekten dusuge dogru siralandigini dogrular

        //10.Sayfayi kapatir
        Driver.closeDriver();
    }
}
