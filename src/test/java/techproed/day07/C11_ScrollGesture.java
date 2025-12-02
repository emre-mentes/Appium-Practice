package techproed.day07;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;

public class C11_ScrollGesture extends ApiDemosBaseTest {


    @Test
    public void testScrollToElement() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Spinner\"))"));
        Thread.sleep(3000);



    }




    @Test
    public void testScrollGestureElement() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));


        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "percent", 2.0,
                "speed", 400
        ));

        Thread.sleep(3000);
        driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 2.0,
                "speed", 400
        ));

        Thread.sleep(3000);


    }

    @Test
    public void testScrollGestureCoordinate() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

        boolean canScrollMore = true;
        while (canScrollMore) {

            canScrollMore= (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 500, "height", 700,
                    "direction", "down",
                    "percent", 1.0
            ));
        }
    }


}
