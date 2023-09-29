package exercise.unit11Assert;

import exercise.common.ExerciseBaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion extends ExerciseBaseClass {
    @Test(priority = 1)
    public void RunTest() {
        //HardAssert: fail 1 step thì stop lun, ko chạy step kế tiếp
        driver.get("https://rise.fairsketch.com/signin");
        String expectedTitle = "Sign in | RISE - Ultimate Project Manager and CRM";
        String ActualTitle = driver.getTitle();
        System.out.println("*** Checking For The Title ***");
        System.out.println("The actual Title is "+ ActualTitle);
        //Assert.assertEquals(ActualTitle, expectedTitle);//failed -> quit - not running the next step.
        Assert.assertTrue(ActualTitle.contains(expectedTitle),"Actual Title contain: " + expectedTitle);

    }
}