import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by VC024129 on 4/28/2017.
 */
public class FirefoxDemo {
    public static void main(String []args){
        System.setProperty("webdriver.gecko.driver","C://Temp//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://quora.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        WebElement tag = driver.findElement(By.cssSelector("a[class='google_button submit_button']"));
        //tag.click();


    }
}
