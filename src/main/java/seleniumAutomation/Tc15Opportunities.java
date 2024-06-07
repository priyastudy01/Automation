package seleniumAutomation;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Tc15Opportunities {

	public static void main(String[] args) throws InterruptedException {
		ReusableMethods rm=new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		rm.loginToApp(driver);
		Thread.sleep(2000);
	//Click on Opportunities Link
		driver.findElement(By.xpath("//a[@title=\"Opportunities Tab\"]")).click();
		System.out.println("Pass:Opportunities Link is clicked");
	//view Opportunities dropdown menu	
		WebElement dropDown=driver.findElement(By.id("fcf"));
		Select view=new Select(dropDown);
		dropDown.click();
		List<WebElement> options= view.getOptions();
		for(WebElement option:options)
		{
			System.out.println(option.getText());
		}
		driver.close();
		
	}

}
