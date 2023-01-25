package pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ReparationWindowPage {
	public WebDriver driver;
	public ReparationWindowPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//li[@class='dropdown item-more']//a[@class='dropdown-toggle']")
	private WebElement moreItemsButton;
	
	@FindBy(xpath="//a[@class='add_reparation']")
	private WebElement addReparationButton;
	
	@FindBy(xpath="//input[@id='imei']")
	private WebElement imeiField;
	
	@FindBy(xpath="//select[@id='client_name']")
	private WebElement selectClientField;
	
	@FindBy(xpath="//select[@id='assigned_to']")
	private WebElement selectAssignedToField;
		
	@FindBy(xpath="//input[@id='reparation_manufacturer']")
	private WebElement manufacturerField;
	
	@FindBy(xpath="//input[@id='reparation_model']")
	private WebElement modelField; 
	
	@FindBy(xpath="//input[@id='category']")
	private WebElement categoryField;
	
	@FindBy(xpath="//input[@id='add_item']")
	private WebElement addItemField;
	
	@FindBy(xpath="//input[@id='defect']")
	private WebElement defectField;
	
	@FindBy(xpath="//input[@id='warranty_card_number']")
	private WebElement warrantyCardNumberField;
	
	@FindBy(xpath="//input[@id='service_charges']")
	private WebElement serviceChargesField;
	
	@FindBy(xpath="//textarea[@id='comment']")
	private WebElement commentField;
	
	@FindBy(xpath="//button[@id='repair_submit']")
	private WebElement addReparationSaveButton;
	
	@FindBy(xpath="//li[@class='parsley-required']")
	private WebElement validationMessageField;
	
	@FindBy(xpath="//button[@id='upload_modal_btn']")
	private WebElement uploadButton;
	
	@FindBy(xpath="(//span[@class='hidden-xs'])[5]")
	private WebElement browseButton;
	
	@FindBy(xpath="//input[@class='file-caption-name']")
	private WebElement fileCaptionField;
	
	@FindBy(xpath="(//span[@style='padding:6px 12px;width:auto;'])[1]")
	private WebElement sendAnAutomaticTxtButton;
	
	@FindBy(xpath="(//span[@style='padding:6px 12px;width:auto;'])[2]")
	private WebElement sendEmailButton;
	
	@FindBy(xpath="//button[@id='sign_repair']")
	private WebElement signRepairButton;
	
	@FindBy(xpath="//h4[@id='titReparation']")
	private WebElement reparationTitle;
	
	@FindBy(xpath="//div[@id='print_button']")
	private WebElement printButton;
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reparation']")
	private WebElement moreInfoButton;
	
	@FindBy(xpath="//td[@style='vertical-align: inherit;']//button[@data-toggle='dropdown']")
	private WebElement actionsDropdownButton;
	
	@FindBy(xpath="//a[@href='#view_reparation']")
	private WebElement viewReparationOption;

	@FindBy(xpath="//li[@class='time-label']//child::span[@class='bg-red']")
	private WebElement statusTimeline;
	
	@FindBy(xpath="//a[text()=' Print Barcode']")
	private WebElement printBarcodeOption;
	
	@FindBy(xpath="//table[@id='bcTable']")
	private WebElement table;
	
	@FindBy(xpath="//table[@id='bcTable']//child::th")
	private WebElement tableHeaders;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reparation/export/0/1?']")
	private WebElement exportToPdfFile;
	
	@FindBy(xpath="//a[@href='#CompletedRepairs']")
	private WebElement completedRepairsField;
	
/*	@FindBy(xpath="(//button[@data-toggle='dropdown'])[2]")
	private WebElement actionDropdown;*/
	
	@FindBy(xpath="(//a[@data-target='#myModal'])[4]")
	private WebElement addPayment;
	
	@FindBy(xpath="//input[@id='amount_1']")
	private WebElement amountField;
	
	@FindBy(xpath="//select[@id='paid_by_1']")
	private WebElement selectPayingBy;
	
	@FindBy(xpath="//input[@name='add_payment']")
	private WebElement addPaymentButton;
	
	@FindBy(xpath="//table[@id='dynamic-table-completed']//tbody//child::tr[2]//td[15]")
	private WebElement paymentTableEntry;
	
	By headerElements = By.xpath("//table[@id='bcTable']//child::th");
	
	
	public void enterSomeReparationDetailsAndAddReparation(String imei,String category, String addItem,String defect,String warrantyCardNumber,String comment) throws IOException {
		String expectedValidationMessage, actualValidationMessage;
		PageUtility.clickOnElement(moreItemsButton);
		Assert.assertFalse(addReparationButton.isSelected(), "Add Client Button is already selected out of scope");
		PageUtility.clickOnElement(addReparationButton);
		PageUtility.enterText(imeiField,imei);
		PageUtility.enterText(categoryField,category);
		PageUtility.enterText(defectField, defect);
		PageUtility.enterText(addItemField, addItem);
		PageUtility.enterText(warrantyCardNumberField, warrantyCardNumber);
		PageUtility.enterText(commentField, comment);
		PageUtility.clickOnElement(addReparationSaveButton);
		actualValidationMessage=validationMessageField.getText();
		expectedValidationMessage=ExcelUtility.getValuesFromExcel(1,0,constants.Constants.TESTDATAFILE,"AddReparationWindowPage");
		Assert.assertEquals(expectedValidationMessage, actualValidationMessage,"Actual and expected validation messages are not equal");		
	}	
	public void getColorOfTheButtonsOfAddReparation() throws IOException {
		String actualuploadButtonColor,expecteduploadButtonColor,actualSendAnAutomaticTxtButtonColor,expectedSendAnAutomaticTxtButtonColor,actualSendEmailButtonColor,expectedSendEmailButtonColor,
		actualSignRepairButtonColor,expectedSignRepairButtonColor;
		PageUtility.clickOnElement(moreItemsButton);
		Assert.assertFalse(addReparationButton.isSelected(), "Add Reparation Button is already selected out of scope");
		PageUtility.clickOnElement(addReparationButton);
		actualuploadButtonColor=uploadButton.getCssValue("background-color");
		expecteduploadButtonColor=ExcelUtility.getValuesFromExcel(1,3,constants.Constants.TESTDATAFILE,"AddReparationWindowPage");
		Assert.assertEquals(expecteduploadButtonColor, actualuploadButtonColor,"Actual and expected color of upload button are not the same");
		actualSendAnAutomaticTxtButtonColor=sendAnAutomaticTxtButton.getCssValue("background-color");
		expectedSendAnAutomaticTxtButtonColor=ExcelUtility.getValuesFromExcel(2,3,constants.Constants.TESTDATAFILE,"AddReparationWindowPage");
		Assert.assertEquals(expectedSendAnAutomaticTxtButtonColor, actualSendAnAutomaticTxtButtonColor,"Actual and expected color of send an automatic txt button are not the same");
		actualSendEmailButtonColor=sendEmailButton.getCssValue("background-color");
		expectedSendEmailButtonColor=ExcelUtility.getValuesFromExcel(3,3,constants.Constants.TESTDATAFILE,"AddReparationWindowPage");
		Assert.assertEquals(expectedSendEmailButtonColor, actualSendEmailButtonColor,"Actual and expected color of send email button are not the same");
		actualSignRepairButtonColor=signRepairButton.getCssValue("background-color");
		expectedSignRepairButtonColor=ExcelUtility.getValuesFromExcel(4,3,constants.Constants.TESTDATAFILE,"AddReparationWindowPage");
		Assert.assertEquals(expectedSignRepairButtonColor, actualSignRepairButtonColor,"Actual and expected color of sign repair button are not the same");
	}	
	public void enterMandatoryDetailsAddReparationReportGenerated(String imei,String manufacturer, String defect,String model,String warrantyCardNumber,String serviceCharges) throws IOException {
		String actualTitle, expectedTitle;
		PageUtility.clickOnElement(moreItemsButton);
		Assert.assertFalse(addReparationButton.isSelected(), "Add Client Button is already selected out of scope");
		PageUtility.clickOnElement(addReparationButton);
        actualTitle=driver.getTitle();
        expectedTitle=ExcelUtility.getValuesFromExcel(1,2,constants.Constants.TESTDATAFILE,"AddReparationWindowPage");
        Assert.assertEquals(expectedTitle, actualTitle,"Expected and actual title are not equal");
		PageUtility.enterText(imeiField,imei);
		PageUtility.selectDropdownbyText(selectClientField, "kiran1 kmn - k");
		PageUtility.selectDropdownbyText(selectAssignedToField, "Joe Jacobs");
		PageUtility.enterText(manufacturerField,manufacturer);
		PageUtility.enterText(modelField, model);
		PageUtility.enterText(defectField, defect);
		PageUtility.enterText(warrantyCardNumberField, warrantyCardNumber);
		PageUtility.enterText(serviceChargesField, serviceCharges);
		PageUtility.clickOnElement(addReparationSaveButton);
		String MainWindow=driver.getWindowHandle();
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		while(i1.hasNext())			
		 	{		
		     String ChildWindow=i1.next();		
		        if(!MainWindow.equalsIgnoreCase(ChildWindow))			
		            {    		
		              driver.switchTo().window(ChildWindow);
		            }
		       }
			   driver.close(); 
			   driver.switchTo().window(MainWindow);		
		}
	public void clickOnViewReparationInNewWindow() throws IOException {
		String actualstatusTimelineColor,expectedstatusTimelineColor;
		PageUtility.clickOnElement(moreInfoButton);
		Assert.assertFalse(actionsDropdownButton.isSelected(), "Actions dropdown is already selected out of scope");
		WaitUtility.waitForVisibilityOfWebelement(driver, actionsDropdownButton);
		PageUtility.clickOnElement(actionsDropdownButton);
		PageUtility.clickOnElement(viewReparationOption);
		WaitUtility.waitForVisibilityOfWebelement(driver, viewReparationOption);
		actualstatusTimelineColor=statusTimeline.getCssValue("background-color");
		expectedstatusTimelineColor=ExcelUtility.getValuesFromExcel(1,0,constants.Constants.TESTDATAFILE,"AddReparationMoreInfoPage");
		Assert.assertEquals(expectedstatusTimelineColor, actualstatusTimelineColor,"Actual and expected color of status timeline are not the same");
	}	
	public void clickOnPrintBarcodeInNewWindowCheckHeader() throws IOException {
		String actualHeader,expectedHeader;
		PageUtility.clickOnElement(moreInfoButton);
		Assert.assertFalse(actionsDropdownButton.isSelected(), "Actions dropdown is already selected out of scope");
		WaitUtility.waitForVisibilityOfWebelement(driver, actionsDropdownButton);
		PageUtility.clickOnElement(actionsDropdownButton);
		PageUtility.clickOnElement(printBarcodeOption);
		expectedHeader=ExcelUtility.getValuesFromExcel(1,1,constants.Constants.TESTDATAFILE,"AddReparationMoreInfoPage");
		List  <WebElement> tableHeader= table.findElements(headerElements);
		for(WebElement header : tableHeader) {
			if(header.getText().equals(expectedHeader)) {
				actualHeader = header.getText();
				Assert.assertEquals(expectedHeader, actualHeader);
				break;
			}
		}
	}
	public void clickOnMoreInfoAndExportPdfFile() throws IOException, InterruptedException {
		String actualstatusTimelineColor,expectedstatusTimelineColor;
		PageUtility.clickOnElement(moreInfoButton);
		String location=ExcelUtility.getValuesFromExcel(1,2,constants.Constants.TESTDATAFILE,"AddReparationMoreInfoPage");
		String sourceLocation = exportToPdfFile.getAttribute("href");
		String wget_command = location + sourceLocation;
		try {
	        Process exec = Runtime.getRuntime().exec(wget_command);
	        int exitVal = exec.waitFor();
	        System.out.println("Exit value: " + exitVal);
	        } catch (IOException ex) {
	        System.out.println(ex.toString());
	        }
		}
		
	}
	

