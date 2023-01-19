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

public class SendSMSWindowPage {
	public WebDriver driver;
	public SendSMSWindowPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='dropdown item-more']//a[@class='dropdown-toggle']")
	private WebElement moreItemsButton;
	
	@FindBy(xpath="//span[@class='fa fa-comment icon']")
	private WebElement sendSMSIcon;
	
	@FindBy(id="client_id_sms")
	private WebElement nameDropdown;
	
	@FindBy(xpath="(//textarea[@placeholder='Message'])[2]")
	private WebElement messageField;
	
	@FindBy(xpath="//button[@form='SendSMS']")
	private WebElement sendSMSSaveButton;
	
	@FindBy(xpath="//div[@class='toast-message']")
	private WebElement toastTitleAlertBox;
	
	public void selectNameEnterMessageAndSend() throws IOException {
		String message="Simple Selfie Issue To be rectified",actualToastTitleAlert,expectedToastTitleAlert;
		PageUtility.clickOnElement(moreItemsButton);
		Assert.assertFalse(sendSMSIcon.isSelected(), "Send SMS Icon is already selected out of scope");
		PageUtility.clickOnElement(sendSMSIcon);
		PageUtility.selectDropdownbyText(nameDropdown, "Lekshmi");
		PageUtility.enterText(messageField, message);
		PageUtility.clickOnElement(sendSMSSaveButton);
		actualToastTitleAlert=toastTitleAlertBox.getText();
		expectedToastTitleAlert=ExcelUtility.getValuesFromExcel(1,0,constants.Constants.TESTDATAFILE,"SendSMSWindowPage");
		Assert.assertEquals(expectedToastTitleAlert, actualToastTitleAlert,"Actual and expected toast alert are not the same");
	}	
}
