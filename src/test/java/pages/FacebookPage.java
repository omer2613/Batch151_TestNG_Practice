package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {
    public FacebookPage() {
        PageFactory.initElements(Driver.getDriver(),this);


    }


    // kullanıcı email kutusuna rastgele bir isim yazın
    @FindBy(xpath = "//*[@name='email']")
    public WebElement emailKutusu;
    // kullanıcı sifre kutusuna rastgele bir password yazın
    @FindBy(xpath = "//*[@name='pass']")
    public WebElement sifreKutusu;
    // giris yap butonuna tıklayın
    @FindBy(xpath = "//*[@name='login']")
    public WebElement girisYapButonu;
    // lutfen bu hesabı baska sekilde tanımla yazı elementinin, gorunur oldugunu test edin
    @FindBy(xpath = "//button")
    public WebElement baskaSekildeTanımla;


}
