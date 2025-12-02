package applications.day02;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C03_Locators {

    @Test
    public void testLocators() throws MalformedURLException {
        String appUrl = System.getProperty("user.dir")
                + File.separator+ "src"
                + File.separator+ "test"
                + File.separator+ "resources"
                + File.separator+ "ApiDemos-debug.apk";


        UiAutomator2Options options = new UiAutomator2Options()
                .setApp(appUrl);

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, options);

        WebElement element = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("accessibilityId : " + element.getText());

        //2.id
        element = driver.findElements(AppiumBy.id("android:id/text1")).get(1);
        System.out.println("id : " + element.getText());


        //3.className
        element = driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println("className  : " + element.getText());


        //4 androidUIAutomator
        element=  driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println("androidUIAutomator : " + element.getText());


        //5 xpath
        element = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        System.out.println("xpath : " + element.getText());





    }
}
