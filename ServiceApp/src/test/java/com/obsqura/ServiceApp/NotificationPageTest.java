package com.obsqura.ServiceApp;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.NotificationPage;

public class NotificationPageTest extends Base {
	LoginPage loginPageObj;
	NotificationPage notificationPageObj;
	@Test (groups = {"Regression"})
	public void checkClickNotificationAndNavigateToQuantityAlerts() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		notificationPageObj = new NotificationPage(driver);
		notificationPageObj.clickNotificationAndNavigateToQuantityAlerts();
	}
	@Test (groups = {"Smoke"})
	public void checkClickNotificationAndQuantityAlertTitle() throws IOException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.enterUsernameAndPassword();
		notificationPageObj = new NotificationPage(driver);
		notificationPageObj.clickNotificationAndQuantityAlertTitle();
	}
}
