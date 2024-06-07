package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tc13_MergeAccounts {

	public static void main(String[] args) throws InterruptedException {
		ReusableMethods rm=new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		rm.loginToApp(driver);
		// CLick on Account Link
		Thread.sleep(2000);
		driver.findElement(By.id("Account_Tab")).click();;
		System.out.println("Pass: Accounts page is loaded ");
		// Click Merge Accounts
		driver.findElement(By.xpath("//*[contains(text(),'Merge Accounts')]")).click();
		System.out.println("Pass:Merge Account link is clicked");
		driver.findElement(By.id("srch")).sendKeys("united");
		driver.findElement(By.xpath("//input[@value=\"Find Accounts\"]")).click();
		System.out.println("Pass: Find Accounts button is clicked");
		// Check both accounts to merge
		WebElement account1=driver.findElement(By.id("cid0"));
		WebElement account2=driver.findElement(By.id("cid1"));
		if(!(account1).isSelected())
		{
			account1.click();
			System.out.println("Pass: Merging account 1 is selected");
		}
		if(!(account2).isSelected())
		{
			account2.click();
			System.out.println("Pass: Merging account 2 is selected");
		}
		else
		{
			System.out.println("Pass:Both accounts are Already checked");
		}
		driver.findElement(By.xpath(" (//input[@value=' Next '])[2]")).click();
		System.out.println("Pass:Step 2. Select the values to retain page is opened");
		driver.findElement(By.xpath(" (//input[@value=' Merge '])[1]")).click();
		//Alert Handling
		driver.switchTo().alert().accept();
		if(driver.findElement(By.xpath("(//th[@scope=\"row\"])[1]")).isDisplayed())
		{
			System.out.println("Pass:In recently viewed view, new merged account is listed.");
		}
		else 
		{
         System.out.println("Fail:In recently viewed view, new merged account is not listed.");
		}	
		driver.close();
     }

    }
