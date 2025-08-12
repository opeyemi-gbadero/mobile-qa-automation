package yohannaAutomations;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import yohannaAutomations.pageObjects.android.CalendarPage;
import yohannaAutomations.pageObjects.android.ChapterIntroPage;
import yohannaAutomations.pageObjects.android.FeedscreenPage;
import yohannaAutomations.pageObjects.android.FeedscreenWalkThroughPage;
import yohannaAutomations.pageObjects.android.FeedscreenWelcomeModalPage;
import yohannaAutomations.pageObjects.android.HomescreenSelectionPage;
import yohannaAutomations.pageObjects.android.RequestPrayerPage;
import yohannaAutomations.pageObjects.android.VodWalthroughNarrativePage;


public class onboardingUIAutomation extends basetest{
	
	//@BeforeMethod
	//p
	private FeedscreenPage feedscreenPage;
	private CalendarPage calendarPage ;
	@BeforeMethod
	public void setUp() {
	    feedscreenPage = new FeedscreenPage(driver);
	    feedscreenPage = new FeedscreenPage(driver);
	}

	
	@Test
	public void IntroScreenTest() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		onboardingPage.validateSplashScreen();
		
		onboardingPage.verifyTheDisplayOfYohannaLogo();
		
		onboardingPage.verifyTheDisplayOfFirstBackgroundImage();
		
		onboardingPage.verifyTheDisplayOfExperienceTheBibleLikeNeverBefore();
		
		onboardingPage.verifyTheDisplayOfImmerseYourselfInScripture();
		
		onboardingPage.validateNextButtonIsClickable();
		
		onboardingPage.clickNext();
		
		onboardingPage.verifyTheDisplayOfYohannaLogo();
		
		onboardingPage.verifyTheDisplayOfFirstBackgroundImage();
		
		onboardingPage.verifyTheDisplayOfStayConnectedEveryDay();
		
		onboardingPage.verifyTheDisplayOfStayConnectedEveryDayDescription();
		
		onboardingPage.validateNextButtonIsClickable();
		
		onboardingPage.clickNext();
		
		onboardingPage.verifyTheDisplayOfYohannaLogo();
		
		onboardingPage.verifyTheDisplayOfFirstBackgroundImage();
		
		onboardingPage.verifyTheDisplayOfStrengthenYourConnectionWithGod();
		
		onboardingPage.verifyTheDisplayOfTakeTimeForPrayerReflectionAndGrowth();
		
		onboardingPage.validateProceedButtonIsClickable();
		
	
		
		//homescreenSelectionPage.validateVisibityOfNotificationForHomeScreenSelectionPage();
		
	
}
	
	@Test
	public void feedscreenValidationForNonRegisteredUsers() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		FeedscreenWelcomeModalPage feedscreenWelcomeModalPage = onboardingPage.clickProceed();
		
		feedscreenWelcomeModalPage.validateWelcomeModal();
		
		//HomescreenSelectionPage homescreenSelectionPage = feedscreenWelcomeModalPage.clickContinue();
		
		//homescreenSelectionPage.validateFeedscreenPreviewModalImage();
		
		//FeedscreenWalkThroughPage feedscreenWalkThroughPage = homescreenSelectionPage.validateBibleScreenPreviewModalImage();
		
		FeedscreenWalkThroughPage feedscreenWalkThroughPage = feedscreenWelcomeModalPage.clickContinue();
		
		feedscreenWalkThroughPage.validateDailyBreadWalkThroughDescription();
		
		VodWalthroughNarrativePage vodWalthroughNarrativePage = feedscreenWalkThroughPage.validateVodWalkthrough();
		
		vodWalthroughNarrativePage.verifyVisibilityOfAllElements();
		
		FeedscreenPage feedscreenPage = vodWalthroughNarrativePage.clickIamAllDoneButton();
		
		feedscreenPage.scrollToTop();
		
		feedscreenPage.validateFaithStoriesTab();
		
		CalendarPage calendarPage =  feedscreenPage.validateCalendarTab();
		
		calendarPage.validateDisplayOfCalendarModal();
		
		feedscreenPage.validateBooksCompletedTabForNonRegisteredUsers();
		
		feedscreenPage.validateDevotionalTabForNonRegisteredUsers();
		
		//ChapterIntroPage chapterIntroPage =  feedscreenPage.scrollToStartReading();
		
		
		//feedscreenPage.validateFaithStoriesTab();
		
		//FeedscreenPage feedscreenPage = new FeedscreenPage(driver);
		//CalendarPage calendarPage =  feedscreenPage.validateCalendarTab();
		//calendarPage.validateDisplayOfCalendarModal();
		
}
	
	
	
	@Test(dependsOnMethods = {"feedscreenValidationForNonRegisteredUsers"})
	public void feedscreenValidationForNonRegisteredUsersII() throws MalformedURLException, URISyntaxException, InterruptedException {
		ChapterIntroPage chapterIntroPage =  feedscreenPage.scrollToStartReading();
		
		chapterIntroPage.validateDisplayOfChapterIntroElements();
		
		chapterIntroPage.validateProceedToChapterButtonFunctionality();
		
		RequestPrayerPage requestPrayerPage =  feedscreenPage.scrollToRequestAPrayerButton();
		
		requestPrayerPage.validateDisplayOfRequestPrayerWelcomeModalForNonRegisteredUsers();
		
		requestPrayerPage.validateRequestPrayerContinueButtonForNonRegisteredUsers();
		
		feedscreenPage = requestPrayerPage.validateLoginPageDisplay();
		
		feedscreenPage.validateFaithStoriesSection();
		
		feedscreenPage.scrollToBottom();
		
		//feedscreenPage.validateTheVodCard();
		
		feedscreenPage.validateVodFunctionalities();
		
	}
	
	
	/*
	
	@Test
	public void validateNavigationTab() throws InterruptedException  {
		//FeedscreenPage feedscreenPage = new FeedscreenPage(driver);
		feedscreenPage.validateFaithStoriesTab();
		
	}
	
	
	@Test
	public void calendarValidationForNonRegisteredUsers() throws MalformedURLException, URISyntaxException, InterruptedException {
		//FeedscreenPage feedscreenPage = new FeedscreenPage(driver);
		CalendarPage calendarPage =  feedscreenPage.validateCalendarTab();
		calendarPage.validateDisplayOfCalendarModal();
		
	}
	*/
	
	
}
