package com.obsqura.ServiceApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtility;

public class Base {
	public WebDriver driver;
	public Properties prop,prop1;
	public FileInputStream fs,fs1;
	public ScreenshotUtility scrshot;
	@BeforeMethod
	public void initBrowser() {
		prop=new Properties();
		try {
			fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.CONFIGfILE);

		} catch (Exception e) {
		}
		try {
			prop.load(fs);
		} catch (Exception e) {
		}
		prop1=new Properties();
		try {
			fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.TESTDATAFILE);
		} catch (Exception e) {
		}
		try {

			prop1.load(fs);
		} catch (Exception e) {
		}
	}
		@BeforeMethod
		@Parameters("browser")
		public void initializeBrowser(String browser) throws Exception {
		if(browser.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+constants.Constants.FIREfOXdRIVERfILE);
		driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ constants.Constants.CHROMEdRIVERfILE);
		driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")){
		System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+constants.Constants.EdGEdRIVERfILE);
		driver = new EdgeDriver();
		}
		else{
		throw new Exception("Browser is not correct");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   
	}
		@AfterMethod
		public void browserQuit(ITestResult iTestResult) throws IOException
	 {
			if (iTestResult.getStatus() == ITestResult.FAILURE) {
				scrshot = new ScreenshotUtility();
				scrshot.getScreenShot(driver, iTestResult.getName());
			}

			driver.quit();
		}
}
