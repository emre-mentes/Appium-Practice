package techproed.day08;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.HaritalarBaseTest;
import techproed.utilities.ReusableMethods;

public class P07_Harita_PinchOpenAndClose extends HaritalarBaseTest {

    @Test
    public void testPinchOpenAndClose() throws InterruptedException {

        WebElement katmanlar = driver.findElement(AppiumBy.accessibilityId("Katmanlar"));
        ReusableMethods.clickGesture(driver,katmanlar);

        WebElement uydu = driver.findElement(AppiumBy.accessibilityId("Uydu"));
        ReusableMethods.clickGesture(driver,uydu);

        WebElement closeMenu = driver.findElement(AppiumBy.accessibilityId("Menüyü kapat"));
        ReusableMethods.clickGesture(driver,closeMenu);

        WebElement aramaText = driver.findElement(AppiumBy.accessibilityId("Burada arayın"));
        ReusableMethods.clickGesture(driver,aramaText);
        WebElement metinArama = driver.findElement(AppiumBy.id("com.google.android.apps.maps:id/search_omnibox_edit_text"));
        metinArama.sendKeys("Oggelshausen");

        Thread.sleep(5000);
        KeyEvent enter = new KeyEvent(AndroidKey.ENTER);
        driver.pressKey(enter);

        Thread.sleep(5000);

        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 200, "top", 350, "width", 150, "height", 100,
                "percent", 1.0,
                "speed",200
        ));
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 200, "top", 350, "width", 150, "height", 100,
                "percent", 1.0,
                "speed",200
        ));
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 200, "top", 350, "width", 150, "height", 100,
                "percent", 1.0,
                "speed",200
        ));
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 200, "top", 350, "width", 150, "height", 100,
                "percent", 1.0,
                "speed",200
        ));
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 200, "top", 350, "width", 150, "height", 100,
                "percent", 1.0,
                "speed",200
        ));

        Thread.sleep(5000);
        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 200, "top", 350, "width", 150, "height", 100,
                "percent", 0.75,
                "speed",200
        ));

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 200, "top", 350, "width", 150, "height", 100,
                "percent", 0.75,
                "speed",200
        ));

        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 200, "top", 350, "width", 150, "height", 100,
                "percent", 0.75,
                "speed",200
        ));




        Thread.sleep(5000);



    }
}
