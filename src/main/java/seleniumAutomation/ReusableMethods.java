package seleniumAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ReusableMethods {
	/** To generate the Element comments go to Function-> Right Click->Source->click->Generate element Comments
	 * Shortcuts 1.To Allign-Ctl+A then Ctl i
	 * 2. main-> ctl+space; Syso+ctl+space
	 * 1.This is about Call the function to login to the Application
	 * @param driver pass as webdriver object
	 * @return boolean true if login is successful
	 */
	
	public boolean loginToApp(WebDriver driver)
	{
		boolean isLogin=false;
		driver.get("https://login.salesforce.com/");   
	    driver.manage().window().maximize();
		if(driver.findElement(By.id("username")).isDisplayed())	{		    
			driver.findElement(By.id("username")).sendKeys("krishpriya@sales.com");
			driver.findElement(By.id("password")).sendKeys("Study_2024");
			driver.findElement(By.id("Login")).click();
			isLogin=true;
			System.out.println("Pass: Login credential is successfull.");
		}
		else
		{
			System.out.println("Login credential is not success.Please Verify");
		}
		return isLogin;
	}
	static WebDriver driver;
	/** 2.This function is for mouseHover action 
	 * @param element pass as webelement object
	 */
	public static void mouseHover(WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	    }
	
	/**3.This function is to do Drag and Drop action
	 * @param element1 object of WebElement
	 * @param element2 object of WebElemnt
	 */
	public static void dragAndDrop(WebElement element1,WebElement element2)
	{ Actions action=new Actions(driver);
	Dimension size=element2.getSize();
	action.dragAndDrop(element1, element2).build().perform();
	}
	
	/**4.This function is for choose the option from the dropdown menu
	 * @param element1 -pass dropdown as Webelemnt object
	 * @param element2 pass value as string
	 */
	public static void selectOptionFromDropDown(WebElement dropDown,String value)
	{
		Select menu=new Select(dropDown);
		menu.selectByVisibleText(value);
	}
	public static void mouseHover1(WebElement element)
	{
	WebElement hoverElement = driver.findElement(By.id(""));
	Actions action = new Actions(driver);
	action.moveToElement(hoverElement).build().perform();
	hoverElement.getCssValue("color");
	}
}

