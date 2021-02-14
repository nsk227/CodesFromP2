package com.amazonsearch.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {
public static String PName;
public static String SetProductName(String ProductName) {
	PName=ProductName;
	return PName;
}
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com");
		driver.manage().window().maximize();
		// Wait time to keyin characters, if application demands to verify characters for robot verification
		Thread.sleep(15000);
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("mt everest picture" + "\n");
		WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"p_76/1249155011\"]/span/a/div[1]/label/i"));
		checkbox.click();
		Thread.sleep(3000);
		WebElement minprice = driver.findElement(By.name("low-price"));
		minprice.sendKeys("35");
		// Thread.sleep (2000);
		WebElement maxprice = driver.findElement(By.cssSelector("#high-price"));
		maxprice.sendKeys("40");
		WebElement submitbtn = driver.findElement(By.className("a-button-input"));
		submitbtn.click();
		Thread.sleep(2000);
		WebElement resultlabel = driver.findElement(By.xpath("//span[@dir='auto'][1]"));
		System.out.print("In Search Result- It should be displaying: " + resultlabel.getText());
		WebElement productlabel = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]"));
		System.out.print(" ");
		System.out.print(productlabel.getText() + "\n");
		WebElement itemselected = driver.findElement(By.className("s-image"));
		itemselected.getAttribute("data-image-index").equals("1");
		itemselected.click();
		Thread.sleep(3000);
		WebElement addtocart = driver.findElement(By.id("add-to-cart-button"));
		addtocart.click();
		WebElement checkoutbox = driver.findElement(By.xpath("//*[@id=\"hlb-view-cart-announce\"]"));
		checkoutbox.click();
		// To get the list of products in the shopping cart
		List<WebElement> finalproduct = driver.findElements(By.className("sc-product-image"));
		for (WebElement shoppinglist : finalproduct) {
			System.out.println(shoppinglist.getAttribute("alt"));
			String PName= AmazonSearch.SetProductName(shoppinglist.getAttribute("alt"));
			System.out.println("Congratulations, Transaction complete. Happy Shopping Naresh!!!");
			//driver.close();
		}
	}
}
