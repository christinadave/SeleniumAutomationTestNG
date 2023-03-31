package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import testcase.OrderFlowTest;

public class Listeners extends OrderFlowTest implements ITestListener {

	public void onTestSuccess(ITestResult result) {
		Reporter.log("Status of execution is - " + result.getStatus());
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log("Status of execution is - " + result.getStatus());
	}
}
