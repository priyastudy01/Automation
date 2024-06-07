package tests;

import java.io.IOException;
import java.lang.reflect.Method;
//import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import listeners.TestListener;
import pages.LoginPage;
import utils.CommonUtil;
import utils.DataUtil;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {
	
	@BeforeMethod(dependsOnGroups = {""})
	public void preCondtions(Method name) {
		System.out.println("Pre condtion login to app");
		BaseTest.setDriver("chrome", false);
		}
	
	@AfterMethod
	public void postCondtions() {
		System.out.println("post condtion to home page of the app");
		BaseTest.getDriver().close();
	}
	
	//@Test
		public void Tc1_verifyLoginValidUserInvalidPass()throws IOException {			
			//ExtentTest test = BaseTest.threadExtentTest.get();
			WebDriver driver = BaseTest.getDriver();
			LoginPage lp = new LoginPage(driver,test);
			driver.get(DataUtil.readLoginTestData("app.url"));
			Assert.assertTrue(lp.isuserNameDisplayed
			(driver, DataUtil.readLoginTestData("valid.username")), "Username field should be displayed");
			Assert.assertTrue(lp.isPasswordnull(driver), "PasswordField should be Null");
			String expectMsg="Please enter your password.";
			String actual=lp.errorMessage.getText();
			Assert.assertEquals(actual, expectMsg, "Error Messgae is matched");
			test.log(Status.INFO, "Validated the error Message");
			CommonUtil.captureScreenShot(driver);
			//throw new NoSuchElementException();
		}
	
	//@Test
	public void Tc2_verifyLoginWithCorrectCredentials()throws IOException {
//		BaseTest.test = extent.createTest("Tc2_verifyLoginWithCorrectCredentials1");
		//ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver,test);
		driver.get(DataUtil.readLoginTestData("app.url"));
		lp.loginToSFDC(DataUtil.readLoginTestData("valid.username"),DataUtil.readLoginTestData("valid.password"),false);
    	Assert.assertTrue(lp.verifyHomePage(driver), "Homepage should be displayed");
		CommonUtil.captureScreenShot(driver);
		//throw new NoSuchElementException();
	}
	
	@Test
	public void Tc3_verifyRememberUserNameCheck()throws IOException {
//		BaseTest.test = extent.createTest("Tc2_verifyLoginWithCorrectCredentials1");
		//ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver,test);
		driver.get(DataUtil.readLoginTestData("app.url"));
		lp.loginToSFDC(DataUtil.readLoginTestData("valid.username"),
				DataUtil.readLoginTestData("valid.password"),true);
		Assert.assertTrue(lp.verifyHomePage(driver),"Homepage should be displayed");
		lp.clickUserMenu(driver);
		lp.clickLogOut(driver);
		Assert.assertTrue(lp.verifyLoginRememberMe(driver), "Login remember should be checked");
		Assert.assertTrue(lp.verifyUserNameIsDisplayed(driver,
				DataUtil.readLoginTestData("valid.username")),
				"User name should be displayed");
		CommonUtil.captureScreenShot(driver);
	}
	
	//@Test
	public void Tc4B_verifyLoginwithWrongCredentials()throws IOException
	{
		//BaseTest.test=extent.createTest("Tc4B_verifyLoginwithWrongCredentials");
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver,test);
		driver.get(DataUtil.readLoginTestData("app.url"));
		lp.loginToSFDC("123","22131", false);
		String expectMsg="Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String actual=lp.errorMessage.getText();
		Assert.assertEquals(actual, expectMsg, "Error Messgae is matched");
		test.log(Status.INFO, "Validated the error Message");
    	CommonUtil.captureScreenShot(driver);

	}

		
	//@Test
	public void Tc4A_verifyForgetPassword()throws IOException {
		//BaseTest.test = extent.createTest("Tc4A_verifyForgetPassword");
		//ExtentTest test = BaseTest.threadExtentTest.get();
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver,test);
		driver.get(DataUtil.readLoginTestData("app.url"));
		lp.forgotPassword();
		Assert.assertTrue(lp.verifyForgotPasswordPageDisplay(driver), "Forgot Password Page should be displayed");
		lp.enterUsername(DataUtil.readLoginTestData("valid.username"));
		String expected="Check Your Email";
		String actual=lp.checkEmailPage.getText();
		Assert.assertEquals(actual, expected, "Check your EMail page should be diaplyed");
		test.log(Status.INFO, "Check your Email page is displayed");
		CommonUtil.captureScreenShot(driver);
		//throw new NoSuchElementException();
	}
	
	
}
