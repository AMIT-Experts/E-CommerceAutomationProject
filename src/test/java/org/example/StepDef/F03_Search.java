package org.example.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static org.example.StepDef.Hooks.driver;
import java.security.Key;
import java.security.KeyStore;

public class F03_Search
{
    @Given("The user on Home page")
    public void the_user_on_the_home_page()
    {
        HomePage.SearchNowBtn();
    }

    @When("The user enters {string} on search field and clicks on search button")
    public void theUserEntersOnSearchFieldandclicksonsearchutton(String search_text)
    {
        WebElement search_item=HomePage.SearchNowBtn();
        search_item.sendKeys(search_text);
        search_item.sendKeys(Keys.ENTER);
    }

    @And("The website returns some results that The user click on advanced search to get specific result")
    public void theWebsiteReturnsSomeResultsThatTheUserClickOnAdvancedSearchToGetSpecificResult()
    {
        SearchPage.Search_box().click();
        //Select Category
        Select select_category=new Select(SearchPage.Category_options());
        select_category.selectByValue("6");
        //Select Manufacture
        Select select_Manufacturer=new Select(SearchPage.Manufacturer_options());
        select_Manufacturer.selectByValue("1");

        SearchPage.Search_Product_Description().click();
        //click on search button
        SearchPage.Search_Btn().click();
    }

    @Then("The final results should match the selected filter and search keywords {string}")
    public void theFinalResultsShouldMatchTheSelectedFilterAndSearchKeywords(String search_text)
    {

        search_text= driver.findElement(By.xpath("//*[contains(text(),'Apple iCam')]")).getText();
        Assert.assertEquals(search_text,"Apple iCam");
    }
}
