package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage {

	@FindBy(id = "user-name")
	WebElement usrname;

	@FindBy(id = "password")
	WebElement pass;

	@FindBy(id = "login-button")
	WebElement button;

	public void loginSauceDemo(String username, String password) throws InterruptedException {
		Thread.sleep(3000);

		usrname.sendKeys("standard_user");
		pass.sendKeys("secret_sauce");
		button.click();
	}
}
