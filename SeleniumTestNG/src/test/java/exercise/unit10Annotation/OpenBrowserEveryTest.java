package exercise.unit10Annotation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class OpenBrowserEveryTest {
    WebDriver driver;

    @BeforeMethod// Open browser once time when beginning, use @BeforeClass or @BeforeTest
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @Test
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//textarea[@type='search']")).sendKeys("anhtester", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//span[@class='VuuXrf'][normalize-space()='Anh Tester Automation Testing'])[1]")).click();
        Thread.sleep(2000);
    }

    @AfterMethod// Close browser once time when beginning, use @AfterClass or @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
