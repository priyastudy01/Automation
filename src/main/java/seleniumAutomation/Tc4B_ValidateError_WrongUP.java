package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tc4B_ValidateError_WrongUP {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://tekarch149-dev-ed.develop.my.salesforce.com//");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("123");
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("22131");
		Thread.sleep(1000);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
        WebElement error=driver.findElement(By.xpath("//div[@class=\"loginError\" and @id=\"error\"]")) ;
        String errorMsg=error.getText();
		String expectMsg="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
        if(errorMsg.equals(expectMsg))
        {System.out.println("Error Msg is matched for Invalid Logins and TC-4B is passed");
	}
        else
        {
        	System.out.println("Error Msg is not matched and Test Case TC-4B is falied ");
        }
        
        driver.close();

}
}
