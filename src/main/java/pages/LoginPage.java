package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.WaitUtil;

public class LoginPage extends BasePage {
	public ExtentTest testLogin;

	public LoginPage(WebDriver driver,ExtentTest test) {
		super(driver);
		testLogin = test;
			
	}
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "Login")
	public WebElement loginButton;
	
	@FindBy(id="home_Tab")
	public WebElement homeTab;
	
	@FindBy(xpath = "//*[@id='rememberUn']")
	public WebElement rememberMe;

	@FindBy(id = "error")
	public WebElement errorMessage;

	@FindBy(partialLinkText = "Forgot")
	public WebElement forgotPassword;

	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;

	@FindBy(id = "un")
	public WebElement forgotUsername;
	
	@FindBy(id="continue")
	public WebElement continueButton;
	
	@FindBy(xpath="//h1[text()='Check Your Email']")
	public WebElement checkEmailPage;
	
	@FindBy(xpath="//div[@id=\"userNav\"]")
	public WebElement userMenu;
	
	@FindBy(xpath="//a[@title=\"Logout\"]")
	public WebElement logOut;
	
	@FindBy(id="header")
	public WebElement forgotYourPasswordPage;

	public void loginToSFDC(String userEmail, String passWord,boolean rememberMe) {
		
		this.username.sendKeys(userEmail);
		testLogin.log(Status.INFO, "Entered Valid username");
		this.password.sendKeys(passWord);
		testLogin.log(Status.INFO, "Entered Valid username");
		if (rememberMe) {
			if(!(this.rememberMe.isSelected())) {
				this.rememberMe.click();
			}
		}
		this.loginButton.click();
		logger.info("Should be signed in to application");
		
		}
	public boolean verifyHomePage(WebDriver driver) {
		boolean isHomepageDisplayed=false;
		if(WaitUtil.waitforElement(driver,homeTab))
			if (this.homeTab.isDisplayed() && this.homeTab.isEnabled()){
				isHomepageDisplayed=true;
			}
		else {
			System.out.println("Home Tab is not visible");}
		return isHomepageDisplayed;}
		
		
	public boolean isuserNameDisplayed(WebDriver driver,String userEmail)
	{
		boolean userNameDisplayed=false;
		if(WaitUtil.waitforElement(driver, username))
		{
			testLogin.log(Status.INFO, "username field is displayed");
			this.username.sendKeys(userEmail);
//			System.out.println("USERNAME:" + this.username.getAttribute("value"));
			if (this.username.getAttribute("value").equals(userEmail)){
				userNameDisplayed= true;
			}			
		}
		else {
			System.out.println("USerName Field is not displayed");}
		return userNameDisplayed;}
   
   public boolean isPasswordnull (WebDriver driver)
   {  
	   boolean passwordField= false;
	   if(WaitUtil.waitforElement(driver, password))
	   {
//		   String passWord= null;
		   this.password.clear();
		   testLogin.log(Status.INFO, "Entered password is Null");
		   this.loginButton.click();
		   passwordField=true;
	   }
	   else {
		   System.out.println("password is not displayed");}
	   return passwordField;}
   
	public void clickUserMenu(WebDriver driver) {
		if (WaitUtil.waitforElement(driver, userMenu)) {
		Actions action=new Actions(driver);
		action.moveToElement(userMenu).build().perform();
		userMenu.click();
		System.out.println("Pass: Usermenu is clicked");
		
		}
		else {
			 System.out.println("User Menu isn't displayed");
		}
	}
	
	public void clickLogOut(WebDriver driver) {
		if (WaitUtil.waitforElement(driver, logOut)) {
			logOut.click();
		}
		else {
			System.out.println("Logout button isn't displayed");
		}
	}
	
	public boolean verifyLoginRememberMe(WebDriver driver) {
		boolean isRememberMe = false; 
		if (WaitUtil.waitforElement(driver, rememberMe)) {
			if (this.rememberMe.isSelected()) isRememberMe=true;
		}
		return isRememberMe;
	}
	
	public boolean verifyUserNameIsDisplayed(WebDriver driver,String userName) {
		boolean userNameDisplayed = false; 
		if (WaitUtil.waitforElement(driver, savedUsername)) {
		if (this.username.getAttribute("value").equals(userName)) {
			userNameDisplayed= true;}
		}
		return userNameDisplayed;
	}
	 public void forgotPassword()
	 {
		 this.username.clear();
		 testLogin.log(Status.INFO, "Username field is empty");
		 this.password.clear();
		 testLogin.log(Status.INFO, "Password field is empty");
		 this.forgotPassword.click();
	 }
	 
	 public boolean verifyForgotPasswordPageDisplay(WebDriver driver)
	 { 
		 boolean isforgotPagedisplayed=false;
		if(WaitUtil.waitforElement(driver, forgotYourPasswordPage))
				if (this.forgotYourPasswordPage.isDisplayed())
				{
					testLogin.log(Status.INFO, "Forgot your password page is displayed");
				isforgotPagedisplayed=true;
				}
		 return isforgotPagedisplayed;
	 }
	 
	 public void enterUsername(String username)
	 {
		 forgotUsername.sendKeys(username);
		 continueButton.click();
		 
	 }
}
	
   
   
	   
	

	


