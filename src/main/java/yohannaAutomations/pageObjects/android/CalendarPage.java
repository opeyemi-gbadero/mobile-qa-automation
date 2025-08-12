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
import utils.CalendarHeaderUtil;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CalendarPage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;

	public CalendarPage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(accessibility="August 2025\nSUN\nMON\nTUE\nWED\nTHU\nFRI\nSAT\nBible Reading\nDevotional\nVerse of the Day")
	private WebElement fullCalendarModal;
	
	
	
	
	public FeedscreenPage validateDisplayOfCalendarModal() {
		String expectedCalendarHeader = CalendarHeaderUtil.getExpectedCalendarHeader();
		WebElement calendarHeader = driver.findElement(AppiumBy.accessibilityId(expectedCalendarHeader));
		wait.until(ExpectedConditions.visibilityOf(calendarHeader));
		Assert.assertTrue(calendarHeader.isDisplayed(), "Calendar header is not displayed as expected: " + expectedCalendarHeader);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		return new FeedscreenPage(driver);
		
		/* wait.until(ExpectedConditions.visibilityOf(fullCalendarModal));
		Assert.assertTrue(fullCalendarModal.isDisplayed(), "Calendar modal is not displayed");
		*/
		
	}
	
}


	



