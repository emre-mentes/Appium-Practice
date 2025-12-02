package applications.day07;

import applications.utilities.ReusableMethods;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import applications.basetest.ApiDemosBaseTest;

public class C12_SwipeGesture extends ApiDemosBaseTest {


    @Test
    public void testSwipeGestureElement() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.75,
                "speed",400
        ));

    }

    @Test
    public void testSwipeGestureElement2() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));
        ReusableMethods.swipeGesture(driver,element,"left",0.75,400);
    }


    @Test
    public void testSwipeGestureCoordinate() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "left", 10, "top", 190, "width", 250, "height", 100,
                "direction", "left",
                "percent", 1,
                "speed",400
        ));
    }


    @Test
    public void testSwipeGestureCoordinate2() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));


        ReusableMethods.swipeGesture(driver, 10, 190, 250,  100,"left",1,400);
    }


}
