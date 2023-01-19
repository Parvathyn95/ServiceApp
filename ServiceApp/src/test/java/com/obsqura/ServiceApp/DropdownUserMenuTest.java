package com.obsqura.ServiceApp;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.DropdownUserMenu;
import pages.LoginPage;
import pages.SideNavigationMenuSelect;

public class DropdownUserMenuTest extends Base{
	LoginPage loginPageObj;
	DropdownUserMenu DropdownUserMenuObj;  //variable given globally
	@Test
	public void verifyUserSignOut() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		DropdownUserMenuObj = new DropdownUserMenu(driver);
		DropdownUserMenuObj.userSignOut();
	}

}
