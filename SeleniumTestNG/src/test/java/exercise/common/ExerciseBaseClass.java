package exercise.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class ExerciseBaseClass {
    public static WebDriver driver;

    @BeforeClass// Open browser once time when beginning, use @BeforeClass or @BeforeTest
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        System.out.println("Open Browser from Exercise BaseClass");
    }
    @AfterClass// Close browser once time when beginning, use @AfterClass or @AfterTest
    public void closeDriver() {

        driver.quit();
        System.out.println("Close Browser from Exercise BaseClass");
    }

    public static WebElement findEleByXPath(String xPath) {

        WebElement eleXPath = driver.findElement(By.xpath(xPath));
        return eleXPath;
    }
}
