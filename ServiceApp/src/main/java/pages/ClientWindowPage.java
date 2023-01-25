package pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.ParameterUtility;
import utilities.WaitUtility;

public class ClientWindowPage {
	public WebDriver driver;
	public ClientWindowPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='dropdown item-more']//a[@class='dropdown-toggle']")
	private WebElement moreItemsButton;
	
	@FindBy(xpath="//a[@class='add_c']")
	private WebElement addClientButton;
	
	@FindBy(xpath="//input[@id='name1']")
	private WebElement clientNameField;
	
	@FindBy(xpath="//input[@id='company1']")
	private WebElement companyField;
	
	@FindBy(xpath="//input[@id='autocomplete']")
	private WebElement geoLocateField;
	
	@FindBy(xpath="//input[@id='route']")
	private WebElement addressField;
	
	@FindBy(xpath="//input[@id='locality']")
	private WebElement cityField;
	
	@FindBy(xpath="//input[@id='postal_code']")
	private WebElement postalCodeField;
	
	@FindBy(xpath="//input[@id='telephone']")
	private WebElement telephoneField;
	
	@FindBy(xpath="//input[@id='email1']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='vat1']")
	private WebElement vatField;
	
	@FindBy(xpath="//input[@id='cf1']")
	private WebElement ssnField;
	
	@FindBy(xpath="//input[@id='image']")
	private WebElement browseButton;
	
	@FindBy(xpath="//input[@class='file-caption-name']")
	private WebElement selectFileField;
	
	@FindBy(xpath="//textarea[@id='comment1']")
	private WebElement commentField;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement addClientSaveButton;
	
	@FindBy(xpath="(//button[text()='×'])[6]")
	private WebElement closeButton;		
			
	@FindBy(xpath="//button[@id='modify_client']")
	private WebElement modifyButton;
	
	@FindBy(xpath="//button[@id='submit']")
	private WebElement saveChangesClientButton;
	
	@FindBy(xpath="//div[@class='toast-title']")
	private WebElement toastTitleAlertBox;
	
	@FindBy(xpath="//li[@class='parsley-required']")
	private WebElement validationMessageField;

	@FindBy(xpath="(//button[@data-dismiss='modal'])[9]")
	private WebElement goBackButton;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers']")
	private WebElement moreInfoButton;
	
	@FindBy(xpath="(//button[@data-toggle='dropdown'])[1]")
	private WebElement actionsDropdownButton;
	
	@FindBy(xpath="(//a[@class='view_client']")
	private WebElement viewClientOption;
	
	@FindBy(xpath="//a[@id='modify_client']")
	private WebElement modifyClientButton;
	
	@FindBy(xpath="//button[@form='client_form']")
	private WebElement saveChangesClient;
	
	@FindBy(xpath="//div[@class='toast-title']")
	private WebElement toastMessageField;
	
	@FindBy(xpath="//img[@src='https://qalegend.com/mobile_service/assets/uploads/images/7889113d65ddf1c52d95adf4eb7ab31e.jpeg']")
	private WebElement imageWindow;
	
	@FindBy(xpath="//div[@id='content-wrapper']//h1")
	private WebElement navPageHeading;
	
	@FindBy(xpath="//i[@data-original-title='Actions']")
	private WebElement rightActionDropdownButton;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers/export_csv']")
	private WebElement exportToExcelFile;
			
	public void enterClientDetailsAndAddClient(String clientName,String company,String geoLocation,String address,String city,String postalCode,
				String telephone,String email,String vat,String ssn,String comment) throws IOException {
		String actualToastTitleAlert,expectedToastTitleAlert,argument,uploadFile;
        argument=ExcelUtility.getValuesFromExcel(1,3,constants.Constants.TESTDATAFILE,"AddClientWindowPage");
        uploadFile=ExcelUtility.getValuesFromExcel(1,4,constants.Constants.TESTDATAFILE,"AddClientWindowPage");
        PageUtility.clickOnElement(moreItemsButton);
		Assert.assertFalse(addClientButton.isSelected(), "Add Client Button is already selected out of scope");
		PageUtility.clickOnElement(addClientButton);
		PageUtility.enterText(clientNameField,clientName);
		PageUtility.enterText(companyField,company);
		PageUtility.enterText(geoLocateField,geoLocation);
		PageUtility.enterText(addressField, address);
		PageUtility.enterText(cityField, city);
		PageUtility.enterText(postalCodeField, postalCode);
		PageUtility.enterText(telephoneField, telephone);
		PageUtility.enterText(emailField, email);
		PageUtility.enterText(vatField, "CG87OJ74");
		PageUtility.enterText(ssnField, ssn);
		PageUtility.scrollDown(driver, argument);
		PageUtility.clickOnElement(browseButton, driver);
		Runtime.getRuntime().exec(uploadFile);
		PageUtility.enterText(commentField, comment);
		PageUtility.clickOnElement(addClientSaveButton);
		actualToastTitleAlert=toastTitleAlertBox.getText();
		expectedToastTitleAlert=ExcelUtility.getValuesFromExcel(1,0,constants.Constants.TESTDATAFILE,"AddClientWindowPage");
		Assert.assertEquals(expectedToastTitleAlert, actualToastTitleAlert,"Actual and expected toast title are not the same");
				
	}
	public void enterClientDetailsWithoutNameAndAddClient(String company,String geoLocation,String address,String city, String postalCode,
		String telephone, String email,String vat,String ssn,String comment) throws IOException {
		String expectedValidationMessage, actualValidationMessage;
		PageUtility.clickOnElement(moreItemsButton);
		Assert.assertFalse(addClientButton.isSelected(), "Add Client Button is already selected out of scope");
		PageUtility.clickOnElement(addClientButton);
		PageUtility.enterText(companyField,company);
		PageUtility.enterText(geoLocateField,geoLocation);
		PageUtility.enterText(addressField, address);
		PageUtility.enterText(cityField, city);
		PageUtility.enterText(postalCodeField, postalCode);
		PageUtility.enterText(telephoneField, telephone);
		PageUtility.enterText(emailField, email);
		PageUtility.enterText(vatField, vat);
		PageUtility.enterText(ssnField, ssn);
		PageUtility.enterText(commentField, comment);
		PageUtility.clickOnElement(addClientSaveButton);
		actualValidationMessage=validationMessageField.getText();
		expectedValidationMessage=ExcelUtility.getValuesFromExcel(1,1,constants.Constants.TESTDATAFILE,"AddClientWindowPage");
		Assert.assertEquals(expectedValidationMessage, actualValidationMessage,"Actual and expected validation messages are not equal");		
	}
	public void colorOfTheVariousButtonsOfAddClientForm() throws IOException {
		String actualBrowseButtonColor,expectedBrowseButtonColor,actualAddClientSaveButton,expectedAddClientSaveButton,
		actualGoBackButtonColor,expectedGoBackButtonColor;
		PageUtility.clickOnElement(moreItemsButton);
		Assert.assertFalse(addClientButton.isSelected(), "Add Client Button is already selected out of scope");
		PageUtility.clickOnElement(addClientButton);
		Assert.assertFalse(addClientButton.isSelected(), "Add Client Button is already selected out of scope");
		actualBrowseButtonColor=browseButton.getCssValue("background-color");
		expectedBrowseButtonColor=ExcelUtility.getValuesFromExcel(1,2,constants.Constants.TESTDATAFILE,"AddClientWindowPage");
		Assert.assertEquals(expectedBrowseButtonColor, actualBrowseButtonColor,"Actual and expected browse button are not equal");		
		actualAddClientSaveButton=addClientSaveButton.getCssValue("background-color");	
		expectedAddClientSaveButton=ExcelUtility.getValuesFromExcel(2,2,constants.Constants.TESTDATAFILE,"AddClientWindowPage");
		Assert.assertEquals(expectedAddClientSaveButton, actualAddClientSaveButton,"Actual and expected Add Clients Save button are not equal");
		actualGoBackButtonColor=goBackButton.getCssValue("background-color");	
		expectedGoBackButtonColor=ExcelUtility.getValuesFromExcel(3,2,constants.Constants.TESTDATAFILE,"AddClientWindowPage");
		Assert.assertEquals(expectedGoBackButtonColor, actualGoBackButtonColor,"Actual and expected Go Back button are not equal");
	}
}
