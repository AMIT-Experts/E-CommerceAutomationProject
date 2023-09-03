package org.example.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import static org.example.StepDef.Hooks.driver;

public class RegisterPage
{
    public static WebElement Female_Gender()

    {
        return driver.findElement(By.id("gender-female"));
    }

    public static WebElement Male_Gender()
    {
        return driver.findElement(By.id("gender-male"));
    }

    public static WebElement First_Name_Field()
    {
        return driver.findElement(By.id("FirstName"));
    }

    public static WebElement Last_Name_Field()
    {
        return driver.findElement(By.id("LastName"));
    }

    public static WebElement Day_Select()
    {
        return driver.findElement(By.name("DateOfBirthDay"));
    }

    public static WebElement Month_Select()
    {
        return driver.findElement(By.name("DateOfBirthMonth"));
    }

    public static WebElement Year_Select()
    {
        return driver.findElement(By.name("DateOfBirthYear"));
    }

    public static WebElement Email_Field()
    {
        return driver.findElement(By.id("Email"));
    }

    //This method enters the element email in order to enter the email in
    public static WebElement Company_Field()
    {
        return driver.findElement(By.id("Company"));
    }

    public static WebElement Newsletter_Field()
    {
        return driver.findElement(By.id("Newsletter"));
    }

    public static WebElement Password_Field()
    {
        return driver.findElement(By.id("Password"));
    }

    public static WebElement Confirm_Password_Field()
    {
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public static WebElement Registeration_Btn()
    {
        return driver.findElement(By.id("register-button"));
    }

    public static List <WebElement> ConfirmRegisteration ()
    {
        return driver.findElements(By.cssSelector("div[class=\"result\"]"));
    }
}