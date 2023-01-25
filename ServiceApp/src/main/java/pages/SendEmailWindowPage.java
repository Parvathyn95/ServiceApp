package pages;

	import java.io.IOException;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.ParameterUtility;

	public class SendEmailWindowPage {
		public WebDriver driver;
		public SendEmailWindowPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//input[@name='identity']")
		private WebElement userNameField;
		
		@FindBy(xpath="//input[@name='password']")
		private WebElement passwordField;
		
		@FindBy(xpath="//div[@class='icheckbox_square-blue']")
		private WebElement rememberMeCheckBox;
		
		@FindBy(xpath="//input[@value='Login']")
		private WebElement loginButton;
		
		@FindBy(xpath="//li[@class='dropdown item-more']//a[@class='dropdown-toggle']")
		private WebElement moreItemsButton;
		
		@FindBy(xpath="//span[@class='fa fa-paper-plane icon']")
		private WebElement sendEmailIcon;
		
		@FindBy(name="email_to[]")
		private WebElement multipleNameField;
		
		@FindBy(xpath="(//input[@placeholder='Subject'])[2]")
		private WebElement subjectField;
		
		@FindBy(xpath="//textarea[@id='sms_body']")
		private WebElement messageField;
		
		@FindBy(xpath="//button[@form='sendEmail']")
		private WebElement sendEmailSaveButton;
		
		@FindBy(xpath="//div[@class='toast-message']")
		private WebElement toastTitleAlertBox;
		
		@FindBy(xpath="//div[@id='sendEmailModal']//following::h5[@id='exampleModalLabel']")
		private WebElement 	exampleModalLabel;
		
		public void selectMultipleNamesSubjectNoMessageAndSend() throws IOException {
			String userName, password,message,actualTitle,expectedTitle;
			message=ExcelUtility.getValuesFromExcel(1,1,constants.Constants.TESTDATAFILE,"SendEmailWindowPage");
			PageUtility.clickOnElement(moreItemsButton);
			Assert.assertFalse(sendEmailIcon.isSelected(), "Send SMS Icon is already selected");
			PageUtility.clickOnElement(sendEmailIcon);
			Select optName = new Select(multipleNameField);
			optName.isMultiple();
			optName.selectByVisibleText("Lekshmi");
			optName.selectByVisibleText("Samuel George");
			PageUtility.clickOnElement(subjectField);
			PageUtility.enterText(subjectField, "Mobile repair");
			PageUtility.clickOnElement(sendEmailSaveButton);
			actualTitle=exampleModalLabel.getText();
			expectedTitle=ExcelUtility.getValuesFromExcel(1,0,constants.Constants.TESTDATAFILE,"SendEmailWindowPage");
			Assert.assertEquals(expectedTitle, actualTitle,"Actual and expected title are not the same");
		}
}


