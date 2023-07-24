package tests.day02;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_Raporlama extends TestBaseRapor {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("batch1514","amazonu test edebilmeli");//-->extenttest etestname ve description degerlerini atamaliyiz


        // 'https://www.amazon.com' adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("AMAZON SAYFASINI GIDILDI");
        // arama kutusuna "Java" yazip aratın
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        extentTest.info("Arama kutusuna java yazildi");
        // sonuc yazisinin "Java" icerdigini test edin
        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("Java"));
        extentTest.info("Sonuc yazisinin Java icerdigi test edildi");

        // kontrollu olarak yeni bir sayfa acın
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        extentTest.info("Konrollu yeni sayfa acildi");

        // yeni acılan sayfada "Kitap" aratın
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage.aramaKutusu.sendKeys("Kitap"+Keys.ENTER);
        extentTest.info("yeni acilan sayfada kitap aratildi");

        // sonuc yazisinin Kitap icerdigini test edin
        Assert.assertTrue(amazonPage.sonucYazisi.getText().contains("Kitap"));
        extentTest.pass("Sonuc yazisinin Kitap icerdigi test edildi");

        // sayfayı kapatınız
        Driver.closeDriver();

        // test raporu alınız
        extentReports.flush();


    }
}
