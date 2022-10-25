package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SpendinggoodPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_017 {
    SpendinggoodPage spendinggoodPage = new SpendinggoodPage();

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC001() {

        giris();

        //7.vendor Customers yazısını tıklar
        spendinggoodPage.customers.click();

        //8. vendor Add New yazısına tıklar
        spendinggoodPage.customers_AddNew.click();

        //9.vendor billing boşlukları dahil doldurur  ve submit tuşuna tıklar
        String username = Faker.instance().name().username();
        spendinggoodPage.customers_Username.sendKeys(username);
        spendinggoodPage.customers_Email.sendKeys(Faker.instance().internet().emailAddress());
        spendinggoodPage.customers_FirstName.sendKeys(Faker.instance().name().firstName());
        spendinggoodPage.customers_LastName.sendKeys(Faker.instance().name().lastName());

        spendinggoodPage.customers_BillingFirstName.sendKeys(Faker.instance().name().firstName());

        Select country = new Select(spendinggoodPage.customers_Country);
        actions.sendKeys(Keys.TAB).sendKeys(Faker.instance().name().lastName()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().company().name()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().address().fullAddress()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().address().fullAddress()).perform();
        country.selectByVisibleText("Turkey");

        actions.sendKeys(Keys.TAB).sendKeys(Faker.instance().address().city()).
                sendKeys(Keys.TAB).sendKeys("Denizli").sendKeys(Keys.TAB).
                sendKeys(Faker.instance().idNumber().valid()).perform();


        spendinggoodPage.customers_Submit.click();


        //        10.vendor customers kayıt oldugunu dogrular

        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", spendinggoodPage.customers_add);



        Assert.assertTrue(spendinggoodPage.customers_add.isDisplayed());

    }

    @Test
    public void TC002() {

        giris();

        //7.vendor Customers yazısını tıklar
        spendinggoodPage.customers.click();

        //8. vendor Add New yazısına tıklar
        spendinggoodPage.customers_AddNew.click();

        //9.vendor billing boşlukları dahil doldurur
        spendinggoodPage.customers_Username.sendKeys(Faker.instance().name().username());
        spendinggoodPage.customers_Email.sendKeys(Faker.instance().internet().emailAddress());
        spendinggoodPage.customers_FirstName.sendKeys(Faker.instance().name().firstName());
        spendinggoodPage.customers_LastName.sendKeys(Faker.instance().name().lastName());

        spendinggoodPage.customers_BillingFirstName.sendKeys(Faker.instance().name().firstName());


        actions.sendKeys(Keys.TAB).sendKeys(Faker.instance().name().lastName()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().company().name()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().address().fullAddress()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().address().fullAddress()).perform();
        Select country = new Select(spendinggoodPage.customers_Country);
        country.selectByVisibleText("Turkey");

        actions.sendKeys(Keys.TAB).sendKeys(Faker.instance().address().city()).
                sendKeys(Keys.TAB).sendKeys("Denizli").sendKeys(Keys.TAB).
                sendKeys(Faker.instance().idNumber().valid()).perform();

        //      10.vendor shipping bilgiler aynı olarak kaydeder
        if (!spendinggoodPage.customers_Same_as_billing.isSelected()) {
            spendinggoodPage.customers_Same_as_billing.click();
        }
        Assert.assertTrue(spendinggoodPage.customers_Same_as_billing.isSelected());
        spendinggoodPage.customers_Submit.click();

        //        11.vendor customers kayıt oldugunu dogrular
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", spendinggoodPage.customers_add);

        Assert.assertTrue(spendinggoodPage.customers_add.isDisplayed());

    }

    @Test
    public void TC003() {


        giris();

        //7.vendor Customers yazısını tıklar
        spendinggoodPage.customers.click();

        //8. vendor Add New yazısına tıklar
        spendinggoodPage.customers_AddNew.click();

        //9.vendor billing boşlukları dahil doldurur
        spendinggoodPage.customers_Username.sendKeys(Faker.instance().name().username());
        spendinggoodPage.customers_Email.sendKeys(Faker.instance().internet().emailAddress());
        spendinggoodPage.customers_FirstName.sendKeys(Faker.instance().name().firstName());
        spendinggoodPage.customers_LastName.sendKeys(Faker.instance().name().lastName());

        spendinggoodPage.customers_BillingFirstName.sendKeys(Faker.instance().name().firstName());


        actions.sendKeys(Keys.TAB).sendKeys(Faker.instance().name().lastName()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().company().name()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().address().fullAddress()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().address().fullAddress()).perform();
        Select country = new Select(spendinggoodPage.customers_Country);
        country.selectByVisibleText("Turkey");

        actions.sendKeys(Keys.TAB).sendKeys(Faker.instance().address().city()).
                sendKeys(Keys.TAB).sendKeys("Denizli").sendKeys(Keys.TAB).
                sendKeys(Faker.instance().idNumber().valid()).perform();

        //      10.vendor shipping bilgiler farklı olarak kaydeder
        if (spendinggoodPage.customers_Same_as_billing.isSelected()) {
            spendinggoodPage.customers_Same_as_billing.click();
        }

        spendinggoodPage.customers_shippingFirstName.sendKeys(Faker.instance().name().firstName());


        actions.sendKeys(Keys.TAB).sendKeys(Faker.instance().name().lastName()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().company().name()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().address().fullAddress()).
                sendKeys(Keys.TAB).sendKeys(Faker.instance().address().fullAddress()).perform();
        Select countrys = new Select(spendinggoodPage.customers_Country);
        countrys.selectByVisibleText("Turkey");

        actions.sendKeys(Keys.TAB).sendKeys(Faker.instance().address().city()).
                sendKeys(Keys.TAB).sendKeys("Denizli").sendKeys(Keys.TAB).
                sendKeys(Faker.instance().idNumber().valid()).perform();

        spendinggoodPage.customers_Submit.click();

        //        11.vendor customers kayıt oldugunu dogrular
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", spendinggoodPage.customers_add);

        Assert.assertTrue(spendinggoodPage.customers_add.isDisplayed());

    }

    public void giris() {

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
    }

}
