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
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FeedscreenWelcomeModalPage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;

	public FeedscreenWelcomeModalPage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(0)")
	private WebElement welcomeModalImage;
	
	//@AndroidFindBy(uiAutomator="new UiSelector().description(\"Welcome to Your Spiritual Journey\")")
	@AndroidFindBy(xpath="//android.view.View[@index = '2']")
	private WebElement welcomeModalTitle;
	
	//@AndroidFindBy(xpath="//android.view.View[@content-desc=\"it’s so good to have you here. May His Word be your place of rest, your source of peace, and the light that guides your journey. Yohanna is here to enrich your experience—helping you see, reflect, and engage with Scripture like never seen before, in a way that feels personal and alive.\"]")	
	@AndroidFindBy(xpath="//android.view.View[@index = '3']")
	private WebElement welcomeModalDescription;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(1)")
	private WebElement illustrativeInsightIcon;
	
	@AndroidFindBy(accessibility="Illustrative Insights")
	private WebElement illustrativeInsightLabel;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(2)")
	private WebElement immersiveModeIcon;
	
	@AndroidFindBy(accessibility="Immersive Mode")
	private WebElement immersiveModeLabel;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(3)")
	private WebElement trackYourProgressIcon;
	
	@AndroidFindBy(accessibility="Track your Progress")
	private WebElement trackYourProgressLabel;

	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(4)")
	private WebElement devotionalIcon;
	
	@AndroidFindBy(accessibility="Devotional")
	private WebElement devotionalLabel;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.view.View\").instance(5)")
	private WebElement welcomeModal;
	
	@AndroidFindBy(accessibility="Continue")
	private WebElement continueButton;
	
	@AndroidFindBy(accessibility="Choose your home-screen\nPersonalize your journey through the Word of God by selecting your preferred home page experience.")
	private WebElement chooseYourHomeScreenModal;
	public void validateWelcomeModal() {
		wait.until(ExpectedConditions.visibilityOf(welcomeModalImage));
		wait.until(ExpectedConditions.visibilityOf(welcomeModal));
		Assert.assertTrue(welcomeModalImage.isDisplayed(), "Welcome Modal Image is not displayed");
		
	
	}
	
	public HomescreenSelectionPage clickContinue() {
		Assert.assertTrue(continueButton.isDisplayed(), "Continue Button is not displayed");
		Assert.assertTrue(continueButton.isEnabled(), "Continue Button is not enabled");
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
		wait.until(ExpectedConditions.visibilityOf(chooseYourHomeScreenModal));
		Assert.assertTrue(chooseYourHomeScreenModal.isDisplayed(), "Choose your home-screen modal is not displayed");
		return new HomescreenSelectionPage(driver);

	}
	
}


	



