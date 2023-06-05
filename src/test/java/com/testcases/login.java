package com.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.pages.Loginpage;
import com.pages.baseClass;

public class login extends baseClass {

	@Test
	public void loginapp() throws InterruptedException {
		logger = report.createTest(" login to saucedemo");

		logger.info("Starting Application");
		// it will go to the login page it will check all the locators and
//		it will initialize and it will return all the object

		Loginpage loginPage = PageFactory.initElements(driver, Loginpage.class);

		loginPage.loginSauceDemo("standard_user", "secret_sauce");
		logger.pass("Login Done Successfully");

	}
}
