package practice.ecommerce;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import practice.common.EcommerceBase;
import practice.keyword.WebUI;

import static java.lang.Thread.sleep;

public class CreateCategory extends EcommerceBase {
    String catName = "00_LH Apple";

    void selectImage(String xPath, String keyword) {
        //Banner
        findEleByXPath(xPath).click();
        //Check search file text field existed
        WebUI.sleep(8);
        Boolean bannerSearch = findEleByXPath("//input[@placeholder='Search your files']").isDisplayed();
        Assert.assertTrue(bannerSearch, "The Search your files textbox is not eixtsed.");
        findEleByXPath("//input[@placeholder='Search your files']").sendKeys(keyword, Keys.ENTER);
        //check if the matched items are displayed
        WebUI.sleep(8);
        Boolean bannerResults = findEleByXPath("(//div[@class='card-file-thumb'])[1]").isDisplayed();
        Assert.assertTrue(bannerResults, "There is no item matched.");
        WebUI.sleep(2);
        findEleByXPath("(//div[@class='card-file-thumb'])[1]").click();
        findEleByXPath("//button[normalize-space()='Add Files']").click();
    }

    void searchCategory(String xPath, String findName, String resultXPath) {
        findEleByXPath(xPath).sendKeys(findName, Keys.ENTER);
        WebUI.sleep(5);
        String getRecord = findEleByXPath(resultXPath).getText();
        System.out.println("Actual value:" + getRecord);
        Assert.assertEquals(getRecord, findName, "The category is not found.");

    }

    void addCategory() {
        //Click on Add New category button
        String btnAddNewCat = findEleByXPath("//span[normalize-space()='Add New category']").getText();
        System.out.println(btnAddNewCat);
        Assert.assertTrue(btnAddNewCat.equals("Add New category"), "Button Add New Category is not displayed.");
        findEleByXPath("//span[normalize-space()='Add New category']").click();
        WebUI.sleep(2);
        //Fill data for Category Information form
        String pageTitle = findEleByXPath("//h5[normalize-space()='Category Information']").getText();
        WebUI.sleep(1);
        Assert.assertTrue(pageTitle.equals("Category Information"), "The Category Information is not displayed");
        findEleByXPath("//input[@id='name']").sendKeys(catName);
//        Thread.sleep(1000);
//        findEleByXPath("//div[contains(text(),'No Parent')]").click();
        WebUI.sleep(1);
        findEleByXPath("//input[@id='order_level']").sendKeys("5");
        findEleByXPath("//div[contains(text(),'Physical')]").click();
        findEleByXPath("//label[normalize-space()='Type']/following-sibling::div//span[normalize-space()='Physical']").click();

        //Banner
        selectImage("//label[contains(text(),'Banner')]/following-sibling::div//div[contains(text(),'Browse')]", "Mask");
        //Icon
        WebUI.sleep(2);
        selectImage("//label[contains(text(),'Icon')]/following-sibling::div//div[contains(text(),'Browse')]", "25936");
        //Cover image

        //Roll down to Save button
        WebUI.sleep(3);
        Actions action = new Actions(driver);
        action.keyDown(Keys.END).build().perform();
        action.release().build().perform();

        WebUI.sleep(3);
        selectImage("//label[contains(text(),'Cover Image')]/following-sibling::div//div[contains(text(),'Choose file')]", "25935");
        //Meta Title
        findEleByXPath("//input[@placeholder='Meta Title']").sendKeys("Iphone");
        findEleByXPath("//textarea[@name='meta_description']").sendKeys("Iphone Meta Description");
        findEleByXPath("//div[contains(text(),'Nothing selected')]").click();

        //Filltering Attributes
        WebUI.sleep(3);
        //Enter a value not existed
        String fillTextNotExisted = "Test";
        findEleByXPath("//div[@class='dropdown-menu show']//input[@aria-label='Search']").sendKeys(fillTextNotExisted);
        Boolean messageDisplay = findEleByXPath("//li[@class='no-results']").isDisplayed();
        System.out.println("Fillering attribute search displayed: " + messageDisplay);
        Assert.assertTrue(messageDisplay, "Filltering Attributes searched incorrectly.");
        //Enter an existed item
        String fillTextExisted = "Size";
        findEleByXPath("//div[@class='dropdown-menu show']//input[@aria-label='Search']").clear();
        findEleByXPath("//div[@class='dropdown-menu show']//input[@aria-label='Search']").sendKeys(fillTextExisted, Keys.ENTER);
        WebUI.sleep(2);
        findEleByXPath("//div[contains(text(),'Size')]").click();
        WebUI.sleep(3);
        findEleByXPath("//button[normalize-space()='Save']").click();

        //Check alert displayed
        String alertMessage = findEleByXPath("//div[@role='alert']").getText();
        System.out.println(alertMessage);
        Assert.assertEquals(alertMessage, "Category has been inserted successfully", "The message is not correct.");
        //div[@role='alert']
    }

    void navigateCategory() {
        //menu Products
        String menuProduct = findEleByXPath("//span[normalize-space()='Products']").getText();
        WebUI.sleep(2);

        Assert.assertTrue(menuProduct.equals("Products"), "Products menu is not available.");
        findEleByXPath("//span[normalize-space()='Products']").click();
        WebUI.sleep(2);
        //menu Category
        String menuCategory = findEleByXPath("//span[normalize-space()='Category']").getText();

        WebUI.sleep(2);
        Assert.assertTrue(menuCategory.equals("Category"), "Category menu is not available.");
        findEleByXPath("//span[normalize-space()='Category']").click();
    }

    @Test
    public void createCategory() {
        //Navigate to menu Products -> Category
        navigateCategory();
        WebUI.sleep(2);
        //Button Add New Category
        addCategory();
        WebUI.sleep(2);
        //Search the created Category
        searchCategory("//input[@id='search']", catName, "//tbody/tr[1]//td[@class='d-flex align-items-center']");
    }


}
