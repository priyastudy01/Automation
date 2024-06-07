package utils;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import constants.FileConstants;

public class CommonUtil {
	public static String captureScreenShot(WebDriver driver) {
		String filePath = FileConstants.Screenshots_FolderPath;
		TakesScreenshot page = (TakesScreenshot) driver;
		File src = page.getScreenshotAs(OutputType.FILE);
		File dst = new File(filePath);
		src.renameTo(dst);
		return filePath;
	}

	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	//Mouse hover action
	public static void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();}
		
	//Select from DropDownMenu
	public static void selectAnOptionFromDropDown(WebElement dropDown, String value) {
		Select DropDownList = new Select(dropDown);
		DropDownList.selectByVisibleText(value);
	}
	
	//select ratio button
	public static void radiobutton(WebElement button) {
		if(!(button).isSelected())
		{
			button.click();
			System.out.println("Radio button is checked");
		}
	}
	public static boolean isItemInDropDown(WebElement dropDown, String value) {
		Select DropDownList = new Select(dropDown);
		boolean optionFound = false;
		List<WebElement> elements = DropDownList.getOptions();
		for (WebElement element:elements) {
			if(element.getText().equals(value)) {
				optionFound = true;
			}
		}
		return optionFound;
	}
	
}
