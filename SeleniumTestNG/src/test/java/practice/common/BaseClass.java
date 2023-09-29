package practice.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;

    @BeforeClass
    public static void createDriver() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void closeDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public static void loginAnTester() {
        WebElement txtEmail = driver.findElement(By.id("email"));
        txtEmail.sendKeys("admin@example.com");

        WebElement txtPassword = driver.findElement(By.id("password"));
        txtPassword.sendKeys("123456");

        WebElement chkRemember = driver.findElement(By.id("remember"));
        chkRemember.click();

        WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        btnLogin.click();
    }

    public static WebElement findEleByXPath(String xPath) {

        WebElement eleXPath = driver.findElement(By.xpath(xPath));
        return eleXPath;
    }
}
