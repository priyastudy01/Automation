package seleniumAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tc9_Logout {
	public static void main(String[] args) throws InterruptedException {
//Log in method called from resuable class
	ReusableMethods reusableMethods = new ReusableMethods();
	WebDriver driver=new ChromeDriver();
	driver.get("https://login.salesforce.com/");
	driver.manage().window().maximize();
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
	WebElement logOut=driver.findElement(By.xpath("//a[@title=\"Logout\"]"));
	logOut.click();
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//div[@id=\"main\"]")).isDisplayed())
			{System.out.println("Pass:Salesforce landing page is displayed");
			}
	else {
		System.out.println("Fail: After Logout the Landing page is not diaplyed");
			}
	driver.close();
}
}
