package seleniumAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Tc2_LoginSFDC {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://tekarch149-dev-ed.develop.my.salesforce.com//");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("krishpriya@sales.com");
		driver.findElement(By.id("password")).sendKeys("Study_2024");
		Thread.sleep(2000);
		driver.findElement(By.id("Login")).click();
	
		Thread.sleep(2000);
		driver.quit();
	}

}
