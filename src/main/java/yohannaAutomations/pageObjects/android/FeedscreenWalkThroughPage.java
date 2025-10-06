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
import org.testng.asserts.SoftAssert;

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
	
	/* @AndroidFindBy(accessibility="Hello," + utils.SalutationUtil.ExpectedSalutation())
	private WebElement greetingText;
	*/
	public WebElement greetingText() {
	String expectedLocator = "Hello," + " " + utils.SalutationUtil.ExpectedSalutation();
	By locator = AppiumBy.accessibilityId(expectedLocator);
	return driver.findElement(locator);
	}
	
	@AndroidFindBy(accessibility="1 of 8\nStay inspired with Daily Bread, your personalized feed of faith and encouragement - all in one place.")
	private WebElement dailyBreadWalkThroughDescription;
	
	@AndroidFindBy(accessibility="Next")
	private WebElement nextButton;
	
	@AndroidFindBy(accessibility="2 of 8\nRead, share, and complete tasks to earn Blessings—unlock exclusive features on your journey!")
	private WebElement gemTokenWalkThroughDescription;
	
	@AndroidFindBy(accessibility="3 of 8\nCustomise your account settings and update your profile information seamlessly from here.")
	private WebElement profileWalkThroughDescription;
	
	@AndroidFindBy(accessibility="4 of 8\nStrengthen your journey—each completed task lights up your calendar as a testament to your commitment!")
	private WebElement calendarWalkThroughDescription;
	
	@AndroidFindBy(accessibility="5 of 8\nYour emotions matter. Share how you’re feeling and receive a personalised prayer from Scripture—bringing you enlightenment, comfort, and peace to your heart.")
	private WebElement devotionalWalkThrough;
	
	@AndroidFindBy(accessibility="6 of 8\nRequest a prayer for yourself or someone you care about, and let Scripture and community lift you up in faith, hope, and love.")
	private WebElement requestPrayerWalkThrough;
	
	@AndroidFindBy(accessibility="7 of 8\nWhether you’re seeking guidance, wisdom, or clarity, chat with Grace AI to explore life, faith, and Scripture—one thoughtful answer at a time")
	private WebElement graceAIWalkThrough;
	
	@AndroidFindBy(accessibility="8 of 8\nReflect on your spiritual journey—your prayers, devotionals, and moments with Scripture—all in one meaningful recap.")
	private WebElement recapWalkThrough;
	
	@AndroidFindBy(xpath="//android.widget.ScrollView")
	private WebElement scrollView;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(4)")
	private WebElement vodTapButton;
	
	@AndroidFindBy(uiAutomator="new UiSelector().description(\"Tap on the Verse of the Day to explore its full meaning and context.\")")
	private  WebElement vodTapDescription;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(3)")
	private WebElement vodCard;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.ImageView\").instance(4)")
	private WebElement vodBackgroundImageModal;
	
	
	public void validateSalutationText() {
		WebElement Salutation = greetingText();
		String actualSalutation = Salutation.getAttribute("content-desc");
		String expectedSalutation = utils.SalutationUtil.ExpectedSalutation();
		
		try {
			Assert.assertTrue(actualSalutation.contains(expectedSalutation), "Salutation text does not match. Expected: " + expectedSalutation + ", but got: " + actualSalutation);
			
		}catch (Exception e) {
			takeScreenshot("salutation_failed");
		}
	}
	
	
	
	public void validateDailyBreadWalkThroughDescription() {
	    WebElement[] descriptions = {
	        dailyBreadWalkThroughDescription,
	        gemTokenWalkThroughDescription,
	        profileWalkThroughDescription,
	        calendarWalkThroughDescription,
	        devotionalWalkThrough,
	        requestPrayerWalkThrough,
	        graceAIWalkThrough,
	        recapWalkThrough
	        
	    };

	    String[] errorMessages = {
	        "Daily Bread Walk Through Description is not displayed",
	        "Gem Token Walk Through Description is not displayed",
	        "Profile Walk Through Description is not displayed",
	        "Calendar Walk Through Description is not displayed",
	        "Books Completed Walk Through Description is not displayed",
	        "Devotional Walk Through Description is not displayed",
	        "Request Prayer Walk Through Description is not displayed",
	        "Grace AI Walk Through Description is not displayed",
	    };

	    for (int i = 0; i < descriptions.length; i++) {
	    	try {
	        wait.until(ExpectedConditions.visibilityOf(descriptions[i]));
	        Assert.assertTrue(descriptions[i].isDisplayed(), errorMessages[i]);
	    	} catch (Exception t) {
	    		System.out.println("Exception caught: " + t.getMessage());
	            takeScreenshot("desc_failed_step_" + i); 
	        }
	    	
	    	try {
	        Assert.assertTrue(nextButton.isEnabled(), "Next button is not enabled on " + errorMessages[i]);
	        nextButton.click();
	        } catch (Exception e) {
	         System.out.println("Next button is not enabled on " + errorMessages[i] + " - Exception: " + e.getMessage());
	        }
	    	}
	}
	
	public VodWalthroughNarrativePage validateVodWalkthrough() {
		scrollDownLittle(scrollView);
		wait.until(ExpectedConditions.visibilityOf(vodTapButton));
		Assert.assertTrue(vodTapButton.isDisplayed(), "Vod Tap Button is not displayed");
		//Assert.assertTrue(vodTapDescription.isDisplayed(), "Vod Tap Description is not displayed");
		Assert.assertTrue(vodCard.isDisplayed(), "Vod Card is not displayed");
		vodBackgroundImageModal.click();
		return new VodWalthroughNarrativePage(driver);
		
	}

	
	
	
	

	
}


	



