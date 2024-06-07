package listeners;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.CommonUtil;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import tests.BaseTest;
public class TestListener implements ITestListener {
	public void onTestStart(ITestResult name) {
		BaseTest.test = BaseTest.extent.createTest(name.getName());
		BaseTest.threadExtentTest.set(BaseTest.test);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		BaseTest.threadExtentTest.get().pass(result.getName());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		BaseTest.threadExtentTest.get().addScreenCaptureFromPath(CommonUtil.captureScreenShot(BaseTest.getDriver()));
		BaseTest.threadExtentTest.get().fail(MarkupHelper.createLabel("FAILED: " + result.getName(), ExtentColor.RED));

	}
}
