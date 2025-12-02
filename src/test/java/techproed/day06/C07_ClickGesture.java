package techproed.day06;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import techproed.basetest.ApiDemosBaseTest;
import techproed.utilities.ReusableMethods;

import static techproed.utilities.ReusableMethods.clickGesture;

public class C07_ClickGesture extends ApiDemosBaseTest {

    @Test
    public void testClickGestureElement() {

        WebElement os = driver.findElement(AppiumBy.accessibilityId("OS"));

       //driver.executeScript("mobile: clickGesture", ImmutableMap.of(
       //        "elementId", ((RemoteWebElement) os).getId()
       //));

        clickGesture(driver,os);
    }


    @Test
    public void testClickGestureCoordinate() {
      // driver.executeScript("mobile: clickGesture", ImmutableMap.of(
      //         "x",500,
      //         "y", 700
      // ));

        clickGesture(driver,700,500);

    }



}
