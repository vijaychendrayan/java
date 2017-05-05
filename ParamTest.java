/**
 * Created by VC024129 on 5/1/2017.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.lang.String;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ParamTest {
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

    public static void main(String []args) throws IOException,NullPointerException,InterruptedException,NoSuchElementException{

        try {
            String excelFilePath = "C:\\Users\\VC024129\\Documents\\Vijay\\TestFrameWork\\TestParameter.xlsx";
            FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            int rowCoutn = 0;
            String seqNumber = " ";
            RichTextString seqNum = null;
            RichTextString testDescr = null;
            RichTextString action = null;
            RichTextString actionType = null;
            RichTextString match = null;
            RichTextString parameter = null;
            RichTextString lineStatus = null;
            //------
            int width = 120;
            int height = 140;
            Dimension dimension = new Dimension(width,height);
            WebElement webElement;
            ParamTest obj = new ParamTest();
            WebDriver webDriverObj = obj.setWebDriver("CHROME");
            //------

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {

                Row rowNext = rowIterator.next();
                if (rowCoutn == 0) {
                    rowCoutn += 1;
                    continue;
                }

                Iterator<Cell> cellIterator = rowNext.cellIterator();
                seqNum = rowNext.getCell(0).getRichStringCellValue();
                testDescr = rowNext.getCell(1).getRichStringCellValue();
                action = rowNext.getCell(2).getRichStringCellValue();
                actionType = rowNext.getCell(3).getRichStringCellValue();
                match = rowNext.getCell(4).getRichStringCellValue();
                parameter = rowNext.getCell(5).getRichStringCellValue();
                lineStatus = rowNext.getCell(6).getRichStringCellValue();
                System.out.print("Seq # : " + seqNum + " --> Test Description : " + testDescr + " --> Action : " + action + "--> Type : " + actionType);
                System.out.print(" --> Match : " + match + " --> Parameter : " + parameter+" --> Status : "+ lineStatus);
                System.out.println();

                //---
                if (lineStatus.getString().equals("A")) {
                    // Navigate
                    if (action.getString().equals("Navigate")) {
                        System.out.println("Navigate " + match.getString());
                        webDriverObj.get(match.getString());
                    }
                    // Send Keys
                    if (action.getString().equals("SendKeys")) {
                        // Xpath
                        if (actionType.getString().equals("Xpath")) {
                            webElement = webDriverObj.findElement(By.xpath(match.getString()));
                            webElement.sendKeys(parameter.getString());
                        }
                        // by ID
                        if (actionType.getString().equals("ID")) {
                            webElement = webDriverObj.findElement(By.id(match.getString()));
                            webElement.sendKeys(parameter.getString());
                        }
                        // by Class name
                        if (actionType.getString().equals("ClassName")) {
                            webElement = webDriverObj.findElement(By.className(match.getString()));
                            webElement.sendKeys(parameter.getString());

                        }
                        // by CSS Selector
                        if (actionType.getString().equals("CSSSelector")) {
                            webDriverObj.findElement(By.cssSelector(match.getString())).sendKeys(parameter.getString());
                        }
                    }
                    // Click
                    if (action.getString().equals("Click")) {
                        if (actionType.getString().equals("Xpath")) {
                            webElement = webDriverObj.findElement(By.xpath(match.getString()));
                            webElement.click();
                        }
                        if (actionType.getString().equals("CSSSelector")) {
                            webDriverObj.findElement(By.cssSelector(match.getString())).click();
                        }

                    }
                    // Compare
                    if (action.getString().equals("Compare")) {
                        // Page Title Checking.
                        if (actionType.getString().equals("PageTitle")) {
                            if (webDriverObj.getTitle().equals(parameter.getString())) {
                                System.out.println("--> Title matched <--");
                            } else {
                                System.out.println("===>Match Exception : Page title is :" + webDriverObj.getTitle() + "==> Given Title is " + parameter.getString());

                            }
                        }

                        // Compare XPath element
                        if(actionType.getString().equals("Xpath")){
                            webElement = webDriverObj.findElement(By.xpath(match.getString()));
                            if(webElement.getText().equals(parameter.getString())){
                                System.out.println("Matched ");
                            }
                            else {
                                System.out.println("Match Exception");
                                System.out.println("Given String to match : "+parameter.getString()+ " Actual value in page : "+webElement.getText());
                            }
                        }
                        // Compare by ID element
                        if(actionType.getString().equals("ID")){
                            webElement = webDriverObj.findElement(By.id(match.getString()));
                            if(webElement.getText().equals(parameter.getString())){
                                System.out.println("Matched");
                            }
                            else {
                                System.out.println("Match Exception");
                                System.out.println("Given String to match : "+parameter.getString()+ " Actual value in page : "+webElement.getText());

                            }
                        }
                        // CSS selector
                        if(actionType.getString().equals("CSSSelector")){
                            webElement = webDriverObj.findElement(By.cssSelector(match.getString()));

                            if(webElement.getText().equals(parameter.getString())){
                                System.out.println("Matched");
                            }
                            else {
                                System.out.println("Match Exception");
                                System.out.println("Given String to match : "+parameter.getString()+ " Actual value in page : "+webElement.getText());
                            }
                        }
                    }
                    // Time Delay
                    if (action.getString().equals("DelayBy")){
                        String sleepTime = parameter.getString();
                        Thread.sleep(Long.valueOf(sleepTime).longValue());
                    }


                }

                //---


                rowCoutn += 1;
            }
            workbook.close();
            fileInputStream.close();
            webDriverObj.quit();
        }
        catch (IOException e){}
        catch (NullPointerException e){System.out.println(e);}
        catch (InterruptedException e){ }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}
