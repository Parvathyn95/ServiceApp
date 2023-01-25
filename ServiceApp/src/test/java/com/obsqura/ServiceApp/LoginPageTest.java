package com.obsqura.ServiceApp;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginPageTest extends Base {
	LoginPage loginPageObj;
	@Test 
	public void verifyEnterUsernameAndPassword() throws IOException {
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
	}
	@Test
	@Parameters({"userName"})
	public void verifyEnterUsernameAndRememberCheckBoxOnly(String userName) throws IOException {
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndRememberCheckBoxOnly(userName);
	}
	@Test
	public void verifyEnterPasswordAndRememberCheckBoxOnly() throws IOException {
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.enterPasswordAndRememberCheckBoxOnly();
	}
	@Test
	public void verifyClickRememberCheckBoxOnly() throws IOException {
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.clickRememberCheckBoxOnly();
	}
	@Test
	public void verifyClickForgotPassword() throws IOException {
		LoginPage loginPageObj = new LoginPage(driver);
		loginPageObj.clickForgotPassword();
	}
}
