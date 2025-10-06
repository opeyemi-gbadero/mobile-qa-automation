package yohannaAutomations.pageObjects.android;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utils.AndroidActions;
import utils.DateRangeUtil;
import utils.SalutationUtil;

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
    private SignUpPage signUpPage;
    private By salutationWithName ; 
    private String fullName;

	public FeedscreenPage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
	this.vodPage = new VodWalthroughNarrativePage(driver);
	this.bibleReadingPage = new BibleReadingSceenPage(driver);
	this.devotionalPage = new DevotionalScreenPage(driver);
	this.loginPageScreen = new LoginPageScreen(driver);
	this.signUpPage = new SignUpPage(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	String dateRange = DateRangeUtil.getWeekRangeString();
	
	
	public WebElement greetingText() {
		String expectedLocator = "Hello," + " " + utils.SalutationUtil.ExpectedSalutation();
		By locator = AppiumBy.accessibilityId(expectedLocator);
		return driver.findElement(locator);
		}
	
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(4)")
	private WebElement vodCard;
	
	//@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(5)")
	//private List<WebElement> vodCards;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.view.View\").instance(5)")
	private WebElement profileIcon;
	
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
	
	//@AndroidFindBy(accessibility="Books Completed\nStart your\njourney")
	//private WebElement booksCompletedTab;
	
	@AndroidFindBy(accessibility="Devotional")
	private WebElement devotionalTab;
	
	@AndroidFindBy(accessibility="Request a prayer")
	private WebElement requestAPrayerButton;
	
	
	@AndroidFindBy(accessibility="Ask Yohanna")
	private WebElement askYohannaButton;
	
	@AndroidFindBy(accessibility="Start Reading")
	private WebElement startReadingButton;
	
	@AndroidFindBy(accessibility="View Recap")
	private WebElement viewRecapButton;
	
	@AndroidFindBy(accessibility="Faith Stories")
	private WebElement faithStoriesSection;
	
	@AndroidFindBy(accessibility="Real stories, real impact! Let these voices inspire you")
	private WebElement faithStoriesSectionDescription;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(1)")
	private WebElement FaithStoriesFirstVideoCard;
	
	@AndroidFindBy(accessibility="Today's Task")
	private WebElement todaysTask;
	
	@AndroidFindBy(accessibility="View Recap")
	private WebElement RecapButton;
	
	@AndroidFindBy(accessibility="Stay inspired! Each task brings you closer to God")
	private WebElement todaysTaskDescription;
	
	@AndroidFindBy(accessibility="Complete 50 verses today\nComplete To Earn 50 Blessings!\nStart")
	private WebElement complete50VersesTodayButton;
	
	@AndroidFindBy(accessibility="Complete verse of the day\nComplete To Earn 1 Blessing!\nStart")
	private WebElement completeVerseOfTheDayButton;
	
	@AndroidFindBy(accessibility="Complete Daily Devotional\nComplete To Earn 3 Blessings!\nStart")
	private WebElement completeDailyDevotionalButton;
	
	
	
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
	
	public RequestPrayerPage validateRequestAPrayerButtonForNonRegisteredUsers() {
		validateDisplayOfElement(requestAPrayerButton, "Request a Prayer Button");
		validateTabStatus(requestAPrayerButton, "Request a Prayer Button is not enabled or displayed");
		requestAPrayerButton.click();
		return new RequestPrayerPage(driver);
	}
	
	public AskGracePage validateAskYohannaButtonForNonRegisteredUsers() {
		validateDisplayOfElement(askYohannaButton, "Ask Grace Button");
		validateTabStatus(askYohannaButton, "Ask Grace Button is not enabled or displayed");
		askYohannaButton.click();
		return new AskGracePage(driver);
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
	
	public RecapPage validateViewRecapButtonForNonRegisteredUsers() {
	   scrollDownLittle(scrollablePage);
	    wait.until(ExpectedConditions.visibilityOf(viewRecapButton));
	    Assert.assertTrue(viewRecapButton.isDisplayed(), "View Recap Button is not displayed");
	    Assert.assertTrue(viewRecapButton.isEnabled(), "View Recap Button is not clickable");
	    
	    viewRecapButton.click();
	    return new RecapPage(driver);
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
		swipeElement(vodCard, "right");
		vodCard.click();
		vodPage.verifyVisibilityOfAllElements();
		try {
		vodPage.scrollDown();
		} catch (Exception e) {
			System.out.println("this is not scrollable " + e.getMessage());
		}
		vodPage.clickIamAllDoneButton();
		
	}
	
	public void validateVodFunctionalities() throws InterruptedException {
		for(int i = 0; i <= 8 ; i++) {
			wait.until(ExpectedConditions.visibilityOf(vodCard));
			vodCard.click();
			//driver.pressKey(new KeyEvent(AndroidKey.BACK));
			vodPage.verifyVisibilityOfAllElements();
			vodPage.scrollDown();
			vodPage.clickIamAllDoneButton();
			swipeElement(vodCard,"right");
			Thread.sleep(2000);
		}
		
	}
	
	public ProfilePage clickProfileIcon() {
		wait.until(ExpectedConditions.visibilityOf(profileIcon));
		profileIcon.click();
		return new ProfilePage(driver);

}
	
	public WebElement SaluteWithName(String fullName) {
		this.fullName = fullName;
		//salutationWithName = AppiumBy.accessibilityId(SalutationUtil.ExpectedSalutation() + ", " + signUpPage.getFullName(fullName))  ;
		salutationWithName = AppiumBy.accessibilityId(SalutationUtil.ExpectedSalutation() + ", " + fullName)  ;

		return driver.findElement(salutationWithName);
	}
	
	public void validateSuccessfulLogin(String fullName, SoftAssert softAssert) {
		try {
			wait.until(ExpectedConditions.visibilityOf(SaluteWithName(fullName)));
			softAssert.assertTrue(SaluteWithName(fullName).isDisplayed(), "Salutation with name is not displayed, login might have failed");
		
		}catch(Exception e) {
			takeScreenshot("validateSuccessfulLogin");
			softAssert.fail("Exception occurred while validating successful login: " + e.getMessage());	
		}
	}
	
	
	public 	WebElement getProfileIcon() {
		return profileIcon;
}
	
	public void scrollDownUntilTodaysTaskVisible(int maxAttempts) {
	    for (int i = 0; i < maxAttempts; i++) {
	        try {
	            if (todaysTask.isDisplayed()) {
	                return;
	            }
	        } catch (Exception e) {
	            // Ignore and scroll
	        }
	        scrollDownLittle(scrollablePage);
	        try {
	            wait.until(ExpectedConditions.visibilityOf(todaysTask));
	            if (todaysTask.isDisplayed()) {
	                return;
	            }
	        } catch (Exception e) {
	            // Continue to next attempt
	        }
	    }
	    throw new RuntimeException("Today's Task is not visible after scrolling.");
	}
	
	public void validateSalutionOfNonLoggedInUsers(SoftAssert softAssert) {
		String actualSalutation = greetingText().getAttribute("content-desc");
		String expectedSalutation = utils.SalutationUtil.ExpectedSalutation();
		
		try {
			softAssert.assertTrue(actualSalutation.contains(expectedSalutation), "Salutation text does not match. Expected: " + expectedSalutation + ", but got: " + actualSalutation);
			
		}catch (Exception e) {
			takeScreenshot("salutation_failed");
			softAssert.fail("Exception occurred while validating salutation: " + e.getMessage());
		}
	}
	
}

	



