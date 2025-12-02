package applications.day04;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import applications.basetest.ApiDemosBaseTest;

public class P01_ApiDemos extends ApiDemosBaseTest {



    @Test
    public void testName() {


        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(0)")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"WiFi settings\")")).click();

        Assert.assertEquals("WiFi settings",driver.findElement(AppiumBy.id("android:id/alertTitle")).getText());
        driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("EMRE");

        driver.findElement(AppiumBy.id("android:id/button1"));




    }




}
