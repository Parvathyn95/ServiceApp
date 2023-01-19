package com.obsqura.ServiceApp;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.SendEmailWindowPage;
import pages.SendSMSWindowPage;

public class SendEmailWindowPageTest extends Base {
	SendEmailWindowPage sendEmailWindowPageObj;
	@Test
	public void verifySelectNameEnterMessageAndSend() throws IOException {
		sendEmailWindowPageObj = new SendEmailWindowPage(driver);
		sendEmailWindowPageObj.selectMultipleNamesSubjectNoMessageAndSend();
	}
}
