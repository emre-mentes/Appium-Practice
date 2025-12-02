package applications.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import applications.basetest.ApiDemosBaseTest;
import applications.utilities.ReusableMethods;

public class C09_LongClickGesture extends ApiDemosBaseTest {


    @Test
    public void testLongClickGestureElement() throws InterruptedException {



        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Long press me"));


        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration",1000  // varsayilan süre 500
        ));
        Thread.sleep(5000);
    }

    @Test
    public void testLongClickGestureCoordinate() throws InterruptedException {



        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Fragment")).click();
        driver.findElement(AppiumBy.accessibilityId("Context Menu")).click();
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Long press me"));

        ReusableMethods.longClickGesture(driver,400,350,1000);




        Thread.sleep(5000);
    }
}
