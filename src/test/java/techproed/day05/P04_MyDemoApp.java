package techproed.day05;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.basetest.MyDemoAppBaseTest;

import java.util.List;

public class P04_MyDemoApp extends MyDemoAppBaseTest {



    @Test
    public void testColor() {

        WebElement menuButton = driver.findElement(AppiumBy.accessibilityId("open menu"));
        menuButton.click();

        WebElement loginButton = driver.findElement(AppiumBy.accessibilityId("menu item log in"));
        loginButton.click();

        WebElement username = driver.findElement(AppiumBy.accessibilityId("Username input field"));
        username.sendKeys("bob@example.com");

        WebElement password = driver.findElement(AppiumBy.accessibilityId("Password input field"));
        password.sendKeys("10203040");
        driver.hideKeyboard();

        WebElement login = driver.findElement(AppiumBy.accessibilityId("Login button"));
        login.click();

        WebElement productTitle = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sauce Labs Backpack\")"));
        productTitle.click();

        By blue =AppiumBy.accessibilityId("blue circle");
        driver.findElement(blue).click();
        driver.findElement(AppiumBy.accessibilityId("Add To Cart button")).click();

        By red =AppiumBy.accessibilityId("red circle");
        driver.findElement(red).click();
        driver.findElement(AppiumBy.accessibilityId("Add To Cart button")).click();

        driver.findElement(AppiumBy.accessibilityId("cart badge")).click();

        List<WebElement> productRow = driver.findElements(AppiumBy.accessibilityId("product row"));

        Assert.assertEquals(productRow.size(),2);


        WebElement blue2 = driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"product row\"])[1] //android.view.ViewGroup[contains(@content-desc,'blue circle')]"));

        Assert.assertTrue(driver.findElement(blue).isDisplayed());
        Assert.assertTrue(driver.findElement(red).isDisplayed());
        Assert.assertTrue(blue2.isDisplayed());


    }
}
