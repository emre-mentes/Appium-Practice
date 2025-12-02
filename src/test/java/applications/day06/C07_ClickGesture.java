package applications.day06;

import applications.utilities.ReusableMethods;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import applications.basetest.ApiDemosBaseTest;

import static applications.utilities.ReusableMethods.clickGesture;

public class C07_ClickGesture extends ApiDemosBaseTest {

    @Test
    public void testClickGestureElement() {

        /**
         * https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
         */

        WebElement os = driver.findElement(AppiumBy.accessibilityId("OS"));

         driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                 "elementId", ((RemoteWebElement) os).getId()
         ));

        //clickGesture(driver,os);
        ReusableMethods.bekle(3);
    }

    @Test
    public void testClickGestureElement2() {

        /**
         * https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
         */

        WebElement os = driver.findElement(AppiumBy.accessibilityId("OS"));
        clickGesture(driver,os);
        ReusableMethods.bekle(3);
    }


    @Test
    public void testClickGestureCoordinate() {
         driver.executeScript("mobile: clickGesture", ImmutableMap.of(
                 "x",300,
                 "y", 1000
         ));

        ReusableMethods.bekle(3);

    }

    @Test
    public void testClickGestureCoordinate2() {
        clickGesture(driver,300,1000);

        ReusableMethods.bekle(3);

    }



}
