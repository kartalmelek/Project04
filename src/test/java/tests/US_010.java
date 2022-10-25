package tests;

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

import java.time.Duration;

public class US_010 {

    SpendinggoodPage spendinggoodPage = new SpendinggoodPage();

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC001() throws InterruptedException {

        // Vendor url'e gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));

        // Sign-in butonuna tiklar
        spendinggoodPage.signIn.click();
        ReusableMethods.waitFor(1);

        // Valid e-mail girer
        spendinggoodPage.userName.sendKeys(ConfigReader.getProperty("userEmail"));
        ReusableMethods.waitFor(1);


        // Valid password girer
        spendinggoodPage.passWord.sendKeys(ConfigReader.getProperty("pass"));
        ReusableMethods.waitFor(1);


        // Sign-in butonuna tiklar
        spendinggoodPage.submit.click();
        ReusableMethods.waitFor(1);

        // My Account' butonuna tiklar
        spendinggoodPage.myAccount.click();
        //actions.sendKeys(spendinggoodPage.myAccount, Keys.ENTER).perform();
        ReusableMethods.waitFor(1);

        // Store Manager' butonuna tiklar
        spendinggoodPage.storeManager.click();
        ReusableMethods.waitFor(1);

        // Products' butonuna tiklar
        spendinggoodPage.products.click();
        ReusableMethods.waitFor(1);

        // Products' bolumunde urune tiklar
        spendinggoodPage.nikeTshirtEdit.click();
        //actions.sendKeys(spendinggoodPage.nikeTshirt, Keys.ENTER).perform();
        ReusableMethods.waitFor(1);


        // Attributes' bolumune tiklar
        spendinggoodPage.attributesButton.click();
        ReusableMethods.waitFor(1);



        // Color' bolumunde "Select All" tiklar ve tum renk seceneklerini belirtir
        spendinggoodPage.colorCheckBox.click();
        spendinggoodPage.colorSelectAll.click();
        ReusableMethods.waitFor(1);




        // Submit'e tiklar
        spendinggoodPage.submitButton.click();
        ReusableMethods.waitFor(1);


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
        Thread.sleep(3000);

        // My Account' butonuna tiklar
        spendinggoodPage.myAccount.click();
        //actions.sendKeys(spendinggoodPage.myAccount, Keys.ENTER).perform();
        Thread.sleep(3000);

        // Store Manager' butonuna tiklar
        spendinggoodPage.storeManager.click();
        Thread.sleep(3000);

        // Products' butonuna tiklar
        spendinggoodPage.products.click();
        Thread.sleep(3000);

        // Products' bolumunde urune tiklar
        spendinggoodPage.nikeTshirtEdit.click();
        //actions.sendKeys(spendinggoodPage.nikeTshirt, Keys.ENTER).perform();
        Thread.sleep(3000);



        // Attributes' bolumune tiklar
        spendinggoodPage.attributesButton.click();



        // Size' bolumunde "Select All" tiklar ve tum beden seceneklerini belirtir
        spendinggoodPage.sizeCheckBox.click();
        spendinggoodPage.sizeSelectAll.click();



        // Submit'e tiklar
        spendinggoodPage.submitButton.click();


        //Urun yazisini dogrula
        ReusableMethods.waitForVisibility(spendinggoodPage.successfullyPublished, 15);

        Assert.assertTrue(spendinggoodPage.successfullyPublished.isDisplayed());

        //Sayfayi kapatir
        Driver.closeDriver();





    }
}
