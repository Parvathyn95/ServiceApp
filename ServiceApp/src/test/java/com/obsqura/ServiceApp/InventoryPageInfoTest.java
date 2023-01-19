package com.obsqura.ServiceApp;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.InventoryPageInfo;
import pages.LoginPage;


public class InventoryPageInfoTest extends Base{
	LoginPage loginPageObj;
	InventoryPageInfo inventoryPageInfoObj;
	@Test
	public void verifyClickOnInventoryPdtMoreInfoAndFetchUrl() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		inventoryPageInfoObj = new InventoryPageInfo(driver);
		inventoryPageInfoObj.clickOnInventoryPdtMoreInfoAndFetchUrl();	
	}
	@Test
	public void verifyAndClickOnPrintBarcodeOrLabelAndGetAlertDescription() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		inventoryPageInfoObj = new InventoryPageInfo(driver);
		inventoryPageInfoObj.clickOnPrintBarcodeOrLabelAndCheckTableHeader();	
	}
	@Test
	public void checkAndClickOnInventoryPdtTableElementAndInspectButtonColors() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		inventoryPageInfoObj = new InventoryPageInfo(driver);
		inventoryPageInfoObj.clickOnInventoryPdtTableElementAndInspectButtonColors();	
	}
	@Test
	public void checkColorOfVariousButtonsInPrintBarcodeOrLabel() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		inventoryPageInfoObj = new InventoryPageInfo(driver);
		inventoryPageInfoObj.colorOfVariousButtonsInPrintBarcodeOrLabel();	
	}
}
