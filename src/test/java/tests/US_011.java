package tests;

import pages.SpendinggoodPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;


public class US_011 extends TestBaseRapor {
    private static Logger logger = LogManager.getLogger(US_011.class.getName());
    //https://spendinggood.com adresine gider
    // Sing butonu'na tiklar
    // Valid User name girer
    // Valid Password girer
    //sign in butonuna tiklar
    // My accuont'a tiklar
    // Store manager'a tiklar
    // Products butonuna tiklar
    // Add new butonuna tiklar
    // Toptan urun gosterme ayarlarini tiklar
    // Piece Type bolumunun gorunulurlugunu dogrular
    //Unit Per Piece bolumunun gorunulurlugunu dogrular
    //Min Order Quantitiy bolumunun gorunulurlugunu dogrular

    WebDriver driver = Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());
    SpendinggoodPage spendinggoodPage = new SpendinggoodPage();



    @Test
    public void TC001_UrunCesiti() throws InterruptedException, IOException {
    extentTest=extentReports.createTest("Pozitif Test,Toptan urun gosterme ayarlarindaki bolumlerin gosterilmesi");
        ReusableMethods.waitFor(2);
        //https://spendinggood.com adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        extentTest.info("Spendinggoog sitesine gildildi");
        spendinggoodPage.signButton.click();
        extentTest.info("Sing in butonuna basildi");
        Thread.sleep(2000);
        // Valid User name girer
        // Valid Password girer
        ReusableMethods.waitFor(2);
        spendinggoodPage.userrEmail.sendKeys(ConfigReader.getProperty("useEmail"));
        spendinggoodPage.password.sendKeys(ConfigReader.getProperty("sifremiz"), Keys.ENTER);
        extentTest.info("Dogru kullanici email ve password girildi");
        Thread.sleep(2000);
        //My accuont'a tiklar
        actions.sendKeys(spendinggoodPage.myaccaunt, Keys.ENTER).perform();
        extentTest.info("My accuont butonuna basildi");
        // Store manager'a tiklar
        spendinggoodPage.stromanager.click();
        extentTest.info("Store Manager butonuna basildi");
        //Products butonuna tiklar
        spendinggoodPage.product.click();
        extentTest.info("Product butonuna basildi");
        // Add new butonuna tiklar
        actions.doubleClick(spendinggoodPage.newadd).click().perform();
        extentTest.info("New add  butonuna basildi");
        // Toptan urun gosterme ayarlarina gider ve tiklar
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("sayfa sonuna inildi");
        ReusableMethods.waitFor(2);
        spendinggoodPage.invatid.click();
        spendinggoodPage.invatid.click();
        extentTest.info("invatid butonuna basildi");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).doubleClick().
                doubleClick(spendinggoodPage.toptanurun).click().perform();
        ReusableMethods.getScreenshotWebElement("toptanurun",spendinggoodPage.toptanurun);
        extentTest.info("Toptan urunler bolumune  tiklandi");
        // Piece Type( bolumunun gorunulurlugunu dogrular
        Assert.assertTrue(spendinggoodPage.PieceType.isEnabled());
        extentTest.info("Piece Type bolumunun gorunur oldugu dogrulandi");
        Thread.sleep(2000);
        //Unit Per Piece bolumunun gorunulurlugunu dogrular
        Assert.assertTrue((spendinggoodPage.UnitsPerPiece.isEnabled()));
        extentTest.info("Unit Per Piece  bolumunun gorunur oldugu dogrulandi");
        Thread.sleep(2000);
        //Min Order Quantitiy bolumunun gorunulurlugunu dogrular
        Assert.assertTrue(spendinggoodPage.MInOrderQuantity.isEnabled());
        extentTest.info("Min Order Quantity bolumunun gorunur oldugu dogrulandi");
        ReusableMethods.getScreenshot("Spendinggood");
        driver.close();


    }


/*
    @Test
    public void TC002_UnitPerPiece() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
        SpendinggoodPage spendinggoodPage = new SpendinggoodPage();
        ReusableMethods.waitFor(2000);
        //https://spendinggood.com adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        spendinggoodPage.signButton.click();
        spendinggoodPage.signButton.click();
        Thread.sleep(2000);
        // Valid User name girer
        // Valid Password girer
        ReusableMethods.waitFor(2);
        spendinggoodPage.userrEmail.sendKeys(ConfigReader.getProperty("useEmail"));
        spendinggoodPage.password.sendKeys(ConfigReader.getProperty("sifremiz"), Keys.ENTER);
        if(spendinggoodPage.singout.isDisplayed()){
            actions.doubleClick(spendinggoodPage.singout).sendKeys(Keys.ENTER).clickAndHold(spendinggoodPage.singout).perform();

        }
        Thread.sleep(2000);
        //My accuont'a tiklar
        actions.sendKeys(spendinggoodPage.myaccaunt,Keys.ENTER).perform();
        // Store manager'a tiklar
        spendinggoodPage.stromanager.click();
        //Products butonuna tiklar
        spendinggoodPage.product.click();
        // Add new butonuna tiklar
        actions.doubleClick(spendinggoodPage.newadd).click().perform();
        // Toptan urun gosterme ayarlarina gider ve tiklar
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        spendinggoodPage.invatid.click();
        spendinggoodPage.invatid.click();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).doubleClick().
                doubleClick(spendinggoodPage.toptanurun).click().perform();

        driver.close();
    }


    @Test
    public void TC003_MinOrderQuantity() throws InterruptedException {

        //https://spendinggood.com adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        spendinggoodPage.signButton.click();
        spendinggoodPage.signButton.click();
        Thread.sleep(2000);
        // Valid User name girer
        // Valid Password girer
        ReusableMethods.waitFor(2);
        spendinggoodPage.userrEmail.sendKeys(ConfigReader.getProperty("useEmail"));
        spendinggoodPage.password.sendKeys(ConfigReader.getProperty("sifremiz"), Keys.ENTER);
        if(spendinggoodPage.singout.isDisplayed()){
            actions.doubleClick(spendinggoodPage.singout).sendKeys(Keys.ENTER).clickAndHold(spendinggoodPage.singout).perform();

        }
        //sign in butonuna tiklar
        actions.sendKeys(Keys.TAB).click().perform();
        //My accuont'a tiklar
        spendinggoodPage.myaccaunt.click();
        // Store manager'a tiklar
        spendinggoodPage.stromanager.click();
        //Products butonuna tiklar
       spendinggoodPage.product.click();
        // Add new butonuna tiklar
        actions.doubleClick(spendinggoodPage.newadd).click().perform();
        // Toptan urun gosterme ayarlarina gider ve tiklar
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.invatid.click();
        spendinggoodPage.invatid.click();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).doubleClick().
                doubleClick(spendinggoodPage.toptanurun).click().perform();
        //Min Order Quantitiy bolumunun gorunulurlugunu dogrular
        Assert.assertTrue(spendinggoodPage.MInOrderQuantity.isEnabled());
        Thread.sleep(1000);
        driver.quit();

    }

*/

}
