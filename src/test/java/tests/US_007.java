package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_007 extends TestBaseRapor { // Secilen ürünlerin brandini belirlemeliyim
    SpendinggoodPage sgPage5 = new SpendinggoodPage();
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void TC016_022_selectedBrands() {
        signInAddProduct();

        sgPage5.elegantAutoGroupBrand.click();
        Assert.assertTrue(sgPage5.elegantAutoGroupBrand.isSelected(),"Elegant Auto Group is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.greenGrassBrand.click();
        Assert.assertTrue(sgPage5.greenGrassBrand.isSelected(),"Green Grass is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.nodeJsBrand.click();
        Assert.assertTrue(sgPage5.nodeJsBrand.isSelected(),"Node Js is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.NSBBrand.click();
        Assert.assertTrue(sgPage5.NSBBrand.isSelected(),"NSB is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.REDBrand.click();
        Assert.assertTrue(sgPage5.REDBrand.isSelected(),"RED is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.skySuiteTechBrand.click();
        Assert.assertTrue(sgPage5.skySuiteTechBrand.isSelected(),"SkySuite Tech is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.sterlingBrand.click();
        Assert.assertTrue(sgPage5.sterlingBrand.isSelected(),"Sterling is not selected");
        ReusableMethods.waitFor(2);
        extentTest = extentReports.createTest("pozitif test","Belirlenen Brands'lari sectigi gorulur");
        Driver.closeDriver();
    }
    public void signInAddProduct(){
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        ReusableMethods.waitFor(2);
        sgPage5.myAccount.click();
        sgPage5.userName.sendKeys(ConfigReader.getProperty("emailAddress"));
        sgPage5.passWord.sendKeys(ConfigReader.getProperty("password"), Keys.ENTER);
        ReusableMethods.waitFor(2);
        sgPage5.storeManager.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        sgPage5.products.click();
        ReusableMethods.waitFor(2);
        sgPage5.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
    }

}
