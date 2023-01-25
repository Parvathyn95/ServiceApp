package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.PageUtility;

public class InventoryPageInfo {
	public WebDriver driver;
	public InventoryPageInfo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//a[@class='small-box-footer'])[3]")
	private WebElement inventoryPdtsMoreInfoButton;
	
	@FindBy(xpath="//table[@id='PRData']//tbody//tr[1]//td[9]//button")
	private WebElement actionDropdownButton;
	
	@FindBy(xpath="//i[@class='fa fa-print']")
	private WebElement printBarcodeOrLabelOption;
	
	@FindBy(xpath="//table[@id='bcTable']")
	private WebElement table;
	
	@FindBy(xpath="//table[@id='bcTable']//child::th")
	private WebElement tableHeaders;
	
	@FindBy(xpath="//input[@value='Update']")
	private WebElement updateButton;
	
	@FindBy(xpath="//button[@id='reset']")
	private WebElement resetButton;
	
	@FindBy(xpath="//table[@id='PRData']//tbody//child::tr")
	private WebElement particularRowElement;
	
	@FindBy(xpath="//a[@data-original-title='Print Barcode/Label']")
	private WebElement printBarcodeOrLabelButton;
	
	@FindBy(xpath="//a[@data-original-title='Edit Product']")
	private WebElement editProductButton;
	
	@FindBy(xpath="//a[@data-original-title='<b>Delete Product</b>']")
	private WebElement deleteProductButton;
	
	By headerElement = By.xpath("//table[@id='dynamic-table']//child::th");

	public void clickOnInventoryPdtMoreInfoAndFetchUrl() throws IOException {
		String actualUrl,expectedUrl;
		Assert.assertFalse(inventoryPdtsMoreInfoButton.isSelected(), "Inventory Products More Info is already selected out of scope");
		PageUtility.clickOnElement(inventoryPdtsMoreInfoButton);
		actualUrl=driver.getCurrentUrl();
		expectedUrl=ExcelUtility.getValuesFromExcel(1,0,constants.Constants.TESTDATAFILE,"InventoryProductsMoreInfo");
		Assert.assertEquals(expectedUrl, actualUrl,"Actual and expected url are not the same");
	}
	public void clickOnPrintBarcodeOrLabelAndCheckTableHeader() throws IOException {
		String actualHeader,expectedHeader;
		PageUtility.clickOnElement(inventoryPdtsMoreInfoButton);
		Assert.assertFalse(actionDropdownButton.isSelected(), "Action Dropdown Button is already selected out of scope");
		PageUtility.clickOnElement(actionDropdownButton);
		PageUtility.clickOnElement(printBarcodeOrLabelOption);
		expectedHeader=ExcelUtility.getValuesFromExcel(1,1,constants.Constants.TESTDATAFILE,"InventoryProductsMoreInfo");
		List  <WebElement> tableHeader= table.findElements(headerElement);
		for(WebElement header : tableHeader) {
			if(header.getText().equals(expectedHeader)) {
				actualHeader = header.getText();
				Assert.assertEquals(expectedHeader, actualHeader);
				break;
			}
		}
	}
	public void clickOnInventoryPdtTableElementAndInspectButtonColors() throws IOException {
		String actualPrintBarcodeOrLabelButton,expectedPrintBarcodeOrLabelButton,actualEditProductButton,expectedEditProductButton,
		actualDeleteProductButton,expectedDeleteProductButton;
		PageUtility.clickOnElement(inventoryPdtsMoreInfoButton);
		PageUtility.clickOnElement(particularRowElement);
		actualPrintBarcodeOrLabelButton=printBarcodeOrLabelButton.getCssValue("background-Color");
		expectedPrintBarcodeOrLabelButton=ExcelUtility.getValuesFromExcel(1,2,constants.Constants.TESTDATAFILE,"InventoryProductsMoreInfo");
		Assert.assertEquals(expectedPrintBarcodeOrLabelButton, actualPrintBarcodeOrLabelButton,"Actual and expected print barcode or label button are not equal");
		actualEditProductButton=editProductButton.getCssValue("background-Color");
		expectedEditProductButton=ExcelUtility.getValuesFromExcel(2,2,constants.Constants.TESTDATAFILE,"InventoryProductsMoreInfo");
		Assert.assertEquals(expectedEditProductButton, actualEditProductButton,"Actual and expected edit product button are not equal");
		actualDeleteProductButton=deleteProductButton.getCssValue("background-Color");
		expectedDeleteProductButton=ExcelUtility.getValuesFromExcel(3,2,constants.Constants.TESTDATAFILE,"InventoryProductsMoreInfo");
		Assert.assertEquals(expectedDeleteProductButton, actualDeleteProductButton,"Actual and expected delete product button are not equal");
	}		
	public void colorOfVariousButtonsInPrintBarcodeOrLabel() throws IOException {
		String actualUpdateButton,expectedUpdateButton,actualResetButton,expectedResetButton;
		PageUtility.clickOnElement(inventoryPdtsMoreInfoButton);
		Assert.assertFalse(actionDropdownButton.isSelected(), "Action Dropdown Button is already selected out of scope");
		PageUtility.clickOnElement(actionDropdownButton);
		PageUtility.clickOnElement(printBarcodeOrLabelOption);
		actualUpdateButton=updateButton.getCssValue("background-Color");
		expectedUpdateButton=ExcelUtility.getValuesFromExcel(1,3,constants.Constants.TESTDATAFILE,"InventoryProductsMoreInfo");
		Assert.assertEquals(expectedUpdateButton, actualUpdateButton,"Actual and expected update button are not equal");
		actualResetButton=resetButton.getCssValue("background-Color");
		expectedResetButton=ExcelUtility.getValuesFromExcel(2,3,constants.Constants.TESTDATAFILE,"InventoryProductsMoreInfo");
		Assert.assertEquals(expectedResetButton, actualResetButton,"Actual and expected reset button are not equal");
	}

}
