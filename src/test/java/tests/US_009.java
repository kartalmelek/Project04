package tests;

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

import java.time.Duration;

public class US_009 {

    SpendinggoodPage spendinggoodPage = new SpendinggoodPage();

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC001() throws InterruptedException {

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


        // 'Shipping' bolumune tiklar
        spendinggoodPage.shippingButton.click();


        //'Shipping' bolumunde kilo ve boyutu belirler
        Actions actions = new Actions(Driver.getDriver());
        spendinggoodPage.weight.sendKeys("85g");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("76").perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("50").perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("76").perform();

        // Submit'e tiklar
        spendinggoodPage.submitButton.click();


        //Urun yazisini dogrula
        ReusableMethods.waitForVisibility(spendinggoodPage.successfullyPublished, 15);

        Assert.assertTrue(spendinggoodPage.successfullyPublished.isDisplayed());


        // Sayfayi kapatir
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

        // 'Shipping' bolumune tiklar
        spendinggoodPage.shippingButton.click();


        // Shipping' bolumunde ne kadar surede teslimat yapilacagini(Processing Time) belirler
        Select select = new Select(spendinggoodPage.processTimeDropdown);
        select.selectByIndex(1);


        // Submit'e tiklar
        spendinggoodPage.submitButton.click();


        //Urun yazisini dogrula
        ReusableMethods.waitForVisibility(spendinggoodPage.successfullyPublished, 15);

        Assert.assertTrue(spendinggoodPage.successfullyPublished.isDisplayed());

        //Sayfayi kapatir
        Driver.closeDriver();


    }
}
