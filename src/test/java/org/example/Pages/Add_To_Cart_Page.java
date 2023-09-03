package org.example.Pages;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.example.StepDef.Hooks.driver;
public class Add_To_Cart_Page {

    public static WebElement Choose_size()
    {
        return driver.findElement(By.id("product_attribute_6"));
    }
    public static WebElement Choose_Color()
    {

        return driver.findElement(By.id("product_attribute_7"));
    }

    public static WebElement Another_Add_To_Cart_Btn()
    {
        return driver.findElement(By.id("add-to-cart-button-24"));
    }

    //go to shopping cart
    public static WebElement Shopping_Cart() {
        return driver.findElement(By.cssSelector("[href=\"/cart\"]"));
    }

    //Update Qty
    public static WebElement Change_Qty() {
        return driver.findElement(By.cssSelector("[class=\"qty-input\"]"));
    }
    //print shape
    public static WebElement Print_shape() {
        return driver.findElement(By.cssSelector("[class=\"attribute-square\"]"));
    }

    // click on Update Qty
    public static WebElement Click_Update_Qty() {
        return driver.findElement(By.id("updatecart"));
    }

    //Estimate shopping
    public static WebElement Estimate_shopping() {
        return driver.findElement(By.id("open-estimate-shipping-popup"));
    }
}