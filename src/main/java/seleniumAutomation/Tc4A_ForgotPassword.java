package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tc4A_ForgotPassword {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("forgot_password_link")).click();
		if(driver.findElement(By.xpath("//h1")).isDisplayed())
		{System.out.println("Pass:Forgot password page is loaded");
		}
		else {System.out.println("Fail:Forgot password page is not loaded ");
		}
		WebElement userName=driver.findElement(By.xpath("//input[@type=\"email\"]"));
		userName.sendKeys("krishpriya@sales.com");
		WebElement submit=driver.findElement(By.xpath("//input[@id=\"continue\"]"));
		submit.click();
		if(driver.findElement(By.xpath("//*[@class=\"mb12\"]")).isDisplayed())
		{System.out.println("Pass:Check your Email page is loaded");
		}
		else
		{System.out.println("Fail:Check your Email page is not loaded ");
		}
		driver.close();
	}

}
