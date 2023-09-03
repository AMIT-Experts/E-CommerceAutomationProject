package org.example.TestRunner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "E:\\Anti\\Sarah Abdelghany\\GraduationProject\\src\\main\\resources\\Features",
        //glue  stepdef copy reference
        glue ="org.example.StepDef",
        tags = "@Smoke",
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"}

)
public class Runner extends AbstractTestNGCucumberTests
{

}
