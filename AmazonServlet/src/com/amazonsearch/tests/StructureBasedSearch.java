package com.amazonsearch.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StructureBasedSearch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com");
		driver.manage().window().maximize();
		
		WebElement mobilesearch = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
		mobilesearch.sendKeys("samsung mobile phones" + "\n");
		System.out.println("xpath: Mobile Search Executed");
		Thread.sleep(3000);
		
		WebElement tvsearch = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		tvsearch.clear();
		tvsearch.sendKeys("samsung smart tv" + "\n");
		Thread.sleep(3000);
		System.out.println("cssSelector:TV Search Executed");
		System.out.println("Summary: xpath & cssSelector locator Search complete");
		driver.close();

	}

}
