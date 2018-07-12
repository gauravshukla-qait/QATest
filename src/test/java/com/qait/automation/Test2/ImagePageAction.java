package com.qait.automation.Test2;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImagePageAction {

	WebDriver driver;
	List<String> srcList;
	
	public ImagePageAction(WebDriver driver) {
		this.driver = driver;
		srcList = new ArrayList<String>();
	}
	
	public void launchImagePage() {
		driver.findElement(By.linkText("Go to Home")).click();
		driver.findElement(By.linkText("Broken Images")).click();
	}
	
	public void verifyImagesAreLoadedProperly() {
		launchImagePage();
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='example']/img"));
		for(WebElement element : elements) {
			String src = element.getAttribute("src");
//			System.out.println(src);
			if(!src.contains("img")) {
				srcList.add(src);
			}
		}
		for(String src : srcList)
			System.out.println(src);
	}
}
