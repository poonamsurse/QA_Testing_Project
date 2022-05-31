package io.meralda.scalenext_TestBaseclass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.meralda.scalenext_Utility.ReadConfig;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public static WebDriver driver;

	@BeforeClass
	public void setup()
	{			

		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
	}


	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}


}
