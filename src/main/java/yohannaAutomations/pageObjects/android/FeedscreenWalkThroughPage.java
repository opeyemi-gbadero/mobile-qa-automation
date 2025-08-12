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

public class FeedscreenWalkThroughPage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;

	public FeedscreenWalkThroughPage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(accessibility="1 of 6\nStay inspired with Daily Bread, your personalized feed of faith and encouragement - all in one place.")
	private WebElement dailyBreadWalkThroughDescription;
	
	@AndroidFindBy(accessibility="Next")
	private WebElement nextButton;
	
	@AndroidFindBy(accessibility="2 of 6\nRead, share, and complete tasks to earn Gems—unlock exclusive features on your journey!")
	private WebElement gemTokenWalkThroughDescription;
	
	@AndroidFindBy(accessibility="3 of 6\nCustomise your account settings and update your profile information seamlessly from here.")
	private WebElement profileWalkThroughDescription;
	
	@AndroidFindBy(accessibility="4 of 6\nStrengthen your journey—each completed task lights up your calendar as a testament to your commitment!")
	private WebElement calendarWalkThroughDescription;
	
	@AndroidFindBy(accessibility="5 of 6\nCelebrate your progress! Track your reading journey, see completed books, and stay motivated along the way.")
	private WebElement booksCompletedWalkThroughDescription;
	
	@AndroidFindBy(accessibility="6 of 6\nYour emotions matter. Share how you’re feeling and receive a personalised prayer from Scripture—bringing you enlightenment, comfort, and peace to your heart.")
	private WebElement devtionalWalkThroughDescription;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(4)")
	private WebElement vodTapButton;
	
	@AndroidFindBy(uiAutomator="new UiSelector().description(\"Tap on the Verse of the Day to explore its full meaning and context.\")")
	private  WebElement vodTapDescription;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(3)")
	private WebElement vodCard;
	
	
	
	
	
	public void validateDailyBreadWalkThroughDescription() {
	    WebElement[] descriptions = {
	        dailyBreadWalkThroughDescription,
	        gemTokenWalkThroughDescription,
	        profileWalkThroughDescription,
	        calendarWalkThroughDescription,
	        booksCompletedWalkThroughDescription,
	        devtionalWalkThroughDescription
	    };

	    String[] errorMessages = {
	        "Daily Bread Walk Through Description is not displayed",
	        "Gem Token Walk Through Description is not displayed",
	        "Profile Walk Through Description is not displayed",
	        "Calendar Walk Through Description is not displayed",
	        "Books Completed Walk Through Description is not displayed",
	        "Devotional Walk Through Description is not displayed"
	    };

	    for (int i = 0; i < descriptions.length; i++) {
	        wait.until(ExpectedConditions.visibilityOf(descriptions[i]));
	        Assert.assertTrue(descriptions[i].isDisplayed(), errorMessages[i]);
	        Assert.assertTrue(nextButton.isEnabled(), "Next button is not enabled on " + errorMessages[i]);
	        nextButton.click();
	    }
	}
	
	public VodWalthroughNarrativePage validateVodWalkthrough() {
		wait.until(ExpectedConditions.visibilityOf(vodTapButton));
		Assert.assertTrue(vodTapButton.isDisplayed(), "Vod Tap Button is not displayed");
		Assert.assertTrue(vodTapDescription.isDisplayed(), "Vod Tap Description is not displayed");
		Assert.assertTrue(vodCard.isDisplayed(), "Vod Card is not displayed");
		vodTapButton.click();
		return new VodWalthroughNarrativePage(driver);
		
	}

	
	
	
	

	
}


	



