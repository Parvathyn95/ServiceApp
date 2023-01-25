package com.obsqura.ServiceApp;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext; 
import org.testng.ITestListener; 
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports; 
import com.aventstack.extentreports.ExtentTest; 
import com.aventstack.extentreports.Status;
import com.obsqura.ServiceApp.Base;
import utilities.ExtentReportUtility;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;

ExtentReports extent=ExtentReportUtility.createExtentReports(); 
ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();


public void onTestStart(ITestResult result) {
test =extent.createTest(result.getMethod().getMethodName()); 
extentTest.set(test);
}

public void onTestSuccess(ITestResult result) {
}

public void onTestFailure(ITestResult result) {

	extentTest.get().fail(result.getThrowable()); 
	WebDriver driver=null;
String testMethodName=result.getMethod().getMethodName();
try { 
	driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
} catch (IllegalArgumentException e) {

} catch (IllegalAccessException e) {

} catch (NoSuchFieldException e) {
 
} catch (SecurityException e) {

}
try { 
	driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance()); 
} catch (Exception e) { }

}

public void onTestSkipped(ITestResult result) {
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) { 
}

public void onTestFailedWithTimeout(ITestResult result) {
}

public void onStart(ITestContext context) {
}

public void onFinish(ITestContext context) { 
	extent.flush();
}


}