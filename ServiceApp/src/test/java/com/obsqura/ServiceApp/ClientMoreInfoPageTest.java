package com.obsqura.ServiceApp;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ClientMoreInfoPage;
import pages.LoginPage;

public class ClientMoreInfoPageTest extends Base{
	LoginPage loginPageObj;
	ClientMoreInfoPage clientMoreInfoPageObj;
	@Test
	public void verifyClickOnViewClientInNewWindowAndModifyName() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		clientMoreInfoPageObj = new ClientMoreInfoPage(driver);
		clientMoreInfoPageObj.clickOnViewClientInNewWindowAndModifyDetails();
	}
	@Test
	public void checkClickOnExportToExcelFileAndDownloadIt() throws IOException, InterruptedException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		clientMoreInfoPageObj = new ClientMoreInfoPage(driver);
		clientMoreInfoPageObj.clickOnExportToExcelFileAndDownloadIt();
	}

}
