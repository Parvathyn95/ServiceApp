package com.obsqura.ServiceApp;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.DataProviderUtility;

public class HomePageTest extends Base {
	LoginPage loginPageObj;
	HomePage homePageObj;
	@Test
	public void verifyAndGetColorOfThreeContainerBoxes() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		homePageObj = new HomePage(driver);
		homePageObj.getColorOfThreeContainerBoxes();
	}
	@Test
	public void verifyAndClickOnDateCalenderAddEventIfAddedOrNot() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		homePageObj = new HomePage(driver);
		homePageObj.clickOnDateCalenderAddEventIfAddedOrNot();
	}
	@Test
	public void verifyAndClickOnDateCalenderEventAndDeleteIt() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		homePageObj = new HomePage(driver);
		homePageObj.clickOnDateCalenderEventAndDeleteIt();
	}
	@Test(dataProvider="formData2",dataProviderClass=DataProviderUtility.class)
	public void verifyEnterAnyTwoFieldsOfQuickEmailAndSend(String mailid,String subject) throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		homePageObj = new HomePage(driver);
		homePageObj.enterAnyTwoFieldsOfQuickEmailAndSend(mailid,subject);
	}
	@Test
	@Parameters({"mailid","subject","message"})
	public void checkEnterAnInvalidMailIdDetailsAndSend(String mailid,String subject,String message) throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		homePageObj = new HomePage(driver);
		homePageObj.enterAnInvalidMailIdDetailsAndSend(mailid,subject,message);
	}
}
