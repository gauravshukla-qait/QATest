package com.qait.automation.Test2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StatusCodeAction {

	WebDriver driver;
	
	public StatusCodeAction(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageHeader() {
		return driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
	}
	
	public void openStstusCodePage() {
		driver.findElement(By.linkText("Go to Home")).click();
		driver.findElement(By.linkText("Status Codes")).click();
		assertTrue(getPageHeader().contains("Status Codes"));
	}
	
	public void clickOnLink404() {
		driver.findElement(By.linkText("404")).click();
	}
	
	public void get404Msg() {
		clickOnLink404();
		String msg = driver.findElement(By.cssSelector("div.example p")).getText();
		assertTrue(msg.contains("This page returned a 404 status code."));
	}
	
	public void verifyHTTPStatusCode() {
		URL url = null;
		int statusCode = 0;
		try {
			url = new URL("http://10.0.31.161:9292/status_codes/404");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpURLConnection http;
		try {
			http = (HttpURLConnection)url.openConnection();
			statusCode = http.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(statusCode, 404);
	}
}
