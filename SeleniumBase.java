/**
 * Created by VC024129 on 4/29/2017.
 */
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class SeleniumBase {

    public static final String FIRE_FOX_DRIVER_PATH = "C://Temp//geckodriver.exe";
    public static final String FIRE_FOX_DRIVER_PROP = "webdriver.gecko.driver";
    public static final String CHROME_DRIVER_PATH = "C://Temp//chromedriver.exe";
    public static final String CHROME_DRIVER_PROP = "webdriver.chrome.driver";

    public WebDriver driver;

    public WebDriver setWebDriver(String browserType){

        if(browserType.equals("CHROME")){
            System.setProperty(CHROME_DRIVER_PROP,CHROME_DRIVER_PATH);
            this.driver = new ChromeDriver();

        }else if(browserType.equals("FIREFOX")){
            System.setProperty(FIRE_FOX_DRIVER_PROP,FIRE_FOX_DRIVER_PATH);
            this.driver = new FirefoxDriver();

        }
        return this.driver;
    }
    public static void main(String []args) throws InterruptedException{
        int width = 120;
        int height = 140;
        Dimension dimension = new Dimension(width,height);
        WebElement webElement;
        SeleniumBase obj = new SeleniumBase();
        WebDriver webDriverObj = obj.setWebDriver("CHROME");
        webDriverObj.get("file:///C:/Users/VC024129/Documents/Vijay/TestFrameWork/ForTesting.html");
        System.out.println(webDriverObj.getTitle());
        webDriverObj.manage().window().maximize();
        webDriverObj.manage().window().setSize(dimension);
        webDriverObj.manage().window().maximize();
        //webElement = webDriverObj.findElement(By.linkText("Visit our HTML tutorial"));
        //webElement.click();
        webElement = webDriverObj.findElement(By.xpath("html/body/form[1]/input[1]"));
        webElement.sendKeys("Vijay");
        //html/body/select
        List <WebElement> webElementList = webDriverObj.findElements(By.xpath("html/body/select"));
        System.out.println(webElementList);
        for(WebElement element: webElementList){
            System.out.println(element.getText());
        }
        Thread.sleep(4000 );
        webDriverObj.quit();


    }
}
