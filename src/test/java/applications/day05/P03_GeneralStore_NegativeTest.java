package applications.day05;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import applications.basetest.GeneralStoreBaseTest;

public class P03_GeneralStore_NegativeTest extends GeneralStoreBaseTest {


    @Test
    public void NegativeTest() {
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        String toastMessage = driver.findElement(AppiumBy.xpath("//android.widget.Toast")).getAttribute("name");

        Assert.assertEquals(toastMessage,"Please enter your name");

    }
}
