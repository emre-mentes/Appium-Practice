package applications.day08;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import applications.basetest.KitapYurduBaseTest;
import applications.utilities.ReusableMethods;

import java.util.List;

public class P06_KitapYurdu_ScrollSwipeGestures extends KitapYurduBaseTest {

    @Test
    public void testKitapYurdu() throws InterruptedException {

        WebElement swipeElement = driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/recyclerViewList"));

        ReusableMethods.swipeGesture(driver,swipeElement,"left",1.0,400);
        WebElement besinciKitap = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.mobisoft.kitapyurdu:id/imageViewProduct\"])[3]"));
        ReusableMethods.clickGesture(driver,besinciKitap);

        List<WebElement> kitapBilgileri = driver.findElements(AppiumBy.xpath("//android.widget.ScrollView[@resource-id=\"com.mobisoft.kitapyurdu:id/productDetailScrollView\"]/android.view.ViewGroup/android.widget.TextView"));
        List<WebElement> künyeBilgileri = driver.findElements(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewAttributeName"));
        List<WebElement> künyeBasliklari = driver.findElements(AppiumBy.id("com.mobisoft.kitapyurdu:id/textViewAttributeTitle"));

        System.out.println("kitap adi : "+kitapBilgileri.get(0).getText());
        System.out.println("yazar adi : "+kitapBilgileri.get(1).getText());
        System.out.println("yayinevi adi : "+kitapBilgileri.get(2).getText());

        System.out.println("*************************************************************************************************************************");

       // driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Künye\"))"));
        WebElement scrollElement = driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/productDetailScrollView"));
        ReusableMethods.scrollGesture(driver,scrollElement,"down",3.0,1000);
        Thread.sleep(3000);

        System.out.println("Baslik sayisi: " + künyeBasliklari.size());
        System.out.println("Bilgi sayisi: " + künyeBilgileri.size());


        for (int i = 0; i <künyeBasliklari.size() ; i++) {
            System.out.print(künyeBasliklari.get(i).getText() + "\t");
            System.out.println(künyeBilgileri.get(i).getText());
        }
        Thread.sleep(5000);


        // Künye tablosunu bul
        WebElement künyeTablosu = driver.findElement(AppiumBy.id("com.mobisoft.kitapyurdu:id/tableLayoutAttributes"));
        // Her satırı al
        List<WebElement> satirlar = künyeTablosu.findElements(AppiumBy.className("android.widget.TableRow"));
        // Her satırdaki iki hücreyi (TextView) yazdır
        for (WebElement satir : satirlar) {
            List<WebElement> hucreler = satir.findElements(AppiumBy.className("android.widget.TextView"));
            if (hucreler.size() >= 2) {
                System.out.println(hucreler.get(0).getText() + " " + hucreler.get(1).getText());
            }
        }


    }
}
