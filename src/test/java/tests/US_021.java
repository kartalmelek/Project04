package tests;

import pages.SpendinggoodPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_021 extends TestBaseRapor {
    SpendinggoodPage spendinggoodPage=new SpendinggoodPage();
    Actions actions=new Actions(Driver.getDriver());
    @Test
    public void TC001()  {
        extentTest=extentReports.createTest("Pozitif test","Go shop bolumune click leyebilme");
        method1();
        extentTest.info("https://spendinggood.com/ sayfasina gidildi ve reports bolumune ulasildi");
        spendinggoodPage.year.click();
        extentTest.info("1 yillik rapor bolumune ulasildi");
        spendinggoodPage.lastmonth.click();
        extentTest.info("son ayin raporlarina ulasildi");
        spendinggoodPage.thismonth.click();
        extentTest.info("Bu ayin raporlarina ulasildi");
        spendinggoodPage.last7days.click();
        extentTest.info("son 7 gunun raporlarina ulasildi");
        extentTest.pass("Basarili test");



    }

    @Test
    public void TC002() throws InterruptedException {
        extentTest=extentReports.createTest("Pozitif test","Go shop bolumune click leyebilme");
        method1();
        extentTest.info("https://spendinggood.com/ sayfasina gidildi ve reports bolumune ulasildi");
        spendinggoodPage.custom.sendKeys("2022-10-19 to 2022-10-21");
        extentTest.info("specifik tarih araligi secilebildi");
        extentTest.pass("Basarili test");

    }



    public void method1()  {
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        spendinggoodPage.signIn.click();
        spendinggoodPage.userName.sendKeys(ConfigReader.getProperty("userEmail"));
        spendinggoodPage.passWord.sendKeys(ConfigReader.getProperty("pass"));
        spendinggoodPage.login2.click();
        ReusableMethods.waitFor(2);
        spendinggoodPage.myAccount.click();
        spendinggoodPage.storeManager.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        spendinggoodPage.reports.click();
    }


}
