package com.qait.automation.Test2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageAction {

	WebDriver driver;
	WebElement link;
	WebElement userName;
	WebElement password;
	Alert promptAlert;
	
	public HomePageAction(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnBasicAuthLink(){
		driver.findElement(By.linkText("Basic Auth")).click();
	}
	
	public void testBasicPromptDisplayed() {
		boolean flag = false;
		try {
			promptAlert = driver.switchTo().alert();
			flag = true;
		}catch (Exception e) {
			flag = false;
		}
		assertTrue(flag);
	}
	// To handle popup
	public void pressKeys(Robot rb) {
		rb.keyPress(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_A);
		rb.keyPress(KeyEvent.VK_D);
		rb.keyRelease(KeyEvent.VK_D);
		rb.keyPress(KeyEvent.VK_M);
		rb.keyRelease(KeyEvent.VK_M);
		rb.keyPress(KeyEvent.VK_I);
		rb.keyRelease(KeyEvent.VK_I);
		rb.keyPress(KeyEvent.VK_N);
		rb.keyRelease(KeyEvent.VK_N);
	}
	
	public void changeTab(Robot rb) {
		rb.keyPress(KeyEvent.VK_TAB);
	    rb.keyRelease(KeyEvent.VK_TAB);
	}
	
	public void pressEnter(Robot rb) {
		/*rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);*/
		promptAlert.accept();
	}
	
	public void sendKeysInAlertBox() {
		try {
			Robot rb = new Robot();
			pressKeys(rb);
			changeTab(rb);
			pressKeys(rb);
			pressEnter(rb);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void performAuthentication() {
		sendKeysInAlertBox();
		System.out.println(driver.getCurrentUrl());
		String s = driver.findElement(By.xpath("//div[@class='example']/p")).getText();
		assertEquals(s, "Congratulations! You must have the proper credentials.");
	}
	
	
	
	
	
	
	
	
	
	
	
}
