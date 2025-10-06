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

public class PreferencePage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;
    private LoginPageScreen loginPageScreen;
    private FeedscreenPage feedscreenPage;

	public PreferencePage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
	this.loginPageScreen = new LoginPageScreen(driver);
	this.feedscreenPage = new FeedscreenPage(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@index = '1']")
	private WebElement themeButton;
	
	
	@AndroidFindBy(accessibility = "Appearance\nSystem\nSwitch between light and dark modes to suit your reading environment")
	private WebElement appearanceButton;
	
	
	
	public ApearanceThemePage clickThemeButton() {
		appearanceButton.click();
		return new ApearanceThemePage(driver);
	}
	
	
	
}


	



