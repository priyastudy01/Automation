package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.CommonUtil;
import utils.DataUtil;
import utils.WaitUtil;

public class CreateAccountPage extends BasePage {
	public CreateAccountPage(WebDriver driver) {
		super(driver);
	}
	// Account Tab
	@FindBy(id = "Account_Tab")
	public WebElement AccountsTab;

	@FindBy(id="userNavLabel")
	public WebElement UserNameDisplay;

	//New Account 

	@FindBy(xpath="(//input[@class='btn'])[3]")
	public WebElement NewAccountButton;

	@FindBy(id="acc2")
	public WebElement AccountName;

	@FindBy(id="acc6")
	public WebElement SelectType;

	@FindBy(id="00Nak000001jJim")
	public WebElement SelectPriority;

	@FindBy(xpath="(//input[@value=' Save '])[2]")
	public WebElement SaveButton;

	@FindBy(id="acc2_ileinner")
	public WebElement SavedAccountName;

	@FindBy(id="acc6_ileinner")
	public WebElement SavedType;

	@FindBy(id="00Nak000001jJim_ileinner")
	public WebElement SavedPriority;

	//Editview
	@FindBy(id="fcf")
	public WebElement ViewDropDown;

	@FindBy(xpath="(//a[contains(text(),'Edit')])[1]")
	public WebElement EditButton;

	@FindBy(xpath="//select[@id=\"fcol1\"]")
	public WebElement Field;

	@FindBy(xpath="//select[@id=\"fop1\"]")
	public WebElement Operator;

	@FindBy(xpath="//input[@id=\"fval1\"]")
	public WebElement Value;

	@FindBy(xpath="//select[@id=\"colselector_select_0\"]")
	public WebElement SelectFieldToDisplay;

	@FindBy(id="colselector_select_0_right")
	public WebElement AvailAddButton;

	@FindBy(xpath="(//input[@class=\"btn primary\"])[2]")
	public WebElement SaveEditView;

	@FindBy(id="ext-gen11")
	public WebElement NewAccountTable;

	@FindBy(xpath="//*[contains(text(),'Last Activity')]")
	public WebElement LastActivityColumn;
	//Create NewView page
	@FindBy(xpath="//*[contains(text(),'Create New View')]")
	public WebElement CreateNewViewLink;

	@FindBy(id="fname")
	public WebElement ViewName;

	@FindBy(id="devname")
	public WebElement ViewUniqueName;

	@FindBy(xpath="//input[@value=' Save ']")
	public WebElement Save;

	@FindBy(xpath="//select[@class=\"title\"]")
	WebElement NewlyAddedView;
	
	//MergeAccounts
	@FindBy(xpath="//*[contains(text(),'Merge Accounts')]")
	public WebElement MergeAccounts;

	@FindBy(id="srch")
	public WebElement SearchText;

	@FindBy(xpath="//input[@value=\"Find Accounts\"]")
	public WebElement FindAccounts;

	@FindBy(id="cid0")
	public WebElement Account1;

	@FindBy(id="cid1")
	public WebElement Account2;

	@FindBy(xpath="(//input[@value=' Next '])[2]")
	public WebElement NextMerge;

	@FindBy(xpath="(//input[@value=' Merge '])[1]")
	public WebElement MergeLink;

	@FindBy(className="ptRightTitle")
	public WebElement MergeStep2of2;

	@FindBy(id="hotlist_mode")
	public WebElement RecentlyViewed;

	@FindBy(xpath="(//th[@scope=\"row\"])[1]")
	public WebElement RecentAccount;

	//Report
	@FindBy(xpath="//a[contains(text(),'Accounts with')]")
	public WebElement accountLastActivity;
	
	@FindBy(className="pageDescription")
	public WebElement unsavedReport;

	@FindBy(id="ext-gen147")
	public WebElement dateField;

	@FindBy(className="x-combo-list-inner")
	public List<WebElement> datefieldOptions;

	@FindBy(id="ext-gen152")
	public WebElement calenderButton;

	@FindBy(xpath="//*[contains(text(),'Today')]")
	public WebElement todayDate;

	@FindBy(id="ext-gen254")
	public WebElement listOfRecords;

	@FindBy(id="ext-gen49")
	public WebElement saveClick;

	@FindBy(xpath="//input[@id=\"saveReportDlg_reportNameField\"]")
	public WebElement reportName;

	@FindBy(xpath="//input[@id=\"saveReportDlg_DeveloperName\"]")
	public WebElement reportUniName;

	@FindBy(xpath=" //*[contains(text(),'Save and Run Report')]")
	public WebElement saveaAndRunReport;

	@FindBy(className="noSecondHeader pageType")
	public WebElement reportPageName;





	//Tc14 
	public boolean verifyUnsavedReport(WebDriver driver) {
		boolean isunsavedReportDisaply=false;
		if(WaitUtil.waitforElement(driver, accountLastActivity)) {
			accountLastActivity.click();
			if(unsavedReport.isDisplayed()) {
				if(unsavedReport.getText().contains("Unsaved Report")){
					System.out.println("Unsaved report page is displayed");
					isunsavedReportDisaply=true;}
				else {System.out.println("Unsaved report page is not displayed");}
				
			}
			}
			return isunsavedReportDisaply;
	}
	public boolean verifyListofAccounts(WebDriver driver) {
		boolean isListAccountDisplay=false;
		if(WaitUtil.waitforElement(driver, dateField)) {
			dateField.click();
			// List<WebElements> listItems ;
			//listItems.get(1).click();
			datefieldOptions.get(1).click();
			if(calenderButton.isDisplayed()) {
				calenderButton.click();
			}
			if(todayDate.isDisplayed()) {
				todayDate.click();
			}
			if(listOfRecords.isDisplayed()) {
				System.out.println("List of Records are displayed");
				isListAccountDisplay=true;}
		} 
		return isListAccountDisplay;}

	public boolean verifyReportPage(WebDriver driver) throws IOException {
		boolean isReportPageDisplayed=false;
		if(WaitUtil.waitforElement(driver, saveClick)) {
			saveClick.click();
			if(WaitUtil.waitforElement(driver, reportName)) {
				reportName.sendKeys(DataUtil.readLoginTestData("reportname"));
				if(reportUniName.isDisplayed()) {
					reportUniName.click();
					if(saveaAndRunReport.isDisplayed()) {
						saveaAndRunReport.click();}
					if(WaitUtil.waitforElement(driver, reportPageName)) {
						if(reportPageName.isDisplayed())
						{System.out.println("Report Page is displayed");}
						isReportPageDisplayed=true;
					}
				}
			}
		} return isReportPageDisplayed;
	}



	public void clickAccountTab() {
		if(AccountsTab.isDisplayed()) {
			AccountsTab.click();
		}
		else {
			System.out.println("AccountTab is not displayed");
		}
	}
	public boolean verifyAccountPage(WebDriver driver) throws IOException {
		boolean isCorrectUsername=false;
		if(WaitUtil.waitforElement(driver, UserNameDisplay)) {
			if(UserNameDisplay.getText().equalsIgnoreCase(DataUtil.readLoginTestData("emailname"))){
				System.out.println("Account Page is displayed with correct UserName");
				isCorrectUsername=true;
			}
			else {
				System.out.println("Account Page is not displayed with correct UserName");
			}
		}
		return isCorrectUsername;
	}
	//Tc10
	public void clickNewButton(WebDriver driver) throws IOException {
		if(NewAccountButton.isDisplayed()) {
			NewAccountButton.click();
			if(WaitUtil.waitforElement(driver, AccountName)) {
				AccountName.sendKeys(DataUtil.readLoginTestData("accountname"));
				CommonUtil.selectAnOptionFromDropDown(SelectType, DataUtil.readLoginTestData("accounttype"));
				CommonUtil.selectAnOptionFromDropDown(SelectPriority, DataUtil.readLoginTestData("priority"));
				SaveButton.click();}
		}
	}
	public boolean verifyNewAccountPage(WebDriver driver) throws IOException, InterruptedException {
		boolean isNewAccountcreated=false;
		Thread.sleep(2000);
		if(WaitUtil.waitforElement(driver, SavedAccountName)) {
			if(SavedAccountName.getText().contains(DataUtil.readLoginTestData("accountname"))) {
				if(SavedType.getText().equals(DataUtil.readLoginTestData("accounttype"))) {
					if(SavedPriority.getText().equals(DataUtil.readLoginTestData("priority"))){						
						System.out.println("New Account Page is displayed with given details ");
						isNewAccountcreated=true;}
				}
			}
		}
		return isNewAccountcreated;
	}

	//Tc11
	public void clickCreateNewView(WebDriver driver) throws IOException {
		if(CreateNewViewLink.isDisplayed()) {
			CreateNewViewLink.click();}
		if(WaitUtil.waitforElement(driver, ViewName)) {
			ViewName.sendKeys(DataUtil.readLoginTestData("viewname"));
			ViewUniqueName.click();
			Save.click();}
		else {
			System.out.println("Create New ViewLink is not displayed");}
	}

	public boolean verifyNewlyAddedview(WebDriver driver) throws IOException {
		boolean isviewdisplayed=false;
		if(WaitUtil.waitforElement(driver, NewlyAddedView)) {
			Select dropdown = new Select(NewlyAddedView);
			if( dropdown.getFirstSelectedOption().getText().equals(DataUtil.readLoginTestData("viewname")));{
				System.out.println("Newly added View is displayed in the account view list");
				isviewdisplayed=true;}
		}
		return isviewdisplayed;}

	//Tc12
	public boolean clickEditLink(WebDriver driver) throws IOException {
		boolean isClickedEditlink=false;
		CommonUtil.selectAnOptionFromDropDown(ViewDropDown,DataUtil.readLoginTestData("viewname"));
		if(EditButton.isDisplayed()) {
			EditButton.click();
			isClickedEditlink=true;
		}
		return isClickedEditlink;
	}

	public boolean verifyEditViewpage(WebDriver driver) throws InterruptedException, IOException {
		boolean isEditViewPageDisplayed=false;
		if(WaitUtil.waitforElement(driver, ViewName)) {
			ViewName.clear();
			ViewName.sendKeys(DataUtil.readLoginTestData("changename"));
			CommonUtil.selectAnOptionFromDropDown(Field, DataUtil.readLoginTestData("field"));
			CommonUtil.selectAnOptionFromDropDown(Operator, DataUtil.readLoginTestData("operator"));
			Value.sendKeys(DataUtil.readLoginTestData("value"));
			CommonUtil.selectAnOptionFromDropDown(SelectFieldToDisplay, DataUtil.readLoginTestData("availfield"));
			AvailAddButton.click();
			SaveEditView.click();
			if(WaitUtil.waitforElement(driver, NewAccountTable)) {
				Thread.sleep(2000);
				if(NewAccountTable.isDisplayed()&& LastActivityColumn.isDisplayed()){
					System.out.println("List of Account names&Last Activity columns are displayed");
					isEditViewPageDisplayed=true;}
			}}
		return isEditViewPageDisplayed;

	}
	//Tc13
	public void SelectAccountMerge(WebDriver driver) throws IOException {
		if(MergeAccounts.isDisplayed()) {
			MergeAccounts.click();}
		if(WaitUtil.waitforElement(driver, SearchText)) {
			SearchText.sendKeys(DataUtil.readLoginTestData("searchtext"));
			FindAccounts.click();}
		if(WaitUtil.waitforElement(driver, Account1)) {
			if(!(Account1).isSelected()) {
				Account1.click();}
			if(!(Account2).isSelected()) {
				Account2.click();}
			NextMerge.click();}
	}
	public boolean MergebyAccounts(WebDriver driver) throws IOException {
		boolean isAccountMerged=false;
		//this.SelectAccountMerge(driver);
		if(WaitUtil.waitforElement(driver, MergeStep2of2)) {
			MergeLink.click();
			isAccountMerged=true;
		}
		return isAccountMerged;
	}
	public boolean MergedAccoutListed(WebDriver driver) throws IOException {
		boolean isMergedDisplay=false;
		driver.switchTo().alert().accept();
		CommonUtil.selectAnOptionFromDropDown(RecentlyViewed, DataUtil.readLoginTestData("mergeacc"));
		if(RecentAccount.getText().contains(DataUtil.readLoginTestData("searchtext"))){
			System.out.println("Merged Account is displayed");
			isMergedDisplay=true;
		}
		return isMergedDisplay;

	}
}