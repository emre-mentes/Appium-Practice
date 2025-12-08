package applications.day06;

import applications.utilities.ReusableMethods;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import applications.basetest.ApiDemosBaseTest;

public class C10_DragGesture extends ApiDemosBaseTest {


    @Test
    public void testDragGestureElement() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();


        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 475,
                "endY", 475,
                "speed",100
        ));

        Thread.sleep(4000);
    }


    @Test
    public void testDragGestureElement2() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();


        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        ReusableMethods.dragGesture(driver,element,475,475);
        Thread.sleep(4000);
    }



    @Test
    public void testDragGestureCoordinate() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();


        WebElement drag = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "startX", 160,
                "startY", 450,
                "endX", 500,
                "endY", 450,
                "speed",100
        ));

        Thread.sleep(4000);

    }
    @Test
    public void testDragGestureCoordinate2() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();


        WebElement drag = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        ReusableMethods.dragGesture(driver,drag,500,450);
        Thread.sleep(4000);

    }
}
