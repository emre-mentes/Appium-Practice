package applications.day03;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C04_NativeElementleriTanimlama {

    @Test
    public void testWebElement() throws MalformedURLException {

        String appUrl = System.getProperty("user.dir")
                + File.separator+ "src"
                + File.separator+ "test"
                + File.separator+ "resources"
                + File.separator+ "ApiDemos-debug.apk";

        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(appUrl);

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, options);

        WebElement app = driver.findElement(AppiumBy.accessibilityId("App"));
        app.click();
        WebElement alarm = driver.findElement(AppiumBy.accessibilityId("Alarm"));
        alarm.click();
        WebElement alarmController = driver.findElement(AppiumBy.accessibilityId("Alarm Controller"));
        alarmController.click();


    }

    @Test
    public void testBy() throws MalformedURLException {

        String appUrl = System.getProperty("user.dir")
                + File.separator+ "src"
                + File.separator+ "test"
                + File.separator+ "resources"
                + File.separator+ "ApiDemos-debug.apk";

        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(appUrl);

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, options);

        By app = AppiumBy.accessibilityId("App");
        By alarm = AppiumBy.accessibilityId("Alarm");
        By alarmController = AppiumBy.accessibilityId("Alarm Controller");

        driver.findElement(app).click();
        driver.findElement(alarm).click();
        driver.findElement(alarmController).click();





    }

}
