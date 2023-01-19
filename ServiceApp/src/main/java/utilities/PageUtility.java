package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static void clickOnElement(WebElement element) {
		element.click();
		}
	
	public static void clearElement(WebElement element) {
		element.clear();
		}

		public static WebElement enterText(WebElement element, String value) {
		element.sendKeys(value);
		return element;
		}

		public static String getElementText(WebElement element) {
		return element.getText();
		}
      
		public static void clickAndHoldOnElement(WebElement element, WebDriver driver) {
			Actions actions = new Actions(driver);
			actions.clickAndHold(element).build().perform();
		}
		
		public static void clickOnElement(WebElement element, WebDriver driver) {
			Actions actions = new Actions(driver);
			actions.click(element).perform();
		}
		
		public static void doubleClickOnElement(WebElement element, WebDriver driver) {
			Actions actions = new Actions(driver);
			actions.doubleClick(element).perform();
		}
		
		public static void selectDropdownbyText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		}

		public static void selectDropdownbyIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		}

		public static WebElement enterIntValue(WebElement element, CharSequence[] value) {
		element.sendKeys(value);
		return element;
		}

		public static Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
		}
		
		public static void scrollDown(WebDriver driver,String argument) {
		JavascriptExecutor Js1 = (JavascriptExecutor) driver;
		Js1.executeScript(argument);
		}
		
		public static void scrollUpBack(WebDriver driver,String argument) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript(argument);
		}
		
		public static void stopPageRefresh(WebDriver driver,String argument) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript(argument);
		}
		
		public static void scrollIntoView(WebDriver driver,String argument, WebElement element) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript(argument, element);
		}
		
		public static void scrollBackToTop(WebDriver driver,String argument, String element) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript(argument, element);
		}
		
		public static void scrollBottomByDocHeight(WebDriver driver,String argument) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeAsyncScript(argument);
		}
		
		public static void scrollAndClickOnElement(WebDriver driver,String argument, WebElement element) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.executeScript(argument, element);
		}
		
		public static void equalsObject(WebDriver driver,Object obj) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.equals(obj);
		}
		
		public static void justWait(WebDriver driver) throws InterruptedException {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.wait();
		}
		
		public static void waitLongTimeout(WebDriver driver,long timeout) throws InterruptedException {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.wait(timeout);
		}
		
		public static void waitLongTimeoutNanos(WebDriver driver,long timeout, int nanos) throws InterruptedException {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.wait(timeout, nanos);
		}
		
		public static int generateHashCode(WebDriver driver) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			return Js1.hashCode();
		}
		
		public static void toNotify(WebDriver driver) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.notify();
		}
		
		public static void toNotifyAll(WebDriver driver) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.notifyAll();
		}
		
		public static void convertToString(WebDriver driver) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.toString();
		}
		
		public static void unpinScriptKey(WebDriver driver, ScriptKey key) {
			JavascriptExecutor Js1 = (JavascriptExecutor) driver;
			Js1.unpin(key);
		}
		
}
