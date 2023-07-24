package tests.day03;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HerokuapPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {
    @DataProvider
    public static Object[][] kullaniciListesi() {
        return new Object[][]{{ConfigReader.getProperty("fakeEmail1"),ConfigReader.getProperty("fakePassword1")},
                             {ConfigReader.getProperty("fakeEmail2"),ConfigReader.getProperty("fakePassword2")},
                             {ConfigReader.getProperty("fakeEmail3"),ConfigReader.getProperty("fakePassword3")}};
    }

    // https://id.heroku.com/login sayfasına gidin

    // yanlıs email ve yanlıs password giriniz
    // (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)

    // login butonuna tıklayınız

    // "There was a problem with your login." yazisinin gorunur oldugunu test edin

    // sayfayı kapatınız


    @Test(dataProvider = "kullaniciListesi")
    public void NegatifLoginDataProvider(String email,String password) {
        // https://id.heroku.com/login sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("herokuapUrl"));

        // yanlıs email ve yanlıs password giriniz
        // (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)
        HerokuapPage herokuapPage=new HerokuapPage();
        herokuapPage.emailKutusu.sendKeys(email);
        herokuapPage.password.sendKeys(password);

        // login butonuna tıklayınız
        herokuapPage.loginButonu.click();

        // "There was a problem with your login." yazisinin gorunur oldugunu test edin
        Assert.assertTrue(herokuapPage.ThereWasProblemElementi.isDisplayed());

        // sayfayı kapatınız
        Driver.closeDriver();

    }
}
