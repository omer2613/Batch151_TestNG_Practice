package tests.day01;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_Priority extends TestBase {

    // amazon isimli bir test methodu olusturunuz. Ve amazona gidiniz
    // bestbuy isimli bir test methodu olusturunuz. Ve bestbuy'a gidiniz
    // techproeducation isimli bir test methodu olusturunuz. Ve techproeducation'a gidiniz

    // once techproeducation, sonra amazon, sonra bestbuy test methodu calısacak sekilde sıralama yapınız


    @Test(priority = -2)
    public void amazon() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void bestbuy() {
        driver.get("https://www.bestbuy.com");
    }

    @Test(priority = -5)
    public void techproeducation() {
        driver.get("https://techproeducation.com");
    }
    /*
        TestNG test methodlarini alfabetik siraya gore calistirir.
        Eger alfabetik siranin disinda bir siralama ile calismasini isterseniz:
        O zaman test methodlarina oncelik(priority) tanimlayabiliriz.


        priority kucukten buyuge gore calisir.
        eger bi test methoduna priority atanmamissa default olarak priority=0 kabul edilir
     */
}
