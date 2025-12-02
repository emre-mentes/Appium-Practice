package applications.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import applications.basetest.ApiDemosBaseTest;

public class C13_FlingeGesture extends ApiDemosBaseTest {


    @Test
    public void testFlingGestureElement() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

        driver.executeScript("mobile: flingGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "speed",5000
        ));



    }
    @Test
    public void testFlingGestureCoordinate() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        driver.executeScript("mobile: flingGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 500, "height", 700,
                "direction", "down",
                "speed",5000
        ));



    }
}
