package applications.day10;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import applications.basetest.VodQABaseTest;
import applications.utilities.ReusableMethods;

import java.time.Duration;
import java.util.Arrays;


public class C22_PointerInput_ZoomOut extends VodQABaseTest {

    @Test
    public void testZoomIn() {
        driver.findElement(AppiumBy.className("android.widget.Button")).click();
        driver.findElement(AppiumBy.accessibilityId("Ping & Zoom")).click();

        ReusableMethods.bekle(3);

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH,"finger2");

        Sequence sequence1 = new Sequence(finger1,1);
        Sequence sequence2 = new Sequence(finger2,2);

        sequence1
                .addAction(finger1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),100,760))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1,Duration.ofMillis(300)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(),280,760))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));


        sequence2
                .addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),600,760))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger2,Duration.ofMillis(300)))
                .addAction(finger2.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(),440,760))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));



        driver.perform(Arrays.asList(sequence1,sequence2));

        ReusableMethods.bekle(3);



    }
}
