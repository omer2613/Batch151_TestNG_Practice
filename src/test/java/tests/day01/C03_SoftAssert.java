package tests.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C03_SoftAssert extends TestBase {

    // "https://amazon.com" sayfasına gidiniz
    /// Title'in "Amazon" icerdigini test edin
    /// Arama kutusunun erisilebilir oldugunu test edin
    // Arama kutusuna nutella yazıp aratın
    /// Sonuc yazısının gorunur oldugunu test edin
    /// Sonuc yazısının "Nutella" icerdigini test edin

    // test islemlerini softAssert ile yapınız ve hatalar icin mesaj versin

    @Test
    public void test01() {
        // "https://amazon.com" sayfasına gidiniz
        driver.get("https://amazon.com");

        // Title'in "Amazon" icerdigini test edin
        SoftAssert softAssert=new SoftAssert();//-->softAssert instance oldugu icin obje olusturulur.
       String amazonTitle= driver.getTitle();
       //softAssert.assertTrue(amazonTitle.contains("Amazon"));
       softAssert.assertTrue(driver.getTitle().contains("Amazon"),"TİTLE AMAZON ICERMIYOR");
        /// Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"ARAMA KUTUSUNA ERISILEMIYOR");

        // Arama kutusuna nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        /// Sonuc yazısının gorunur oldugunu test edin
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYazisi.isDisplayed(),"SONUC YAZISI GORULMUYOR");

        /// Sonuc yazısının "Nutella" icerdigini test edin
        softAssert.assertTrue(sonucYazisi.getText().contains("Nutella"),"SONUC YAZISI NUTELLA ICERMIYOR");

        softAssert.assertAll();//-->assertAll yazip tum hatalari listelemesini istemeliyiz.Aksi halde hata vermez.perform gibi
        System.out.println("omer");//--> herhangi bir hata yoksa yeni bir kodu calistirir.
        /*
        Junit te Assert kullandigimizda Assert fail oldugunda test calismayi durduruyordu ve geri kalanini calistirmiyordu.
        TestNG de hem Assert hem softassert yapilari var. Test sonuna kadar calissin testin sonunda  tüm hatalari listelesin
        istiyorsak softAssert kullaniliriz.
        Raporlama icin assertAll gerekli.
         */
    }
}
