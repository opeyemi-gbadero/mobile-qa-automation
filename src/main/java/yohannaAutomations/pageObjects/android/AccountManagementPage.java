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
import org.testng.asserts.SoftAssert;

import utils.AndroidActions;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AccountManagementPage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;
    private ProfilePage profilePage;
    private LoginPageScreen loginPageScreen;

	public AccountManagementPage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
	this.profilePage = new ProfilePage(driver);
	this.loginPageScreen = new LoginPageScreen(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility="Delete All Local Data")
	private WebElement deleteAllLocalDataButton;
	
	@AndroidFindBy(accessibility="Log Out")
	private WebElement logOutButton;
	
	@AndroidFindBy(accessibility= "Delete Account")
	private WebElement deleteAccountButton;
	
	
	public FeedscreenPage validateLogOutButtonFunctionality(SoftAssert softassert) {
		try {
		logOutButton.click();
		softassert.assertTrue(loginPageScreen.getLoginPage().isDisplayed());
		}catch(Exception e) {
			takeScreenshot("validateLogOutButtonFunctionality");
			softassert.fail("Log Out button functionality is not working");
		}
		
		return new FeedscreenPage(driver);
	
	
	}
	
}


	



