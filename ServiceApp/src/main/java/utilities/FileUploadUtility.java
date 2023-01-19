package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	
	public void fileUpload(WebDriver driver, WebElement element,String s1) {
		element.sendKeys(s1);
	
	}
	
}
