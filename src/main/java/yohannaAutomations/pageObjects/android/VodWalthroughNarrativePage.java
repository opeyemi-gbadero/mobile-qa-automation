package yohannaAutomations.pageObjects.android;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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

public class VodWalthroughNarrativePage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;

	public VodWalthroughNarrativePage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(0)")
	private WebElement vodBackgroundImageModal;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.view.View\").instance(4)")
	private WebElement vodBackButton;
	
	@AndroidFindBy(xpath="//android.view.View[@index='2']")
	private WebElement verseOfTheDay;
	
	@AndroidFindBy(xpath="//android.view.View[@index='3']")
	private WebElement vodBookName;
	
	@AndroidFindBy(accessibility = "Narrative")
	private WebElement narrativeTitle;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView")
	private WebElement narrativeDescription;
	
	@AndroidFindBy(accessibility = "I am all done")
	private WebElement iAmAllDoneButton;
	
	@AndroidFindBy(accessibility = "Share")
	private WebElement shareButton;
	
	/* private void scrollDown() {
	    driver.executeScript("mobile: scroll", ImmutableMap.of("direction", "down"));
	}
	*/
	
	
	private void assertElementToBeVisible(WebElement element, String errorMessage) {
		wait.until(ExpectedConditions.visibilityOf(element));
		Assert.assertTrue(element.isDisplayed(), errorMessage);
	}
	
	public void verifyVisibilityOfAllElements() {
		
		assertElementToBeVisible(vodBackgroundImageModal, "Vod Background Image Modal is not visible");
		assertElementToBeVisible(vodBackButton, "Vod Back Button is not visible");
		assertElementToBeVisible(verseOfTheDay, "Verse of the Day is not visible");
		assertElementToBeVisible(vodBookName, "Vod Book Name is not visible");
		assertElementToBeVisible(narrativeTitle, "Narrative Title is not visible");
		assertElementToBeVisible(narrativeDescription, "Narrative Description is not visible");
		assertElementToBeVisible(iAmAllDoneButton, "I am all done button is not visible");
		assertElementToBeVisible(shareButton, "Share button is not visible");
	}
	
	public void scrollDown() {
	    Map<String, Object> scrollParams = new HashMap<>();
	    scrollParams.put("elementId", ((org.openqa.selenium.remote.RemoteWebElement) narrativeDescription).getId());
	    scrollParams.put("left", 100);
		scrollParams.put("top", 100);
		scrollParams.put("width", 200);
		scrollParams.put("height", 200);
		scrollParams.put("direction", "down");
		scrollParams.put("percent", 10.0);
	    driver.executeScript("mobile: scrollGesture", scrollParams);
	}
	
	public FeedscreenPage clickIamAllDoneButton() {
		scrollDown();
		iAmAllDoneButton.click();
		return new FeedscreenPage(driver);
	}
	
	
	// Getters for the elements
	
	public WebElement getVodBackgroundImageModal() {
		return vodBackgroundImageModal;
	}
	
	public WebElement getVodBackButton() {
		return vodBackButton;
	}
	
	public WebElement getVerseOfTheDay() {
		return verseOfTheDay;
	}
	
	public WebElement getVodBookName() {
		return vodBookName;
	}
	
	public WebElement getNarrativeTitle() {
		return narrativeTitle;
	}
	
	public WebElement getNarrativeDescription() {
		return narrativeDescription;
	}
	
	public WebElement getIamAllDoneButton() {
		return iAmAllDoneButton;
	}
	
	public WebElement getShareButton() {
		return shareButton;
	}
	
	
	
	
	
}


	



