package com.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    public static WebDriver driver;
  
    public static WebDriver  browserLaunch() {
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }


    public static void inputValueElement(WebElement element,String value){
    	element.sendKeys(value);
    	
    }
    public static void clickOnElement(WebElement element){
    	element.click();
    	
    }
    public static void getUrl(String value){
    	driver.get(value);
    	
    }
    public static String gettingText(WebElement element){
    	String text = element.getText();
    	return text;
    }
}
