package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tc3_RememberMe {

	public static void main(String[] args) throws InterruptedException {
			WebDriver driver=new ChromeDriver();
			driver.get("https://login.salesforce.com/");
			driver.manage().window().maximize();
			driver.findElement(By.id("username")).sendKeys("krishpriya@sales.com");
			driver.findElement(By.id("password")).sendKeys("Study_2024");
			Thread.sleep(2000);
			WebElement rememberMe=driver.findElement(By.id("rememberUn"));
			rememberMe.click();
			Thread.sleep(2000);
		if(!(rememberMe.isSelected())) {
			rememberMe.click();
			System.out.println("Pass:RememberMe check box is checked");
		} else {
			System.out.println("RemeberMe Checkbox is already selected");
		}
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
		//Click on User Menu option 
				WebElement userMenu=driver.findElement(By.xpath("//div[@id=\"userNav\"]"));
				Actions action=new Actions(driver);
				action.moveToElement(userMenu).build().perform();
				userMenu.click();
				System.out.println("Pass: Usermenu is clicked");

				//Click on Logout
				WebElement logOut=driver.findElement(By.xpath("//a[@title=\"Logout\"]"));
				logOut.click();
				System.out.println(" Pass: Logout button is clicked");
				Thread.sleep(2000);
				String Expected="krishpriya@sales.com";
			    String actual=driver.findElement(By.id("username")).getAttribute("value");
			   // try {
		if(Expected.equals(actual)){
			
				System.out.println("Pass:User Name is prepopulated &Remember me is checked");
			}
						
		else {
			System.out.println("Fail:User Name is not prepopulated &Remember me is notchecked");}
		
	try {
		if(rememberMe.isSelected())
		{ System.out.println("Checkbox is checked");}
	}
	catch(StaleElementReferenceException ex)
			    {
			   }finally {
			    	System.out.println("Validation is completed");}
			    }
		//driver.close();
	}


