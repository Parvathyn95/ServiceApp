package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import utilities.PageUtility;
import utilities.ParameterUtility;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
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
	
	@FindBy(xpath="//div[@id='infoMessage']//child::p")
	private WebElement infoMessageField;
	
	@FindBy(xpath="//div[@id='infoMessage']//child::p[2]")
	private WebElement infoMessageField1;
	
	@FindBy(xpath="//li[@class='dropdown item-more']//a")
	private WebElement profileIcon;
	
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement signOutButton;
	
	@FindBy(xpath="//a[text()='Forgot your password?']")
	private WebElement forgotPasswordLink;

	@FindBy(xpath="//input[@name='identity']")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath="//div[@id='infoMessage']//p")
	private WebElement invalidMsgButton;
	
	
	public void enterUsernameAndPassword() throws IOException {
		String userName, password,actualUrl,expectedUrl;
		userName = ExcelUtility.getValuesFromExcel(1,1,constants.Constants.TESTDATAFILE,"Login Page");
		password = ExcelUtility.getValuesFromExcel(1,2,constants.Constants.TESTDATAFILE,"Login Page");
		PageUtility.enterText(userNameField, userName);
		PageUtility.enterText(passwordField, password);
		Assert.assertFalse(rememberMeCheckBox.isSelected(), "Remember Me check box is selected out of scope");
		PageUtility.clickOnElement(rememberMeCheckBox);
		Assert.assertFalse(loginButton.isSelected(), "Login button is selected out of scope");	
		PageUtility.clickOnElement(loginButton);
		actualUrl=driver.getCurrentUrl();
		expectedUrl=ExcelUtility.getValuesFromExcel(1,3,constants.Constants.TESTDATAFILE,"Login Page");
		Assert.assertEquals(expectedUrl, actualUrl,"Actual and expected url are not the same");
	}
	
	public void enterUsernameAndRememberCheckBoxOnly(String userName) throws IOException {
		String actualMessage,expectedMessage;
		ParameterUtility.sendKeyValue(driver, userNameField, userName);
		Assert.assertFalse(rememberMeCheckBox.isSelected(), "Remember Me check box is selected out of scope");
		PageUtility.clickOnElement(rememberMeCheckBox);
		Assert.assertFalse(loginButton.isSelected(), "Login button is selected out of scope");	
		PageUtility.clickOnElement(loginButton);
		actualMessage = infoMessageField.getText();
		expectedMessage = ExcelUtility.getValuesFromExcel(1,0,constants.Constants.TESTDATAFILE,"Login Page");
		Assert.assertEquals(expectedMessage, actualMessage,"Actual and expected validation messages are the same");
	}
	
	public void enterPasswordAndRememberCheckBoxOnly() throws IOException {
		String actualMessage,expectedMessage;
		String password = ExcelUtility.getValuesFromExcel(1,2,constants.Constants.TESTDATAFILE,"Login Page");
		PageUtility.enterText(passwordField, password);
		Assert.assertFalse(rememberMeCheckBox.isSelected(), "Remember Me check box is selected out of scope");
		PageUtility.clickOnElement(rememberMeCheckBox);
		Assert.assertFalse(loginButton.isSelected(), "Login button is selected out of scope");
		PageUtility.clickOnElement(loginButton);
		actualMessage = infoMessageField.getText();
		expectedMessage = ExcelUtility.getValuesFromExcel(2,0,constants.Constants.TESTDATAFILE,"Login Page");
		Assert.assertEquals(expectedMessage, actualMessage,"Actual and expected validation messages are the same");
	}
	
	public void clickRememberCheckBoxOnly() throws IOException {
		String actualMessage,actualMessage1,actualMessage2,expectedMessage;
		Assert.assertFalse(rememberMeCheckBox.isSelected(), "Remember Me check box is selected out of scope");
		PageUtility.clickOnElement(rememberMeCheckBox);
		Assert.assertFalse(loginButton.isSelected(), "Login button is selected out of scope");	
		PageUtility.clickOnElement(loginButton);
		actualMessage1 = infoMessageField.getText();
		actualMessage2 = infoMessageField1.getText();
		actualMessage = actualMessage1 + actualMessage2;
		expectedMessage = ExcelUtility.getValuesFromExcel(3,0,constants.Constants.TESTDATAFILE,"Login Page");
		Assert.assertEquals(expectedMessage, actualMessage,"Actual and expected validation messages are the same");
	}
	
	public void clickForgotPassword() throws IOException {
		String actualUrl,expectedUrl,actualInfoMessage,expectedInfoMessage;
		Assert.assertFalse(forgotPasswordLink.isSelected(), "Forgot Password link is selected out of scope");
		PageUtility.clickOnElement(forgotPasswordLink);
		actualUrl=driver.getCurrentUrl();
		expectedUrl = ExcelUtility.getValuesFromExcel(1,4,constants.Constants.TESTDATAFILE,"Login Page");
		Assert.assertEquals(expectedUrl, actualUrl,"Actual and expected url are not equal");
		PageUtility.enterText(emailField, "parvathyn@rocketmail.com");
		PageUtility.clickOnElement(submitButton);
		actualInfoMessage=invalidMsgButton.getText();
		expectedInfoMessage=ExcelUtility.getValuesFromExcel(1,5,constants.Constants.TESTDATAFILE,"Login Page");
		Assert.assertEquals(expectedUrl, actualUrl,"Actual and expected info messages are not equal");	
	}
}