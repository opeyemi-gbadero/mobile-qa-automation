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

public class DevotionalScreenPage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;

	public DevotionalScreenPage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="//android.widget.ImageView[contains(@content-desc, 'Devotional with Grace') and contains(@content-desc, 'Sharing how you’re feeling takes courage')]")
	private WebElement devotionalWelcomeModal;
	
	@AndroidFindBy(accessibility = "Continue")
	private WebElement continueButton;
	
	
	
	public WebElement getDevotionalWelcomeModal() {
		return devotionalWelcomeModal;
	}
	
	public WebElement getContinueButton() {
		return continueButton;
	}
	
}


	



