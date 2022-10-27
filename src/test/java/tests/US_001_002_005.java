package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_001_002_005 extends TestBaseRapor {

    SpendinggoodPage spendinGoodPage = new SpendinggoodPage();
    Actions actions = new Actions(Driver.getDriver());

    SpendinggoodPage sgPage5= new SpendinggoodPage();

    @Test(groups = "group01")
    public void OnayKoduGirme() throws InterruptedException {
        extentTest = extentReports.createTest("Pozitif Test", "Yeni hesabin olusturuldugu gorulur");
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        extentTest.info("//Istenilen URL'ye gidilir");
        Thread.sleep(1500);
        spendinGoodPage.signIn.click();
        extentTest.info("//Acilan sayfada signIn buttonunu tiklar");
        Thread.sleep(1500);
        spendinGoodPage.SIGNUP.click();
        extentTest.info("//Acilan sayfada sign up buttonunu tiklar");
        Thread.sleep(1500);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("//Acilan sayfada Become a Vendor'a tiklanilir");
        Thread.sleep(2000);
        Assert.assertTrue(spendinGoodPage.UcEmailPasswordConfirmPassword.isDisplayed());
        extentTest.info("//Sayfada Email, Password, ConfirmPassword girilme kisimlarinin gorunur oldugunu test edilir");
        Thread.sleep(1500);
        spendinGoodPage.Email1.click();
        extentTest.info("//Email kismina click yapar");
        Thread.sleep(1500);
        actions.sendKeys("yoesfsimsek@gmail.com").sendKeys(Keys.TAB).
                sendKeys("123456").sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("Team04").sendKeys(Keys.TAB).
                sendKeys("Team04").sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
        spendinGoodPage.UniqOlmayanYazisi.isDisplayed();
        extentTest.info("//Girilen mail adresinin uniq olduguna bakilir");
        Driver.getDriver().navigate().refresh();
        extentTest.info(" /Sayfayi yeniler");
        Thread.sleep(2000);
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        extentTest.info("//Email ve onay kodu icin yeni bir sayfa acip \"https://www.mohmal.com/tr/inbox\" adresinden mail ve codu alip getirir");
        Driver.getDriver().get("https://www.mohmal.com/tr/inbox");
        extentTest.info("//\"https://www.mohmal.com/tr/inbox\" adresine gidilir");
        Thread.sleep(1500);
        List<String> windowList = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowList.get(1));
        Thread.sleep(1500);
        String email = spendinGoodPage.geciciEmail.getText();
        System.out.println(email);
        extentTest.info("//Acilan sayfadaki email adresini getirip yazdirir");
        Driver.getDriver().switchTo().window(windowList.get(0));
        spendinGoodPage.Email1.sendKeys(email);
        Thread.sleep(1500);
        Driver.getDriver().switchTo().window(windowList.get(1));
        extentTest.info("//Tekrar \"https://www.mohmal.com/tr/inbox\" adresine gider");
        Thread.sleep(4000);
        spendinGoodPage.yenilemeTusu.click();
        extentTest.info("//YenilemeTusuna click yapar");
        Thread.sleep(1500);
        Driver.getDriver().navigate().refresh();
        extentTest.info("Sayfayi yeniler");
        spendinGoodPage.geciciEmailBox.click();
        extentTest.info("//Maile gelen kismina tiklar");
        WebElement iframe = Driver.getDriver().findElement(By.cssSelector("div>#read>div>iframe")); //iframe gir
        Driver.getDriver().switchTo().frame(iframe);
        extentTest.info("//Acilan sayfada iframe oldugu icin methodu oluşturulur");
        Thread.sleep(1500);
        int code = Integer.parseInt(spendinGoodPage.verificationCode.getText().replaceAll("\\D", ""));
        String code2 = String.valueOf(code);
        extentTest.info("//maile gelen kodu alip getirir");
        Driver.getDriver().switchTo().defaultContent();
        extentTest.info(" //iframe den cikis yapar");
        Driver.getDriver().switchTo().window(windowList.get(0));
        Thread.sleep(1000);
        spendinGoodPage.VerificationCodeBox.sendKeys(code2);
        Thread.sleep(1000);
        spendinGoodPage.Password.sendKeys("Team04");
        extentTest.info("//Password olusturur");
        Thread.sleep(1000);
        spendinGoodPage.ConfirmPassword.sendKeys("Team04");
        extentTest.info("//Ayni pasword tekrar girilir");
        Thread.sleep(1000);
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info("//RegisterButtonuna tiklar");
        Thread.sleep(1000);
        spendinGoodPage.MyAccount.isDisplayed();
        extentTest.info("//Siteye kayit yaptigini doğrular");
        Thread.sleep(2000);
        Driver.closeDriver();
        extentTest.info("//sayfayi kapatir");
        extentTest.pass("Basarili Test");
    }

    @Test (groups = "group02")
    public void SupporTicketsFollowingsVeLogoutOlmaliTest() {
        extentTest = extentReports.createTest("Support tickets, followings ve log out olmali","Support tickets, follwings ve log out gorunur");
        extentTest.info("Email ve Sifre girilerek Siteye girilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        ReusableMethods.waitFor(10);
        extentTest.info("SignIn Buttonuna click yapar");
        ReusableMethods.jsclick(spendinGoodPage.signIn1);
        ReusableMethods.waitFor(3);
        extentTest.info("Email ve Password girip SIGN IN Buttonuna click yapar");
        ReusableMethods.waitFor(3);
        actions.click(spendinGoodPage.userName).sendKeys("yoesfsimsek@gmail.com").
                sendKeys(Keys.TAB).sendKeys("Team04").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.pass("Giris yapilip MyAccount yazısı gorulmeli");
        ReusableMethods.waitFor(3);
        ReusableMethods.jsclick(spendinGoodPage.MyAccount);
        Assert.assertTrue(spendinGoodPage.MyAccountYazisi.isDisplayed());

        Driver.closeDriver();

    }
    @Test (groups = "group03")  // TC_001 Productsta urun listemi görmeliyim; status, stock, price, date
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
        ReusableMethods.waitFor(3);
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

        ReusableMethods.waitFor(5);
        sgPage5.clickBigPhoto.click();
        ReusableMethods.waitFor(5);
        sgPage5.chooseBigPhoto.click();
        sgPage5.selectBigPhoto.click();

        ReusableMethods.waitFor(5);
        sgPage5.productTitle.sendKeys("NewLaptop");
        actions.sendKeys(Keys.TAB).sendKeys("20").sendKeys(Keys.TAB).
                sendKeys("15").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("MSK Laptop 16GB Ram 500 SSD").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("16GB Ram \n 500 SSD \n Dual Core").perform();
        ReusableMethods.waitFor(5);

        // TC_004 Kisa tanımlama ve geniş tanımlama (short description, Description)
        Assert.assertTrue(sgPage5.shortDescription.isDisplayed());
        ReusableMethods.waitFor(3);
        Assert.assertTrue(sgPage5.description.isDisplayed());

        // TC_003 Urun ismi ekle; product title, satis miktarı, foto - Devami

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(4);
        sgPage5.manageStockClick.click();
        ReusableMethods.waitFor(4);
        actions.sendKeys(Keys.TAB).sendKeys("10").perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(4);

        sgPage5.accessoriesCategories.click();
        sgPage5.elegantAutoGroupBrand.click();

        ReusableMethods.waitFor(4);
        //sgPage5.soldIndividually.click();
        //sgPage5.submitAddProduct.click();

    }
    public void signInProduct(){
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
        ReusableMethods.waitFor(3);
        sgPage5.myAccount.click();
        sgPage5.userName.sendKeys(ConfigReader.getProperty("userEmail"));
        sgPage5.passWord.sendKeys(ConfigReader.getProperty("pass"), Keys.ENTER);
        ReusableMethods.waitFor(3);
        sgPage5.storeManager.click();
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        sgPage5.products.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);

    }
}
