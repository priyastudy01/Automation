package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.CommonUtil;
import utils.DataUtil;
import utils.WaitUtil;

public class UserMenuPage extends BasePage {

	public UserMenuPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(xpath = "//a[@title='My Profile']")
	public WebElement myProfile;

	@FindBy(id = "userNav-menuItems/a[2]")
	public WebElement mySettings;

	@FindBy(id = "userNav-menuItems/a[3]")
	public WebElement developersConsole;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement switchToLightningExperience;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement logout;

	// My profile
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editContactButton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement editProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement aboutTab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement aboutTabLastName;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id='tailBreadcrumbNode']")
	public WebElement userProfilePageNameDisplay;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement filelink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentpost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement Uploadfile;

	@FindBy(css = "#chatterFile")
	public WebElement Fileopen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;
	// Photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;

	@FindBy(id = "publishersharebutton")
	public WebElement photosharebutton;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;
	// My Settings
	// personallink

	@FindBy(xpath = "//*[@id=\'PersonalInfo_font\']")
	public WebElement personallink;

	@FindBy(xpath = "//*[@id=\"LoginHistory_font\"]")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement logindisplay;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	// Display&layoutlink

	@FindBy(xpath = "//*[@id=\"DisplayAndLayout_font\"]")
	public WebElement DisplayLayoutlink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	@FindBy(id="p4")
	public WebElement customApp;
	
	@FindBy(id="duel_select_0")
	public WebElement Availabletab;

	//@FindBy(xpath = "//*[@id=\"duel_select_0\"]/option[73]")
	

	@FindBy(xpath = "//*[@id=\"duel_select_0_right\"]/img")
	public WebElement Add;

	@FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
	public WebElement save;

	@FindBy(xpath = "//*[@id=\"report_Tab\"]")
	public WebElement tabListReport;
	
	@FindBy(id="duel_select_1")
	public WebElement selectedTab;
	

	// Emaillink
	
	@FindBy(id="EmailSetup_font")
	public WebElement Emaillink;

	@FindBy(id="EmailSettings_font")
	public WebElement MyEmailSettings;

	@FindBy(id="sender_name")
	public WebElement Emailname;

	@FindBy(xpath="//*[@id=\"sender_email\"]")
	public WebElement Emailaddress;

	@FindBy(id="auto_bcc1")
	public WebElement BCCradiobutton;

	@FindBy(name="save")
	public WebElement Saveonemail;
	
	@FindBy(id="meSaveCompleteMessage")
	public WebElement Emailconfirmation;
	

	// Calendar and Remainders
	@FindBy(id ="CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(id ="Reminders_font")
	public WebElement ActivityRemainder;

	@FindBy(id ="testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(id ="summary")
	public WebElement SampleEventPopup;

	@FindBy(css = "#displayBadge")
	public WebElement moderatorButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
	public WebElement firstPostText;

	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;

	@FindBy(name = "j_id0:waitingForm")
	public WebElement spinnerIcon;

	@FindBy(id = "cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;

	@FindBy(id = "progressIcon")
	public WebElement fileUploadSpinner;

	@FindBy(id="editors")
	public WebElement DeveloperConsoleEditor;
	
	@FindBy(className="pShowMore")
	public WebElement DownloadLoginHistory;
	
	@FindBy(id="tsidButton")
	public WebElement MenuApp;
	
	public void selectUserMenu() {
		if (userMenu.isDisplayed()) {
			userMenu.click();
		} else {
			System.out.println("Element is not displayed");
		}
	}

	public boolean selectUserMenuOption(WebDriver driver, String option) {
		boolean isOptionVerified = false;
		logger.debug("Selecting an user menu option: "+option);
		WebElement userMenuOption = driver.findElement(By.xpath("//*[text()='" + option + "']"));
		if (WaitUtil.waitforElement(driver, userMenuOption)) {
			logger.debug(option+" was visible");
			userMenuOption.click();
			logger.debug(option+" was clicked");
			isOptionVerified = true;
		} else {
			System.out.println(option + " Option is not visible");
			logger.debug(option+" Could not be selected");
		}
		return isOptionVerified;
	}

	public void selectEditIcon(WebDriver driver) {
		if (WaitUtil.waitforElement(driver, editContactButton)) {
			editContactButton.click();
		} else {
			System.out.println("Edit contact button was not visible");
		}
	}

	public boolean verifyEditContactIframe(WebDriver driver) {
		boolean isIframeLoaded = false;
		if (WaitUtil.waitforElement(driver, iframeAboutTab)) {
			driver.switchTo().frame(iframeAboutTab);
			if (aboutTab.isDisplayed() && contactTab.isDisplayed()) {
				isIframeLoaded = true;
			} else {
				System.out.println("Iframe is not Loaded");
			}
		}
		return isIframeLoaded;
	}

	/**
	 * @param driver
	 * @param lastName
	 * @return
	 */
	public boolean verifyLastNameChangeInAboutTab(WebDriver driver, String lastName) {
		boolean isLastNameChanged = false;
		if (aboutTab.isDisplayed()) {
			aboutTab.click();
			aboutTabLastName.clear();
			aboutTabLastName.sendKeys(lastName);
			saveAllButton.click();
			driver.switchTo().parentFrame();
		}
		if (userProfilePageNameDisplay.isDisplayed()) {
			String actualName = userProfilePageNameDisplay.getText();
			if (actualName.contains(lastName)) {
				isLastNameChanged = true;
			} else {
				System.out.println("Last name is not changed");
			}
		}
		return isLastNameChanged;
	}

	/**
	 * @param driver
	 * @param message
	 * @return
	 */
	public boolean verifyCreatePost(WebDriver driver, String message) {
		boolean isPostCreated = false;
		if(postLink.isDisplayed()) {
			postLink.click();
			driver.switchTo().frame(0);
			postTextArea.sendKeys(message);
			driver.switchTo().defaultContent();
			if(shareButton.isDisplayed()) {
				shareButton.click();
				isPostCreated = true;
			} else {
				System.out.println("Share button is not enabled");
			}
		}
		return isPostCreated;
	}

	public boolean verifyFileUpload(WebDriver driver, String filePath) throws InterruptedException {
		boolean isFileUploadSuccess  = false;
		Thread.sleep(4000);
		if(WaitUtil.waitforElement(driver, filelink)) {			
			filelink.click();
			if(WaitUtil.waitforElement(driver, Uploadfile)) {
				Uploadfile.click();
			}
			if(WaitUtil.waitforElement(driver, Fileopen)) {
				Fileopen.sendKeys(filePath);
				shareButton.click();
				if(WaitUtil.waitForElementToDisappear(driver, cancelUpload)) {
					if(verifyFilePostElement.isDisplayed()) {
						isFileUploadSuccess = true;
					}
				}
			}
		}
		return isFileUploadSuccess;
	}

	public void clickOnUpdatePhotoButton(WebDriver driver) {
		CommonUtil.mouseHover(driver, moderatorButton);
		if(updateButton.isDisplayed()) {
			updateButton.click();
		}
	}

	public boolean verifyPhotoUpload(WebDriver driver, String imageFilePath) throws InterruptedException {
		boolean isPhotoUploadSuccess = false;
		this.clickOnUpdatePhotoButton(driver);
		driver.switchTo().frame(photoUploadIframe);
		if(WaitUtil.waitforElement(driver, uploadphoto)) {
			uploadphoto.sendKeys(imageFilePath);
			photoSaveButton.click();
		}
		Thread.sleep(4000);
		//		WaitUtil.waitForElementToDisappear(driver, spinnerIcon) 
		//		&&
		if( WaitUtil.waitforElement(driver, photoSaveButton2)) {
			photoSaveButton2.click();
			Thread.sleep(10000);
			if(WaitUtil.waitForElementToDisappear(driver, spinnerWhileCropping)) {
				isPhotoUploadSuccess = true;
			}
		}
		driver.switchTo().parentFrame();
		return isPhotoUploadSuccess;
	}

	public boolean isuserMenuItemsDisplayed(WebDriver driver){
		String[] values = {"My Profile", "My Settings", "Developer Console", 
				"Switch to Lightning Experience","Logout" };
		if(userMenuOptions.size()!=values.length){
			return false;}
		int index=0;
		for(WebElement subElement:userMenuOptions ){
			if (!subElement.getText().equals(values[index])) {
				System.out.print(subElement.getText());
				return false;
			}
			index++;}
		return true;
	}	
	//Tc08
	public boolean isDevConsoleClosed(WebDriver driver) {
		boolean isDevConsoleOpened=false;

		Set<String>getAllWindows=driver.getWindowHandles();
		String[] getWindow=getAllWindows.toArray(new String[getAllWindows.size()]);
		driver.switchTo().window(getWindow[1]);
		isDevConsoleOpened=true;
		if(WaitUtil.waitforElement(driver, DeveloperConsoleEditor))
		{
			System.out.println("Pass: Developer console page is opened");
			driver.close();
		}
		else
		{System.out.println("Fail: Developer console page is not opened");}
		return isDevConsoleOpened;
	}
 public boolean mySettingPageDisply(WebDriver driver) {
	 boolean ismySettingPageDisply=false;
	 if(WaitUtil.waitforElement(driver, personallink)) {
		 personallink.click();
		 ismySettingPageDisply=true;}
	 return ismySettingPageDisply;
 }

 public boolean isLoginHistoryPageDisplay(WebDriver driver) {
	 boolean isLoginHistoryDisplay=false;
	 if(loginHistorylink.isDisplayed()) {
		 loginHistorylink.click();
		 if(WaitUtil.waitforElement(driver, logindisplay)){
			 System.out.println("LoginDisplay data is loaded");
			 DownloadLoginHistory.isDisplayed();
			 DownloadLoginHistory.click();
			 System.out.println("Downloaded completed successfully");}
			 isLoginHistoryDisplay=true; }
		 return isLoginHistoryDisplay;
		 }
	 
public void DisplayLayoutlink() {
	if (DisplayLayoutlink.isDisplayed()) {
		DisplayLayoutlink.click();
		if (CustomizedTab.isDisplayed()) {
			CustomizedTab.click();}
	} else {
		System.out.println("DisplayLayoutlink &Customized my Tab are not displayed");}
	}
	public void customAppAvailTab(WebDriver driver) throws InterruptedException {
		CommonUtil.selectAnOptionFromDropDown(customApp, "Salesforce Chatter");
		Thread.sleep(2000);
		CommonUtil.selectAnOptionFromDropDown(Availabletab, "Reports");
		Thread.sleep(2000);
		if(WaitUtil.waitforElement(driver, Add)){
			Add.click();
			if(save.isDisplayed()) {
			save.click();}
		}
	}
	public boolean verifyAddedReport(WebDriver driver) {
		boolean isReportadded=false;
		this.DisplayLayoutlink();
		CommonUtil.selectAnOptionFromDropDown(customApp, "Salesforce Chatter");
		if (WaitUtil.waitforElement(driver, selectedTab)) {
			if(CommonUtil.isItemInDropDown(selectedTab,"Reports")) {				
			System.out.println(" Reports are displyed in Selected Tab");
		}
		ArrayList<String> menuItems = new ArrayList<String>();
		menuItems.add("Salesforce Chatter");
		menuItems.add("Marketing CRM Classic");
		for(String menuItem: menuItems) {
			MenuApp.click();
			this.selectUserMenuOption(driver,menuItem);
						
			if(WaitUtil.waitforElement(driver, tabListReport)) {
				System.out.println("Reports are available in top of Salesforce Page");
				isReportadded=true;
			}		
			else {System.out.println("Reports are not displayed");}		
			}
		}
		
		return isReportadded;
		
	}	
	public void clickSaleMenuApp(WebDriver driver) {
		MenuApp.click();
		this.selectUserMenuOption(driver, "Sales");
		this.selectUserMenu();
		this.selectUserMenuOption(driver,"My Settings");
	}
	
	public boolean verifyClickEmailLink(WebDriver driver) throws InterruptedException{
	 boolean isClickedEmailLink=false;
		if(WaitUtil.waitforElement(driver,Emaillink)) {
			Emaillink.click();
			if(MyEmailSettings.isDisplayed()) {
				MyEmailSettings.click();
			}
			
			if(Emailname.isDisplayed()) {
				try {
					if(Emailname.getAttribute("value").equalsIgnoreCase(DataUtil.readLoginTestData("emailname"))){
						System.out.println("Email name is prepopulated");
						if(Emailaddress.getAttribute("value").equalsIgnoreCase(DataUtil.readLoginTestData("emailaddress"))) {
							System.out.println("Email Address is prepolulated");
							if(BCCradiobutton.getAttribute("value").equals("1")){
								System.out.println("Email automatic bcc 'Yes' is checked");
								Saveonemail.click();
								isClickedEmailLink=true;
							}}}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Thread.sleep(2000);
				if(WaitUtil.waitforElement(driver, Emailconfirmation))
				{
					System.out.println("My Setting Email page is saved");
				}
				else {
					System.out.println("My setting Email page is not displayed");
				}
			}
		}
		return(isClickedEmailLink);
	}
	public void clickCalendar(WebDriver driver) {
		if(WaitUtil.waitforElement(driver, CalendarAndReminders)) {
			CalendarAndReminders.click();
			if(ActivityRemainder.isDisplayed()) {
				ActivityRemainder.click();
				
			}
		}
	}
	public boolean verifySampleEventpopup(WebDriver driver) {
		boolean ispopupopenend=false;
		if(WaitUtil.waitforElement(driver, OpenaTestRemainder)) {
			OpenaTestRemainder.click();
		}
		String parent=driver.getWindowHandle();
		for(String handle : driver.getWindowHandles()) { 
			if(handle != parent) {
			driver.switchTo().window(handle);}
			String title=driver.getTitle();
			System.out.println(title);
			if(title.contains("Reminder"))
			{
				System.out.println("Pass: Sample Event popup window is displayed");}
				
				else
			{System.out.println("Fail:Sample Event popup window is not displayed");}
			ispopupopenend=true;
		}
		return ispopupopenend;
	}
}


