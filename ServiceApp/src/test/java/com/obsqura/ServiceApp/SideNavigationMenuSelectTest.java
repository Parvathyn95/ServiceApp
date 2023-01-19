package com.obsqura.ServiceApp;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.SideNavigationMenuSelect;

public class SideNavigationMenuSelectTest extends Base {
	SideNavigationMenuSelect sideNavigationMenuSelectObj;
	
	@Test
	public void checkNavigationMenuClick(String expectedString){
		sideNavigationMenuSelectObj = new SideNavigationMenuSelect(driver);
		sideNavigationMenuSelectObj.navigationMenuClick(expectedString);
	}
}
