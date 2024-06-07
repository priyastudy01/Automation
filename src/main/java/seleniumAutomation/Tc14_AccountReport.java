package seleniumAutomation;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tc14_AccountReport {

	public static void main(String[] args) throws InterruptedException {
		ReusableMethods rm=new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		rm.loginToApp(driver);
		// CLick on Account Link
		Thread.sleep(2000);
		driver.findElement(By.id("Account_Tab")).click();
		System.out.println("Pass: Accounts page is loaded ");
		driver.findElement(By.xpath("//a[contains(text(),'Accounts with')]")).click();
		System.out.println("Pass:Unsaved Report page is displayed");
	//Enter details in the Unsaved Report page	
		Thread.sleep(2000);
		WebElement dateField = driver.findElement(By.id("ext-gen147"));
		dateField.click();
		List<WebElement> listItems = driver.findElements(By.className("x-combo-list-item"));
		listItems.get(1).click();
//		listItems.selectByValue("Created Date");
//		WebElement createdDate = driver.findElement(By.id("ext-"))
		//driver.findElement(By.id("ext-gen152")).click();
		//driver.findElement(By.id("ext-gen293")).click();
		driver.findElement(By.id("ext-gen154")).click(); // Calendar button.
		driver.findElement(By.id("ext-comp-1112")).click(); // Calendar today button.
		driver.findElement(By.id("ext-gen49")).click(); // Save Button
		System.out.println("Pass:Entered Created date and To filed and clicked save button");
	// Save Report pop window (Handling child window)
		WebElement reportName=driver.findElement(By.xpath("//input[@id=\"saveReportDlg_reportNameField\"]"));
		reportName.sendKeys("Viewreport");
		driver.findElement(By.xpath("//input[@id=\"saveReportDlg_DeveloperName\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ext-gen301")).click();
		Thread.sleep(1000);
		System.out.println("Pass: Entered report Name and clicked on save&Run Report button");
		if(driver.findElement(By.className("noSecondHeader pageType")).isDisplayed())
		{
		System.out.println("Pass:Report page is opened");
		}
		else
		{
			System.out.println("Fail:Report page is not opened");
		}
        
	}

}
