package yohannaAutomations.pageObjects.android;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.AndroidActions;
import utils.DateRangeUtil;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FeedscreenPage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;
    private VodWalthroughNarrativePage vodPage;
    private BibleReadingSceenPage bibleReadingPage;
    private DevotionalScreenPage devotionalPage;
    private LoginPageScreen loginPageScreen;

	public FeedscreenPage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
	this.vodPage = new VodWalthroughNarrativePage(driver);
	this.bibleReadingPage = new BibleReadingSceenPage(driver);
	this.devotionalPage = new DevotionalScreenPage(driver);
	this.loginPageScreen = new LoginPageScreen(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	String dateRange = DateRangeUtil.getWeekRangeString();
	
	
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(5)")
	private WebElement vodCard;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(5)")
	private List<WebElement> vodCards;

	
	@AndroidFindBy(xpath="//android.widget.ScrollView")
	private WebElement scrollablePage;
	
	
	@AndroidFindBy(accessibility="Faith Stories\nTab 2 of 3")
	private WebElement faithStoriesTab;
	
	@AndroidFindBy(accessibility="VOD\nTab 3 of 3")
	private WebElement verseOfTheDayTab;
	
	@AndroidFindBy(accessibility="SUN\nMON\nTUE\nWED\nTHU\nFRI\nSAT")
	private WebElement calendarTab;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(1)")
	private WebElement calendarBackButton;
	
	@AndroidFindBy(accessibility="Books Completed\nStart your\njourney")
	private WebElement booksCompletedTab;
	
	@AndroidFindBy(accessibility="Devotional with Grace\nHow are you\nfeeling today")
	private WebElement devotionalTab;
	
	@AndroidFindBy(accessibility="Start Reading")
	private WebElement startReadingButton;
	
	@AndroidFindBy(accessibility="Request a prayer")
	private WebElement requestAPrayerButton;
	
	@AndroidFindBy(accessibility="Faith Stories")
	private WebElement faithStoriesSection;
	
	@AndroidFindBy(accessibility="Real stories, real impact! Let these voices inspire you")
	private WebElement faithStoriesSectionDescription;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(1)")
	private WebElement FaithStoriesFirstVideoCard;
	
	
	
	//@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(3)")
	//private WebElement vodCard;
	
	public void scrollToTop() {
		
		scrollUp(scrollablePage);
		
	}
	public void scrollToBottom() {
		
		scrollDown(scrollablePage);
		
	}
	
	private void validateTabStatus(WebElement tab, String message) {
		Assert.assertTrue(tab.isEnabled(), message);
		Assert.assertTrue(tab.isDisplayed(), message);
	}
	
	private void validateDisplayOfElement(WebElement element, String elementName) {
		Assert.assertTrue(element.isDisplayed(), elementName + " is not displayed");
	}
	
	public void validateFaithStoriesTab() throws InterruptedException {
		//wait.until(ExpectedConditions.visibilityOf(faithStoriesTab));
		validateTabStatus(verseOfTheDayTab, "Verse of the Day tab is not enabled or displayed");
		verseOfTheDayTab.click();
		scrollToTop();
		validateTabStatus(faithStoriesTab, "Faith Stories tab is not enabled or displayed");
		faithStoriesTab.click();
		scrollToTop();
		
		Thread.sleep(4000); // Wait for the tab to load
		
	}
	
	public CalendarPage validateCalendarTab() {
		String expectedDateRange = dateRange;
		WebElement newCalendarTab = driver.findElement(AppiumBy.accessibilityId(expectedDateRange));
		
		validateTabStatus(newCalendarTab, "Calendar tab is not enabled or displayed");
		newCalendarTab.click();
		return new CalendarPage(driver);		
	}
	
	public void validateBooksCompletedTabForNonRegisteredUsers() {
		validateTabStatus(booksCompletedTab, "Books Completed tab is not enabled or displayed");
		booksCompletedTab.click();
		wait.until(ExpectedConditions.visibilityOf(bibleReadingPage.getBibleReadingFirstPage()));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public void validateDevotionalTabForNonRegisteredUsers() {
		validateTabStatus(devotionalTab, "Devotional tab is not enabled or displayed");
		devotionalTab.click();
		wait.until(ExpectedConditions.visibilityOf(devotionalPage.getDevotionalWelcomeModal()));
		validateTabStatus(devotionalPage.getDevotionalWelcomeModal(), "Devotional Welcome Modal is not displayed");
		validateTabStatus(devotionalPage.getContinueButton(), "Continue button is not enabled or displayed");
		devotionalPage.getContinueButton().click();
		wait.until(ExpectedConditions.visibilityOf(loginPageScreen.getLoginPage()));
		validateTabStatus(loginPageScreen.getLoginPage(), "Login Page is not displayed");
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public ChapterIntroPage scrollToStartReading() {
	    By startReadingLocator = AppiumBy.accessibilityId("Start Reading");
	    while (driver.findElements(startReadingLocator).isEmpty()) {
	        scrollDown(scrollablePage);
	    }
	    
	    WebElement startReadingButton = driver.findElement(startReadingLocator);
	    wait.until(ExpectedConditions.visibilityOf(startReadingButton));
	    startReadingButton.click();
	    return new ChapterIntroPage(driver);
	}
	
	public RequestPrayerPage scrollToRequestAPrayerButton() {
		By requestAPrayerLocator = AppiumBy.accessibilityId("Request a prayer");
		while (driver.findElements(requestAPrayerLocator).isEmpty()) {
			scrollDownLittle(scrollablePage);
		}
		
		WebElement requestAPrayerButton = driver.findElement(requestAPrayerLocator);
		wait.until(ExpectedConditions.visibilityOf(requestAPrayerButton));
		requestAPrayerButton.click();
		return new RequestPrayerPage(driver);
		
	}
	
	public void validateFaithStoriesSection() throws InterruptedException {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(faithStoriesSection));
	        validateDisplayOfElement(faithStoriesSection, "Faith Stories Section");
	        validateDisplayOfElement(faithStoriesSectionDescription, "Faith Stories Section Description");
	        validateDisplayOfElement(FaithStoriesFirstVideoCard, "First Faith Stories Video Card");
	        FaithStoriesFirstVideoCard.click();
	    } catch (Exception e) {
	        System.out.println("Error validating Faith Stories Section: " + e.getMessage());
	        // Optionally, rethrow or handle as needed
	    }
	    Thread.sleep(9000); // Wait for the video to load
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	public void validateTheVodCard() {
		wait.until(ExpectedConditions.visibilityOf(vodCard));
		Assert.assertTrue(vodCard.isDisplayed(), "VOD Card is not displayed");
		vodCard.click();
		
	}
	
	public void validateVodFunctionalities() {
		for(int i = 0; i <= 8 ; i++) {
			vodCard.click();
			//driver.pressKey(new KeyEvent(AndroidKey.BACK));
			vodPage.verifyVisibilityOfAllElements();
			vodPage.scrollDown();
			vodPage.clickIamAllDoneButton();
			wait.until(ExpectedConditions.visibilityOf(vodCard));
			swipeElement(vodCard,"right");
		}
		
	}
	

}


	



