package com.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecureAreaPage {
	    public static WebDriver driver;
	   
	    @FindBy(xpath = "//div[contains(text(),'You logged into a secure area!')]")
		private WebElement successText;
	    
	  @FindBy(xpath="//a[@href='/logout']")
	  private WebElement logout;
	  
	    public WebElement getLogout() {
		return logout;
	}

		public SecureAreaPage(WebDriver driver) {
	        this.driver = driver;
	       PageFactory.initElements(driver, this);
	    }

		public WebElement getSuccessText() {
			return successText;
		}
	    
	}

