package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.SpendinggoodPage;
import utilities.ConfigReader;


import utilities.Driver;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class US_016 {


    SpendinggoodPage spendinggoodPage = new SpendinggoodPage();


    @Test
    public void TC001() throws InterruptedException {
        //1 vendor url ye gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));

        //2 vendor sayfadan My Account. tiklar
        spendinggoodPage.myAccount.click();

        //3 vendor valid username girer
        spendinggoodPage.userName.sendKeys("hakan");

        //4 vendor valid Password girer
        spendinggoodPage.passWord.sendKeys("JVyMaGb9G6iD47Q");

        //5.vendor sign In tıklar
        spendinggoodPage.submit.click();

        //6.vendor  store Manager yazısını tıklar
        spendinggoodPage.storeManager.click();

        //7.vendor Customers yazısını tıklar
        spendinggoodPage.customers.click();

        //8. vendor Add New yazısına tıklar
        spendinggoodPage.customers_AddNew.click();

        //9.vendor ilk 4 boşlukları doldurur ve submit tuşuna tıklar
        String username = Faker.instance().name().username();
        spendinggoodPage.customers_Username.sendKeys(username);
        spendinggoodPage.customers_Email.sendKeys(Faker.instance().internet().emailAddress());
        spendinggoodPage.customers_FirstName.sendKeys(Faker.instance().name().firstName());
        spendinggoodPage.customers_LastName.sendKeys(Faker.instance().name().lastName());

        spendinggoodPage.customers_Submit.click();

        //10.vendor Customers yazısını tıklar
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_UP).perform();
        spendinggoodPage.customers.click();

        //11.search bolumune musteri username adını girer
        spendinggoodPage.customers_Search.sendKeys(username);

        //12.username bolumunde adının görunur olduğunu doğrular
        Thread.sleep(5000);
        String actual_Username = spendinggoodPage.customers_SearchResult.getText();
        Assert.assertEquals("Customers eklenemedi", username, actual_Username);
    }

    @Test
    public void TC002() throws InterruptedException {

        //1 vendor url ye gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));

        //2 vendor My Account a tıklar
        spendinggoodPage.myAccount.click();

        //3 vendor valid username girer
        spendinggoodPage.userName.sendKeys("hakan");

        //4 vendor valid Password girer
        spendinggoodPage.passWord.sendKeys("JVyMaGb9G6iD47Q");

        //5.vendor sign In tıklar
        spendinggoodPage.submit.click();

        //6. vendor  store Manager yazısını tıklar
        spendinggoodPage.storeManager.click();

        //7.vendor Customers yazısını tıklar

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.customers.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //8.vendor name bölümünün olduğunu dogrular ve yazdirir
        SoftAssert sassert = new SoftAssert();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(spendinggoodPage.customers_Names.get(0)));

        sassert.assertTrue(spendinggoodPage.customers_Names.get(0).isDisplayed());

        System.out.println("customers_Names");
        spendinggoodPage.customers_Names.forEach(t -> System.out.println(t.getText()));

        //9.vendor username olduğunu doğrular ve yazdirir
        sassert.assertTrue(spendinggoodPage.customers_UserNames.get(0).isDisplayed());
        System.out.println("customers_UserNames");
        spendinggoodPage.customers_UserNames.forEach(t -> System.out.println(t.getText()));

        //10.vendor email olduğunu doğrular ve yazdirir
        sassert.assertTrue(spendinggoodPage.customers_Emails.get(0).isDisplayed());
        System.out.println("customers_Emails");
        spendinggoodPage.customers_Emails.forEach(t -> System.out.println(t.getText()));

        //11. vendor location olduğunu doğrular ve yazdirir
        sassert.assertTrue(spendinggoodPage.customers_Locations.get(0).isDisplayed());
        System.out.println("customers_Locations");
        spendinggoodPage.customers_Locations.forEach(t -> System.out.println(t.getText()));

        //12.vendor money spent görünür olduğunu doğrular ve yazdirir
        sassert.assertTrue(spendinggoodPage.customers_MoneySpents.get(0).isDisplayed());
        System.out.println("customers_MoneySpents");
        spendinggoodPage.customers_MoneySpents.forEach(t -> System.out.println(t.getText()));

        //13 vendor last order görünür olduğunu doğrular ve yazdirir
        sassert.assertTrue(spendinggoodPage.customers_LastOrders.get(0).isDisplayed());
        System.out.println("customers_LastOrders");
        spendinggoodPage.customers_LastOrders.forEach(t -> System.out.println(t.getText()));

        sassert.assertAll();
    }

    @Test
    public void TC003() throws InterruptedException {
        //1 vendor url ye gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));

        //2 vendor sayfadan My Account. tiklar
        spendinggoodPage.myAccount.click();

        //3 vendor valid username girer
        spendinggoodPage.userName.sendKeys("hakan");

        //4 vendor valid Password girer
        spendinggoodPage.passWord.sendKeys("JVyMaGb9G6iD47Q");

        //5.vendor sign In tıklar
        spendinggoodPage.submit.click();

        //6.vendor  store Manager yazısını tıklar
        spendinggoodPage.storeManager.click();

        //7.vendor Customers yazısını tıklar
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.customers.click();

        // 8.vendor pdf butonuna  tıklar
        spendinggoodPage.customers_PDF.click();
        Thread.sleep(5000);

        //  9.vendor pdf olarak indirildiğini doğrular.
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "/Downloads/Store Manager - Spending Good.pdf";

        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }

    @Test
    public void TC004() throws InterruptedException {
        //1 vendor url ye gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));

        //2 vendor sayfadan My Account. tiklar
        spendinggoodPage.myAccount.click();

        //3 vendor valid username girer
        spendinggoodPage.userName.sendKeys("hakan");

        //4 vendor valid Password girer
        spendinggoodPage.passWord.sendKeys("JVyMaGb9G6iD47Q");

        //5.vendor sign In tıklar
        spendinggoodPage.submit.click();

        //6.vendor  store Manager yazısını tıklar
        spendinggoodPage.storeManager.click();

        //7.vendor Customers yazısını tıklar
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.customers.click();

        // 8.vendor excel butonuna  tıklar
        spendinggoodPage.customers_Excel.click();
        Thread.sleep(5000);

        //  9.vendor excel olarak indirildiğini doğrular.
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "/Downloads/Store Manager - Spending Good.xlsx";

        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
    @Test
    public void TC005() throws InterruptedException {
        //1 vendor url ye gider
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));

        //2 vendor sayfadan My Account. tiklar
        spendinggoodPage.myAccount.click();

        //3 vendor valid username girer
        spendinggoodPage.userName.sendKeys("hakan");

        //4 vendor valid Password girer
        spendinggoodPage.passWord.sendKeys("JVyMaGb9G6iD47Q");

        //5.vendor My Account tıklar
        spendinggoodPage.submit.click();

        //6.vendor  store Manager yazısını tıklar
        spendinggoodPage.storeManager.click();

        //7.vendor Customers yazısını tıklar
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        spendinggoodPage.customers.click();

        // 8.vendor csv butonuna  tıklar
        spendinggoodPage.customers_CSV.click();
        Thread.sleep(5000);

        //  9.vendor csv olarak indirildiğini doğrular.
        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "/Downloads/Store Manager - Spending Good.csv";

        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
}
