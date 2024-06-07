package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.WaitUtil;

public class CreateOpportunityPage extends BasePage {
	public CreateOpportunityPage(WebDriver driver) {
		super(driver);}
	
	@FindBy(id="Opportunity_Tab")
	public WebElement opportunityLink;
	
	@FindBy(xpath="//img[@title=\"Opportunity\"]")
	public WebElement page;
	
	@FindBy(id="fcf")
	public WebElement viewdownDropMenu;
	
	@FindBy(xpath="//input[@value=\" New \"]")
	public WebElement opporNewButton;
	
	@FindBy(id="opp3")
	public WebElement opportunityName;
	
	@FindBy(xpath="(//img[@class=\"lookupIcon\"])[1]")
	public WebElement accountName;
	
	@FindBy(id="lksrch")
	public WebElement serachInput;
	
	@FindBy(xpath="//input[@name=\"go\"]")
	public WebElement goButton;
	
	@FindBy(xpath="//a[@class=\" dataCell \"]")
	public WebElement firstRow;
	
	@FindBy(xpath="//span[@class=\"dateFormat\"]")
	public WebElement closeDate;
	
	@FindBy(xpath="//select[@id=\"opp11\"]")
	public WebElement stage;
	
	@FindBy(xpath="//input[@id=\"opp12\"]")
	public WebElement probability;
	
	@FindBy(id="opp6")
	public WebElement leadSource;
	
	@FindBy(id="opp17_lkwgt")
	public WebElement primayCampaign;
	
	 @FindBy(xpath="(//input[@name=\"save\"])[1]")
	 public WebElement saveButton;
	
	public boolean OpportunityHomePage(WebDriver driver){
		boolean isopportunityDisplayed=false;
		if(WaitUtil.waitforElement(driver, opportunityLink)) {
			opportunityLink.click();
			if(page.getText().equals("Opportunity")){
				System.out.println("Opportunity Homepage is displayed");
				isopportunityDisplayed=true;}
					}
		return isopportunityDisplayed;
	}
	
	public boolean isOpposDropdownDisplay(WebDriver driver) {
		String[] values = {"All Opportunities", "Closing Next Month", "Closing This Month", 
				"My Opportunities","New Last Week","New This Week","Opportunity Pipeline","Private","Recently Viewed Opportunities","Won" };
		if(WaitUtil.waitforElement(driver, viewdownDropMenu)) {
			Select view=new Select(viewdownDropMenu);
			viewdownDropMenu.click();
			
			List<WebElement> options= view.getOptions();
			if(options.size()!=values.length){
				return false;}
			int index=0;
			for(WebElement option:options ){
				if (!option.getText().equals(values[index])) {
					System.out.print(option.getText());
					return false;
				}
				index++;}
					}return true;
	}

	
}


