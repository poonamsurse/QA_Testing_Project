package io.meralda.scalenext_Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.meralda.scalenext_TestBaseclass.BaseClass;

public class RegisterPage{
	WebDriver Idriver;
	//Initializing the Page Objects:
	public RegisterPage(WebDriver rdriver){
		Idriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	

	@FindBy(name="first_name")
	WebElement FirstName;
	
	@FindBy(name="last_name")
	WebElement LastName;
	
	@FindBy(name="email")
	WebElement Email;
	
	@FindBy(name="mobile")
	WebElement MobileNumber;
	
	@FindBy(xpath="//*[@placeholder=\"DOB\"]")
	WebElement DOB;
	
	@FindBy(xpath="//*[@class=\"checkout-form\"]//descendant::div/input[@name=\"password\"]")
	WebElement password;
	
	@FindBy(name="password_confirmation")
	WebElement Confirmpassword;
	
	@FindBy(xpath="//button[text()=\"Register\"]")
	WebElement registerbutton;
	
	@FindBy(xpath="//*[text()=\"Login\"]")
	WebElement login;
	
	public void setFirstname(String FN)
	{
		FirstName.sendKeys(FN);
	}
	
	public void setLastname(String LN)
	{
		LastName.sendKeys(LN);
	}
	
	
	public void setEmail(String mail)
	{
		Email.sendKeys(mail);
	}
	
	
	public void setMobile(String MN)
	{
		MobileNumber.sendKeys(MN);
	}
	
	public void setDOB(String Date)
	{
		DOB.sendKeys(Date);
	}
	
	public void setPassword(String PW)
	{
		password.sendKeys(PW);
	}
	
	public void setConfirmpassword(String CPW)
	{
		Confirmpassword.sendKeys(CPW);
	}
	
	
	public void clickRegister()
	{
		JavascriptExecutor jse = (JavascriptExecutor)Idriver;
		jse.executeScript("arguments[0].click()", registerbutton);
	}
	
	public void clickLogin()
	{
	   login.click();
	}
	
}
