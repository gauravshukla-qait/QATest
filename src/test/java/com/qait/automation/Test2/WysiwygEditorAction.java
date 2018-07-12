package com.qait.automation.Test2;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WysiwygEditorAction {

	WebDriver driver;
	WebElement textArea;
	WebElement editBtn;
	List<WebElement> editOptions;
	
	public WysiwygEditorAction(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageHeader() {
		return driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
	}
	
	public void openEditor() {
		driver.findElement(By.linkText("Go to Home")).click();
		driver.findElement(By.linkText("WYSIWYG Editor")).click();
		assertTrue(getPageHeader().contains("TinyMCE WYSIWYG Editor"));
	}
	
	public void performActions() {
		clearTextAreaAndEnterText();
		selectAllTextFromTextEditor();
	}
	
	public void clearTextAreaAndEnterText() {
		driver.switchTo().frame("mce_0_ifr");
		textArea = driver.findElement(By.id("tinymce"));
		textArea.clear();
		textArea.sendKeys("QA InfoTech");
		driver.switchTo().parentFrame();
	}
	
	public void selectAllTextFromTextEditor() {
		editBtn = driver.findElement(By.id("mceu_16-open"));
//		System.out.println(driver.findElement(By.id("mceu_34")).isDisplayed());
		editBtn.click();
		System.out.println(driver.findElement(By.id("mceu_34")).isDisplayed());
//		driver.findElement(By.cssSelector("div#mceu_42 span")).click();
		/*Actions action = new Actions(driver);
		for(WebElement element : editOptions) {
			action.moveToElement(element).build().perform();
		}*/
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		WebElement element = (WebElement) js.executeScript("return document.getElementById('mceu_42')");
//		element.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
