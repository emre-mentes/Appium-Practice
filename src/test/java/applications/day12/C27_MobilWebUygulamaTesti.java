package applications.day12;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import applications.basetest.ChromeBrowserBaseTest;
import applications.utilities.ReusableMethods;

public class C27_MobilWebUygulamaTesti extends ChromeBrowserBaseTest {


    @Test
    public void testBrowser() {


        driver.get("https://www.techproeducation.com");
        ReusableMethods.bekle(5);

        driver.findElement(By.id("menu-btn")).click();
        driver.findElement(By.xpath("//a[.='Education Models']")).click();


        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());


        //driver.get("https://www.amazon.com");
        ReusableMethods.bekle(3);
    }
}
