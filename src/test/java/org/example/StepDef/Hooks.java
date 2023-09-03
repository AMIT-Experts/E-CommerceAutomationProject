package org.example.StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Hooks
{
    public static WebDriver driver;

    @Before
    public void open_Browser()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driver.get("https://demo.nopcommerce.com/");
    }
    @After
    public void close_Browser() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
