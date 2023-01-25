package com.obsqura.ServiceApp;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.ReparationWindowPage;
import utilities.DataProviderUtility;
import pages.LoginPage;

public class ReparationWindowPageTest extends Base {
	LoginPage loginPageObj;
	ReparationWindowPage reparationWindowPageObj;
	@Test(priority=5)
	@Parameters({"imei","category","addItem","defect","warrantyCardNumber","comment"})
	public void verifyAndEnterSomeReparationDetailseAndAddReparation(String imei,String category, String addItem,String defect,String warrantyCardNumber,String comment) throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		reparationWindowPageObj = new ReparationWindowPage(driver);
		reparationWindowPageObj.enterSomeReparationDetailsAndAddReparation(imei,category, addItem,defect, warrantyCardNumber,comment);
	}
	@Test(priority=2)
	public void verifyGetColorOfTheButtonsOfAddReparation() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		reparationWindowPageObj = new ReparationWindowPage(driver);
		reparationWindowPageObj.getColorOfTheButtonsOfAddReparation();
	}
	@Test(priority=0,dataProvider="formData4",dataProviderClass=DataProviderUtility.class)
	public void verifyAndEnterMandatoryDetailsAddReparationReportGenerated(String imei,String manufacturer, String defect,String model,String warrantyCardNumber,String serviceCharges) throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		reparationWindowPageObj = new ReparationWindowPage(driver);
		reparationWindowPageObj.enterMandatoryDetailsAddReparationReportGenerated(imei, manufacturer, defect, model,warrantyCardNumber,serviceCharges);
	}
	@Test(priority=4)
	public void verifyClickOnViewReparationInNewWindow() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		reparationWindowPageObj = new ReparationWindowPage(driver);
		reparationWindowPageObj.clickOnViewReparationInNewWindow();
	}
	@Test(priority=3)
	public void verifyClickOnPrintBarcodeInNewWindowCheckHeader() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		reparationWindowPageObj = new ReparationWindowPage(driver);
		reparationWindowPageObj.clickOnPrintBarcodeInNewWindowCheckHeader();
	}
	@Test(priority=1)
	public void checkClickOnMoreInfoAndExportPdfFile() throws IOException, InterruptedException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		reparationWindowPageObj = new ReparationWindowPage(driver);
		reparationWindowPageObj.clickOnMoreInfoAndExportPdfFile();
	}
}
