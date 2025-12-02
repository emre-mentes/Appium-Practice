package techproed.day12;

import org.testng.annotations.Test;
import techproed.basetest.ChromeBrowserBaseTest;
import techproed.utilities.ReusableMethods;

public class C27_MobilWebUygulamaTesti extends ChromeBrowserBaseTest {


    @Test
    public void testBrowser() {



        //chrome u acamadim telefonda maalesef
        driver.get("https://www.google.com");

       // driver.get("https://www.amazon.com");
        ReusableMethods.bekle(3);
    }
}
