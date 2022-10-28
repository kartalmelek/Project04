package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_005 {  // Store Manager olarak, Products a gidip yeni ürünler yükleyebilmeliyim
    SpendinggoodPage sgPage5= new SpendinggoodPage();

    Actions actions = new Actions(Driver.getDriver());
    @Test  // TC_001 Productsta urun listemi görmeliyim; status, stock, price, date
    public void TC001_seeProductsList() throws InterruptedException {
        signInProduct();

        List<String> workList = new ArrayList<>(Arrays.asList("Status","Stock","Price","Date"));
        ReusableMethods.waitFor(2);
        List<WebElement> proListMenu =sgPage5.producListMenu;
        int count=2;
        for (int i = 0; i <workList.size() ; i++) {
            for (WebElement w:proListMenu) {
                if(workList.get(i).equals(w.getText())){
                    count+=1;
            }
        }
        }
        if(count==4){
        System.out.println("Status, Stock, Price, Date basliklari icermektedir." +count);
    }
        // TC_002 Yeni urun ekle (Add new); urun icin Virtual veya Downloadable secenegi olmali
        actions.sendKeys(Keys.PAGE_UP).perform();
        sgPage5.addNewButton.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        sgPage5.virtualText.click();
        Assert.assertTrue(sgPage5.virtualText.isSelected());
        sgPage5.dawnlodableText.click();
        Assert.assertTrue(sgPage5.dawnlodableText.isSelected());
        sgPage5.dawnlodableText.click();

        // TC_003 Urun ismi ekle; product title, satis miktarı, foto
        sgPage5.productPhoto.click();
        ReusableMethods.waitFor(2);
        sgPage5.mediaGalery.click();
        sgPage5.photos.click();
        sgPage5.addToGalery.click();

        ReusableMethods.waitFor(2);
        sgPage5.clickBigPhoto.click();
        ReusableMethods.waitFor(2);
        sgPage5.chooseBigPhoto.click();
        sgPage5.selectBigPhoto.click();

        ReusableMethods.waitFor(2);
        sgPage5.productTitle.sendKeys("NewLaptop");
        actions.sendKeys(Keys.TAB).sendKeys("20").sendKeys(Keys.TAB).
                sendKeys("15").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("MSK Laptop 16GB Ram 500 SSD").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("16GB Ram \n 500 SSD \n Dual Core").perform();
        ReusableMethods.waitFor(2);

        // TC_004 Kisa tanımlama ve geniş tanımlama (short description, Description)
        Assert.assertTrue(sgPage5.shortDescription.isDisplayed());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(sgPage5.description.isDisplayed());

        // TC_003 Urun ismi ekle; product title, satis miktarı, foto - Devami

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        sgPage5.manageStockClick.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.TAB).sendKeys("10").perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(2);

        sgPage5.accessoriesCategories.click();
        sgPage5.elegantAutoGroupBrand.click();

        ReusableMethods.waitFor(2);
        ReusableMethods.jsclick(sgPage5.submitAddProduct);
        Driver.closeDriver();

    }
    public void signInProduct(){
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        ReusableMethods.waitFor(2);
        sgPage5.myAccount.click();
        sgPage5.userName.sendKeys(ConfigReader.getProperty("userEmail"));
        sgPage5.passWord.sendKeys(ConfigReader.getProperty("pass"), Keys.ENTER);
        ReusableMethods.waitFor(2);
        sgPage5.storeManager.click();
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        sgPage5.products.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);

    }
}
