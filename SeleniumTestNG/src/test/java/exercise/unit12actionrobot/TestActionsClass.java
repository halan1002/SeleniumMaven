package exercise.unit12actionrobot;

import exercise.common.ExerciseBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestActionsClass extends ExerciseBaseClass {
    @Test
    public void TestSendKeys() throws InterruptedException {

        driver.get("https://www.google.com/");

        // Element search box
        WebElement element = driver.findElement(By.xpath("//textarea[@name='q']"));

        // Create action class
        Actions action = new Actions(driver);

        // Use action to call sendKeys Enter
        //keyDown, keyUp: lowercase, uppercase
        action.keyDown(element,Keys.SHIFT).sendKeys(element, "Anh ").keyUp(element,Keys.SHIFT).sendKeys(element, "tester").sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        //perform search
        WebElement searchResult = driver.findElement(By.xpath("//a[normalize-space()='Selenium Java']"));
        action.sendKeys(searchResult).perform();
        //check if the page is fully loaded
        WebElement logoAnhTester = driver.findElement(By.xpath("//img[@alt='Anh Tester Logo']"));
        Assert.assertTrue(logoAnhTester.isDisplayed(), "The page is not loaded fully.");
        Thread.sleep(2000);
        //Move to another webelement
        WebElement moveToExercise4 = driver.findElement(By.xpath("//a[contains(text(),'[Selenium Java] Bài 4: Cài đặt môi trường Selenium')]"));
        action.moveToElement(moveToExercise4).build().perform();
        Thread.sleep(2000);
        //Double click on a text, it'll be highlighted
        WebElement txtSelenium = driver.findElement(By.xpath("//h1[normalize-space()='Selenium Java']"));
        action.doubleClick(txtSelenium).build().perform();
        Thread.sleep(2000);
        //Right click to open a context menu, close context menu
        action.contextClick(txtSelenium).build().perform();
        action.click(driver.findElement(By.xpath("//ul[@class='breadcrumb__list']"))).build().perform();
        Thread.sleep(2000);
        //Holdover
        WebElement menuTools = driver.findElement(By.xpath("//a[normalize-space()='tools']"));
        action.clickAndHold(menuTools).build().perform();
        Thread.sleep(2000);
//        WebElement subMenuTools = driver.findElement(By.xpath("//a[normalize-space()='Website Demo CRM']"));
//        action.click(subMenuTools).build().perform();
//        driver.getWindowHandle();
//        Thread.sleep(2000);

    }
    @Test
    public void dragAndDrop() throws InterruptedException {
        //Open new drag and drop page
        driver.get("https://demo.guru99.com/test/drag_drop.html");
        Actions action = new Actions(driver);
        WebElement sourceBank = driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
        WebElement destinationBank = driver.findElement(By.xpath("//ol[@id='bank']//li[@class='placeholder']"));
        action.dragAndDrop(sourceBank, destinationBank).build().perform();
        WebElement sourceAmount = driver.findElement(By.xpath("(//div[@id='products']//li[@data-id='2'])[1]"));
        WebElement destinationAmount = driver.findElement(By.xpath("//ol[@id='amt7']//li[@class='placeholder']"));
        action.dragAndDrop(sourceAmount, destinationAmount).build().perform();
        Thread.sleep(5000);
        // WebElement sourceLoan= driver.findElement(By.xpath("//a[normalize-space()='LOAN']"));
        //WebElement DestinationLoan=driver.findElement(By.xpath("//h3[normalize-space()='DEBIT SIDE']"));;
        // Assert.assertTrue(action.dragAndDrop(sourceLoan, DestinationLoan).build().perform(),"");

    }

}
