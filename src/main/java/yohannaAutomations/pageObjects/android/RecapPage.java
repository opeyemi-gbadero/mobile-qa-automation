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

public class RecapPage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;
    private LoginPageScreen loginPage;

	public RecapPage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    this.loginPage = new LoginPageScreen(driver);
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="//android.widget.ImageView[contains(@content-desc, 'View your Recap')]")
	private WebElement recapWelcomePage;
	
	@AndroidFindBy(accessibility = "Continue")
	private WebElement continueButton;
	
	private void validateDisplayOfElement(WebElement element, String elementName) {
		Assert.assertTrue(element.isDisplayed(), elementName + " is not displayed");
	}
	private void validateElementClickable(WebElement element, String elementName) {
		Assert.assertTrue(element.isEnabled(), elementName + " is not clickable");
	}
	public void validateDisplayOfRecapWelcomePage() {
		validateDisplayOfElement(recapWelcomePage, "Recap Welcome Page");
	}
	public void validateRecapContinueButton() {
		validateDisplayOfElement(continueButton, "Continue Button");
		validateElementClickable(continueButton, "Continue Button");
		continueButton.click();

	}
	
	
	public FeedscreenPage validateLoginPageDisplay() {
		wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginPage()));
		validateDisplayOfElement(loginPage.getLoginPage(), "Login Page");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		return new FeedscreenPage(driver);
	}
	
	
}


	



