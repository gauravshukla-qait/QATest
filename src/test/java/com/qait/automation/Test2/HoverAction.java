package com.qait.automation.Test2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverAction {

	WebDriver driver;
	List<WebElement> imgList;
	
	public HoverAction(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openHoverPage() {
		driver.findElement(By.linkText("Go to Home")).click();
		driver.findElement(By.linkText("Hovers")).click();
		String s = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		assertEquals(s, "Hovers");
	}
	
	public void verifyNumberOfImagesOnHoversPage() {
		imgList = driver.findElements(By.cssSelector("div.example img"));
		assertEquals(imgList.size(), 3);
	}
	
	public void performHoverAction() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("div.example img"))).build().perform();
		assertTrue(driver.findElement(By.className("figcaption")).isDisplayed());
	}
	
	public void afterHoverAction() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.className("example"))).build().perform();
		assertFalse(driver.findElement(By.className("figcaption")).isDisplayed());
	}	
}
