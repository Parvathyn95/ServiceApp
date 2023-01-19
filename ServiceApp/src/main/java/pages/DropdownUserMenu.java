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

public class DropdownUserMenu {
	public WebDriver driver;
	public DropdownUserMenu(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@class='dropdown-toggle'])[2]")
	private WebElement profileIconButton;
	
	@FindBy(xpath="//a[text()='Sign out']")
	private WebElement signOutButton;
	
	public void userSignOut() throws IOException {
		String actualUrl,expectedUrl;
		Assert.assertFalse(profileIconButton.isSelected(), "Profile icon button is selected out of scope");
		PageUtility.clickOnElement(profileIconButton);
		PageUtility.clickOnElement(signOutButton);
		actualUrl = driver.getCurrentUrl();
		expectedUrl = ExcelUtility.getValuesFromExcel(2,3,constants.Constants.TESTDATAFILE,"Login Page");
		Assert.assertEquals(expectedUrl, actualUrl, "Actual and expected url are equal");		
	}	
}

