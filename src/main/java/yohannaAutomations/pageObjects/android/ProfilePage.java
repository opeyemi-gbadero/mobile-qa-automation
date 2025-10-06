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

public class ProfilePage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;
    private LoginPageScreen loginPageScreen;

	public ProfilePage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
	this.loginPageScreen = new LoginPageScreen(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility="My Profile\nHello")
	private WebElement profileModal;
	
	@AndroidFindBy(accessibility="Create account to get started")
	private WebElement createAccountButton;
	
	@AndroidFindBy(accessibility="Bible Version\nKJV")
	private WebElement bibleVersionDropdown;
	
	@AndroidFindBy(accessibility="Language\nEnglish")
	private WebElement languageDropdown;
	
	@AndroidFindBy(accessibility="Preferences")
	private WebElement preferencesSection;
	
	@AndroidFindBy(accessibility="Terms of Use")
	private WebElement termsOfUseLink;
	
	@AndroidFindBy(accessibility="Privacy Policy")
	private WebElement privacyPolicyLink;
	
	@AndroidFindBy(accessibility="Account Management")
	private WebElement accountManagementButton;
	
	
	
	
	
	public void verifyProfilePageDisplay() {
		wait.until(ExpectedConditions.visibilityOf(profileModal));
		validateDisplayOfUI(profileModal, "profileModal");
		
	}
	
	public LoginPageScreen clickCreateAccountButton() {
		
		validateDisplayOfUI(createAccountButton, "createAccountButton");
		createAccountButton.click();
		
		return new LoginPageScreen(driver);
		}
	
	public void validateCreateAccountButton() {
		validateDisplayOfUI(createAccountButton, "createAccountButton");
		createAccountButton.click();
		wait.until(ExpectedConditions.visibilityOf(loginPageScreen.getLoginPage()));
		validateDisplayOfUI(loginPageScreen.getLoginPage(), "loginPage");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public LoginPageScreen navigateToLoginPage(SoftAssert softAssert) {
		try {
		validateDisplayOfUI(createAccountButton, "createAccountButton");
		createAccountButton.click();
		
		} catch(Exception e ) {
			takeScreenshot("navigateToLoginPage");
			softAssert.fail("Failed to navigate to Login Page from Profile Page");
		}
		return new LoginPageScreen(driver);
	}
	
	public BibleVersionPage validateBibleVersionDropdown() {
		validateDisplayOfUI(bibleVersionDropdown, "bibleVersionDropdown");
		bibleVersionDropdown.click();
		return new BibleVersionPage(driver);
	}
	
	public LanguagePage validateLanguageDropdown() {
		validateDisplayOfUI(languageDropdown, "languageDropdown");
		languageDropdown.click();
		return new LanguagePage(driver);
	}
	
	public PreferencePage validatePreferencesSection() {
		validateDisplayOfUI(preferencesSection, "preferencesSection");
		preferencesSection.click();
		return new PreferencePage(driver);
	}
	
	
	public WebElement getProfileModal() {
		return profileModal;
}
	
	public AccountManagementPage clickAccountManagementButton() {
		validateDisplayOfUI(accountManagementButton, "accountManagementButton");
		accountManagementButton.click();
		return new AccountManagementPage(driver);
	}
	public WebElement getAccountManagementButton() {
		return accountManagementButton;
}
}
	



