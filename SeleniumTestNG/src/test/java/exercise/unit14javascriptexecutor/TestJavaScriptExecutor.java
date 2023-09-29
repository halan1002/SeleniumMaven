package exercise.unit14javascriptexecutor;

import exercise.common.ExerciseBaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class TestJavaScriptExecutor extends ExerciseBaseClass {

    @Test
    public void javaExecutorTest() {
        driver.get("https://demo.activeitzone.com/ecommerce/users/login");
        //declare and initial an object
        JavascriptExecutor js=(JavascriptExecutor) driver;
        //Close the dialog
        findEleByXPath("//button[@data-value='removed']/i").click();
        findEleByXPath("//button[normalize-space()='Copy credentials']").click();


    }
}
