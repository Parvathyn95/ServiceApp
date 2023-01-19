package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideNavigationMenuSelect {
	public WebDriver driver;
	By sideNavMenuItemsList = By.xpath("//ul[@class='nav navbar-nav']//child::li[starts-with(@class,'dropdown')]");
	private String expectedString;
	public SideNavigationMenuSelect(WebDriver driver) {
		this.driver=driver;
	}
	public void navigationMenuClick(String expectedString) {
		List <WebElement> sideNavMenuItems = driver.findElements(sideNavMenuItemsList);
			for(WebElement sideNavMenu : sideNavMenuItems) {
				if(sideNavMenu.getText().equalsIgnoreCase(expectedString)) {
					sideNavMenu.click();
					break;
				}
			}
	}
}
