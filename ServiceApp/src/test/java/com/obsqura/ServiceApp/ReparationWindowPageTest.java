package com.obsqura.ServiceApp;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.ReparationWindowPage;
import pages.LoginPage;

public class ReparationWindowPageTest extends Base {
	LoginPage loginPageObj;
	ReparationWindowPage reparationWindowPageObj;
	@Test
	public void verifyAndEnterSomeReparationDetailseAndAddReparation() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		reparationWindowPageObj = new ReparationWindowPage(driver);
		reparationWindowPageObj.enterSomeReparationDetailsAndAddReparation();
	}
	@Test
	public void verifyGetColorOfTheButtonsOfAddReparation() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		reparationWindowPageObj = new ReparationWindowPage(driver);
		reparationWindowPageObj.getColorOfTheButtonsOfAddReparation();
	}
	@Test
	public void verifyAndEnterMandatoryDetailsAddReparationReportGenerated() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		reparationWindowPageObj = new ReparationWindowPage(driver);
		reparationWindowPageObj.enterMandatoryDetailsAddReparationReportGenerated();
	}
	@Test
	public void verifyClickOnViewReparationInNewWindow() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		reparationWindowPageObj = new ReparationWindowPage(driver);
		reparationWindowPageObj.clickOnViewReparationInNewWindow();
	}
	@Test
	public void verifyClickOnPrintBarcodeInNewWindowCheckHeader() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		reparationWindowPageObj = new ReparationWindowPage(driver);
		reparationWindowPageObj.clickOnPrintBarcodeInNewWindowCheckHeader();
	}
	@Test
	public void checkClickOnMoreInfoAndExportPdfFile() throws IOException, InterruptedException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		reparationWindowPageObj = new ReparationWindowPage(driver);
		reparationWindowPageObj.clickOnMoreInfoAndExportPdfFile();
	}
	/*@Test
	public void verifyCompletedOrdersAddPaymentsinNewWindow() throws IOException, InterruptedException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		reparationWindowPageObj = new ReparationWindowPage(driver);
		reparationWindowPageObj.completedOrdersAddPaymentsinNewWindow();
	}*/
}
