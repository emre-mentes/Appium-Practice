package applications.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import applications.basetest.VodQABaseTest;

public class C14_PinchOpenAndCloseGesture extends VodQABaseTest {


    @Test
    public void testPinchOpenAndCloseGestureElement() throws InterruptedException {
        driver.findElement(AppiumBy.className("android.widget.Button")).click();

        driver.findElement(AppiumBy.accessibilityId("Ping & Zoom")).click();

        WebElement element = driver.findElement(AppiumBy.className("android.widget.ImageView"));

         driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", 0.75,
                 "speed",500
        ));

         Thread.sleep(2000);
         driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "percent", 0.75,
                 "speed",500
        ));

    }

    @Test
    public void testPinchOpenAndCloseGestureCoordinate() throws InterruptedException {
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
        driver.findElement(AppiumBy.accessibilityId("Ping & Zoom")).click();
        WebElement element = driver.findElement(AppiumBy.className("android.widget.ImageView"));
         driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                 "left", 100, "top", 600, "width", 400, "height", 400,
                "percent", 0.75,
                 "speed",500
        ));

         Thread.sleep(2000);
         driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                 "left", 100, "top", 600, "width", 400, "height", 400,
                "percent", 0.75,
                 "speed",500
        ));

    }
}
