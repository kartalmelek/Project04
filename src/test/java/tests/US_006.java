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

public class US_006 extends TestBaseRapor {  // Secilen ürünlerin categorilerini belirlemeliyim
    SpendinggoodPage sgPage5 = new SpendinggoodPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC005_014_isSelectedCategories() {
        signInAddProduct();

        sgPage5.accessoriesCategories.click();
        Assert.assertTrue(sgPage5.accessoriesCategories.isSelected(),"Accesories is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.bookmusicFilmCategories.click();
        Assert.assertTrue(sgPage5.bookmusicFilmCategories.isSelected(),"Book & Music & Films is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.electronicCategories.click();
        Assert.assertTrue(sgPage5.electronicCategories.isSelected(),"Electronic is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.healthBeautyCategories.click();
        Assert.assertTrue(sgPage5.healthBeautyCategories.isSelected(),"Health & Beauty is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.giftIdeasCategories.click();
        Assert.assertTrue(sgPage5.giftIdeasCategories.isSelected(),"Gift Ideas is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.fashionCategories.click();
        Assert.assertTrue(sgPage5.fashionCategories.isSelected(),"Fashion is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.cosmeticCategories.click();
        Assert.assertTrue(sgPage5.cosmeticCategories.isSelected(),"Cosmetic is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.foodCategories.click();
        Assert.assertTrue(sgPage5.foodCategories.isSelected(),"Food is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.kidsCategories.click();
        Assert.assertTrue(sgPage5.kidsCategories.isSelected(),"Kids is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.menCategories.click();
        Assert.assertTrue(sgPage5.menCategories.isSelected(),"Men is not selected");
        ReusableMethods.waitFor(2);
        sgPage5.womenCategories.click();
        Assert.assertTrue(sgPage5.womenCategories.isSelected(),"Women is not selected");
        ReusableMethods.waitFor(4);
        extentTest = extentReports.createTest("pozitif test","Belirlenen kategorileri sectigi gorulur");
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