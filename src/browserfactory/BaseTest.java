package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public void openBrowser(String baseUrl){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver =new ChromeDriver();
        //lunch Url
        driver.get(baseUrl);
        //maximise window
        driver.manage().window().maximize();
        driver.manage().deleteCookieNamed(baseUrl);
        //give implicit time to window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    // close driver
    public void closeDriver(){
        driver.close();
    }

}
