package com.SauceDemo.POMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOMClass {

	private WebDriver driver;
	

	//find the elements by @FindBY
	@FindBy(xpath="//input[@id='user-name']")
	private WebElement username;
	
	//3.actions on element -method
		public void sendUsername(String[] loginData)
		{
			System.out.println(loginData[0]);
			username.sendKeys(loginData[0]);
		}
		
		@FindBy(xpath="//input[@id='password']")
		private WebElement password;
		
	     public void sendPassword(String [] loginData)
	     {	System.out.println(loginData[1]);
	    	 password.sendKeys(loginData[1]);
	     }
				
	     @FindBy(xpath="//input[@id='login-button']")
	 	 private WebElement loginButton;
		
		
		public void clickLoginButton()
		{
			loginButton.click();
		}
		
		private String pageTitile;
		public String getTitle() {
			
			pageTitile = driver.getTitle();
			 System.out.println(pageTitile);
			 return pageTitile;
		}
		
		public LoginPagePOMClass(WebDriver driver) {
			
			this.driver = driver;
			
			PageFactory.initElements(driver, this);
		}
}
