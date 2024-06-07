package seleniumAutomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tc21Lead_Dorpdown {

	public static void main(String[] args) throws InterruptedException {
		
			ReusableMethods rm=new ReusableMethods();
			WebDriver driver=new ChromeDriver();
			rm.loginToApp(driver);
			Thread.sleep(2000);
		
			//Click on Lead Tab
			driver.findElement(By.id("Lead_Tab")).click();
			System.out.println("Pass:Lead tab is clicked");
			WebElement view=driver.findElement(By.id("fcf"));
			Select views=new Select(view);
			view.click();
			List<WebElement> options= views.getOptions();
			for(WebElement option:options)
			{
				System.out.println(option.getText());
			}
			driver.close();

	}

}
