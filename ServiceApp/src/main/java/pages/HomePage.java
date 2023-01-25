package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.ParameterUtility;
import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='small-box bg-aqua']")
	private WebElement reparationContainerBox;
	
	@FindBy(xpath="//div[@class='small-box bg-green']")
	private WebElement clientContainerBox;
	
	@FindBy(xpath="//div[@class='small-box bg-yellow']")
	private WebElement inventoryPdtContainerBox;
	
	@FindBy(xpath="//div[@class='fc-bg']//td[@data-date='2023-01-26']")
	private WebElement specificDate;
	
	@FindBy(xpath="(//h4[@class='modal-title'])[9]")
	private WebElement newWindowTitle;	
	
	@FindBy(xpath="//div[@class='modal-content']//child::input[@class='bootbox-input bootbox-input-text form-control']")
	private WebElement newWindowTextField;	
	
	@FindBy(xpath="//button[@data-bb-handler='confirm']")
	private WebElement okButton;	
	
	@FindBy(xpath="//div[@class='toast-container']//following::div[@class='toast-message']")
	private WebElement toastMessageField;	
	
	@FindBy(xpath="//div[@class='fc-content']//child::span[text()='Mobile Rebooting']")
	private WebElement mobileRebootingEvent;
	
	@FindBy(xpath="//button[@data-bb-handler='confirm']")
	private WebElement removeEventYesButton;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='subject_']")
	private WebElement subjectField;
	
	@FindBy(xpath="//textarea[@id='body_']")
	private WebElement messageField;

	@FindBy(xpath="//button[@form='send_email_form']")
	private WebElement sendEmailButton;

	@FindBy(xpath="//li[@class='parsley-required']")
	private WebElement validationMessage;
	
	@FindBy(xpath="//li[@class='parsley-type']")
	private WebElement invalidMailValidationMessage;
	
	public void getColorOfThreeContainerBoxes() throws IOException {
		String actualReparationColor,expectedReparationColor,actualClientColor,expectedClientColor,actualInventoryPdtColor,expectedInventoryPdtColor;
		actualReparationColor=reparationContainerBox.getCssValue("background-color");
		expectedReparationColor=ExcelUtility.getValuesFromExcel(1,1,constants.Constants.TESTDATAFILE,"HomePage");
		Assert.assertEquals(expectedReparationColor, actualReparationColor,"Actual and expected color of Reparation box are not equal");
		actualClientColor=clientContainerBox.getCssValue("background-color");
		expectedClientColor=ExcelUtility.getValuesFromExcel(1,2,constants.Constants.TESTDATAFILE,"HomePage");
		Assert.assertEquals(expectedClientColor, actualClientColor,"Actual and expected color of Client box are not equal");
		actualInventoryPdtColor=inventoryPdtContainerBox.getCssValue("background-color");
		expectedInventoryPdtColor=ExcelUtility.getValuesFromExcel(1,3,constants.Constants.TESTDATAFILE,"HomePage");
		Assert.assertEquals(expectedInventoryPdtColor, actualInventoryPdtColor,"Actual and expected color of Inventory Products box are not equal");
	}	
	
	public void clickOnDateCalenderAddEventIfAddedOrNot() throws IOException {
		String actualToastMessage,expectedToastMessage;
		Assert.assertFalse(specificDate.isSelected(), "Specific date in date calendar is already selected out of scope");
		PageUtility.clickOnElement(specificDate, driver);
		PageUtility.enterText(newWindowTextField,"Mobile Rebooting");
		PageUtility.clickOnElement(okButton);
		actualToastMessage=toastMessageField.getText();
		expectedToastMessage=ExcelUtility.getValuesFromExcel(1,4,constants.Constants.TESTDATAFILE,"HomePage");
		Assert.assertEquals(expectedToastMessage, actualToastMessage,"Expected and actual toast messages are not equal");
	}
	
	public void clickOnDateCalenderEventAndDeleteIt() throws IOException {
		String actualToastMessage,expectedToastMessage;
		Assert.assertFalse(mobileRebootingEvent.isSelected(), "Mobile Rebooting Entry is already selected out of scope");
		PageUtility.clickOnElement(mobileRebootingEvent);
		PageUtility.clickOnElement(removeEventYesButton);
		WaitUtility.waitForVisibilityOfWebelement(driver, toastMessageField);
		actualToastMessage=toastMessageField.getText();
		expectedToastMessage=ExcelUtility.getValuesFromExcel(1,5,constants.Constants.TESTDATAFILE,"HomePage");
		Assert.assertEquals(expectedToastMessage, actualToastMessage,"Expected and actual toast messages are not equal");
	}	
	
	public void enterAnyTwoFieldsOfQuickEmailAndSend(String mailid,String subject) throws IOException {
		String actualValidationMessage,expectedValidationMessage;
		PageUtility.enterText(emailField, mailid);
		PageUtility.enterText(subjectField, subject);
		PageUtility.clickOnElement(messageField);
		Assert.assertFalse(sendEmailButton.isSelected(), "Send Email button is already selected out of scope");
		PageUtility.clickOnElement(sendEmailButton);
		actualValidationMessage=validationMessage.getText();
		expectedValidationMessage=ExcelUtility.getValuesFromExcel(1,6,constants.Constants.TESTDATAFILE,"HomePage");
		Assert.assertEquals(expectedValidationMessage, actualValidationMessage,"Expected and actual validation messages are not equal");
	}	
	
	public void enterAnInvalidMailIdDetailsAndSend(String mailid,String subject,String message) throws IOException {
		String actualInvalidMailValidationMessage,expectedInvalidMailValidationMessage;
		ParameterUtility.sendKeyValue(driver, emailField, mailid);
		ParameterUtility.sendKeyValue(driver, subjectField, subject);
		ParameterUtility.sendKeyValue(driver, messageField, message);
		Assert.assertFalse(sendEmailButton.isSelected(), "Send Email button is already selected out of scope");
		PageUtility.clickOnElement(sendEmailButton);
		actualInvalidMailValidationMessage=invalidMailValidationMessage.getText();
		expectedInvalidMailValidationMessage=ExcelUtility.getValuesFromExcel(2,6,constants.Constants.TESTDATAFILE,"HomePage");
		Assert.assertEquals(expectedInvalidMailValidationMessage, actualInvalidMailValidationMessage,"Expected and actual invalid mail validation messages are not equal");
	}	
	
}
