package applications.day11;

import org.testng.annotations.Test;
import applications.basetest.DeviceBaseTest;
import applications.utilities.ReusableMethods;

import java.time.Duration;


public class C24_EkranKilidi extends DeviceBaseTest {

    @Test
    public void testLockDevice() {

        driver.lockDevice(Duration.ofSeconds(1));
        ReusableMethods.bekle(1);

    }
    @Test
    public void testUnLockDevice() {

        driver.lockDevice();
        ReusableMethods.bekle(5);
        driver.unlockDevice();

    }
    @Test
    public void testIsDeviceLock() {

        System.out.println(driver.isDeviceLocked());
        driver.lockDevice();
        ReusableMethods.bekle(5);
        System.out.println(driver.isDeviceLocked());
        driver.unlockDevice();
        System.out.println(driver.isDeviceLocked());

    }
}
