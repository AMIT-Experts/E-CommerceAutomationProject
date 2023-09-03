package org.example.StepDef;
import java.util.List;
import java.util.Random;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.Add_To_Cart_Page;
import org.example.Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.example.StepDef.Hooks.driver;

public class F04_Add_To_Cart
{
   @Given("The user navigates list of products in home page")
    public void The_user_has_list_of_products()
   {
       //Another product
       HomePage.Add_product().click();
   }

    @When("User selects a product as {string} and chooses relevant options")
    public void userSelectsAProductAsAndChoosesRelevantOptions(String product)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        //Select size
        //driver.findElement(By.cssSelector("[id=\"product_attribute_9\"]")).click();

        Select select_size=new Select(Add_To_Cart_Page.Choose_size());
        select_size.selectByIndex(3);
        //Select color
        Select select_color=new Select(Add_To_Cart_Page.Choose_Color());
        select_color.selectByValue("18");
        Add_To_Cart_Page.Print_shape().click();
    }

   @And("User opens the product and add to cart")
    public void Useropenstheproductandaddtocart()
   {
       WebElement Add_to_cart_button= driver.findElement(By.id("add-to-cart-button-24"));
       Actions action=new Actions(driver);
       action.moveToElement(Add_to_cart_button).click().build().perform();

     //press add to cart button
     //Add_To_Cart_Page.Another_Add_To_Cart_Btn();
   }
    @Then("The product is added to the shopping cart")
    public void theProductIsAddedToTheShoppingCart()

    {
        Add_To_Cart_Page.Shopping_Cart().click();
    }

    @And("The user can confirm the addition in the shopping cart")
    public void theUserCanConfirmTheAdditionInTheShoppingCart()
    {
        WebElement confirm_product= driver.findElement(By.cssSelector("[class=\"product-name\"]"));
        System.out.println(confirm_product.isDisplayed());
    }

    @And("The user can update the quantity of the product in the shopping cart")
    public void theUserCanUpdateTheQuantityOfTheProductInTheShoppingCart(){

        Add_To_Cart_Page.Change_Qty().clear();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        Add_To_Cart_Page.Change_Qty().sendKeys("2");
        Add_To_Cart_Page.Click_Update_Qty().click();
        Add_To_Cart_Page.Estimate_shopping().click();

    }


}
