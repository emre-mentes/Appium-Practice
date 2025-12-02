package applications.day01;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class C01_SetupDriver {

    @Test
    public void testDesiredCapabilities() throws MalformedURLException {

        /*
        Sorunun Nedeni:
        Appium 3.x ve Selenium 4 sürümlerinde, DesiredCapabilities ile tanımlanan app, appPackage, appActivity, automationName, udid gibi anahtarlar artık W3C standardına uygun değil. Bu nedenle Appium, oturum açarken bu keyleri kabul etmiyor ve Illegal key values seen in w3c capabilities hatası veriyor.

        Çözüm Notu:
        Bu değerler yerine UiAutomator2Options (veya ilgili platform seçenekleri) kullanılmalı; Appium otomatik olarak appium: prefix’i ekleyerek W3C uyumlu hale getiriyor.

         */

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","android");//zorunlu
        capabilities.setCapability("automationName","uiautomator2");//zorunlu
        capabilities.setCapability("udid","320413824465");
        capabilities.setCapability("app","C:\\Users\\emreo\\IdeaProjects\\Appium_Upskills\\src\\test\\resources\\ApiDemos-debug.apk");
        capabilities.setCapability("appPackage","io.appium.android.apis");
        capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");


        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, capabilities);


    }



    @Test
    public void testUiAutomator2Options() throws MalformedURLException {

        String appUrl = System.getProperty("user.dir")
                + File.separator+ "src"
                + File.separator+ "test"
                + File.separator+ "resources"
                + File.separator+ "ApiDemos-debug.apk";


        UiAutomator2Options options = new UiAutomator2Options()


                .setApp(appUrl)
               //.setUdid("320413824465")
               //.setAppPackage("com.google.android.calculator")
               //.setAppActivity("com.android.calculator2.Calculator");
                ;

        URL url = new URL("http://0.0.0.0:4723");
        AndroidDriver driver = new AndroidDriver(url, options);



    }
}

