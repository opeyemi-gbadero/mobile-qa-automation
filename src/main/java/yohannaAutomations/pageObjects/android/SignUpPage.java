package yohannaAutomations.pageObjects.android;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.time.Duration;
import java.util.NoSuchElementException;

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

public class SignUpPage extends AndroidActions {
	AndroidDriver driver;
    private WebDriverWait wait;
	private String fullName;
	private By welcomeModal;

	public SignUpPage(AndroidDriver driver) {
	super(driver);
	this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(70));
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.EditText\").instance(0)")
	private WebElement fullNameField;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.EditText\").instance(1)")
	private WebElement emailField;
	
	@AndroidFindBy(accessibility="Choose your language\nEnglish")
	private WebElement chooseYourLanguageDropdown;
	
	@AndroidFindBy(accessibility="Get me started")
	private WebElement getMeStartedButton;
	
	@AndroidFindBy(accessibility="Already have an account? \nSign in here")
	private WebElement signInHereLink;
	
	@AndroidFindBy(accessibility="or sign up with")
	private WebElement orSignUpWithText;
	
	@AndroidFindBy(accessibility="Portuguese")
	private WebElement portugueseLanguageOption;
	
	@AndroidFindBy(accessibility="Proceed")
	private WebElement proceedButton;
	
	@AndroidFindBy(accessibility="Invalid Email Address")
	private WebElement invalidEmailErrorMessage;
	
	@AndroidFindBy(uiAutomator="new UiSelector().className(\"android.widget.EditText\").instance(2)")
	private WebElement otpField;
	
	@AndroidFindBy(accessibility="Resend Code")
	private WebElement resendCodeButton;
	
	@AndroidFindBy(xpath="//android.widget.Toast")
	private WebElement toastMessage;
	
	@AndroidFindBy(xpath="//android.view.Vie[contains(@content-desc, 'You are all done for now.')]")
	private WebElement welcomeModaal;
	
	@AndroidFindBy(accessibility="I’m ready to begin my journey")
	private WebElement imReadyToBeginMyJourneyButton;
	
	@AndroidFindBy(xpath="//android.view.View[contains(@content-desc, 'My Profile')]")
	private WebElement loggedInProfile;
	
	// Portuguese language elements
	
	@AndroidFindBy(accessibility="Criar uma conta")
	private WebElement criarUmaContaText; //let's get started in Portuguese
	
	@AndroidFindBy(accessibility="Vamos começar")
	private WebElement vamosComecarText; //let's get started in Portuguese
	
	@AndroidFindBy(accessibility="Escolher idioma\nPortuguês")
	private WebElement escolherIdiomaDropdown; //choose your language in Portuguese
	
	@AndroidFindBy(accessibility="Escolher idioma")
	private WebElement escolherIdiomaText; //choose your language in Portuguese Modal
	
	@AndroidFindBy(accessibility="Inglês")
	private WebElement inglesLanguageOption; //English in Portuguese
	
	@AndroidFindBy(accessibility="Português")
	private WebElement portuguesLanguageOption; //Portuguese in Portuguese
	
	@AndroidFindBy(accessibility="Continuar")
	private WebElement continuarButton; //proceed in Portuguese
	
	@AndroidFindBy(accessibility="Começar")
	private WebElement comecarButton; //get me started in Portuguese
	
	@AndroidFindBy(accessibility="ou cadastre-se com")
	private WebElement ouCadastreSeComText; //or sign up with in Portuguese
	
	@AndroidFindBy(accessibility="Já tem conta? \nFaça o login aqui")
	private WebElement jaTemContaLink; //already have an account? sign in here in Portuguese
	
	
	public void verifySignUpPageDisplay() {
		try {
		wait.until(ExpectedConditions.visibilityOf(fullNameField));
		validateDisplayOfUI(fullNameField, "fullNameField");
		validateDisplayOfUI(emailField, "emailField");
		validateDisplayOfUI(chooseYourLanguageDropdown, "chooseYourLanguageDropdown");
		validateDisplayOfUI(getMeStartedButton, "getMeStartedButton");
		validateDisplayOfUI(signInHereLink, "signInHereLink");
		validateDisplayOfUI(orSignUpWithText, "orSignUpWithText");
		}catch(Exception e) {
			takeScreenshot("verifySignUpPageDisplay");
		}
		
	}
	
	public void verifyPortugueseLanguageSelection() throws InterruptedException {
		try {
		chooseYourLanguageDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(portugueseLanguageOption));
		portugueseLanguageOption.click();	
		wait.until(ExpectedConditions.visibilityOf(proceedButton));
		proceedButton.click();
		wait.until(ExpectedConditions.visibilityOf(criarUmaContaText));
		validateDisplayOfUI(criarUmaContaText, "criarUmaContaText");
		validateDisplayOfUI(vamosComecarText, "vamosComecarText");
		validateDisplayOfUI(escolherIdiomaDropdown, "escolherIdiomaDropdown");
		escolherIdiomaDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(escolherIdiomaText));
		validateDisplayOfUI(escolherIdiomaText, "escolherIdiomaText");
		validateDisplayOfUI(inglesLanguageOption, "inglesLanguageOption");
		validateDisplayOfUI(portuguesLanguageOption, "portuguesLanguageOption");
		validateDisplayOfUI(continuarButton, "continuarButton");
		continuarButton.click();
		validateDisplayOfUI(comecarButton, "comecarButton");
		validateDisplayOfUI(ouCadastreSeComText, "ouCadastreSeComText");
		validateDisplayOfUI(jaTemContaLink, "jaTemContaLink");
		escolherIdiomaDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(inglesLanguageOption));
		inglesLanguageOption.click();
		continuarButton.click();
		
		
		}catch(Exception e) {
			takeScreenshot("verifyPortugueseLanguageSelection" );
			System.out.println(e.getMessage());
		}
		
		Thread.sleep(4000);
		
	}
	public void verifyEnglishLanguageSelection() throws InterruptedException {
		try {
			escolherIdiomaDropdown.click();
			wait.until(ExpectedConditions.visibilityOf(inglesLanguageOption));
			inglesLanguageOption.click();
			continuarButton.click();
			validateDisplayOfUI(fullNameField, "fullNameField");
			validateDisplayOfUI(emailField, "emailField");
			validateDisplayOfUI(chooseYourLanguageDropdown, "chooseYourLanguageDropdown");
			validateDisplayOfUI(getMeStartedButton, "getMeStartedButton");
			validateDisplayOfUI(signInHereLink, "signInHereLink");
			validateDisplayOfUI(orSignUpWithText, "orSignUpWithText");
		}catch(Exception e) {
			takeScreenshot("verifyEnglishLanguageSelection");
			System.out.println(e.getMessage());
		}
		
		Thread.sleep(4000);
	
	}

	public void enterFullName(String fullName) {
	
		fullNameField.click();
		fullNameField.sendKeys(fullName);
		this.fullName = fullName;
		welcomeModal = AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Well done " + fullName + "! You are all done for now.')]");
	}
	public 	WebElement getWelcomeModal() {
		return driver.findElement(welcomeModal);
	}
	public String getFullName()  {
		return  this.fullName;
	}
	public void enterEmail(String email) {
		emailField.click();
		emailField.sendKeys(email);
	}
	
	public void clickGetMeStartedButton() {
		getMeStartedButton.click();
	}
	
	public void validateInvalidEmailErrorMessage() {
		try {
		wait.until(ExpectedConditions.visibilityOf(invalidEmailErrorMessage));
		validateDisplayOfUI(invalidEmailErrorMessage, "invalidEmailErrorMessage");
		emailField.click();
		emailField.clear();
		fullNameField.click();
		fullNameField.clear();
		
		Thread.sleep(4000);
		
		}catch(Exception e) {
			takeScreenshot("validateInvalidEmailErrorMessage");
		}
	}
	
	public void validateVisibilityOfOtpField(SoftAssert softAssert) {
		try {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		    WebElement toast = wait.until(ExpectedConditions.presenceOfElementLocated(
		        By.xpath("//android.widget.Toast")
		    ));
		    String toastText = toast.getText();
		    System.out.println("Toast message: " + toastText);

		    // Example assertion
		    Assert.assertEquals(toastText, "Invalid email address");
		} catch (Exception e) {
		    System.out.println("Toast not found: " + e.getMessage());
		}

		try {
			
		wait.until(ExpectedConditions.visibilityOf(otpField));
		softAssert.assertTrue(otpField.isDisplayed(), "OTP field is not displayed");
		Thread.sleep(4000);
		
		}catch(Exception e) {
			takeScreenshot("OtpField");
			softAssert.fail("Exception caught: "  + e.getMessage());
		}
	}
	
	public void validateVisibilityOfResendCodeButton(SoftAssert softAssert) {
		try {
		wait.until(ExpectedConditions.visibilityOf(resendCodeButton));
		softAssert.assertTrue(resendCodeButton.isDisplayed(), "Resend Code button is not displayed");
		Thread.sleep(4000);
		
		}catch(Exception e) {
			takeScreenshot("ResendCodeButton");
			softAssert.fail("Exception caught: "  + e.getMessage());
		}
	}
	
	public void validateResendCodeFunctionality(SoftAssert softAssert) {
		try {
		resendCodeButton.click();
		//wait.until(ExpectedConditions.visibilityOf(toastMessage));
		//softAssert.assertTrue(toastMessage.isDisplayed(), "Toast message is not displayed after clicking Resend Code button");
		Thread.sleep(8000);
		
		}catch(Exception e) {
			takeScreenshot("ResendCodeFunctionality");
			softAssert.fail("Exception caught: "  + e.getMessage());
		}
	}
	
	public FeedscreenPage validateSuccessfulSignUp(SoftAssert softAssert) {
		try {
		wait.until(ExpectedConditions.visibilityOf(resendCodeButton));
		getMeStartedButton.click();
		wait.until(ExpectedConditions.visibilityOf(getWelcomeModal()));
		imReadyToBeginMyJourneyButton.click();
		wait.until(ExpectedConditions.visibilityOf(loggedInProfile));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		}catch(Exception e) {
			takeScreenshot("validateSuccessfulSignUp");
			softAssert.fail("Exception caught: "  + e.getMessage());
		}
		return new FeedscreenPage(driver);	
	}
}

	//My Profile\nS\nsamosa\nsamosa@mailinator.com
/*
 //android.view.View[@content-desc="My Profile
S
samosa
samosa@mailinator.com"]*/
 



