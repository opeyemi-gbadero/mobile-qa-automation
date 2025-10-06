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

public class LanguagePage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;
    private LoginPageScreen loginPageScreen;
    private FeedscreenPage feedscreenPage;
    //private ProfilePage profilePage = new ProfilePage(driver);

	public LanguagePage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
	this.loginPageScreen = new LoginPageScreen(driver);
	this.feedscreenPage = new FeedscreenPage(driver);
	//this.profilePage = new ProfilePage(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(accessibility="Select language")
	private WebElement languageModalPage;
	
	@AndroidFindBy(accessibility="English")
	private WebElement englishLanguage;
	
	@AndroidFindBy(accessibility="Portuguese")
	private WebElement portugueseLanguage;
	
	public void validateDisplayOfLanguagePage() {
		//wait.until(ExpectedConditions.visibilityOf(englishLanguage));
		validateDisplayOfUI(englishLanguage, "English Language");
		validateDisplayOfUI(portugueseLanguage, "Portuguese Language");
		
	}
	
	public ProfilePage navigatoProfilePage()  {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		feedscreenPage.getProfileIcon().click();
		return new ProfilePage(driver);
	//	wait.until(ExpectedConditions.visibilityOf(profilePage.getProfileModal()));		
		}
	
	
}


	



