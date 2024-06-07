package seleniumAutomation;

import java.util.List;
import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tc8_DeveloperConsole {

	public static void main(String[] args) throws InterruptedException {
	//Log in method called from resuable class
		ReusableMethods reusableMethods = new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		reusableMethods.loginToApp(driver);
		Thread.sleep(2000);
	// Click on User Menu option 
		WebElement userMenu=driver.findElement(By.xpath("//div[@id=\"userNav\"]"));
		Actions action=new Actions(driver);
		action.moveToElement(userMenu).build().perform();
		userMenu.click();
	//Check the user menu list
		Thread.sleep(2000);
		List<WebElement> subElements=driver.findElements(By.xpath("(//div[@class='mbrMenuItems'])[1]"));
		for(WebElement subElement:subElements )
		{
			System.out.println(subElement.getText());
		}
		Thread.sleep(2000);
		
	// Click on Developer console Link
		WebElement devConsole=driver.findElement(By.xpath("//a[@title='Developer Console (New Window)']"));
		devConsole.click();

	// It will return the parent window name as a String
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		
		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
			}

			System.out.println(driver.switchTo().window(child_window).getTitle());
		}
		Thread.sleep(3000);
		if(driver.findElement(By.id("editors")).isDisplayed())
		{
			System.out.println("Pass: Developer console page is opened");
			driver.close();
		}
		else
		{System.out.println("Fail: Developer console page is not opened");

		}
		Thread.sleep(1000);
		//driver.findElement(By.)
	}
}
