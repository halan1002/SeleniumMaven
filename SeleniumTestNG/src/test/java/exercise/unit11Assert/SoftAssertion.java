package exercise.unit11Assert;

import exercise.common.ExerciseBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static java.lang.Thread.sleep;

public class SoftAssertion extends ExerciseBaseClass {
    @Test(priority = 1)
    public void RunTest() throws InterruptedException {
        //SoftAssert: fail 1 step t-> stop not moving next steps
        driver.get("https://rise.fairsketch.com/signin");
        String formTitle=driver.findElement(By.xpath("//h2[normalize-space()='Sign in']")).getText();
        //check title of login form.
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(formTitle,"Sign in form","Form Title is not correct.");
        System.out.println("Actual form Name is: " + formTitle);
        //click login button.
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        WebElement menuClient= driver.findElement(By.xpath("//span[normalize-space()='Clients']"));

        softAssert.assertTrue(menuClient.isDisplayed(),"CLients menu is not displayed.");
        //click on CLients menu item.
        menuClient.click();
        sleep(2000);

        //Use AssertAll() to close out.
        softAssert.assertAll();

    }
}
