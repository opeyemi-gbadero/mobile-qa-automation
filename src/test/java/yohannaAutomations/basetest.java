package yohannaAutomations;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import yohannaAutomations.pageObjects.android.OnboardingPage;


public class basetest {
	public 	AndroidDriver driver;
	public AppiumDriverLocalService service;
	public OnboardingPage onboardingPage;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
		 service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		UiAutomator2Options options = new  UiAutomator2Options();
		options.setDeviceName("Pixel8");
		//options.setApp("//Users//user//eclipse-workspace//Automation//src//test//java//resources//General-Store.apk");
		options.setApp("/Users/user/eclipse-workspace/YohannaProject/src/test/java/resources/app-staging-zza.apk");

		 driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 onboardingPage = new OnboardingPage(driver);
	}
	
	public void swipeElement(WebElement element, String direction) {
	    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
	        "elementId", ((RemoteWebElement) element).getId(),
	        "direction", direction,
	        "percent", 0.9	  
	    ));
    
	}
	
	
	public void scrollToContentDescAndroid(AndroidDriver driver, String contentDesc) {
	    // Use UiAutomator2 strategy with AppiumBy
	    String uiAutomatorScript = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"" + contentDesc + "\"))";
	    WebElement element = driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorScript));
	    System.out.println("Element found: " + element.getText());
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
