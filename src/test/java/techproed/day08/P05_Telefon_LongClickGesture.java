package techproed.day08;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.TelefonBaseTest;
import techproed.utilities.ReusableMethods;

public class P05_Telefon_LongClickGesture extends TelefonBaseTest {

    @Test
    public void testTelefonLongClickGesture() throws InterruptedException {

        By keyPad = AppiumBy.accessibilityId("tuş takımı");
        By bir = AppiumBy.accessibilityId("1,");
        By iki = AppiumBy.accessibilityId("2,ABC");
        By uc = AppiumBy.accessibilityId("3,DEF");
        By dort = AppiumBy.accessibilityId("4,GHI");
        By bes = AppiumBy.accessibilityId("5,JKL");
        By alti = AppiumBy.accessibilityId("6,MNO");
        By yedi = AppiumBy.accessibilityId("7,PQRS");
        By sekiz = AppiumBy.accessibilityId("8,TUV");
        By dokuz = AppiumBy.accessibilityId("9,WXYZ");
        By sifir = AppiumBy.accessibilityId("0");
        By aramaButton = AppiumBy.accessibilityId("telefonu arar");
        By hataMesaji = AppiumBy.id("android:id/message");

        driver.findElement(keyPad).click();
        ReusableMethods.longClickGesture(driver,driver.findElement(sifir));
        ReusableMethods.clickGesture(driver,driver.findElement(dokuz));
        ReusableMethods.clickGesture(driver,driver.findElement(sifir));
        ReusableMethods.clickGesture(driver,driver.findElement(bes));
        ReusableMethods.clickGesture(driver,driver.findElement(uc));
        ReusableMethods.clickGesture(driver,driver.findElement(sifir));
        ReusableMethods.clickGesture(driver,driver.findElement(bes));
        ReusableMethods.clickGesture(driver,driver.findElement(bes));
        ReusableMethods.clickGesture(driver,driver.findElement(yedi));
        ReusableMethods.clickGesture(driver,driver.findElement(alti));
        ReusableMethods.clickGesture(driver,driver.findElement(sekiz));
        ReusableMethods.clickGesture(driver,driver.findElement(iki));
        ReusableMethods.clickGesture(driver,driver.findElement(bir));
        ReusableMethods.clickGesture(driver,driver.findElement(aramaButton));
        Thread.sleep(9000);


        Assert.assertEquals("Mobil ağ kullanılamıyor.",driver.findElement(hataMesaji).getText());
    }
}
