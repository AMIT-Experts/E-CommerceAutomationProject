package org.example.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.example.StepDef.Hooks.driver;
public class CheckOut_Page
{
    // sign on agree terms of service
    public static WebElement Agree_Terms()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver.findElement(By.id("termsofservice"));
    }
    public static WebElement checkout_New_Btn()
    {

        return driver.findElement(By.id("checkout"));
    }
    //click on check out as a guest
    public static WebElement Check_out_As_guest()
    {

        return driver.findElement(By.cssSelector("[class=\"button-1 checkout-as-guest-button\"]"));
    }
    //Enter first name
    public static WebElement Billing_firstname()
    {

        return driver.findElement(By.id("BillingNewAddress_FirstName"));
    }
    //Enter Last name
    public static WebElement Billing_lastname()
    {

        return driver.findElement(By.id("BillingNewAddress_LastName"));
    }
    //Enter Email
    public static WebElement Billing_Email()
    {

        return driver.findElement(By.id("BillingNewAddress_Email"));
    }
    // Enter The company by faker
    public static WebElement Billing_Company()
    {

        return driver.findElement(By.id("BillingNewAddress_Company"));
    }
    //Select country
    public static WebElement Billing_Country()
    {

        return driver.findElement(By.id("BillingNewAddress_CountryId"));
    }
    //select state
    public static WebElement Billing_State()
    {

        return driver.findElement(By.id("BillingNewAddress_StateProvinceId"));
    }
    //Select City
    public static WebElement Billing_City()
    {

        return driver.findElement(By.id("BillingNewAddress_City"));
    }
    public static WebElement Billing_Address1()
    {

        return driver.findElement(By.id("BillingNewAddress_Address1"));
    }
    public static WebElement Billing_Address2()
    {

        return driver.findElement(By.id("BillingNewAddress_Address2"));
    }
    //Enter Zipcode
    public static WebElement Billing_ZipPostalCode()
    {

        return driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
    }

    public static WebElement Billing_Phone_num()
    {

        return driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
    }
    //enter fax num
    public static WebElement Billing_fax_num()
    {

        return driver.findElement(By.id("BillingNewAddress_FaxNumber"));
    }
    //press on continue
    public static WebElement Continue_Btn()
    {

        return driver.findElement(By.xpath("//*[contains(text(),'Continue')]"));
    }
    //CreditCardType
    public static WebElement CreditCardType()
    {

        return driver.findElement(By.id("CreditCardType"));
    }
    //CardholderName
    public static WebElement CardholderName()
    {

        return driver.findElement(By.id("CardholderName"));
    }
    //CardNumber
    public static WebElement CardNumber()
    {

        return driver.findElement(By.id("CardNumber"));
    }

    //select ExpireMonth
    public static WebElement ExpireMonth()
    {

        return driver.findElement(By.id("ExpireMonth"));
    }
    //select ExpireYear
    public static WebElement ExpireYear()
    {

        return driver.findElement(By.id("ExpireYear"));
    }
    //CardCode
    public static WebElement CardCode()
    {

        return driver.findElement(By.id("CardCode"));
    }
}
