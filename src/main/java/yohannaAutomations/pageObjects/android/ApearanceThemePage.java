package yohannaAutomations.pageObjects.android;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.AndroidActions;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ApearanceThemePage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;
  

	public ApearanceThemePage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility="SYSTEM")
	private WebElement systemThemeOption;
	
	@AndroidFindBy(accessibility="LIGHT")
	private WebElement lightThemeOption;
	
	@AndroidFindBy(accessibility="DARK")
	private WebElement darkThemeOption;
	
	@AndroidFindBy(accessibility="Done")
	private WebElement doneButton;
	
	
	public void verifyThemeOptionsDisplayed() {
		try {
		validateDisplayOfUI(systemThemeOption, "systemThemeOption");
		validateDisplayOfUI(lightThemeOption, "lightThemeOption");
		validateDisplayOfUI(darkThemeOption, "darkThemeOption");
		}catch(Exception e) {
			takeScreenshot("verifyThemeOptionsDisplayed");
		}

	}
	
	public FeedscreenPage clickDoneButton() {
		try {
		doneButton.click();
		Thread.sleep(4000);
		}catch(Exception e) {
			takeScreenshot("clickDoneButton");
		}
		return new FeedscreenPage(driver);
	}
	
	
}


	



