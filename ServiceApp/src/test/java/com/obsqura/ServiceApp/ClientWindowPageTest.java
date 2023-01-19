package com.obsqura.ServiceApp;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.ClientWindowPage;
import pages.LoginPage;
import utilities.DataProviderUtility;

public class ClientWindowPageTest extends Base {
	LoginPage loginPageObj;
	ClientWindowPage clientWindowPageObj;
	@Test
	public void verifyEnterClientDetailsAndAddClient() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		clientWindowPageObj = new ClientWindowPage(driver);
		clientWindowPageObj.enterClientDetailsAndAddClient();
	}
	@Test(dataProvider="formData",dataProviderClass=DataProviderUtility.class)
	public void verifyeEnterClientDetailsWithoutNameAndAddClient(String company,String geoLocation,String address,String city, String postalCode,
	   String telephone, String email,String vat,String ssn,String comment) throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		clientWindowPageObj = new ClientWindowPage(driver);
		clientWindowPageObj.enterClientDetailsWithoutNameAndAddClient(company,geoLocation,address,city, postalCode,
				telephone, email,vat,ssn,comment);
	}
	@Test
	public void verifycolorOfTheVariousButtonsOfAddClientForm() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		clientWindowPageObj = new ClientWindowPage(driver);
		clientWindowPageObj.colorOfTheVariousButtonsOfAddClientForm();
	}
	@Test
	public void verifyClickOnViewClientInNewWindowAndModifyName() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		clientWindowPageObj = new ClientWindowPage(driver);
		clientWindowPageObj.clickOnViewClientInNewWindowAndModifyDetails();
	}
	@Test
	public void checkClickOnExportToExcelFileAndDownloadIt() throws IOException, InterruptedException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		clientWindowPageObj = new ClientWindowPage(driver);
		clientWindowPageObj.clickOnExportToExcelFileAndDownloadIt();
	}
}
