package exercise.unit13alertpopup;

import exercise.common.ExerciseBaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PrintsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import practice.keyword.WebUI;

import java.util.Set;

public class TestAlertPopupiFrame extends ExerciseBaseClass {
   // @Test(priority = 1)
    public void testAlert() {
        WebUI.sleep(2);
        driver.get("https://demo.guru99.com/test/delete_customer.php");
        String formTitle = findEleByXPath("//td[@class='heading3']").getText();
        System.out.println("--- " + formTitle);
        findEleByXPath("//input[@name='cusid']").sendKeys("Test");
        findEleByXPath("//input[@name='submit']").click();
        WebUI.sleep(2);
        //Get the first message contain
        String firstMessage = driver.switchTo().alert().getText();
        WebUI.sleep(1);
        System.out.println("--- The first message is: " + firstMessage);
        Assert.assertEquals(firstMessage, "Do you really want to delete this Customer?", "The first message is not corrected");
        //Accept the message by clicking OK button
        WebUI.sleep(1);
        driver.switchTo().alert().accept();

        //The second message
        String secondMessage = driver.switchTo().alert().getText();
        WebUI.sleep(2);
        System.out.println("--- The second message is: " + secondMessage);
        Assert.assertEquals(secondMessage, "Customer Successfully Delete!", "The second message is not corrected");
        WebUI.sleep(2);
        Alert alertMess = driver.switchTo().alert();
        WebUI.sleep(2);
        alertMess.accept();
    }

    //@Test(priority = 2)
    public void testAlertTextbox() {
        WebUI.sleep(2);
        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
        WebUI.sleep(2);
        String urlAlert = findEleByXPath("//a[normalize-space()='Alert with Textbox']").getText();
        System.out.println("The second page: " + urlAlert);
        Assert.assertEquals(urlAlert, "Alert with Textbox", "The url is not displayed.");
        WebUI.sleep(1);
        findEleByXPath("//a[normalize-space()='Alert with Textbox']").click();
        WebUI.sleep(2);
        String buttonShowDemo = findEleByXPath("(//button[normalize-space()='click the button to demonstrate the prompt box'])[1]").getText();
        Assert.assertEquals(buttonShowDemo, "click the button to demonstrate the prompt box", "The url is not displayed.");
        findEleByXPath("(//button[normalize-space()='click the button to demonstrate the prompt box'])[1]").click();
        WebUI.sleep(2);
        Alert alertText = driver.switchTo().alert();
        String enteredText = "Lan Ha";
        alertText.sendKeys(enteredText);
        WebUI.sleep(2);
        alertText.accept();
        WebUI.sleep(1);
        String actualRresult = findEleByXPath("//p[@id='demo1']").getText();
        //Check if the text result exactly correct
        String expectedResult = "Hello " + enteredText + " How are you today";
        System.out.println("--- Expected result: " + expectedResult);
        System.out.println("--- Actual result: " + actualRresult);
        //Check result text contains the entered text
        Assert.assertTrue(actualRresult.contains(enteredText),"The text is not entered successfully");
        WebUI.sleep(1);
    }
   // @Test//(priority = 3)
    public void testWindowHandle() {
        WebUI.sleep(2);
        driver.navigate().to("https://demo.guru99.com/popup.php");
        WebUI.sleep(2);
        Boolean urlAlert = findEleByXPath("//a[normalize-space()='Click Here']").isDisplayed();
        Assert.assertTrue(urlAlert,"The Click here link is not existed.");
        WebUI.sleep(2);
        findEleByXPath("//a[normalize-space()='Click Here']").click();
        //Get tab ID of the current window, it's unique
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);
        //Get all IDs of all tabs in a window. Each ID is unique
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            System.out.println(window);
            if (!MainWindow.equals(window)) {
                driver.switchTo().window(window);
                WebUI.sleep(1);
                System.out.println("Moved to a new window.");
                System.out.println("Page title: " + driver.switchTo().window(window).getTitle());
                System.out.println("Page URL: " + driver.switchTo().window(window).getCurrentUrl());

                Boolean formTitle=findEleByXPath("//h2[contains(text(),'Enter your email address to get')]").isDisplayed();
                Assert.assertTrue(formTitle,"It's not a correct window");
                //Enter invalid email
                findEleByXPath("//input[@name='emailid']").sendKeys("testab");
                WebUI.sleep(3);
                findEleByXPath("//input[@name='btnLogin']").click();
                Boolean invalidMessage=findEleByXPath("(//label[normalize-space()='Email ID is not valid'])[1]").isDisplayed();
                WebUI.sleep(3);
                Assert.assertTrue(invalidMessage,"Invalid message for email is not displayed");

                findEleByXPath("//input[@name='emailid']").clear();
                WebUI.sleep(3);
                findEleByXPath("//input[@name='emailid']").sendKeys("testabc@gmail.com");
                findEleByXPath("//input[@name='btnLogin']").click();
                WebUI.sleep(2);
                //Check the access details info displayed
                Boolean accessDetail=findEleByXPath("//h2[normalize-space()='Access details to demo site.']").isDisplayed();
                Assert.assertTrue(accessDetail,"Access details to demo site page is not displayed.");
                WebUI.sleep(3);
                //close new tab
                driver.close();
            }

        }
        //actually, this section is no need
        WebUI.sleep(3);
        driver.switchTo().window(MainWindow);
        System.out.println("Back to orginal tab: " + driver.switchTo().window(MainWindow).getCurrentUrl());

    }
    @Test
    public void testiFrame01(){
        driver.navigate().to("https://anhtester.com/contact");
        WebUI.sleep(8);
        System.out.println("Total iframe : " + driver.findElements(By.tagName("iframe")).size());
        WebUI.sleep(2);

        //----Switch to content of Messenger--------
        driver.switchTo().frame(0);
        System.out.println(driver.findElement(By.tagName("strong")).getText());
        //----Switch to icon of Messenger---------
        //1. Switch to Parent WindowHandle
        driver.switchTo().parentFrame();
        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1);
        driver.findElement(By.tagName("svg")).click(); //click message icon đto hide messenger chat
        WebUI.sleep(2);
    }
}
