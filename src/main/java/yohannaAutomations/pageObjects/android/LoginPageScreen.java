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
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPageScreen extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;

	public LoginPageScreen(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(uiAutomator ="new UiSelector().className(\"android.view.View\").instance(5)")
	private WebElement loginPage;
	
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.EditText\")")
	private WebElement emailField;
	
	@AndroidFindBy(accessibility="Sign in")
	private WebElement signInButton;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.EditText\").instance(1)")
	private WebElement otpField;
	
	@AndroidFindBy(accessibility="Resend Code")
	private WebElement resendCodeButton;
	
	
	@AndroidFindBy(accessibility="New user? \nSign Up")
	private WebElement signUpButton;
	
	@AndroidFindBy(accessibility="Lets get started")
	private WebElement getStartedTag;
	
	public WebElement getLoginPage() {
		return loginPage;
	}
	
	public SignUpPage clickSignUpButton() throws InterruptedException {
		try {
		wait.until(ExpectedConditions.elementToBeClickable(signUpButton));
		signUpButton.click();
		wait.until(ExpectedConditions.visibilityOf(getStartedTag));
		}catch(Exception e) {
			takeScreenshot("clickSignUpButton");
		}
		
		Thread.sleep(4000);
		return new SignUpPage(driver);
	}
	
	public void validateValidSignin(String email, SoftAssert softAssert) {
		try {
		validateDisplayOfUI(loginPage, "loginPage");
		emailField.click();
		emailField.sendKeys(email);
		signInButton.click();
		wait.until(ExpectedConditions.visibilityOf(otpField));
		softAssert.assertTrue(otpField.isDisplayed());
		otpField.click();
		wait.until(ExpectedConditions.visibilityOf(resendCodeButton));
		softAssert.assertTrue(resendCodeButton.isDisplayed());
		signInButton.click();
		
		}catch(Exception e) {
			takeScreenshot("validateValidSignin");
			Assert.fail("Exception in the method validateValidSignin "+e.getMessage());
		}
	}
	
}

	



