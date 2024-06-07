package seleniumAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tc12_EditView {

	public static void main(String[] args) throws InterruptedException {
		ReusableMethods rm=new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		rm.loginToApp(driver);
	// CLick on Account Link
		Thread.sleep(2000);
		driver.findElement(By.id("Account_Tab")).click();;
		System.out.println("Pass: Accounts page is loaded ");
	//Select Values from Dopdown and click Edit
		Select view=new Select(driver.findElement(By.id("fcf")));
		view.selectByVisibleText("Dell");
		driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[1]")).click();
		System.out.println("Pass:Clicked Edit button");
	// Enter details in "EditView"Page
		driver.findElement(By.id("fname")).sendKeys("");
		driver.findElement(By.id("fname")).sendKeys("HPack");
		//driver.findElement(By.id("devname")).click();
		//driver.findElement(By.id("devname")).clear();
		//driver.findElement(By.id("devname")).sendKeys("HP");
		Select field=new Select(driver.findElement(By.xpath("//select[@id=\"fcol1\"]")));
		field.selectByVisibleText("Account Name");
		Select operator=new Select(driver.findElement(By.xpath("//select[@id=\"fop1\"]")));
		operator.selectByVisibleText("contains");
		//driver.findElement(By.xpath("//input[@id=\"fval1\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"fval1\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"fval1\"]")).sendKeys("a");
	// Select fields to display as Last Activity
		Select avilableFields=new Select(driver.findElement(By.xpath("//select[@id=\"colselector_select_0\"]")));
		avilableFields.selectByVisibleText("Last Activity");
		driver.findElement(By.id("colselector_select_0_right")).click();
		driver.findElement(By.xpath("(//input[@class=\"btn primary\"])[2]"));
		System.out.println("Pass: Account name contains a will be displayed");
		driver.close();
		
		}

}
