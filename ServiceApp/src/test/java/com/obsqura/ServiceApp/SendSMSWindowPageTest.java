package com.obsqura.ServiceApp;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SendSMSWindowPage;

public class SendSMSWindowPageTest extends Base {
	LoginPage loginPageObj;
	SendSMSWindowPage sendSMSWindowPageObj;
	@Test
	public void verifySelectNameEnterMessageAndSend() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		sendSMSWindowPageObj = new SendSMSWindowPage(driver);
		sendSMSWindowPageObj.selectNameEnterMessageAndSend();	
	}
}
