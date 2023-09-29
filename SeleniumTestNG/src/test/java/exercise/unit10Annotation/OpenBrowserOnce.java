package exercise.unit10Annotation;

import exercise.common.ExerciseBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class OpenBrowserOnce extends ExerciseBaseClass {

    @Test(priority = 1, description = "Open AnnhTester Blog")
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        //Thread.sleep(2000);
    }

    @Test(priority = 2, description = "Login to AnnhTester Blog")
    public void login() throws InterruptedException {
        driver.findElement(By.xpath("//a[@id='btn-login']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("admin@example.com", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123456", Keys.ENTER);
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//span[@aria-live='polite']")).click();
        //Thread.sleep(1000);
        //driver.findElement(By.xpath("//button[@id='login']")).click();
    }

}
