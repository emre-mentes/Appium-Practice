package applications.day09;

import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;
import applications.basetest.ApiDemosBaseTest;

import java.time.Duration;
import java.util.Collections;

public class C15_PointerInput_Tap extends ApiDemosBaseTest {


    @Test
    public void testTap() throws InterruptedException {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");

        Sequence sequence = new Sequence(finger,1)
                /// parmak, ekran üzerindeki tap yapilacak koordinata hareket ettirilir
                .addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),500,1000))

                /// parmak ile, farenin sol tusuna basar gibi ekranda belirledigimiz koordinata bastik
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))

                /// ekranda parmaginbasili olarak duracagi sureyi belirledik
                .addAction(new Pause(finger,Duration.ofMillis(300)))

                /// parmagi ekranda bastigimiz koordinattan kaldirdik
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        /// sirali adimlari topluca harekete gecirdik
        driver.perform(Collections.singletonList(sequence));
        Thread.sleep(5000);





    }
}
