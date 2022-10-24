package tests;

import Page.SpendinggoodPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Page.SpendinggoodPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_004 extends TestBaseRapor {
    SpendinggoodPage spendinggoodPage = new SpendinggoodPage();
    Actions actions = new Actions(Driver.getDriver());
    US_003 us_003 = new US_003();
    double ikincisepet=0;


    public void TC_001() {
        extentTest=extentReports.createTest("Pozitif test","Sepete urun ekleyebilme");

        us_003.loginmethod();
        extentTest.info("https://spendinggood.com/ sayfasina gidildi ve orders bolumune tiklandi");
        ReusableMethods.waitFor(4);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        spendinggoodPage.gotoshop.click();
        extentTest.info("go shop bolumune clicklendi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(4);
        spendinggoodPage.urun2.click();
        extentTest.info("4. urune tiklandi");
        spendinggoodPage.urunadd.click();
        extentTest.info("urun sepete eklendi");
        ReusableMethods.waitFor(5);
        spendinggoodPage.sepet.click();
        extentTest.info("sepete clicklendi");
        spendinggoodPage.viewcart.click();
        extentTest.info("viewcart bolumune clicklendi");
        double ilksepet = Double.parseDouble(spendinggoodPage.sepetsayim.getText().replace("$", "").replace(",", ""));
        spendinggoodPage.urunarttirma.click();
        extentTest.info("urun 1 adet arttirildi");
        spendinggoodPage.update.click();
        extentTest.info("urun arttirilmasi guncellendi");
        ReusableMethods.waitFor(4);
        ikincisepet = Double.parseDouble(spendinggoodPage.sepetsayim.getText().replace("$", "").replace(",", ""));
        Assert.assertTrue(ikincisepet > ilksepet);
        extentTest.pass("Basarili test");

    }

    @Test
    public void TC001_1() {
        TC_001();
        ReusableMethods.waitFor(2);
        spendinggoodPage.urunazaltma.click();
        extentTest.info("urun azaltildi");
        spendinggoodPage.update.click();
        extentTest.info("urun azaltilmasi update edildi");
        ReusableMethods.waitFor(7);
        double ucuncusepet = Double.parseDouble(spendinggoodPage.sepetsayim.getText().replace("$", "").replace(",", ""));
        Assert.assertTrue(ucuncusepet<ikincisepet);
        extentTest.pass("Basarili test");
    }

    @Test
    public void TC002 () {
        extentTest=extentReports.createTest("Pozitif test","Stock sayisindan fazla eklenemedi");
        us_003.loginmethod();
        extentTest.info("https://spendinggood.com/ sayfasina gidildi ve orders bolumune tiklandi");
        ReusableMethods.waitFor(4);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        spendinggoodPage.gotoshop.click();
        extentTest.info("go shop bolumune clicklendi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(4);
        spendinggoodPage.urun2.click();
        extentTest.info("4. urune tiklandi");
        spendinggoodPage.stocksayisi.isDisplayed();
        extentTest.info("stock sayisina ulasildi");
        spendinggoodPage.urunadd.click();
        extentTest.info("urun sepete eklendi");
        ReusableMethods.waitFor(4);
        spendinggoodPage.stockguncelleme.clear();
        String list=spendinggoodPage.stocksayisi.getText();
        String [] list1=list.split(" ");
        String ilkeleman=list1[0];
        spendinggoodPage.stockguncelleme.sendKeys(ilkeleman);
        extentTest.info("stock sayisi kadar urun sepete gonderildi");
        spendinggoodPage.urunadd.click();
        extentTest.info("sepete ekle bolumune tiklandi");
        String actual=spendinggoodPage.toplam.getText();
        System.out.println("actual = " + actual);
        String expected="$1,100.00";
        Assert.assertEquals(expected,actual);
        ReusableMethods.waitFor(6);
        extentTest.info("stock fazlasi urununun eklenemedigi goruldu");
        extentTest.pass("Basarili test");
    }


    @Test
    public void TC003() {
        extentTest=extentReports.createTest("Pozitif test","cupon secenegine ulasabilme");
        us_003.loginmethod();
        extentTest.info("https://spendinggood.com/ sayfasina gidildi ve orders bolumune tiklandi");
        ReusableMethods.waitFor(6);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        spendinggoodPage.gotoshop.click();
        extentTest.info("go shop bolumune clicklendi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(4);
        spendinggoodPage.urun2.click();
        extentTest.info("4. urune tiklandi");
        spendinggoodPage.urunadd.click();
        extentTest.info("urun sepete eklendi");
        ReusableMethods.waitFor(2);
        spendinggoodPage.sepet.click();
        extentTest.info("sepete clicklendi");
        spendinggoodPage.viewcart.click();
        extentTest.info("viewcart bolumune clicklendi");
        ReusableMethods.waitFor(2);
        spendinggoodPage.cuponsecenegi.isEnabled();
        extentTest.info("cupon secenegine ulasildi");
        extentTest.pass("Basarili test");
    }
    @Test
    public void TC004() {
        extentTest=extentReports.createTest("Pozitif test","Continoushopping bolumune ulasabilme");
        us_003.loginmethod();
        extentTest.info("https://spendinggood.com/ sayfasina gidildi ve orders bolumune tiklandi");
        ReusableMethods.waitFor(4);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        spendinggoodPage.gotoshop.click();
        extentTest.info("go shop bolumune clicklendi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(4);
        spendinggoodPage.urun2.click();
        extentTest.info("4. urune tiklandi");
        spendinggoodPage.urunadd.click();
        extentTest.info("urun sepete eklendi");
        ReusableMethods.waitFor(2);
        spendinggoodPage.sepet.click();
        extentTest.info("sepete clicklendi");
        spendinggoodPage.viewcart.click();
        extentTest.info("clearcart bolumune clicklendi");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(spendinggoodPage.continoushopping.isEnabled());
        extentTest.info("continoushopping yazisina ulasildi");
        extentTest.pass("Basarili test");

    }

    @Test
    public void TC005() {
        extentTest=extentReports.createTest("Pozitif test","Totalamaount  bolumune ulasabilme");
        us_003.loginmethod();
        extentTest.info("https://spendinggood.com/ sayfasina gidildi ve orders bolumune tiklandi");
        ReusableMethods.waitFor(4);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        spendinggoodPage.gotoshop.click();
        extentTest.info("go shop bolumune clicklendi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(4);
        spendinggoodPage.urun2.click();
        extentTest.info("4. urune tiklandi");
        spendinggoodPage.urunadd.click();
        extentTest.info("urun sepete eklendi");
        ReusableMethods.waitFor(2);
        spendinggoodPage.sepet.click();
        extentTest.info("sepete clicklendi");
        spendinggoodPage.viewcart.click();
        extentTest.info("clearcart bolumune clicklendi");
        ReusableMethods.waitFor(4);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.proceedtocheckout.click();
        extentTest.info("proceedtocheckout bolumune tiklandi");
        ReusableMethods.waitFor(2);
        spendinggoodPage.billingdetails.isEnabled();
        extentTest.info("billingdetails bolumune ulasildi");
        actions.sendKeys(Keys.PAGE_DOWN);
        spendinggoodPage.totalamount.isEnabled();
        extentTest.info("totalamount bolumune ulasildi");
        extentTest.pass("Basarili test");

    }
    @Test
    public void TC006() {
        extentTest=extentReports.createTest("Pozitif test","Sepet bos yazisina ulasabilme");
        us_003.loginmethod();
        extentTest.info("https://spendinggood.com/ sayfasina gidildi ve orders bolumune tiklandi");
        ReusableMethods.waitFor(4);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        spendinggoodPage.gotoshop.click();
        extentTest.info("go shop bolumune clicklendi");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(4);
        spendinggoodPage.urun2.click();
        extentTest.info("4. urune tiklandi");
        spendinggoodPage.urunadd.click();
        extentTest.info("urun sepete eklendi");
        ReusableMethods.waitFor(2);
        spendinggoodPage.sepet.click();
        extentTest.info("sepete clicklendi");
        spendinggoodPage.viewcart.click();
        extentTest.info("viewcart bolumune clicklendi");
        ReusableMethods.waitFor(2);
        spendinggoodPage.clearcart.click();
        extentTest.info("clearcart bolumune clicklendi");
        Assert.assertTrue(spendinggoodPage.sepetbosyazisi.isDisplayed());
        extentTest.info("sepet bos yazisina ulasildi");
        extentTest.pass("Basarili test");
    }
}
