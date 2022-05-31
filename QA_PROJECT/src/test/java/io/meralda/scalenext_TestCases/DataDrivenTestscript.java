package io.meralda.scalenext_TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.meralda.scalenext_Pages.RegisterPage;
import io.meralda.scalenext_TestBaseclass.BaseClass;
import io.meralda.scalenext_Utility.XLUtils;

public class DataDrivenTestscript extends BaseClass {

@Test(dataProvider="LoginData")
public void register(String firstname, String lastname, String email,String mobile, String birthdate, String password,String confirmpassword ) throws InterruptedException
{
	RegisterPage rp=new RegisterPage(driver);
	rp.setFirstname(firstname);
	rp.setLastname(lastname);
	rp.setEmail(email);
	Thread.sleep(3000);
	rp.setMobile(mobile);
	Thread.sleep(3000);
	rp.setPassword(password);
	Thread.sleep(3000);
	rp.setConfirmpassword(confirmpassword);
	Thread.sleep(3000);
	rp.clickRegister();
	Thread.sleep(3000);
	
	String title=driver.getTitle();
	System.out.println(title);
	Assert.assertEquals(title, "MERALDA || hOME");	
}



@DataProvider(name="LoginData")
String [][] getData() throws IOException
{
	String path=System.getProperty("user.dir")+"/src/main/java/io/meralda/scalenext_Testdata/register.xlsx";
	
	int rownum=XLUtils.getRowCount(path, "Sheet1");
	int colcount=XLUtils.getCellCount(path,"Sheet1",1);
	
	String logindata[][]=new String[rownum][colcount];
	
	for(int i=1;i<=rownum;i++)
	{
		for(int j=0;j<colcount;j++)
		{
			logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
		}
			
	}
return logindata;
}


}
