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
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.List;

public class US_001 extends TestBaseRapor {
    SpendinggoodPage spendinGoodPage = new SpendinggoodPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
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
}
