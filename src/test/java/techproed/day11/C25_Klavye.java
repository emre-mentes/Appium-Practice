package techproed.day11;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;
import techproed.utilities.ReusableMethods;

public class C25_Klavye extends ApiDemosBaseTest {


    @Test
    public void testIsKeyboardShown() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextFields\"))"));
        driver.findElement(AppiumBy.accessibilityId("TextFields")).click();

        System.out.println(driver.isKeyboardShown());

        driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).click();

        System.out.println(driver.isKeyboardShown());

        driver.hideKeyboard();

        System.out.println(driver.isKeyboardShown());

        ReusableMethods.bekle(2);
    }

    @Test
    public void testPressKey() {


        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"TextFields\"))"));
        driver.findElement(AppiumBy.accessibilityId("TextFields")).click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).click();

        ///driver.pressKey(new KeyEvent(AndroidKey.E).withKey(AndroidKey.M).withKey(AndroidKey.R).withKey(AndroidKey.E));
        /*
        withKey() metodu biraz kafa karıştırıcıdır, çünkü ismi “birden fazla tuşu ekleyecekmiş” gibi görünür — ama Appium’da öyle çalışmaz.
        Gel adım adım açıklayayım 👇

        💡 withKey() Ne İşe Yarar?

        withKey() yalnızca modifier (yardımcı) tuşlarla birlikte kullanılır.
        Yani örneğin Shift + A, Ctrl + C, Alt + Tab gibi kombinasyonlarda işe yarar.

        Appium dokümantasyonuna göre:
         */


       driver.pressKey(new KeyEvent(AndroidKey.BACK));
       driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));




    }
}
