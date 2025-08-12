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

public class HomescreenSelectionPage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;

	public HomescreenSelectionPage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(0)")
	private WebElement welcomeModalImage;
	
	@AndroidFindBy(accessibility="Daily Bread (Feeds)")
	private WebElement dailyBreadModalScreen;
	
	@AndroidFindBy(accessibility="Bible Reading Screen")
	private WebElement bibleReadingScreenModal;
	
	@AndroidFindBy(accessibility="Tap to Preview")
	private WebElement tapToPreviewButton;
	
	@AndroidFindBy(accessibility="Set 'Daily Bread' as my Homepage")
	private WebElement setDailyBreadButton;
	
	@AndroidFindBy(accessibility="Set 'Reading Screen' as my Homepage")
	private WebElement setReadingScreenButton;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\")")
	private WebElement previewModalImage;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Default Home Screen Set!\"]")
	private WebElement defaultHomeScreenSetMessage;
	
	public void validateFeedscreenPreviewModalImage() {
		Assert.assertTrue(tapToPreviewButton.isEnabled(), "taptopreviewbutton modal image is not enabled");
		Assert.assertTrue(setDailyBreadButton.isEnabled(), "setDailyBreadButton is not enabled");
		tapToPreviewButton.click();
		Assert.assertTrue(previewModalImage.isDisplayed(), "Preview modal image is not displayed");
		previewModalImage.click();
		//wait.until(ExpectedConditions.invisibilityOf(previewModalImage));
		//Assert.assertFalse(previewModalImage.isDisplayed(), "Preview modal image is still displayed after clicking it");
	}
	
	public FeedscreenWalkThroughPage validateBibleScreenPreviewModalImage() {
		bibleReadingScreenModal.click();
		Assert.assertTrue(setReadingScreenButton.isEnabled(), "setReadingScreenButton is not enabled");
		Assert.assertTrue(tapToPreviewButton.isEnabled(), "taptopreviewbutton modal image is not enabled");
		tapToPreviewButton.click();
		Assert.assertTrue(previewModalImage.isDisplayed(), "Preview modal image is not displayed");
		previewModalImage.click();
		//Assert.assertFalse(previewModalImage.isDisplayed(), "Preview modal image is still displayed after clicking it");
		setReadingScreenButton.click();
		wait.until(ExpectedConditions.invisibilityOf(setReadingScreenButton));
		
		return new FeedscreenWalkThroughPage(driver);

		
	}
	
	public void validateVisibityOfNotificationForHomeScreenSelectionPage() {
		//wait.until(ExpectedConditions.visibilityOf(defaultHomeScreenSetMessage));
		Assert.assertTrue(defaultHomeScreenSetMessage.isDisplayed(), "Default Home Screen Set! Toast message is not displayed");		
	}
	
	
}


	



