package com.qait.automation.Test2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SortableDataAction {

	WebDriver driver;
	List<WebElement> table1RowList;
	List<Integer> dueColumnDataList;
	
	public SortableDataAction(WebDriver driver) {
		this.driver = driver;
		dueColumnDataList = new ArrayList<Integer>();
	}
	
	public void openDataTablePage() {
		driver.findElement(By.linkText("Go to Home")).click();
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		String s = driver.findElement(By.xpath("//div[@class='example']/h3")).getText();
		assertEquals(s, "Data Tables");
	}
	
	public void sortTable() {
		driver.findElement(By.cssSelector("table#table1 th:nth-of-type(4) span")).click();
	}

	public void getNumericDataFromDueColumn() {
        table1RowList = driver.findElements(By.cssSelector("table#table1 tbody tr"));
		for(WebElement row : table1RowList) {			
			String[] arr = row.findElement(By.cssSelector("td:nth-of-type(4)")).getText().split("\\$|\\.");
            dueColumnDataList.add(Integer.parseInt(arr[1]));
		}	
	}
	
	public void checkTableIsSorted() {
		sortTable();
		getNumericDataFromDueColumn();
		boolean flag = false;
		int counter = 0;
		for(int i = 0; i < dueColumnDataList.size()-1; i++) {
			if(dueColumnDataList.get(i) <= dueColumnDataList.get(i+1))
				counter++ ;
			else
				break;
		}
		if(counter == dueColumnDataList.size()-1)
			flag = true;
		assertTrue(flag);	
	}
}
