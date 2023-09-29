package practice.common;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class EcommerceBase extends BaseClass{

    @BeforeClass
    public void loginEcommerce(){
        driver.get("https://demo.activeitzone.com/ecommerce/login");
        String pageTitle=findEleByXPath("//h1[normalize-space()='Welcome to Active eCommerce CMS']").getText();
        Assert.assertEquals(pageTitle, "Welcome to Active eCommerce CMS", "The login page is not loaded.");
        findEleByXPath("//button[normalize-space()='Copy']").click();
        findEleByXPath("//button[normalize-space()='Login']").click();
    }
}
