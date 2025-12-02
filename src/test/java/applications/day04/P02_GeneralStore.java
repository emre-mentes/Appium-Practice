package applications.day04;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import applications.basetest.GeneralStoreBaseTest;

import java.util.List;

public class P02_GeneralStore extends GeneralStoreBaseTest {


    @Test
    public void testGeneralStore() throws InterruptedException {

        WebElement menu = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/spinnerCountry"));
        menu.click();

        WebElement angola = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Angola\")"));

        angola.click();

        WebElement textBox = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
        textBox.sendKeys("Emre");

        WebElement femaleButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/radioFemale"));
        femaleButton.click();
        WebElement letsShopButton = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/btnLetsShop\")"));
        letsShopButton.click();
        Thread.sleep(5000);

        List<WebElement> addToCart = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart"));
        for (WebElement w :addToCart) {
            w.click();
        }

        Thread.sleep(5000);

        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        List<WebElement> sepet = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productImage"));

        System.out.println("sepetteki ürün sayisi : " + sepet.size());

        Assert.assertEquals(sepet.size(), 2);

        List<WebElement> fiyatlar = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productPrice"));


        double total = 0;
        for (WebElement w : fiyatlar) {
           String priceText =  w.getText();//$160.97
            double price = Double.parseDouble(priceText.substring(1));//160.97
            total+=price;
        }

        System.out.println(total);


        WebElement toplamPrice = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/totalAmountLbl"));
        double totalFatura= Double.parseDouble(toplamPrice.getText().substring(1));

        System.out.println("totalFatura = " + totalFatura);
        Assert.assertEquals(totalFatura,total);

        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")")).click();
        driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();

        Thread.sleep(5000);

    }
}
