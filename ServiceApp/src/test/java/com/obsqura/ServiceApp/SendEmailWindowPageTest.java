package com.obsqura.ServiceApp;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SendEmailWindowPage;
import pages.SendSMSWindowPage;

public class SendEmailWindowPageTest extends Base {
	LoginPage loginPageObj;
	SendEmailWindowPage sendEmailWindowPageObj;
	@Test
	public void verifySelectNameEnterMessageAndSend() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		sendEmailWindowPageObj = new SendEmailWindowPage(driver);
		sendEmailWindowPageObj.selectMultipleNamesSubjectNoMessageAndSend();
	}
}
