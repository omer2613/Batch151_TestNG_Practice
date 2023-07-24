package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HerokuapPage {
    public HerokuapPage() {
        PageFactory.initElements(Driver.getDriver(),this);

        // https://id.heroku.com/login sayfasına gidin

        // yanlıs email ve yanlıs password giriniz
        // (NOT: birden fazla yanlıs email ve password'u dataProvider kullanarak sırayla deneyin)


    }
    @FindBy(xpath = "//*[@name='email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;



    // login butonuna tıklayınız

    @FindBy(xpath = "//button[@name='commit']")
    public WebElement loginButonu;

    // "There was a problem with your login." yazisinin gorunur oldugunu test edin

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement  ThereWasProblemElementi;


}
