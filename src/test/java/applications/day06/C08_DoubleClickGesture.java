package applications.day06;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import applications.basetest.CalculatorBaseTest;

import static applications.utilities.ReusableMethods.clickGesture;

public class C08_DoubleClickGesture extends CalculatorBaseTest {

    @Test
    public void testDoubleClickGesture() throws InterruptedException {


        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("7")).click();
        WebElement element = driver.findElement(AppiumBy.id("com.google.android.calculator:id/formula"));

        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));




    }

    @Test
    public void testDoubleClickGestureCoordinate() throws InterruptedException {


        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("7")).click();
        WebElement element = driver.findElement(AppiumBy.id("com.google.android.calculator:id/formula"));

        driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                "x",600,
                "y",250
        ));

        Thread.sleep(2000);
        clickGesture(driver,365, 441);
        Thread.sleep(8000);
        System.out.println(driver.getClipboardText());
        System.out.println(driver.manage().window().getSize());

    }
}
