package applications.basetest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ChromeBrowserBaseTest {

    public AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options()
                //.setUdid("emulator-5554")
                .setUdid("320413824465")
                .withBrowserName("chrome");

        URL url = new URL("http://0.0.0.0:4723");
        driver = new AndroidDriver(url, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();

    }
}
