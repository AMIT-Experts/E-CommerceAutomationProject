package org.example.StepDef;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.example.StepDef.Hooks.driver;
public class F05_CheckOut
{
    Faker faker=new Faker();
    //SoftAssert soft=new SoftAssert();
    @Given("The guest user navigate to the shopping cart to buy {string}")
    public void The_guest_user_navigate_to_the_shopping_cart(String product)
    {
        //select a random product
//      List<WebElement> element= driver.findElements(By.className("product"));
//      System.out.println(element.size());
//      Random randomGenerator = new Random();
//      int randomInt = randomGenerator.nextInt(8);
//      element.get(randomInt).click();

        WebElement search_element=driver.findElement(By.id("small-searchterms"));
        search_element.sendKeys(product);
        search_element.sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("[class=\"button-2 product-box-add-to-cart-button\"]")).click();
        Add_To_Cart_Page.Shopping_Cart().click();

    }
    @And("The guest user agrees to the terms and conditions and click on the Check out button")
    public void theGuestUserAgreesToTheTermsAndConditionsAndClickOnTheCheckOutButton()
    {
        //sign on terms
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        CheckOut_Page.Agree_Terms().click();
        CheckOut_Page.checkout_New_Btn().click();
        CheckOut_Page.Check_out_As_guest().click();
    }

    @When("The guest user add his details: First and Last name, Email, Company")
    public void theGuestUserAddHisDetailsFirstAndLastNameEmailCompany()
    {
        CheckOut_Page.Billing_firstname().sendKeys(faker.name().firstName());
        CheckOut_Page.Billing_lastname().sendKeys(faker.name().lastName());
        CheckOut_Page.Billing_Email().sendKeys(faker.internet().emailAddress());
        CheckOut_Page.Billing_Company().sendKeys(faker.company().name());

    }

    @And("The guest user select the country and state")
    public void theGuestUserSelectTheCountryAndState()
    {
        //Select country
        Select select_country=new Select(CheckOut_Page.Billing_Country());
        select_country.selectByValue("168");
        //Select state
        Select select_state=new Select(CheckOut_Page.Billing_State());
        select_state.selectByValue("0");
    }

    @And("The guest user add city and address details and zipcode")
    public void theGuestUserAddCityAndAddressDetails()
    {
        CheckOut_Page.Billing_City().sendKeys(faker.address().cityName());
        CheckOut_Page.Billing_Address1().sendKeys(faker.internet().emailAddress());
        CheckOut_Page.Billing_Address2().sendKeys(faker.internet().emailAddress());
        CheckOut_Page.Billing_ZipPostalCode().sendKeys(faker.address().zipCode());
    }

    @And("The user adds Phone number and Fax")
    public void theUserAddsPhoneNumberAndFax()
    {
        CheckOut_Page.Billing_Phone_num().sendKeys(faker.phoneNumber().cellPhone());
        CheckOut_Page.Billing_fax_num().sendKeys("123");

    }

    @And("The user clicks on Continue")
    public void theUserClicksOnContinue()
    {
        CheckOut_Page.Continue_Btn().click();
    }

    @And("The user selects the shipping method and clicks on Continue")
    public void theUserSelectsTheShippingMethodAndClicksOnContinue()
    {
        driver.findElement(By.cssSelector("[class=\"button-1 shipping-method-next-step-button\"]")).click();
    }

    @And("The user selects the payment method by money order and clicks on Continue")
    public void theUserSelectsThePaymentMethodAndClicksOnContinue()
    {
        //Check / Money Order
        driver.findElement(By.id("paymentmethod_0")).click();
        driver.findElement(By.cssSelector("[class=\"button-1 payment-method-next-step-button\"]")).click();
    }

    @And("The user add the payment method details for Money order")
    public void theUserAddThePaymentMethodDetails()
    {
        ////class="button-1 payment-method-next-step-button"
        driver.findElement(By.cssSelector("[class=\"button-1 payment-info-next-step-button\"]")).click();
    }

    @And("The guest user clicks on Confirm")
    public void theGuestUserClicksOnConfirm()
    {
        driver.findElement(By.cssSelector("[class=\"button-1 confirm-order-next-step-button\"]")).click();
    }

    @Then("The order is confirmed and the user can navigate to order details")
    public void theOrderIsConfirmedAndTheUserCanNavigateToOrderDetails()
    {
        //•	Order Number is showing
        boolean result=driver.findElement(By.xpath("//*[contains(text(),'Order number')]")).isDisplayed();
        Assert.assertTrue(result);
        //•	Order is successfully placed then the shopping cart is empty
        String Expected_text="Your order has been successfully processed!";
        String Actual_text=driver.findElement(By.xpath("//*[contains(text(),'Your order has been successfully processed!')]")).getText();
        Assert.assertEquals(Actual_text,Expected_text);
        //soft.assertAll();

    }

    @And("The user selects the payment method by Credit card and clicks on Continue")
    public void theUserSelectsThePaymentMethodByCreditCardAndClicksOnContinue()
    {
        //pay by Credit Card
        driver.findElement(By.id("paymentmethod_1")).click();
        driver.findElement(By.cssSelector("[class=\"button-1 payment-method-next-step-button\"]")).click();

    }

    @And("The user add the payment method details")
    public void theUserAddThePaymentMethodDetailsforcreditcard()
    {
        Select select_card_type=new Select(CheckOut_Page.CreditCardType());
        select_card_type.selectByValue("visa");
        CheckOut_Page.CardholderName().sendKeys(faker.finance().creditCard());
        CheckOut_Page.CardNumber().sendKeys("5555555555554444");
        //expire month
        Select select_month=new Select(CheckOut_Page.ExpireMonth());
        select_month.selectByValue("4");
        //expire year
        Select select_year=new Select(CheckOut_Page.ExpireYear());
        select_year.selectByValue("2026");
        //enter card code
        CheckOut_Page.CardCode().sendKeys("22555");
        driver.findElement(By.cssSelector("[class=\"button-1 payment-info-next-step-button\"]")).click();

    }
}
