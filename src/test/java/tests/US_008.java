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

import java.util.List;

    public class US_008 extends TestBaseRapor {

        SpendinggoodPage spendinggoodPage = new SpendinggoodPage();

        Actions actions = new Actions(Driver.getDriver());

        @Test
        public void TC001() throws InterruptedException {
            extentTest = extentReports.createTest("Manage Stock", "Vendor urun miktarini belirleyebilmeli");

            // Vendor url'e gider
            Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
            extentTest.info("Vendor websitesine gidebildi");

            // Sign-in butonuna tiklar
            spendinggoodPage.signIn.click();
            ReusableMethods.waitFor(5);
            extentTest.info("Signin butonuna tiklayabildi");


            // Valid e-mail girer
            spendinggoodPage.userName.sendKeys(ConfigReader.getProperty("emailAddress"));
            ReusableMethods.waitFor(5);
            extentTest.info("Email adresini yazabildi");


            // Valid password girer
            spendinggoodPage.passWord.sendKeys(ConfigReader.getProperty("password"));
            ReusableMethods.waitFor(5);
            extentTest.info("Sifresini yazabildi");


            // Sign-in butonuna tiklar
            spendinggoodPage.submit.click();
            ReusableMethods.waitFor(3);
            extentTest.info("Submit'e tiklayabildi");


            // My Account' butonuna tiklar
            spendinggoodPage.myAccount.click();
            //actions.sendKeys(spendinggoodPage.myAccount, Keys.ENTER).perform();..
            ReusableMethods.waitFor(3);
            extentTest.info("Vendor MyAccount'a tiklayabildi");


            // Store Manager' butonuna tiklar
            spendinggoodPage.storeManager.click();
            ReusableMethods.waitFor(3);
            extentTest.info("Store Manager butonuna tiklayabildi");


            // Products' butonuna tiklar
            spendinggoodPage.products.click();
            ReusableMethods.waitFor(3);
            extentTest.info("Products butonuna tiklayabildi");


            // Products' bolumunde urune tiklar
            ReusableMethods.jsclick(spendinggoodPage.products);
            //actions.sendKeys(spendinggoodPage.nikeTshirt, Keys.ENTER).perform();
            ReusableMethods.waitFor(3);
            extentTest.info("Urunde edit'e tiklayabildi");


            // Inventory' bolumunde 'Manage Stock' kutusuna tick atar
            spendinggoodPage.manageStockCheckBox.click();
            ReusableMethods.waitFor(3);
            extentTest.info("Inventory bolumunde 'Manage Stock' kutusuna tick atabildi");


            // Urun miktarini (Stock Qty) belirler
            spendinggoodPage.stockQty.sendKeys("25");
            ReusableMethods.waitFor(3);
            extentTest.info("Urun miktarini belirleyebildi");


            // Submit'e tiklar
            ReusableMethods.jsclick(spendinggoodPage.submitButton);
            ReusableMethods.waitFor(7);
            extentTest.info("Submit butonuna tiklayabildi");


            //Urun yazisini dogrula
            ReusableMethods.waitForVisibility(spendinggoodPage.successfullyPublished, 15);
            Assert.assertTrue(spendinggoodPage.successfullyPublished.isEnabled());
            extentTest.info("Vendor 'Product Successfully Published.' yazisini gorebildi");


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
            spendinggoodPage.userName.sendKeys(ConfigReader.getProperty("emailAddress"));

            // Valid password girer
            spendinggoodPage.passWord.sendKeys(ConfigReader.getProperty("password"));

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

            List<WebElement> tumOptions = select.getOptions();
            for (WebElement each : tumOptions
            ) {
                System.out.println(each.getText());
            }

            //Sayfayi kapatir
            Driver.closeDriver();

        }
    }

