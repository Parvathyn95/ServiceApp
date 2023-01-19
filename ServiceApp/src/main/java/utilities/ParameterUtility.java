package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParameterUtility {
	
	public static void sendKeyValue(WebDriver driver,WebElement element,String newString) {
		element.sendKeys(newString);
	}

}
