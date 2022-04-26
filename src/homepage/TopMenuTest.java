package homepage;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void SetUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        List<WebElement> topMenuName = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li"));
        for (WebElement name : topMenuName) {
            if (name.getText().equalsIgnoreCase(menu)) {
                name.click();
                break;
            }
        }
    }
    @Test
    public void verifyComputer(){
        selectMenu("Computers");
        verifyText("Computers",By.xpath("//h1[contains(text(),'Computers')]"),"Computers");
    }
    @Test
    public void verifyElectronics(){
        selectMenu("Electronics");
        verifyText("Electronics",By.xpath("//h1[contains(text(),'Electronics')]"),"Electronics");
    }
    @Test
    public void verifyApparel(){
        selectMenu("Apparel");
        verifyText("Apparel",By.xpath("//h1[contains(text(),'Apparel')]"),"Apparel");
    }
    @Test
    public void verifyDigitalDownloads(){
        selectMenu("Digital downloads");
        verifyText("Digital downloads",By.xpath("//h1[contains(text(),'Digital downloads')]"),"Digital downloads");
    }
    @Test
    public void verifyBooks(){
        selectMenu("Books");
        verifyText("Books",By.xpath("//h1[contains(text(),'Books')]"),"Books");
    }
    @Test
    public void verifyJewelry(){
        selectMenu("Jewelry");
        verifyText("Jewelry",By.xpath("//h1[contains(text(),'Jewelry')]"),"Jewelry");
    }
    @Test
    public void verifyGiftCards(){
        selectMenu("Gift Cards");
        verifyText("Gift Cards",By.xpath("//h1[contains(text(),'Gift Cards')]"),"Gift Cards");
    }

}

