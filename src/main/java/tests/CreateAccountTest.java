package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import constants.WaitConstant;
import listeners.TestListener;
import pages.CreateAccountPage;
import pages.LoginPage;
import utils.DataUtil;

@Listeners(TestListener.class)
public class CreateAccountTest extends BaseTest{

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
	
	//@Test
	public void CreateAccount_Tc10() throws IOException, InterruptedException{
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver,test);
		CreateAccountPage cap=new CreateAccountPage(driver);
		driver.get(DataUtil.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_DURATION);
		lp.loginToSFDC(DataUtil.readLoginTestData("valid.username"),DataUtil.readLoginTestData("valid.password"),false);
		cap.clickAccountTab();
		Assert.assertTrue(cap.verifyAccountPage(driver),
				"AccountPage should be displayed with correct Username");
		test.log(Status.INFO, "Account page is displayed with correct UserName");
		cap.clickNewButton(driver);
		Assert.assertTrue(cap.verifyNewAccountPage(driver), "New account page should be displayed with account details");
		test.log(Status.INFO, "New Account page is displayed with given Account details");}

	//@Test
	public void CreateNewView_Tc11() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver,test);
		CreateAccountPage cap=new CreateAccountPage(driver);
		driver.get(DataUtil.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_DURATION);
		lp.loginToSFDC(DataUtil.readLoginTestData("valid.username"),DataUtil.readLoginTestData("valid.password"),false);
		cap.clickAccountTab();
		Assert.assertTrue(cap.verifyAccountPage(driver),
				"AccountPage should be displayed with correct Username");
		test.log(Status.INFO, "Account page is displayed with correct UserName");
		cap.clickCreateNewView(driver);
		Assert.assertTrue(cap.verifyNewlyAddedview(driver), "Newely added View should be displayed in the account view list");
		test.log(Status.INFO,"Newely added View should be displayed in the account view list");}
	
	//@Test
	public void ClickEditView_Tc12() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver,test);
		CreateAccountPage cap=new CreateAccountPage(driver);
		driver.get(DataUtil.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_DURATION);
		lp.loginToSFDC(DataUtil.readLoginTestData("valid.username"),DataUtil.readLoginTestData("valid.password"),false);
		cap.clickAccountTab();
		Assert.assertTrue(cap.verifyAccountPage(driver),
				"AccountPage should be displayed with correct Username");
		test.log(Status.INFO, "Account page is displayed with correct UserName");
		Assert.assertTrue(cap.clickEditLink(driver), "Edit Page should be displayed");
		test.log(Status.INFO,"Edit Page should be displayed");
		Assert.assertTrue(cap.verifyEditViewpage(driver), "List of Account names&Last Activity columns should be displayed");
		test.log(Status.INFO,"List of Account names&Last Activity columns are displayed");}
	
	//@Test
	public void MergeAccounts_Tc13() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver,test);
		CreateAccountPage cap=new CreateAccountPage(driver);
		driver.get(DataUtil.readLoginTestData("app.url"));
		driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_DURATION);
		lp.loginToSFDC(DataUtil.readLoginTestData("valid.username"),DataUtil.readLoginTestData("valid.password"),false);
		cap.clickAccountTab();
		Assert.assertTrue(cap.verifyAccountPage(driver),
				"AccountPage should be displayed with correct Username");
		test.log(Status.INFO, "Account page is displayed with correct UserName");
		cap.SelectAccountMerge(driver);
		Assert.assertTrue(cap.MergebyAccounts(driver), "Merge by Accounts step 2 page should be displayed");
		test.log(Status.INFO, "Merge by Accounts step 2 page is displayed");
		Assert.assertTrue(cap.MergedAccoutListed(driver), "New merged Accounts should be displayed on Recently viewed page");
		test.log(Status.INFO, "New merged Accounts are displayed on Recently viewed page");}
	
	@Test
	public void CreateAccountReport_Tc14() throws IOException {
	WebDriver driver = BaseTest.getDriver();
	LoginPage lp = new LoginPage(driver,test);
	CreateAccountPage cap=new CreateAccountPage(driver);
	driver.get(DataUtil.readLoginTestData("app.url"));
	driver.manage().timeouts().implicitlyWait(WaitConstant.IMPLICIT_WAIT_DURATION);
	lp.loginToSFDC(DataUtil.readLoginTestData("valid.username"),DataUtil.readLoginTestData("valid.password"),false);
	Assert.assertTrue(cap.verifyAccountPage(driver),
			"AccountPage should be displayed with correct Username");
	test.log(Status.INFO, "Account page is displayed with correct UserName");
	cap.clickAccountTab();
	Assert.assertTrue(cap.verifyUnsavedReport(driver), "Unsaved Report page should be displyed");
	test.log(Status.INFO,"Unsaved Report page is displyed");
	Assert.assertTrue(cap.verifyListofAccounts(driver), "List of Accounts page should be displayed");
	test.log(Status.INFO, "List of Account page is displayed");
	Assert.assertTrue(cap.verifyReportPage(driver), "Report page should be displayed");
	test.log(Status.INFO, "Report is displayed");}
}


