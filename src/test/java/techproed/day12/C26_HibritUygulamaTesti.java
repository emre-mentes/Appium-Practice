package techproed.day12;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;
import techproed.utilities.ReusableMethods;

import java.util.Set;

public class C26_HibritUygulamaTesti extends ApiDemosBaseTest {

    @Test
    public void testHibrit() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
        driver.findElement(AppiumBy.accessibilityId("WebView")).click();

        ReusableMethods.bekle(5);
        Set<String> contextHandles = driver.getContextHandles();
        for (String w : contextHandles) {
            System.out.println(w);
        }

        /*
        test calistirdigimizda eger chromedriver bulunamadi seklinde bir hata mesaji alirsak , serveri
        asagidaki komut ile calistirip testi tekrar calistiririz, böylece chromedriver bilgisayarimiza otomatik yüklenir
        appium --allow-insecure chromedriver_autodownload
        hoca yukardakini yazdi ama o ders zamani appium 2 ile calisdiklari icin bende o calismadi, bende yukardaki komutun appium 3 ile
        güncellenmis halini bulup calistirmayi denedim. hata vermedi ama testim gene gecmedi
        appium --allow-insecure=*:chromedriver_autodownload


         */
        driver.context("WEBVIEW_io.appium.android.apis");

        System.out.println("URL"+ driver.getCurrentUrl()); //file://android_asset/html/index.html vermesi lazim normalde

        System.out.println("baslik" + driver.findElement(By.tagName("h1")).getText());
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
        driver.findElement(AppiumBy.accessibilityId("Visibility")).click();

        ReusableMethods.bekle(5);



    }


}
