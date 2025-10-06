package utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
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
	        "percent", 1.0	  
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
	
	public void scrollDownUntilVisible(WebElement page, String accessibilityId) {
	    int maxScrolls = 10;
	    for (int i = 0; i < maxScrolls; i++) {
	        try {
	            WebElement element = driver.findElement(AppiumBy.accessibilityId(accessibilityId));
	            if (element.isDisplayed()) {
	                return; 
	            }
	        } catch (Exception e) {
	            
	        }
	       
	        Map<String, Object> scrollParams = new HashMap<>();
	        scrollParams.put("elementId", ((org.openqa.selenium.remote.RemoteWebElement) page).getId());
	        scrollParams.put("direction", "down");
	        scrollParams.put("percent", 1.0);
	        driver.executeScript("mobile: scrollGesture", scrollParams);
	    }
	    throw new RuntimeException("Element with accessibilityId '" + accessibilityId + "' not found after scrolling.");
	}

	
	public void validateButtonStatus(WebElement tab, String message) {
		Assert.assertTrue(tab.isEnabled(), message);
		Assert.assertTrue(tab.isDisplayed(), message);
	}
	
	public void validateDisplayOfUI(WebElement element, String elementName) {
		Assert.assertTrue(element.isDisplayed(), elementName + " is not displayed");
	}
	
	public void takeScreenshot(String fileName) {
	    try {
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        File destFile = new File(System.getProperty("user.dir") + "/screenshots/" + fileName + ".png");
	        FileUtils.copyFile(srcFile, destFile);
	        System.out.println(" Screenshot saved: " + destFile.getAbsolutePath());
	    } catch (IOException e) {
	        System.out.println("️ Failed to save screenshot: " + e.getMessage());
	    }
	}
	
	
}
