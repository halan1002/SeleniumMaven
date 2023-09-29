package exercise.unit12actionrobot;

import exercise.common.ExerciseBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;

public class TestRobotClass extends ExerciseBaseClass {

    @Test
    public void inputText() throws InterruptedException, AWTException {

        driver.get("https://anhtester.com/");

        Thread.sleep(1000);
        WebElement inputCourseElement = driver.findElement(By.name("key"));

        inputCourseElement.click();

        Robot robot = new Robot();
        robot.delay(1000);
        // Nhập từ khóa selenium
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_U);
        robot.keyPress(KeyEvent.VK_M);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);
    }
    @Test
    public void mousePress() throws InterruptedException, AWTException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        Robot robot = new Robot();
        //Move to position x,y
        robot.mouseMove(1400, 200);
        //Dalay <=> sleep
        robot.delay(1000);
        //Left click
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //drag and drop
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Thread.sleep(2000);
    }
    @Test
    //Take a screenshot
    public void takeScreenshot(String fileName) throws AWTException, IOException {
        //Get size screen browser
        Robot robot= new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println("Screen size is: " + screenSize);
        //Initial a rectangle frame
        Rectangle screenRectangle = new Rectangle(screenSize);
        //create a screen capture
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //save to a file formated png
        File file = new File(fileName + ".png");
        ImageIO.write(image, "png", file);
    }
    //Goi ham chup hình
    public void createScreenCapture() throws InterruptedException, AWTException, IOException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);
        takeScreenshot("imageRobot");
        Thread.sleep(1000);
    }
}
