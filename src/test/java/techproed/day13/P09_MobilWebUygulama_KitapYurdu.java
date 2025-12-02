package techproed.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.ChromeBrowserBaseTest;
import techproed.utilities.ReusableMethods;

import java.time.Duration;

public class P09_MobilWebUygulama_KitapYurdu extends ChromeBrowserBaseTest {


    @Test
    public void testRegister() {

        driver.get("https://www.kitapyurdu.com");

        WebElement cookieScriptAccept = driver.findElement(By.id("cookiescript_accept"));
        ReusableMethods.visibleWait(driver,cookieScriptAccept,15);
        cookieScriptAccept.click();


        driver.findElement(By.xpath("//a[@href='index.php?route=account/account']")).click();

        driver.findElement(By.xpath("//a[contains(., 'Ücretsiz')]")).click();
        driver.findElement(By.id("firstname")).sendKeys("Temel");
        driver.findElement(By.id("lastname")).sendKeys("REIS");
        driver.findElement(By.id("email")).sendKeys("temelreis@godzilla.com");
        driver.findElement(By.id("password")).sendKeys("123456789");
        driver.findElement(By.id("confirm")).sendKeys("123456789");
        driver.hideKeyboard();

        driver.findElement(By.id("form-check-input")).click();

        // Butonu bul
        WebElement üyeOl = driver.findElement(By.id("register-button"));

// Sayfada buton görünene kadar bekle
        ReusableMethods.visibleWait(driver, üyeOl, 15);

// Klavyeyi kapat (mobilde ekranın üstünde kalmış olabilir)
        driver.hideKeyboard();

        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(üyeOl));

// Buton tıklanabilir olana kadar bekle (eğer ReusableMethods'ta böyle bir method varsa)
        ReusableMethods.clickableWait(driver, üyeOl, 15);

// Buton ekran dışında ise scroll yap
        driver.executeScript("arguments[0].scrollIntoView(true);", üyeOl);

// Butona tıkla
        üyeOl.click();
        Assert.assertEquals(driver.findElement(By.xpath("//h1[text()='Hesabınız Oluşturuldu!!']")).getText(),"Hesabınız Oluşturuldu!!");

        ReusableMethods.bekle(5);





    }
}
