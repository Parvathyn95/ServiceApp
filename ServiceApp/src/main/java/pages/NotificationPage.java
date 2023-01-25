package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class NotificationPage {
	public WebDriver driver;
	public NotificationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@class='btn blightOrange tip']")
	private WebElement notificationIcon;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/mobile_service/panel/reports/quantity_alerts']")
	private WebElement notificationDropdown;
	
	@FindBy(xpath="//table[@id='dynamic-table']")
	private WebElement table;
	
	@FindBy(xpath="//table[@id='dynamic-table']//child::th")
	private WebElement tableHeaders;
	
	@FindBy(xpath="//div[@id='content-wrapper']//h1")
	private WebElement headerTitle;
	
	By headerElements = By.xpath("//table[@id='dynamic-table']//child::th");
	
	public void clickNotificationAndNavigateToQuantityAlerts() throws IOException {
		String actualHeader,expectedHeader;
		Assert.assertFalse(notificationIcon.isSelected(), "Notification Icon is already selected out of scope");
		PageUtility.clickOnElement(notificationIcon);
		Assert.assertFalse(notificationDropdown.isSelected(), "Notification Dropdown option is already selected out of scope");
		PageUtility.clickOnElement(notificationDropdown);
		expectedHeader=ExcelUtility.getValuesFromExcel(1,0,constants.Constants.TESTDATAFILE,"NotificationPage");
		WaitUtility.fluentVisibilityOfAllElements(driver, headerElements);
		List  <WebElement> tableHeader= table.findElements(headerElements);
		for(WebElement header : tableHeader) {
			if(header.getText().equals(expectedHeader)) {
				actualHeader = header.getText();
				Assert.assertEquals(expectedHeader, actualHeader);
				break;
			}
		}
	}
	public void clickNotificationAndQuantityAlertTitle() throws IOException {
		String actualTitle,expectedTitle;
		Assert.assertFalse(notificationIcon.isSelected(), "Notification Icon is already selected out of scope");
		PageUtility.clickOnElement(notificationIcon);
		Assert.assertFalse(notificationDropdown.isSelected(), "Notification Dropdown option is already selected out of scope");
		PageUtility.clickOnElement(notificationDropdown);
		actualTitle=headerTitle.getText();
		WaitUtility.waitForTitleContains(driver, actualTitle);
		expectedTitle=ExcelUtility.getValuesFromExcel(1,1,constants.Constants.TESTDATAFILE,"NotificationPage");
		Assert.assertEquals(actualTitle, expectedTitle,"Expected and actual title are not equal");
	}	
	
}
