package tests;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.List;

public class US_008 extends TestBaseRapor {

    SpendinggoodPage spendinggoodPage = new SpendinggoodPage();

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC001() throws InterruptedException {
        extentTest= extentReports.createTest("Manage Stock", "Vendor urun miktarini belirleyebilmeli");

        // Vendor url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        extentTest.info("Vendor websitesine gidebildi");

        // Sign-in butonuna tiklar
        spendinggoodPage.signIn.click();
        ReusableMethods.waitFor(3);

        // Valid e-mail girer
        spendinggoodPage.userName.sendKeys(ConfigReader.getProperty("userEmail"));
        ReusableMethods.waitFor(3);

        // Valid password girer
        spendinggoodPage.passWord.sendKeys(ConfigReader.getProperty("pass"));
        ReusableMethods.waitFor(3);

        // Sign-in butonuna tiklar
        spendinggoodPage.submit.click();
        ReusableMethods.waitFor(3);

        // My Account' butonuna tiklar
        spendinggoodPage.myAccount.click();
        //actions.sendKeys(spendinggoodPage.myAccount, Keys.ENTER).perform();
        ReusableMethods.waitFor(3);

        // Store Manager' butonuna tiklar
        spendinggoodPage.storeManager.click();
        ReusableMethods.waitFor(3);

        // Products' butonuna tiklar
        spendinggoodPage.products.click();
        ReusableMethods.waitFor(3);

        // Products' bolumunde urune tiklar
        spendinggoodPage.nikeTshirtEdit.click();
        //actions.sendKeys(spendinggoodPage.nikeTshirt, Keys.ENTER).perform();
        ReusableMethods.waitFor(3);

        // Inventory' bolumunde 'Manage Stock' kutusuna tick atar
        spendinggoodPage.manageStockCheckBox.click();
        ReusableMethods.waitFor(3);

        // Urun miktarini (Stock Qty) belirler
        spendinggoodPage.stockQty.sendKeys("25");
        ReusableMethods.waitFor(3);

        // Submit'e tiklar
        spendinggoodPage.submitButton.click();
        ReusableMethods.waitFor(3);

        //Urun yazisini dogrula
        ReusableMethods.waitForVisibility(spendinggoodPage.successfullyPublished, 15);

        Assert.assertTrue(spendinggoodPage.successfullyPublished.isDisplayed());



        extentTest.pass("Vendor basarili bir sekilde urun miktarini belirledi");

        //Sayfayi kapatir
        Driver.closeDriver();

    }

    @Test
    public void TC002() throws InterruptedException {

        // Vendor url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));

        // Sign-in butonuna tiklar
        spendinggoodPage.signIn.click();

        // Valid e-mail girer
        spendinggoodPage.userName.sendKeys(ConfigReader.getProperty("userEmail"));

        // Valid password girer
        spendinggoodPage.passWord.sendKeys(ConfigReader.getProperty("pass"));

        // Sign-in butonuna tiklar
        spendinggoodPage.submit.click();
        ReusableMethods.waitFor(3);

        // My Account' butonuna tiklar
        spendinggoodPage.myAccount.click();
        //actions.sendKeys(spendinggoodPage.myAccount, Keys.ENTER).perform();
        ReusableMethods.waitFor(3);

        // Store Manager' butonuna tiklar
        spendinggoodPage.storeManager.click();
        ReusableMethods.waitFor(3);

        // Products' butonuna tiklar
        spendinggoodPage.products.click();
        ReusableMethods.waitFor(3);

        // Products' bolumunde urune tiklar
        spendinggoodPage.nikeTshirtEdit.click();
        //actions.sendKeys(spendinggoodPage.nikeTshirt, Keys.ENTER).perform();
        ReusableMethods.waitFor(3);


        //Inventory' bolumunde 'Backorder' seceneklerini kontrol eder
        Select select = new Select(spendinggoodPage.backordersDropdown);

        List<WebElement> tumOptions= select.getOptions();
        for (WebElement each: tumOptions
        ) {
            System.out.println(each.getText());
        }

        //Sayfayi kapatir
        Driver.closeDriver();





    }
}
