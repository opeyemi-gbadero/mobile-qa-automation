package utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.apache.commons.io.FileUtils;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class AndroidActions {
	AndroidDriver driver;
	public AndroidActions(AndroidDriver driver) {
		this.driver = driver;
	}
	public void swipeElement(WebElement element, String direction) {
	    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
	        "elementId", ((RemoteWebElement) element).getId(),
	        "direction", direction,
	        "percent", 0.9	  
	    ));
    
	}
	
	
	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/reports" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		
	}
	
	public void scrollDown(WebElement ele) {
	    Map<String, Object> scrollParams = new HashMap<>();
	    scrollParams.put("elementId", ((org.openqa.selenium.remote.RemoteWebElement) ele).getId());
	    scrollParams.put("left", 100);
		scrollParams.put("top", 100);
		scrollParams.put("width", 200);
		scrollParams.put("height", 200);
		scrollParams.put("direction", "down");
		scrollParams.put("percent", 10.0);
	    driver.executeScript("mobile: scrollGesture", scrollParams);
	}
	public void scrollDownLittle(WebElement ele) {
	    Map<String, Object> scrollParams = new HashMap<>();
	    scrollParams.put("elementId", ((org.openqa.selenium.remote.RemoteWebElement) ele).getId());
	    scrollParams.put("left", 100);
		scrollParams.put("top", 100);
		scrollParams.put("width", 200);
		scrollParams.put("height", 100);
		scrollParams.put("direction", "down");
		scrollParams.put("percent", 1.0);
	    driver.executeScript("mobile: scrollGesture", scrollParams);
	}
	
	public void scrollUp(WebElement element) {
	    Map<String, Object> scrollParams = new HashMap<>();
	    scrollParams.put("elementId", ((org.openqa.selenium.remote.RemoteWebElement) element).getId());
	    scrollParams.put("left", 100);
		scrollParams.put("top", 100);
		scrollParams.put("width", 200);
		scrollParams.put("height", 200);
		scrollParams.put("direction", "up");
		scrollParams.put("percent", 10.0);
	    driver.executeScript("mobile: scrollGesture", scrollParams);
	}
	
	
	
}
