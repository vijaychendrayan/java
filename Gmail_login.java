/**
 * Created by VC024129 on 4/28/2017.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Gmail_login{
    public static void main(String []args){
        System.setProperty("webdriver.gecko.driver","C://Temp//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        String appUrl = "https://accounts.google.com";
        driver.get(appUrl);
        driver.manage().window().maximize();
        String expectedTitle = "Sign in Google Accounts";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Verified");
        }
        else{
            System.out.println("Verification failed");
        }
        WebElement userName = driver.findElement(By.id("Email"));
        userName.clear();
        userName.sendKeys("Vijaychendrayan");
        WebElement nextButton = driver.findElement(By.id("next"));
        nextButton.click();
        WebElement password = driver.findElement(By.id("Passwd"));
        password.clear();
        password.sendKeys("TestSelenium");

    }
}
