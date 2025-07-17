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
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import yohannaAutomations.pageObjects.android.FeedscreenWelcomeModalPage;
import yohannaAutomations.pageObjects.android.HomescreenSelectionPage;


public class onboardingUIAutomation extends basetest{
	@Test
	public void AppiumTest() throws MalformedURLException, URISyntaxException, InterruptedException {
		
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
	public void ScreenSelectionTest() throws MalformedURLException, URISyntaxException, InterruptedException {
		
	FeedscreenWelcomeModalPage feedscreenWelcomeModalPage = onboardingPage.clickProceed();
		
		feedscreenWelcomeModalPage.validateWelcomeModal();
		
		HomescreenSelectionPage homescreenSelectionPage = feedscreenWelcomeModalPage.clickContinue();
		
		homescreenSelectionPage.validateFeedscreenPreviewModalImage();
		
		homescreenSelectionPage.validateBibleScreenPreviewModalImage();
		
		
}
}
