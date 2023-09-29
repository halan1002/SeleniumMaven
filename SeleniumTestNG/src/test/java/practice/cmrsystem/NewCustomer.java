package practice.cmrsystem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Date;

import static practice.common.BaseClass.*;

public class NewCustomer {
    public static void main(String[] args) throws InterruptedException {
        createDriver();
        driver.get(" https://crm.anhtester.com/admin/authentication");

        loginAnTester();//Login
        WebElement menuCustomers = driver.findElement(By.xpath("//span[normalize-space()='Customers']"));
        menuCustomers.click();//click Customers menu

        WebElement btnNewCustomer = driver.findElement(By.xpath("//div[@class='_buttons']//following-sibling::a[contains(normalize-space(),'New Customer')]"));
        btnNewCustomer.click();//click New Customer button
        //Fill New Customer form
        WebElement txtCompany = driver.findElement(By.id("company"));
        txtCompany.sendKeys("ABC company" + new Date());

        WebElement txtVat = driver.findElement(By.id("vat"));
        txtVat.sendKeys("1234567");

        WebElement txtPhone = driver.findElement(By.id("phonenumber"));
        txtPhone.sendKeys("88888888");

        WebElement txtWebsite = driver.findElement(By.id("website"));
        txtWebsite.sendKeys("https://crm.anhtester.com/");

        //Group
        WebElement listGroup = driver.findElement(By.xpath("//label[contains(.,'Groups')]/following-sibling::div"));
        listGroup.click();
        WebElement txtGroupSearch = driver.findElement(By.xpath("//div[@class='bs-actionsbox']/parent::div[contains(@class,'dropdown-menu')]//input"));
        txtGroupSearch.sendKeys("AA");
        WebElement txtGroupValue = driver.findElement(By.xpath("//div[@class='bs-actionsbox']/following-sibling::div[@role='listbox']"));
        txtGroupValue.click();
        WebElement txtGroupReselect = driver.findElement(By.xpath("//label[normalize-space()='Groups']"));
        txtGroupReselect.click();

        //Currency
        WebElement listCurency = driver.findElement(By.xpath("//label[contains(.,'Currency')]/following-sibling::div"));
        listCurency.click();
        WebElement listCurencyVal = driver.findElement(By.xpath("//span[@class='text'][contains (., 'USD')]"));
        listCurencyVal.click();

        //Currency
        WebElement listLanguage = driver.findElement(By.xpath("//label[contains(.,'Default Language ')]/following-sibling::div"));
        listLanguage.click();
        WebElement listLanguageVal = driver.findElement(By.xpath("//span[@class='text'][contains (., 'English')]"));
        listLanguageVal.click();
        //Address:
        WebElement txtAddress = driver.findElement(By.id("address"));
        txtAddress.sendKeys("1515 CMT8");
        WebElement txtCity = driver.findElement(By.id("city"));
        txtCity.sendKeys("Ho Chi Minh");
        WebElement txtState = driver.findElement(By.id("state"));
        txtState.sendKeys("N/A");
        WebElement txtZip = driver.findElement(By.id("zip"));
        txtZip.sendKeys("70000");
        //Country
        WebElement listCountry = driver.findElement(By.xpath("//div[@app-field-wrapper='country']/child::div/button"));
        listCountry.click();
        WebElement listCountrySearch = driver.findElement(By.xpath("//select[@id='country']/following-sibling::div//input"));
        listCountrySearch.sendKeys("A");
        WebElement listCountryVal = driver.findElement(By.xpath("//span[normalize-space()='Vietnam']"));
        listCountryVal.click();
        //CLick on Bill & Shipping tab
        WebElement billShipping = driver.findElement(By.xpath("//a[normalize-space()='Billing & Shipping']"));
        billShipping.click();
        //Billing section
        WebElement billStreet = driver.findElement(By.id("billing_street"));
        billStreet.sendKeys("55 Billing Street");
        WebElement billCity = driver.findElement(By.id("billing_city"));
        billCity.sendKeys("Billing City");
        WebElement billState = driver.findElement(By.id("billing_state"));
        billState.sendKeys("Billing State");
        WebElement billZip = driver.findElement(By.id("billing_zip"));
        billZip.sendKeys("30000");

        WebElement billCountry = driver.findElement(By.xpath("//button[@data-id='billing_country']//div[@class='filter-option-inner-inner']"));
        billCountry.click();
        WebElement billCountrySearch = driver.findElement(By.xpath("//button[@data-id='billing_country']//following-sibling::div//input"));
        billCountrySearch.sendKeys("Vietnam");
        WebElement billCountryVal = driver.findElement(By.xpath("//button[@data-id='billing_country']//following-sibling::div//span[normalize-space()='Vietnam']"));
        billCountryVal.click();

        //Shipping section
        WebElement shippingStreet = driver.findElement(By.id("shipping_street"));
        shippingStreet.sendKeys("88 Shipping Street");
        WebElement shippingCity = driver.findElement(By.id("shipping_city"));
        shippingCity.sendKeys("Shipping City");
        WebElement shippingState = driver.findElement(By.id("shipping_state"));
        shippingState.sendKeys("Shipping State");
        WebElement shippingZip = driver.findElement(By.id("shipping_zip"));
        shippingZip.sendKeys("45678");

        WebElement shippingCountry = driver.findElement(By.xpath("//button[@data-id='shipping_country']//div[@class='filter-option-inner-inner']"));
        shippingCountry.click();
        WebElement shippingCountrySearch = driver.findElement(By.xpath("//button[@data-id='shipping_country']//following-sibling::div//input"));
        shippingCountrySearch.sendKeys("Sing");
        WebElement shippingCountryVal = driver.findElement(By.xpath("//button[@data-id='shipping_country']//following-sibling::div//span[normalize-space()='Singapore']"));
        shippingCountryVal.click();


        //Click Save and create contact
//        WebElement btnSaveCreate = driver.findElement(By.xpath("button[normalize-space()='Save']"));
//        btnSaveCreate.click();

        //Thread.sleep(5000);
        closeDriver();
    }
}
