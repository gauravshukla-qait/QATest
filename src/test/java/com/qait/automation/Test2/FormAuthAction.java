package com.qait.automation.Test2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormAuthAction {

	WebDriver driver;
	WebElement usernameTextBox;
	WebElement passwordTextBox;
	WebElement loginBtn;

	public FormAuthAction(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageHeader() {
		return driver.findElement(By.xpath("//div[@class='example']/h2")).getText();
	}
	
	public void launchLoginPage() {
		driver.findElement(By.linkText("Go to Home")).click();
		driver.findElement(By.linkText("Form Authentication")).click();
		String header = getPageHeader();
		assertEquals(header, "Login Page");
	}

	public void performLogin(String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("radius")).submit();
	}
	
	public void verifyInvalidLogin() {
		performLogin("invalid", "invalid");
		String errorMsg = driver.findElement(By.id("flash")).getText();
//		String errorMsg = "";
//		assertEquals(errorMsg, "Your username is invalid!");
		assertTrue(errorMsg.contains("Your username is invalid!"));
	}
	
	public void verifyValidLogin() {
		performLogin("tomsmith", "SuperSecretPassword!");
//		String successMsg = getPageHeader();
//		assertEquals(successMsg, "Secure Area");
		String successMsg = driver.findElement(By.id("flash")).getText();
		assertTrue(successMsg.contains("You logged into a secure area!"));
	}
	
	public void performLogOut() {
		driver.findElement(By.linkText("Logout")).click();
	}
	
	public void verifyLogOut() {
		performLogOut();
		String msg = driver.findElement(By.id("flash")).getText();
		assertTrue(msg.contains("You logged out of the secure area!"));
	}
	
	
	
	
	
	
	
	
	
}
