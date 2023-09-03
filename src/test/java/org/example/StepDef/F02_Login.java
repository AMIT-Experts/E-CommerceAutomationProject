package org.example.StepDef;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.example.Pages.RegisterPage;
import org.example.StepDef.F01_Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.example.StepDef.Hooks.driver;

public class F02_Login
{
    SoftAssert soft=new SoftAssert();
    @Given("the user clicks on login")
    public void NavigateToLogin()
   {
    HomePage.LoginNowBtn().click();
   }
    @When("the user fills email as {string} and password {string} and clicks on login")
    public void theUserFillsEmailAsAndPasswordAndClicksOnLogin(String email, String password)
    {
        RegisterPage.Email_Field().sendKeys(email);
        RegisterPage.Password_Field().sendKeys(password);
        LoginPage.Login_Btn().click();

    }
    @Then("The user login successfully")
    public void theUserLoginSuccessfully()
    {
      //Confirm that user login to the system successfully
        String expected_login="My account";
        String actual_login=driver.findElement(By.xpath("//*[contains(text(),'My account')]")).getText();
        Assert.assertEquals(actual_login,expected_login);
       // driver.findElement(By.linkText("Log out")).click();

    }
    @Then("Error message is displayed")
    public void errorMessageIsDisplayed()
    {
        //Confirm that user could not log in to the system
        String expected_invalid_text="Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect";
        WebElement element_Text=driver.findElement(By.cssSelector("[class=\"message-error validation-summary-errors\"]"));
        String actual_invalid_text=element_Text.getText();

        System.out.println("The invalid text :  "+actual_invalid_text);
        Assert.assertEquals(actual_invalid_text,expected_invalid_text);
        //check the error message color is red

        //retrieve color
        String rgbaColor =driver.findElement(By.cssSelector("[class=\"message-error validation-summary-errors\"]")).getCssValue("color");
        String actualColor= Color.fromString(rgbaColor).asHex();
        System.out.println("actualColor");
        Assert.assertEquals(actualColor,"#e4434b");
        soft.assertAll();
    }
}
