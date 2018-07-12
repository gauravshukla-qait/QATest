package com.qait.automation.Test2;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ExitIntentAction {
	
	WebDriver driver;
	WebElement contentBox;
	Rectangle p;
	
	public ExitIntentAction(WebDriver driver) {
		this.driver = driver;
	}

	public void launchExitIntentPage() {
		driver.findElement(By.linkText("Go to Home")).click();
		driver.findElement(By.linkText("Exit Intent")).click();
		driver.manage().window().maximize();
		String s = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		assertEquals(s, "Exit Intent");
	}
	
	public void moveMouseOverContent(){
		contentBox = driver.findElement(By.id("content"));
		p = contentBox.getRect();		
		try {
			Robot robot = new Robot();
			 robot.mouseMove(p.getX()+p.getWidth(), p.getY()+p.getHeight());
			 robot.mouseMove(p.getX(), p.getY()+10);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void readPopUpTitle() {
		moveMouseOverContent();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = driver.findElement(By.className("modal-title")).getText();
		assertEquals(s, "THIS IS A MODAL WINDOW");
		removePopUpDisplay();
	}

	private void removePopUpDisplay() {
		try {
			Robot rb = new Robot();
			rb.mousePress(InputEvent.BUTTON1_MASK);
			rb.mouseRelease(InputEvent.BUTTON1_MASK);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
