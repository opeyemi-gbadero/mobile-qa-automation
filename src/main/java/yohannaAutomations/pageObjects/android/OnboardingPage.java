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

public class OnboardingPage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;

	public OnboardingPage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(4));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.ImageView")
	private WebElement splashScreen;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(1)")
	private WebElement yohannaLogo;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(0)")
	private WebElement backgroundImage;
	
	@AndroidFindBy(accessibility="Experience the Bible Like Never Before")
	private WebElement experienceTheBibleLikeNeverBefore;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Immerse yourself in Scripture through a visually rich and engaging journey, bringing timeless wisdom to life in a whole new way.\"]")
	private WebElement immerseYourselfInScripture;
	
	@AndroidFindBy(accessibility="Stay Connected Every Day")
	private WebElement stayConnectedEveryDay;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Start your day with an uplifting Verse of the Day, reflect on your emotions with the Mood Check-In, and deepen your spiritual connection with tools designed to inspire and guide you.\"]")
	private WebElement stayConnectedEveryDayDescription;
	
	@AndroidFindBy(accessibility="Next")
	private WebElement nextButton;
	
	@AndroidFindBy(accessibility="Strengthen Your Connection with God")
	private WebElement strengthenYourConnectionWithGod;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Take time for prayer, reflection, and growth. This space is designed to nurture your relationship with God and guide you on your spiritual journey.\"]")
	private WebElement takeTimeForPrayerReflectionAndGrowth;
	
	@AndroidFindBy(accessibility="Proceed")
	private WebElement Proceed;
	
	@AndroidFindBy(accessibility="Continue")
	private WebElement Continue;
	
	@AndroidFindBy(accessibility="Tap to Preview")	
	private WebElement TapToPreview;
	
	@AndroidFindBy(xpath="//android.widget.ImageView")
	private WebElement cancelPreview;
	
	@AndroidFindBy(accessibility="Set 'Daily Bread' as my Homepage")
	private WebElement setDailyBread;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(3)")
	private WebElement verseOfTheDayCard;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView/android.view.View[2]")
	private WebElement verseOfTheDayScrollable;
	
	@AndroidFindBy(accessibility="I am all done")
	private WebElement done;
	
	
	
	public void validateSplashScreen() {
		wait.until(ExpectedConditions.visibilityOf(splashScreen));
		Assert.assertTrue(splashScreen.isDisplayed(), "Splash screen is not displayed");
	}
	
	public void verifyTheDisplayOfYohannaLogo() {
		wait.until(ExpectedConditions.visibilityOf(yohannaLogo));
		Assert.assertTrue(yohannaLogo.isDisplayed(), "Yohanna logo is not displayed");
	}
	
	public void verifyTheDisplayOfFirstBackgroundImage() {
		wait.until(ExpectedConditions.visibilityOf(backgroundImage));
		Assert.assertTrue(backgroundImage.isDisplayed(), "First background image is not displayed");
	}
	
	public void verifyTheDisplayOfExperienceTheBibleLikeNeverBefore() {
		wait.until(ExpectedConditions.visibilityOf(experienceTheBibleLikeNeverBefore));
		Assert.assertTrue(experienceTheBibleLikeNeverBefore.isDisplayed(), "Experience the Bible Like Never Before text is not displayed");
	}
	
	public void verifyTheDisplayOfImmerseYourselfInScripture() {
		wait.until(ExpectedConditions.visibilityOf(immerseYourselfInScripture));
		Assert.assertTrue(immerseYourselfInScripture.isDisplayed(), "Immerse yourself in Scripture text is not displayed");
	}
	
	public void verifyTheDisplayOfStayConnectedEveryDay() {
		wait.until(ExpectedConditions.visibilityOf(stayConnectedEveryDay));
		Assert.assertTrue(stayConnectedEveryDay.isDisplayed(), "Stay Connected Every Day text is not displayed");
	}
	
	public void verifyTheDisplayOfStayConnectedEveryDayDescription() {
		wait.until(ExpectedConditions.visibilityOf(stayConnectedEveryDayDescription));
		Assert.assertTrue(stayConnectedEveryDayDescription.isDisplayed(), "Stay Connected Every Day description is not displayed");
	}
	
	public void validateNextButtonIsClickable() {
		wait.until(ExpectedConditions.elementToBeClickable(nextButton));
		Assert.assertTrue(nextButton.isEnabled(), "Next button is not clickable");
	}
	
	public void clickNext() {
		
		nextButton.click();
	}
	
	public void verifyTheDisplayOfStrengthenYourConnectionWithGod() {
		wait.until(ExpectedConditions.visibilityOf(strengthenYourConnectionWithGod));
		Assert.assertTrue(strengthenYourConnectionWithGod.isDisplayed(), "Strengthen Your Connection with God text is not displayed");
	}
	
	public void verifyTheDisplayOfTakeTimeForPrayerReflectionAndGrowth() {
		wait.until(ExpectedConditions.visibilityOf(takeTimeForPrayerReflectionAndGrowth));
		Assert.assertTrue(takeTimeForPrayerReflectionAndGrowth.isDisplayed(), "Take time for prayer, reflection, and growth text is not displayed");
	}
	
	public void validateProceedButtonIsClickable() {
		wait.until(ExpectedConditions.elementToBeClickable(Proceed));
		Assert.assertTrue(Proceed.isEnabled(), "Proceed button is not clickable");
	}
	
	public FeedscreenWelcomeModalPage clickProceed() {
		Proceed.click();
		return new FeedscreenWelcomeModalPage(driver);
	}
	
	
	
	
	
	//currently refactoring this code
	public void clickContinue() {
		Continue.click();
	}
	public void clickTapToPreview() {
		TapToPreview.click();
	}
	
	public void clickCancelPreview() {
		cancelPreview.click();
	}
	
	public void clickSetDailyBread() {
		setDailyBread.click();
	}
	
	public void clickNextButtons() {
		for(int i = 0; i < 6; i++) {
			nextButton.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
		
	public void SwipeVerseOfTheDay(){
		swipeElement(verseOfTheDayCard, "right");
		verseOfTheDayCard.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void scrollVerseOfTheDay() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean)((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				"elementId", ((org.openqa.selenium.remote.RemoteWebElement) verseOfTheDayScrollable).getId(),
				"left", 100,
				"top", 100,
				"width", 200,
				"height", 200,
				"direction", "down",
				"percent", 10.0
				));
		}while(canScrollMore);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
	
	}
	

	
	
	}


	



