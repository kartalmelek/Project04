package tests;

import Page.SpendinggoodPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import Page.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_003 extends TestBaseRapor {
    SpendinggoodPage spendinggoodPage=new SpendinggoodPage();
    Actions actions =new Actions(Driver.getDriver());


    @Test
    public void TC001() {
        extentTest=extentReports.createTest("Pozitif test","Go shop bolumune click leyebilme");
        loginmethod();
        extentTest.info("https://spendinggood.com/ sayfasina gidildi ve orders bolumune tiklandi");
        ReusableMethods.waitFor(4);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        spendinggoodPage.gotoshop.click();
        extentTest.info("go shop bolumune clicklendi");
    extentTest.pass("Basarili test");
    }



    @Test
    public void TC002()  {
        extentTest=extentReports.createTest("Pozitif test","Sepete urun ekleyebilme");
        loginmethod();
        extentTest.info("https://spendinggood.com/ sayfasina gidildi ve orders bolumune tiklandi");
        urunekleme();
        extentTest.info("Sepete urun eklendi");
        System.out.println("spendinggoodPage.sepet1.size() = " + spendinggoodPage.sepet1.size());
        extentTest.info("Sepete urun eklendigi goruldu");
        extentTest.pass("Basarili test");

    }

    @Test
    public void TC003() {
        extentTest=extentReports.createTest("Pozitif test","Fatura detaylarina ulasabilme");
        loginmethod();
        extentTest.info("https://spendinggood.com/ sayfasina gidildi ve orders bolumune tiklandi");
        urunekleme();
        extentTest.info("Sepete urun eklendi");
        ReusableMethods.waitFor(1);
        spendinggoodPage.viewcart.click();
        extentTest.info("viewcart bolumune clicklendi");
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.proceedtocheckout.click();
        extentTest.info("Proceedtocheckout bolumune clicklendi");
        spendinggoodPage.billingdetails.isDisplayed();
        extentTest.info("fatura detaylarina ulasildi");
        extentTest.pass("Basarili test");
    }

    @Test
    public void TC004() {
        extentTest=extentReports.createTest("Pozitif test","Adres bilgileri goruntuleyebilme");
        loginmethod();
        extentTest.info("https://spendinggood.com/ sayfasina gidildi ve orders bolumune tiklandi");
         urunekleme();
        extentTest.info("Sepete urun eklendi");
        ReusableMethods.waitFor(1);
        spendinggoodPage.viewcart.click();
        extentTest.info("viewcart bolumune clicklendi");
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.proceedtocheckout.click();
        extentTest.info("Proceedtocheckout bolumune clicklendi");
        spendinggoodPage.billingdetails.isDisplayed();
        extentTest.info("fatura detaylarina ulasildi");
        spendinggoodPage.name.clear();
        spendinggoodPage.name.sendKeys("aaa", Keys.ENTER);
        actions.sendKeys(Keys.TAB).sendKeys("bb").sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        extentTest.info("kisi bilgileri girildi");
        extentTest.pass("Basarili test");



    }



    public  void loginmethod()  {
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        spendinggoodPage.signIn.click();
        spendinggoodPage.userName.sendKeys(ConfigReader.getProperty("userEmail"));
        spendinggoodPage.passWord.sendKeys(ConfigReader.getProperty("pass"));
        spendinggoodPage.login2.click();
        ReusableMethods.waitFor(3);
        spendinggoodPage.myAccount.click();
        spendinggoodPage.orders.click();

    }
    public void urunekleme(){
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        spendinggoodPage.gotoshop.click();
        ReusableMethods.waitFor(1);
        spendinggoodPage.urun1.click();
        spendinggoodPage.urunadd.click();
       // Driver.getDriver().navigate().back();
       // Driver.getDriver().navigate().back();
       // actions.sendKeys(Keys.PAGE_DOWN).perform();
       // ReusableMethods.waitFor(1);
       // spendinggoodPage.urun2.click();
       // spendinggoodPage.urunadd.click();
       // Driver.getDriver().navigate().back();
       // Driver.getDriver().navigate().back();
       // spendinggoodPage.urun3.click();
       // spendinggoodPage.urunadd.click();
       // Driver.getDriver().navigate().back();
       // Driver.getDriver().navigate().back();
       // spendinggoodPage.urun4.click();
       // spendinggoodPage.urunadd.click();
       // Driver.getDriver().navigate().back();
       // Driver.getDriver().navigate().back();
       // actions.sendKeys(Keys.PAGE_DOWN).perform();
       // spendinggoodPage.urun5.click();
       // spendinggoodPage.urunadd.click();
        spendinggoodPage.sepet.click();

    }

}
