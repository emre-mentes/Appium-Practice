package applications.day11;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import applications.basetest.ApiDemosBaseTest;
import applications.utilities.ReusableMethods;

import java.io.File;
import java.time.Duration;

public class C23_UygulamaEtkilesimleri extends ApiDemosBaseTest {

    @Test
    public void testTerminateApp() {


        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();

        ReusableMethods.bekle(2);
        driver.terminateApp("io.appium.android.apis");
        /// UYGULAMAYI KAPATIR

        ReusableMethods.bekle(5);

    }
    @Test
    public void testActivateApp() {


        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();

        ReusableMethods.bekle(2);
        driver.activateApp("com.google.android.calculator");
        ///  UYGULAMAYI ACAR


        ReusableMethods.bekle(5);

        driver.activateApp("io.appium.android.apis");
    }

    @Test
    public void testRunAppInBackground() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Custom")).click();
        ReusableMethods.bekle(2);

        driver.runAppInBackground(Duration.ofSeconds(5));
        ///  UYGULAMAYI ARKAPLANDA CALISTIRIR
        ReusableMethods.bekle(5);
    }
    @Test
    public void testInstallApp() {

        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";
        driver.installApp(appUrl);
        ///  UYGULAMA YÜKLER

        ReusableMethods.bekle(5);

    }

    @Test
    public void testIsInstallApp() {

        System.out.println(driver.isAppInstalled("com.saucelabs.mydemoapp.rn"));
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "test"
                + File.separator + "resources"
                + File.separator + "Android-MyDemoAppRN.1.3.0.build-244.apk";
        driver.installApp(appUrl);
        ///  UYGULAMANIN YÜKLÜ OLUP OLMADIGINI KONTROL EDER

        System.out.println(driver.isAppInstalled("com.saucelabs.mydemoapp.rn"));
    }
    @Test
    public void testQueryAppState() {

        driver.queryAppState("io.appium.android.apis");
        /// UYGULAMANIN DURUMUNU SORGULAR

        System.out.println(driver.queryAppState("io.appium.android.apis"));
        /// RUNNING_IN_FOREGROUND
        ReusableMethods.bekle(3);

        driver.terminateApp("io.appium.android.apis");
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        /// NOT_RUNNING
        ReusableMethods.bekle(2);

        driver.activateApp("io.appium.android.apis");
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        /// RUNNING_IN_FOREGROUND
        ReusableMethods.bekle(2);

        driver.activateApp("com.google.android.calculator");
        System.out.println(driver.queryAppState("io.appium.android.apis"));
        /// RUNNING_IN_BACKGROUND
        ReusableMethods.bekle(2);
    }
}
