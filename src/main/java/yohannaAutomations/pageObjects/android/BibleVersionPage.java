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

public class BibleVersionPage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;
    private LoginPageScreen loginPageScreen;
    private FeedscreenPage feedscreenPage;
    private ProfilePage profilePage;
    
	public BibleVersionPage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
	this.loginPageScreen = new LoginPageScreen(driver);
	this.feedscreenPage = new FeedscreenPage(driver);
	this.profilePage = new ProfilePage(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/* @AndroidFindBy(accessibility="Select bible version")
	private WebElement bibleVersionModalPage;
	*/
	@AndroidFindBy(xpath="//android.view.View[@index = '1']")
	private WebElement bibleVersionModalPage;
	
	@AndroidFindBy(accessibility="King James Version in English")
	private WebElement kjvVersion;
	
	@AndroidFindBy(accessibility="American Standard Version in English")
	private WebElement asvVersion;
	
	
	public void validateDisplayOfBibleVersionPage() {
		try {
		wait.until(ExpectedConditions.visibilityOf(kjvVersion));
		validateDisplayOfUI(kjvVersion, "King James Version");
		validateDisplayOfUI(asvVersion, "American Standard Version");
		}catch(Exception e) {
			takeScreenshot("validateDisplayOfBibleVersionPage");
			Assert.fail("Bible Version page is not displayed");
		}
		
	}
	public void navigatoProfilePage()  {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		feedscreenPage.getProfileIcon().click();
		wait.until(ExpectedConditions.visibilityOf(profilePage.getProfileModal()));		
		
	}
	
}


	



