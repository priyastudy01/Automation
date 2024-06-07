package seleniumAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Tc1_Login_Error {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("krishpriya@sales.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("Login")).click();

		WebElement capture= driver.findElement(By.id("error"));
		String errorMsg=capture.getText();
		String expectMsg="Please enter your password.";
		if(errorMsg.equals(expectMsg))
		{
			System.out.println(" Verified Error message and Test case is passed");
		}
		else
		{
			System.out.println("Error messgae is not matched and TestCase is fail");
		}
		Thread.sleep(2000);
		driver.close();
	}
}

