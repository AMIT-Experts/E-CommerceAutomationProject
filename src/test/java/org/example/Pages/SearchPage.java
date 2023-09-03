package org.example.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.example.StepDef.Hooks.driver;

public class SearchPage
{
    //another search label
    public static WebElement Another_Search_box()
    {
        return driver.findElement(By.id("q"));
    }
    //sign on checkbox to open advanced search
    public static WebElement Search_box()
    {
        return driver.findElement(By.id("advs"));
    }
    public static WebElement Category_options()
    {
        return driver.findElement(By.id("cid"));
    }
    public static WebElement Manufacturer_options()
    {
        return driver.findElement(By.id("mid"));
    }
    public static WebElement Search_Product_Description()
    {
        return driver.findElement(By.id("sid"));
    }
    //Search button
    public static WebElement Search_Btn()
    {
        return driver.findElement(By.cssSelector("[class=\"button-1 search-button\"]"));
    }
}
