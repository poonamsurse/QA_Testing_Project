package io.meralda.scalenext_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.meralda.scalenext_Pages.RegisterPage;
import io.meralda.scalenext_TestBaseclass.BaseClass;

public class SingleUserTestScript extends BaseClass {

	@Test
	public void registerUser()
	{
		RegisterPage rp=new RegisterPage(driver);
		rp.setFirstname("Poonam");
		rp.setLastname("Jadhav");
		rp.setEmail("poonam@gmail.com");
		rp.setMobile("4563728907");
		rp.setDOB("1998-08-09");
		rp.setPassword("Poonam@1234");
		rp.setConfirmpassword("Poonam@1234");
		rp.clickRegister();
		
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "MERALDA || HOMe");	
	}
}
