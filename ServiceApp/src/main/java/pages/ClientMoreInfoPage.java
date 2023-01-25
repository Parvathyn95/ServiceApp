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
import utilities.WaitUtility;

public class ClientMoreInfoPage {
	public WebDriver driver;
	public ClientMoreInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='name1']")
	private WebElement clientNameField;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers']")
	private WebElement moreInfoButton;
	
	@FindBy(xpath="//button//span[@class='caret']")
	private WebElement actionsDropdownButton;
	
	@FindBy(xpath="((//a[@class='view_client'])[i]")
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
	
	@FindBy(xpath="//a[@data-toggle='dropdown']//child::i[@data-original-title='Actions']")
	private WebElement rightActionDropdownButton;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/customers/export_csv']")
	private WebElement exportToExcelFile;
	
	@FindBy(xpath="//table[@id='dynamic-table']")
	private WebElement table;
	
	@FindBy(xpath="//table[@id='dynamic-table']//child::th")
	private WebElement tableHeaders;
	
	By headerElements = By.xpath("//table[@id='dynamic-table']//child::th");
	
	public void clickOnViewClientInNewWindowAndModifyDetails() throws IOException {
		String actualHeader,expectedHeader;
		PageUtility.clickOnElement(moreInfoButton);
		expectedHeader=ExcelUtility.getValuesFromExcel(1,0,constants.Constants.TESTDATAFILE,"NotificationPage");
		List  <WebElement> tableHeader= table.findElements(headerElements);
		for(WebElement header : tableHeader) {
			if(header.getText().equals(expectedHeader)) {
				actualHeader = header.getText();
				Assert.assertEquals(expectedHeader, actualHeader);
				break;
			}
		}
	}	
	
	public void clickOnExportToExcelFileAndDownloadIt() throws IOException, InterruptedException {
		String actualNavPageTitle,expectedNavPageTitle;
		actualNavPageTitle=navPageHeading.getText();
		expectedNavPageTitle=ExcelUtility.getValuesFromExcel(1,1,constants.Constants.TESTDATAFILE,"AddClientMoreInfo");
		PageUtility.clickOnElement(moreInfoButton);
		Assert.assertFalse(rightActionDropdownButton.isSelected(), "Right Actions dropdown is already selected out of scope");
		PageUtility.clickOnElement(rightActionDropdownButton);
		WaitUtility.waitForElement(driver, exportToExcelFile);
		PageUtility.clickOnElement(exportToExcelFile);
		String location=ExcelUtility.getValuesFromExcel(1,2,constants.Constants.TESTDATAFILE,"AddClientMoreInfo");
		String sourceLocation = exportToExcelFile.getAttribute("href");
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
