package seleniumAutomation;

//import java.awt.AWTException;
//import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tc6_MyProfile {
	public static void main(String[] args) throws InterruptedException {
		//Log in method called from resuable class
		ReusableMethods reusableMethods = new ReusableMethods();
		WebDriver driver=new ChromeDriver();
		reusableMethods.loginToApp(driver);
		Thread.sleep(2000);
		WebElement userMenu=driver.findElement(By.xpath("//div[@id=\"userNav\"]"));
		Actions action=new Actions(driver);
		action.moveToElement(userMenu).build().perform();
		userMenu.click();
		
	//Click myprofile
		WebElement myProfile=driver.findElement(By.xpath("(//a[@class=\"menuButtonMenuLink firstMenuItem\"])[1]"));
		myProfile.click();
		Thread.sleep(2000);	
	
	//click edit Profile
		WebElement pencil=driver.findElement(By.xpath("(//img[@title=\"Edit Profile\"])[1]"));
		pencil.click();
		
	//click Edit profile iframe.Edit Last name
		driver.switchTo().frame("contactInfoContentId");
		WebElement aboutTab=driver.findElement(By.id("aboutTab"));
		aboutTab.click();
		Thread.sleep(1000);
		WebElement lastName=driver.findElement(By.xpath("//input[@id=\"lastName\"]"));
		lastName.clear();
		lastName.sendKeys("Krishh");
		Thread.sleep(1000);
		WebElement saveButton=driver.findElement(By.xpath("//input[@value=\"Save All\"]"));
		Thread.sleep(1000);
		saveButton.click();
		driver.switchTo().parentFrame();
		
	//click post link and enter text and share
		WebElement postLink=driver.findElement(By.id("publisherAttachTextPost"));
		postLink.click();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		WebElement enterText=driver.findElement(By.xpath("//body"));
		enterText.sendKeys("Sharing this post for Testing purpose");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//input[@id=\"publishersharebutton\"]")).click();	
		Thread.sleep(1000);
	//File Upload
		WebElement fileLink = driver.findElement(By.id("publisherAttachContentPost"));
	     fileLink.click();
		System.out.println("Clicked on filelink");
		
	     WebElement upLoadFile = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
	     upLoadFile.click();
	     System.out.println("clicked on uploadfile button on computer");
	     Thread.sleep(3000); 
	     WebElement choosefile = driver.findElement(By.id("chatterFile"));
	     choosefile.sendKeys("C:\\Users\\Vinodh\\OneDrive\\Desktop\\Dine easy.xlsx");
	     
	     System.out.println("choosefile option is selected");
	     WebElement Share = driver.findElement(By.id("publishersharebutton"));
	     Share.click();
	     Thread.sleep(4000);
	     
	// Photo Upload
	     WebElement addPhoto=driver.findElement(By.id("uploadLink"));
	     JavascriptExecutor jse = (JavascriptExecutor)driver;
	     jse.executeScript("arguments[0].click()", addPhoto);
	     driver.switchTo().frame("uploadPhotoContentId");
	     Thread.sleep(1000);
	     WebElement loadFile= driver.findElement(By.className("fileInput"));
	     loadFile.sendKeys("C:\\Users\\Vinodh\\OneDrive\\Desktop\\flower.jpg");
	     WebElement saveButton1 = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
	     jse.executeScript("arguments[0].click()", saveButton1);
	     Thread.sleep(3000);
	     WebElement saveButton2 = driver.findElement(By.id("j_id0:j_id7:save"));
	     jse.executeScript("arguments[0].click()", saveButton2);	
	     Thread.sleep(1000);
	     driver.switchTo().defaultContent();
	}
	

	}
//WebElement FileLink = driver.findElement(By.xpath("//span[contains(@class,'publisherattachtext')][contains(text(),'File')]"));
//clickObj(FileLink, "FileLink"); System.out.println("Clicked on filelink");
//WebElement UploadFile = driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
//clickObj(UploadFile, "UploadFile");
//System.out.println("clicked on uploadfile button on computer");
//Thread.sleep(3000); WebElement choosefile =
//driver.findElement(By.xpath("//input[@id='chatterFile']"));
//enterText(choosefile, "C:\\Users\\admin\\Desktop\\SFDC 37 Testcases.xlsx",
//"choosefile"); System.out.println("choosefile option is selected");
//WebElement Share = driver.findElement(By.id("publishersharebutton"));
//clickObj(Share, "ShareButton");


