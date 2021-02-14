package com.amazonsearch.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNonAttributeSearch {

		public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.get("https://amazon.com");
			driver.manage().window().maximize();
			WebElement findgift = driver.findElement(By.linkText("Find a Gift"));
			findgift.click();
			System.out.print("linkText: User is in the page " + driver.getTitle());
			Thread.sleep(2000);
			List<WebElement> giftlinks=driver.findElements(By.partialLinkText("Gifts"));
			for(WebElement links:giftlinks) {
				System.out.println(links.getText()+ " " + links.isDisplayed());
			}
			

	}

}
