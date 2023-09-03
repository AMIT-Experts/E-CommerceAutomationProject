package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.example.StepDef.Hooks.driver;

public class HomePage
{
    //Register Link in home page
    public static WebElement RegisterNowBtn()


    {
        return driver.findElement(By.className("ico-register"));
    }
    public static WebElement LoginNowBtn()

    {
        return driver.findElement(By.className("ico-login"));
    }

    public static WebElement SearchNowBtn()
    {
        return driver.findElement(By.id("small-searchterms"));
    }
    public static WebElement Add_product()
    {
       WebElement element= driver.findElement(By.id("small-searchterms"));
       element.sendKeys("shoes");
       element.sendKeys(Keys.ENTER);
       return driver.findElement(By.cssSelector("[class=\"button-2 product-box-add-to-cart-button\"]"));

    }

}