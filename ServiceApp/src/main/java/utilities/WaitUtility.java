package utilities;

import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long IMPLICIT_WAIT = 20;
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT = 50;
	public static final long FLUENT_WAIT = 30;
	
	public enum LocatorType {
		Id, Xpath, CssSelector, Linktext, PartiallinkText, Tagname, Name, ClassName;
	}
	public static void waitForAlertIsPresent(WebDriver driver) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void waitForAttributeContains(WebDriver driver, By locator, String attribute,String value) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
	}
	public static void waitForAttributeContains(WebDriver driver, WebElement element, String attribute,String value) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.attributeContains(element, attribute, value));
	}
	
	public static void waitForDomAttributeToBe(WebDriver driver, WebElement element,String attribute,String value) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.domAttributeToBe(element, attribute, value));
	}
	public static void waitForElement(WebDriver driver, WebElement target) {                  
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
			wait.until(ExpectedConditions.visibilityOf(target));
	}
	public static void waitForElementSelectionStateToBe(WebDriver driver, WebElement element,Boolean selected) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
	}
	public static void waitForElementToBeClickable(WebDriver driver, By locator) {					//implemented
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public static void waitForElementToBeClickable(WebDriver driver, WebElement target) {			//implemented
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeClickable(target));
	}
	public static void waitForElementToBeSelected(WebDriver driver,WebElement element) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public static void waitForFrameToBeAvailableAndSwitchToIt(WebDriver driver,By locator) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	public static void waitForFrameToBeAvailableAndSwitchToIt(WebDriver driver,String frameLocator) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	public static void waitForInvisibilityOfAllElements(WebDriver driver,List <WebElement> elements) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	public static void waitForInvisibilityOf(WebDriver driver,List <WebElement> elements) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	public static void waitForInvisibilityOfAllElements(WebDriver driver,WebElement elements) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}
	public static void waitForInvisibilityOfAllElementWithText(WebDriver driver,By locator, String text) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
	}
	public static void waitForJavaScriptThrowsNoExceptions(WebDriver driver, String javascript) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.javaScriptThrowsNoExceptions(javascript));
	}
	public static void waitForNot(WebDriver driver, ExpectedCondition <?> condition) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.not(condition));
	}
	public static void waitFornumberOfElementsToBeLessThan(WebDriver driver, By locator, Integer number) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator, number));
	}
	public static void waitFornumberOfElementsToBeMoreThan(WebDriver driver, By locator, Integer number) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, number));
	}
	public static void waitFornumberOfElementsToBeMoreThan(WebDriver driver, int expectedNumberOfWindows) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
	}
	public static void waitForPresenceOfAllElementsLocatedBy(WebDriver driver, By locator) {	//implemented			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	public static void waitForPresenceOfElementLocated(WebDriver driver, By locator) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static void waitForPresenceOfElementLocated(WebDriver driver, ExpectedCondition <T> condition) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.refreshed(condition));
	}
	public static void waitForTextToBe(WebDriver driver, By locator, String value) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBe(locator, value));
	}
	public static void waitForTextToBePresentInElement(WebDriver driver, WebElement element, String text) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	public static void waitForTextToBePresentInElementValue(WebDriver driver, By locator, String text) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElementValue(locator, text));
	}
	public static void waitForTextToBePresentInElementValue(WebDriver driver, WebElement element, String text) {			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.textToBePresentInElementValue(element, text));
	}
	public static void waitForTitleContains(WebDriver driver, String title) {					//implemented
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.titleContains(title));
	}
	public static void waitForUrlContains(WebDriver driver, String fraction) {					//implemented
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.urlContains(fraction));
	}
	public static void waitForUrlMatches(WebDriver driver, String regex) {					
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.urlMatches(regex));
	}
	public static void waitForVisibilityOf(WebDriver driver, WebElement element) {					
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitForVisibilityOfElementLocated(WebDriver driver, By locator) {		//implemented
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public static void waitForVisibilityOfAllElements(WebDriver driver, WebElement elements) {					
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	public static void waitForVisibilityOfAllElementsLocatedBy(WebDriver driver, By locator) {	//implemented			
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	public static void waitForAttributeToBe(WebDriver driver, By locator, String attribute, String value) {		  		//fluentwait
		//WebDriverWait fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT));
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
				 							.withTimeout(Duration.ofSeconds(25))
				 							.pollingEvery(Duration.ofSeconds(5))
				 							.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.attributeToBe(locator, attribute, value));
	}
	public static void waitForAttributeToBe(WebDriver driver, WebElement element, String attribute, String value) {		//fluentwait
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
				 							.withTimeout(Duration.ofSeconds(25))
				 							.pollingEvery(Duration.ofSeconds(5))
				 							.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.attributeToBe(element, attribute, value));
	}
	public static void waitForDomPropertyToBe(WebDriver driver, WebElement element,String property,String value) {		 //fluentWait	
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
												.withTimeout(Duration.ofSeconds(25))
												.pollingEvery(Duration.ofSeconds(5))
												.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.domPropertyToBe(element, property, value));
	}
	public static void waitForElementSelectionStateToBe(WebDriver driver, By locator,Boolean selected) {			
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
												.withTimeout(Duration.ofSeconds(25))
												.pollingEvery(Duration.ofSeconds(5))
												.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.elementSelectionStateToBe(locator, selected));
	}
	public static void waitForElementToBeSelected(WebDriver driver, By locator) {	
		WebDriverWait fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT));
		fluentWait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	public static void waitForFrameToBeAvailableAndSwitchToIt(WebDriver driver,int frameLocator) {			
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
				 								.withTimeout(Duration.ofSeconds(25))
				 								.pollingEvery(Duration.ofSeconds(5))
				 								.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	public static void waitForFrameToBeAvailableAndSwitchToIt(WebDriver driver,WebElement frameLocator) {			
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
											.withTimeout(Duration.ofSeconds(25))
											.pollingEvery(Duration.ofSeconds(5))
											.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	public static void waitForInvisibilityOf(WebDriver driver,WebElement element) {			
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
				 								.withTimeout(Duration.ofSeconds(25))
				 								.pollingEvery(Duration.ofSeconds(5))
				 								.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.invisibilityOf(element));
	}
	public static void waitForInvisibilityOfElementLocated(WebDriver driver,By locator) {			
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
				 								.withTimeout(Duration.ofSeconds(25))
				 								.pollingEvery(Duration.ofSeconds(5))
				 								.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	public static void waitForJsReturnsValue(WebDriver driver, String javascript) {			
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
												.withTimeout(Duration.ofSeconds(25))
												.pollingEvery(Duration.ofSeconds(5))
												.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.jsReturnsValue(javascript));
	}
	public static void waitFornumberOfElementsToBe(WebDriver driver, By locator, Integer number) {			
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
												.withTimeout(Duration.ofSeconds(25))
												.pollingEvery(Duration.ofSeconds(5))
												.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.numberOfElementsToBe(locator, number));
	}
	public static void waitForStalenessOf(WebDriver driver, WebElement element) {			
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
												.withTimeout(Duration.ofSeconds(25))
												.pollingEvery(Duration.ofSeconds(5))
												.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.stalenessOf(element));
	}
	public static void waitForTextToBePresentInElementLocated(WebDriver driver, By locator, String text) {			
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
				 								.withTimeout(Duration.ofSeconds(25))
				 								.pollingEvery(Duration.ofSeconds(5))
				 								.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}
	public static void waitForTitleIs(WebDriver driver, String title) {							//implemented
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
				 								.withTimeout(Duration.ofSeconds(25))
				 								.pollingEvery(Duration.ofSeconds(5))
				 								.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.titleIs(title));
	}
	public static void waitForUrlToBe(WebDriver driver, String url) {					
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
				 								.withTimeout(Duration.ofSeconds(25))
				 								.pollingEvery(Duration.ofSeconds(5))
				 								.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.urlToBe(url));
	}
	public static void waitForVisibilityOf(WebDriver driver, List <WebElement> elements) {					
		FluentWait<WebDriver> fluentWait = new WebDriverWait(driver, Duration.ofSeconds(FLUENT_WAIT))
										 .withTimeout(Duration.ofSeconds(25))
										.pollingEvery(Duration.ofSeconds(5))
										.ignoring(Exception.class);
		fluentWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

}
