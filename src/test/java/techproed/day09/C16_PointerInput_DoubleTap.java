package techproed.day09;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import techproed.basetest.CalculatorBaseTest;

import java.time.Duration;
import java.util.Collections;

public class C16_PointerInput_DoubleTap extends CalculatorBaseTest {

    @Test
    public void testDoubleTap() {


        driver.findElement(AppiumBy.accessibilityId("9")).click();
        driver.findElement(AppiumBy.accessibilityId("5")).click();
        driver.findElement(AppiumBy.accessibilityId("7")).click();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence sequence =new Sequence(finger,1)
                /// ilk tiklama
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),600,250))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofMillis(300)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))

                ///  ikinci tiklama
                .addAction(finger.createPointerMove(Duration.ofMillis(10), PointerInput.Origin.viewport(),595,255))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofMillis(300)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));




        //WebElement element = driver.findElement(AppiumBy.id("com.google.android.calculator:id/formula"));

     /// driver.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
     ///         "x",600,
     ///         "y",250
     /// ));



    }
}
