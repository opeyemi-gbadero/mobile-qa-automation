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
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ChapterIntroPage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;
    private BibleReadingSceenPage bibleReadingSceenPage;

	public ChapterIntroPage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
	this.bibleReadingSceenPage = new BibleReadingSceenPage(driver);
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(accessibility="Welcome to Genesis Chapter 1")
	private WebElement chapterIntroModal;
	
	@AndroidFindBy(className = "android.widget.ImageView")
	private WebElement closeChapterIntroBackgroundImage;
	
	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, \"It reveals God's personal and intentional design\")]")	
	private WebElement chapterIntroDescription;
	
	
	@AndroidFindBy(accessibility = "Proceed to Genesis Chapter 1")
	private WebElement proceedToChapterButton;
	
	private void validateDisplayOfElement(WebElement element, String elementName) {
		Assert.assertTrue(element.isDisplayed(), elementName + " is not displayed");
	}
	private void validateElementClickable(WebElement element, String elementName) {
		Assert.assertTrue(element.isEnabled(), elementName + " is not clickable");
	}
	
	public void validateDisplayOfChapterIntroElements() {
		
		wait.until(ExpectedConditions.visibilityOf(chapterIntroModal));
		validateDisplayOfElement(chapterIntroModal, "Chapter Intro Modal");
		validateDisplayOfElement(closeChapterIntroBackgroundImage, "Close Chapter Intro Background Image");
		validateDisplayOfElement(chapterIntroDescription, "Chapter Intro Description");
		validateDisplayOfElement(proceedToChapterButton, "Proceed to Chapter Button");
	}
	
	public FeedscreenPage validateProceedToChapterButtonFunctionality() {
		validateElementClickable(proceedToChapterButton, "Proceed to Chapter Button");
		proceedToChapterButton.click();
		wait.until(ExpectedConditions.visibilityOf(bibleReadingSceenPage.getBibleReadingFirstPage()));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		return new FeedscreenPage(driver);
		}
}


	



