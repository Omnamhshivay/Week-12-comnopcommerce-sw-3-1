package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.Random;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void textVerified() throws InterruptedException {
        mouseHoverAndClick(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"), By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]"));
        verifyText("Electronics", By.xpath("//div[@class='center-2']/div/div[1]/h1"), "Verify cellphones text");
    }

    @Test
    public void verifyThatTheProductAddedSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
        //2.2 Mouse Hover on “Cell phones” and click
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        //1.3 Verify the text “Cell phones”
        verifyText("Cell phones", By.xpath("//div[@class='page category-page']/div[1]/h1"), "Verify cellphones text");
        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//div[@class='product-viewmode']/a[2]"));
        Thread.sleep(2000);
        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//div[@class='item-grid']/div[3]/div/div[2]/h2/a"));
        // 2.6 Verify the text “Nokia Lumia 1020”
        verifyText("Nokia Lumia 1020", By.xpath("//div[@class='product-name']/h1"), "Verify nokia lumia 1020 text");
        //2.7 Verify the price “$349.00”
        verifyText("$349.00", By.xpath("//div[@class='prices']/div/span"), "Price verify");
        //2.8 Change quantity to 2
        clearTextFromField(By.id("product_enteredQuantity_20"));
        Thread.sleep(2000);
        sendTextToElement(By.id("product_enteredQuantity_20"), "2");
        Thread.sleep(2000);
        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.id("add-to-cart-button-20"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyText("The product has been added to your shopping cart", By.xpath("//div[@id='bar-notification']/div/p"), "Verify sgopping cart text");
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//div[@id='bar-notification']/div/span"));
        Thread.sleep(3000);
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverAndClick(By.xpath("//li[@id='topcartlink']"),By.xpath("/html[1]/body[1]/div[6]/div[1]/div[1]/div[2]/div[2]/div[1]/div[4]/button[1]"));

        //2.12 Verify the message "Shopping cart"
        verifyText("Shopping cart", By.xpath("//div[@class='page-title']/h1"), "Display Shopping cart");
        //2.13 Verify the quantity is 2
        //verifyText("2", By.xpath("//td[@class='quantity']/input"), "Verify quantity");
        //2.14 Verify the Total $698.00
        verifyText("$698.00", By.xpath("//td[@class='subtotal']/span"), "Verify price");
        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //2.16 Click on checkout
        clickOnElement(By.id("checkout"));
        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyText("Welcome, Please Sign In!", By.xpath("//div[@class='page-title']/h1"), "Verify welcome sign in text");
        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//div[@class='buttons']/button[2]"));
        //2.19 Verify the text “Register”
        verifyText("Register", By.xpath("//div[@class='page-title']/h1"), "Register text validation");
        //2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"), "maxi");
        sendTextToElement(By.id("LastName"), "momo");
        WebElement emailField = driver.findElement(By.id("Email"));// email field locator
        emailField.click();// click email field
        Random randomGenerator = new Random();// random generator class
        int randomInt = randomGenerator.nextInt(1000);
        emailField.sendKeys("username" + randomInt + "@gmail.com");// creating random email generator
        sendTextToElement(By.id("Password"), "123456");
        sendTextToElement(By.id("ConfirmPassword"), "123456");
        //2.21 Click on “REGISTER” Button
        clickOnElement(By.id("register-button"));
        //2.22 Verify the message “Your registration completed”
        verifyText("Your registration completed", By.xpath("//div[@class='page-body']/div[1]"), "Your registration completed text");
        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//div[@class='buttons']/a"));
        //2.24 Verify the text “Shopping cart”
        verifyText("Shopping cart", By.xpath("//div[@class='page-title']/h1"), "Verify shopping cart text");
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        //2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.27 Fill the Mandatory fields
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "Albania");
        sendTextToElement(By.id("BillingNewAddress_City"), "surat");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "999 baker road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "56235");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "9898989898");
        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@class='buttons']/button[4]"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.id("shippingoption_2"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));
        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/button"));
        //2.32 Select “Visa” From Select credit card dropdown
        //2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"), "pin");
        sendTextToElement(By.id("CardNumber"), "4917484589897107");
        selectByIndexFromDropDown(By.id("ExpireYear"), 2);
        sendTextToElement(By.id("CardCode"), "007");
        //2.34 Click on “CONTINUE”CHECKOUT”
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));
        //2.35 Verify “Payment Method” is “Credit Card”
        verifyText("Credit Card", By.xpath("//li[@class='payment-method']/span[2]"), "Credit card validation");
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyText("2nd Day Air", By.xpath("//li[@class='shipping-method']/span[2]"), "Shipping method validation");
        //2.37 Verify Total is “$698.00”
        verifyText("$698.00", By.xpath("//td[@class='subtotal']/span"), "Amount validation");
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//div[@id='confirm-order-buttons-container']/button"));
        //2.39 Verify the Text “Thank You”
        verifyText("Thank you", By.xpath("//div[@class='page checkout-page order-completed-page']/div[1]/h1"), "Thank you text validation");
        //2.40 Verify the message “Your order has been successfully processed!”
        verifyText("Your order has been successfully processed!", By.xpath("//div[@class='page checkout-page order-completed-page']/div[2]/div/div[1]"), "yoru order has been successfully processed");
        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@class='section order-completed']/div[3]/button"));
        //2.42 Verify the text “Welcome to our store”
        verifyText("Welcome to our store", By.xpath("//div[@class='topic-block-title']/h2"), "Welcome to store text");
        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//div[@class='header-links']/ul/li[2]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demo.nopcommerce.com/";
        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @After
    public void close() {
        driver.close();
    }

}
