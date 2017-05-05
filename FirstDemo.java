import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstDemo {

    public static void main(String []args){

        System.setProperty("webdriver.chrome.driver", "C://Temp//chromedriver.exe");
        ChromeDriver dr1=new ChromeDriver();
        //dr1.get("http://quora.com");
        System.out.println(dr1.getCurrentUrl());
        System.out.println(dr1.getTitle());
        //WebElement tagName = dr1.findElementByCssSelector("a[class='google_button submit_button']");
        //WebElement tag2 = dr1.findElement(By.cssSelector("a[class='facebook_button submit_button']"));
        //tagName.click();
        //tag2.click();
        dr1.get("http://gmail.com");
        WebElement gmail = dr1.findElement(By.id("Email"));
        gmail.sendKeys("Vijay");
    }
}
