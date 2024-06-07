package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constants.WaitConstant;
import listeners.TestListener;
import pages.CreateAccountPage;
import pages.CreateOpportunityPage;
import pages.LoginPage;
import utils.DataUtil;

@Listeners(TestListener.class)
public class CreateOpportunityTest extends BaseTest{
	
	@BeforeMethod()
	public void preCondtions() {
		System.out.println("Pre condtion login to app");
		BaseTest.setDriver("chrome", false);}
		
	@AfterMethod
	public void postCondtions() {
		System.out.println("post condtion to home page of the app");
		BaseTest.getDriver().close();}
	
	@Test
	public void OpportunityDropdown_Tc15() throws IOException, InterruptedException{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver,test);
		CreateOpportunityPage cop=new CreateOpportunityPage(driver);
		driver.get(DataUtil.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_DURATION);
		lp.loginToSFDC(DataUtil.readLoginTestData("valid.username"),DataUtil.readLoginTestData("valid.password"),false);
		Assert.assertTrue(cop.OpportunityHomePage(driver), "Opportunity HomePage shoud display");
		Assert.assertTrue(cop.isOpposDropdownDisplay(driver), "Opportunities View dropdrop menu should displayed");
}
}
