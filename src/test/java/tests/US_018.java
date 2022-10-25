package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_018 {
    SpendinggoodPage spendinggoodPage = new SpendinggoodPage();
    @Test
    public void TC001(){

        giris();

        //7.vendor Refund yazısını tıklar
        spendinggoodPage.refund.click();

        //8. vendor request id  yazısının görunur olduğunu dogrular ve yazdirir
        Assert.assertTrue(spendinggoodPage.customers_UserNames.get(0).isDisplayed());
        System.out.println("Refund request id");
        spendinggoodPage.customers_UserNames.forEach(t -> System.out.println(t.getText()));
        
    }

    @Test
    public void TC002(){

        giris();

        //7.vendor Refund yazısını tıklar
        spendinggoodPage.refund.click();

        //8. vendor order id  yazısının görunur olduğunu dogrular ve yazdirir
        Assert.assertTrue(spendinggoodPage.customers_Emails.get(0).isDisplayed());
        System.out.println("Refund order id");
        spendinggoodPage.customers_Emails.forEach(t -> System.out.println(t.getText()));

    }
    @Test
    public void TC003(){

        giris();

        //7.vendor Refund yazısını tıklar
        spendinggoodPage.refund.click();

        //8. vendor urun miktari  yazısının görunur olduğunu dogrular ve yazdirir
        Assert.assertTrue(spendinggoodPage.customers_Locations.get(0).isDisplayed());
        System.out.println("Refund urun miktari");
        spendinggoodPage.customers_Locations.forEach(t -> System.out.println(t.getText()));

    }
    @Test
    public void TC004(){

        giris();

        //7.vendor Refund yazısını tıklar
        spendinggoodPage.refund.click();

        //8. vendor iade urunun tipi  yazısının görunur olduğunu dogrular ve yazdirir
        Assert.assertTrue(spendinggoodPage.refund_Type.get(0).isDisplayed());
        System.out.println("Refund iade urunun tipi");
        spendinggoodPage.refund_Type.forEach(t -> System.out.println(t.getText()));

    }
    @Test
    public void TC005(){

        giris();

        //7.vendor Refund yazısını tıklar
        spendinggoodPage.refund.click();

        //8. vendor iade urunun sebebi  yazısının görunur olduğunu dogrular ve yazdirir
        Assert.assertTrue(spendinggoodPage.customers_MoneySpents.get(0).isDisplayed());
        System.out.println("Refund iade urunun sebebi");
        spendinggoodPage.customers_MoneySpents.forEach(t -> System.out.println(t.getText()));

    }
    public void giris() {

        //1 vendor url ye gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));

        //2 vendor sayfadan My Account. tiklar

        spendinggoodPage.myAccount.click();

        //3 vendor valid username girer
        spendinggoodPage.userName.sendKeys("hakan");

        //4 vendor valid Password girer
        spendinggoodPage.passWord.sendKeys("JVyMaGb9G6iD47Q");

        //5.vendor sign In tıklar
        spendinggoodPage.submit.click();

        //6.vendor  store Manager yazısını tıklar
        spendinggoodPage.storeManager.click();
    }
}
