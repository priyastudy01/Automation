package seleniumAutomation;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tc5_UserMenu {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("krishpriya@sales.com");
		driver.findElement(By.id("password")).sendKeys("Study_2024");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
		WebElement userMenu=driver.findElement(By.xpath("//div[@id=\"userNav\"]"));
		Actions action=new Actions(driver);
		action.moveToElement(userMenu).build().perform();
		userMenu.click();
		Thread.sleep(2000);
		//Check User Menu items 
		List<WebElement> subElements=driver.findElements(By.xpath("(//div[@class='mbrMenuItems'])[1]"));
		
		for(WebElement subElement:subElements )
		{
			System.out.println(subElement.getText());
		}
		Thread.sleep(2000);
		driver.close();

	}

}
