package techproed.day13;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.GeneralStoreBaseTest;
import techproed.utilities.ReusableMethods;

import java.util.List;
import java.util.Set;

public class P08_HibritUygulama_GeneralStore extends GeneralStoreBaseTest {


    @Test
    public void testGeneralStore() throws InterruptedException {

        WebElement menu = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
        menu.click();

        WebElement scrollMenu = driver.findElement(AppiumBy.className("android.widget.ListView"));

         driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Barbados\"))"));
        WebElement barbados = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Barbados\"]"));

        barbados.click();

        WebElement textBox = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
        textBox.sendKeys("Emre");

        WebElement femaleButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
        femaleButton.click();

        WebElement letsShopButton = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")"));
        letsShopButton.click();
        Thread.sleep(5000);


        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))"));
        driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).get(1).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"LeBron Soldier 12 \"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).click();


        ReusableMethods.bekle(5);

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        ReusableMethods.bekle(2);

        List<WebElement> sepet = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productImage"));

        System.out.println("sepetteki ürün sayisi : " + sepet.size());

        Assert.assertEquals(sepet.size(), 2);

        List<WebElement> fiyatlar = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));


        double total = 0;
        for (WebElement w : fiyatlar) {
            String priceText = w.getText();//$160.97
            double price = Double.parseDouble(priceText.substring(1));//160.97
            total += price;
        }

        System.out.println(total);


        WebElement toplamPrice = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl"));
        double totalFatura = Double.parseDouble(toplamPrice.getText().substring(1));

        System.out.println("totalFatura = " + totalFatura);
        Assert.assertEquals(totalFatura, total);

        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();

        Thread.sleep(5000);
        driver.context("WEBVIEW_com.androidsample.generalstore");

        ReusableMethods.visibleWait(driver,driver.findElement(By.xpath("//textarea[@jsname='yZiJbe']")),15);
        ReusableMethods.clickableWait(driver,driver.findElement(By.xpath("//textarea[@jsname='yZiJbe']")),15);
        driver.findElement(By.xpath("//textarea[@jsname='yZiJbe']")).sendKeys("TEMEL REIS"+ Keys.ENTER);

        ReusableMethods.bekle(5);

        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");

        String baslik = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")).getText();
        Assert.assertEquals(baslik,"General Store");


    }

}



