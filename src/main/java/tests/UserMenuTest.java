package tests;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constants.FileConstants;
import constants.WaitConstant;
import listeners.TestListener;
import pages.LoginPage;

import pages.UserMenuPage;
import utils.DataUtil;

@Listeners(TestListener.class)
public class UserMenuTest extends BaseTest {
	@BeforeMethod()
	public void preCondtions() {
		System.out.println("Pre condtion login to app");
		BaseTest.setDriver("chrome", false);
	}
	
	@AfterMethod
	public void postCondtions() {
		System.out.println("post condtion to home page of the app");
		BaseTest.getDriver().close();
	}
	
	@Test
	public void verifyMyProfile_TC06() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver,test);
		UserMenuPage ump = new UserMenuPage(driver);
		driver.get(DataUtil.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_DURATION);
		lp.loginToSFDC(DataUtil.readLoginTestData("valid.username"), DataUtil.readLoginTestData("valid.password"),false);
		ump.selectUserMenu();
		Assert.assertTrue(ump.selectUserMenuOption(driver, "My Profile"), "UserMenu option should be selected");
		ump.selectEditIcon(driver);
		Assert.assertTrue(ump.verifyEditContactIframe(driver), "Iframe should be loaded");
		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, "QA"), "LastName should be changed");
		Assert.assertTrue(ump.verifyCreatePost(driver, "Hello Java"), "Post should be created");
		Assert.assertTrue(ump.verifyFileUpload(driver, FileConstants.FILE_PATH), "File should be uploaded successfully");
		Assert.assertTrue(ump.verifyPhotoUpload(driver, FileConstants.IMAGE_PATH), "Photo should be uploaded successfully");
	}
	
	
  @Test
  public void selectUserMenuDropdown_TC05() throws IOException {
	  WebDriver driver=BaseTest.getDriver();
	  LoginPage lp=new LoginPage(driver,test);
	  UserMenuPage ump = new UserMenuPage(driver);
	  driver.get(DataUtil.readLoginTestData("app.url"));
	  driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_DURATION);
	  lp.loginToSFDC(DataUtil.readLoginTestData("valid.username"), DataUtil.readLoginTestData("valid.password"),false);
      Assert.assertTrue(lp.verifyHomePage(driver), "HomePage should be displayed"); 
      ump.selectUserMenu();
      Assert.assertTrue(ump.isuserMenuItemsDisplayed(driver), "UserMenu items should be displayed");}
  
  @Test
  public void logoutFromUsermenu_TC09() throws IOException, InterruptedException {
	  WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver,test);
		UserMenuPage ump = new UserMenuPage(driver);
		driver.get(DataUtil.readLoginTestData("app.url"));	
		driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_DURATION);
		lp.loginToSFDC(DataUtil.readLoginTestData("valid.username"), DataUtil.readLoginTestData("valid.password"),false);
		ump.selectUserMenu();
		Assert.assertTrue(ump.isuserMenuItemsDisplayed(driver),"UserMenu items should be displayed");
		Assert.assertTrue(ump.selectUserMenuOption(driver, "Logout"), "App should be logged out");
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), DataUtil.readLoginTestData("relogin.url"));
		  }
  
  @Test
  public void selectDevConsole_Tc08() throws IOException{
	  WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver,test);
		UserMenuPage ump = new UserMenuPage(driver);
		driver.get(DataUtil.readLoginTestData("app.url"));	
		driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_DURATION);
		lp.loginToSFDC(DataUtil.readLoginTestData("valid.username"), DataUtil.readLoginTestData("valid.password"),false);
		ump.selectUserMenu();
		Assert.assertTrue(ump.isuserMenuItemsDisplayed(driver),"UserMenu items should be displayed");
		Assert.assertTrue(ump.selectUserMenuOption(driver, "Developer Console"), "Developer Console should be selected");
		Assert.assertTrue(ump.isDevConsoleClosed(driver), "Developer console Closed");
		Set<String>getAllWindows=driver.getWindowHandles();
		String[] getWindow=getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[0]);
		test.info("Home page validation");
		Assert.assertTrue(lp.verifyHomePage(driver), "Home Page should be displayed");
	  
  }
  
  @Test
  public void selectMySettings_Tc07() throws IOException, InterruptedException{
	  WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver,test);
		UserMenuPage ump = new UserMenuPage(driver);
		driver.get(DataUtil.readLoginTestData("app.url"));	
		driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_DURATION);
		lp.loginToSFDC(DataUtil.readLoginTestData("valid.username"), DataUtil.readLoginTestData("valid.password"),false);
		ump.selectUserMenu();
		Assert.assertTrue(ump.isuserMenuItemsDisplayed(driver),"UserMenu items should be displayed");
		Assert.assertTrue(ump.selectUserMenuOption(driver, "My Settings"), "My Settings should be selected");
		Assert.assertTrue(ump.mySettingPageDisply(driver), "Personal Link should be clicked");
		Assert.assertTrue(ump.isLoginHistoryPageDisplay(driver), "LoginHistory page should be displayed and Data should be downloaded");
		ump.DisplayLayoutlink();
		ump.customAppAvailTab(driver);
		Assert.assertTrue(ump.verifyAddedReport(driver), "Reports should be added in the Selected Tab and Salesforce page");
		ump.clickSaleMenuApp(driver);
		Assert.assertTrue(ump.verifyClickEmailLink(driver), "Given details are saved in My Email Settings page");
		ump.clickCalendar(driver);
		Assert.assertTrue(ump.verifySampleEventpopup(driver), "Sample Event should be displayed");
}
}
