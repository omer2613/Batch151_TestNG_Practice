package tests.day03;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_DataProvider {
    @DataProvider
    public static Object[][] kelimeler() {
        return new Object[][]{{"Nutella"},
                              {"Java"},
                              {"cigdem"},
                              {"Netherlands"}};
    }

    // amazon sayfasına gidelim
    // Nutella, Java, cigdem ve Netherlands icin arama yapalım
    // sonucların aradıgımız kelime icerdigini test edelim
    // sayfayı kapatalım


    @Test(dataProvider = "kelimeler")
    public void test01(String kelimeler) {
        // amazon sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Nutella, Java, cigdem ve Netherlands icin arama yapalım
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(kelimeler, Keys.ENTER);

        // sonucların aradıgımız kelime icerdigini test edelim
        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains(kelimeler));


        // sayfayı kapatalım
        Driver.closeDriver();
    }
}
