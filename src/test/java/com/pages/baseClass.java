package com.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utility.BrowserFactory;
import com.utility.helper;

public class baseClass {

	public WebDriver driver;
	public ExtentReports report;

	public ExtentTest logger;

	@BeforeSuite
	public void setupSuit() {
		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File(System.getProperty("user.dir") + "/Report/Saucedemo.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeClass
	public void setup() {
		driver = BrowserFactory.StartApplication(driver, "Chrome", "https://www.saucedemo.com");

	}

	@AfterClass

	public void teardown() {
		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void teardownMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {
			helper.captureScreenshot(driver);
		}

		report.flush();

	}

}
