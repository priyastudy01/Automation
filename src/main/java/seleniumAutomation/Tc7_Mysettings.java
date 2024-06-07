package seleniumAutomation;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tc7_Mysettings {

	public static void main(String[] args) throws InterruptedException {
	//Log in method called from resuable class
				ReusableMethods reusableMethods = new ReusableMethods();
				WebDriver driver=new ChromeDriver();
				reusableMethods.loginToApp(driver);
				Thread.sleep(2000);
	// Click on User Menu option 
				WebElement userMenu=driver.findElement(By.xpath("//div[@id=\"userNav\"]"));
				Actions action=new Actions(driver);
				action.moveToElement(userMenu).build().perform();
				userMenu.click();
	//Check the user menu list
				Thread.sleep(2000);
				List<WebElement> subElements=driver.findElements(By.xpath("(//div[@class='mbrMenuItems'])[1]"));
					for(WebElement subElement:subElements )
				{
					System.out.println(subElement.getText());
				}
				Thread.sleep(2000);
	//Click on Mysettings
				WebElement mySettings=driver.findElement(By.xpath("//a[@title='My Settings']"));
				mySettings.click();
				System.out.println("Pass:My settings link is clicked");
	//Click on Personal
				WebElement personal=driver.findElement(By.xpath("//div[@id='PersonalInfo']"));
				personal.click();
				System.out.println("Pass:Personal link is clicked");
	//Click on login History
				WebElement loginHistory=driver.findElement(By.xpath("//a[@id='LoginHistory_font']"));
				loginHistory.click();
				System.out.println("Pass:LoginHistory link is clicked");
	//click on Download login History
				driver.findElement(By.className("pShowMore")).click();
				System.out.println("Pass:Downloaded completed successfully");
	//click on Display&Layout Link
				WebElement display=driver.findElement(By.xpath("//div[@id='DisplayAndLayout']"));
				display.click();
				System.out.println("Pass:Didplay&Layout link is clicked");
	//Click on customize my Tabs link
				driver.findElement(By.id("CustomizeTabs_font")).click();
				System.out.println("Pass:Customized my Tabs link is clicked");
	//Choose Saleforce chatter from dopdown Menu
				
				Select menu=new Select(driver.findElement(By.id("p4")));
				menu.selectByVisibleText("Salesforce Chatter");
				System.out.println("Pass:Chosen salesforce chatter from Drop down menu");
	// select report Tab from Available Tab
				Select availTab=new Select(driver.findElement((By.xpath("//*[@id='duel_select_0']"))));
				availTab.selectByVisibleText("Reports");
				WebElement add=driver.findElement(By.className("rightArrowIcon"));
				add.click();
				Thread.sleep(2000);
				System.out.println("Pass: Reports is added in Selected Tab");
	// Click on Email Link
				driver.findElement(By.xpath("(//a[@class=\"header setupFolder\"])[3]")).click();
				System.out.println("Pass:Email id link is clicked");
				driver.findElement(By.xpath("//a[@id='EmailSettings_font']")).click();
				System.out.println("Pass:My Email Settings link is clicked");
				WebElement 	emailName=driver.findElement(By.id("sender_name"));
				WebElement emailAddress=driver.findElement(By.id("sender_email"));
				WebElement autoBcc= driver.findElement(By.id("auto_bcc1"));
				if(emailName.isDisplayed()&&
						emailName.isEnabled()
						&& emailAddress.isDisplayed() && emailAddress.isEnabled()
						&& autoBcc.isSelected() && autoBcc.isEnabled()) {
					System.out.println("Validation pass");
				}
				else {
					System.out.println("Validation Fail");
				}
				driver.findElement(By.name("save")).click();
	//Click On Calender&Reminders
			driver.findElement(By.xpath("(//a[@class=\"header setupFolder\"])[5]")).click();
			driver.findElement(By.id("Reminders_font")).click();//click Activity reminder button
			driver.findElement(By.id("testbtn")).click();///click Test reminder button
			// It will return the parent window name as a String
			String parent=driver.getWindowHandle();
			for(String handle : driver.getWindowHandles()) { 
			  if(handle != parent) {
			      driver.switchTo().window(handle);
			  }
			      String title=driver.getTitle();
					System.out.println(title);
			  
						if(title.contains("Reminder"))
						{
							System.out.println("Pass: Sample Event popup window is displayed");
							driver.close();
						}
						else
						{System.out.println("Fail:Sample Event popup window is not displayed");

						}
			  }
			}
}
//			     String expectedUrl1 = driver.getCurrentUrl();
//			Set<String>s=driver.getWindowHandles();
//			// Now iterate using Iterator
//			Iterator<String> I1= s.iterator();
//			while(I1.hasNext())
//			{
//				String child_window=I1.next();
//				if(!parent.equals(child_window))
//				{
//					driver.switchTo().window(child_window);
//				}
//
//				System.out.println(driver.switchTo().window(child_window).getTitle());
//				Thread.sleep(3000);
		
			
	
//				String parentWindow = driver.getWindowHandle();
//			    for(String handle : driver.getWindowHandles()) { 
//			     if(handle != parentWindow) {
//			      driver.switchTo().window(handle);
//			     String expectedUrl1 = driver.getCurrentUrl();
//			     String actualUrl1 = "https://ap8.salesforce.com/ui/core/activity/ReminderSettingsPage?setupid=Reminders&retURL=%2Fui%2Fsetup%2FSetup%3Fsetupid%3DCalendarAndReminders";
//			      
//			     if(actualUrl1.equalsIgnoreCase(expectedUrl1)) {
//			       System.out.println("MySettings page is not Lunched");
//			     }
//			      else {
//			       System.out.println("User is on MySettings page");
//			      } 
//			     }
//			    }
//			}
//			
//				
//	}


