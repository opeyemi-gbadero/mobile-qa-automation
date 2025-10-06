package yohannaAutomations;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import yohannaAutomations.pageObjects.android.AccountManagementPage;
import yohannaAutomations.pageObjects.android.ApearanceThemePage;
import yohannaAutomations.pageObjects.android.AskGracePage;
import yohannaAutomations.pageObjects.android.BibleVersionPage;
import yohannaAutomations.pageObjects.android.CalendarPage;
import yohannaAutomations.pageObjects.android.ChapterIntroPage;
import yohannaAutomations.pageObjects.android.FeedscreenPage;
import yohannaAutomations.pageObjects.android.FeedscreenWalkThroughPage;
import yohannaAutomations.pageObjects.android.FeedscreenWelcomeModalPage;
import yohannaAutomations.pageObjects.android.LanguagePage;
import yohannaAutomations.pageObjects.android.LoginPageScreen;
import yohannaAutomations.pageObjects.android.PreferencePage;
import yohannaAutomations.pageObjects.android.ProfilePage;
import yohannaAutomations.pageObjects.android.RecapPage;
import yohannaAutomations.pageObjects.android.RequestPrayerPage;
import yohannaAutomations.pageObjects.android.SignUpPage;
import yohannaAutomations.pageObjects.android.VodWalthroughNarrativePage;


public class onboardingUIAutomation extends basetest{
	
	//@BeforeMethod
	//p
	private FeedscreenPage feedscreenPage;
	private AccountManagementPage accountManagementPage;
	SoftAssert softAssert = new SoftAssert();

	 @BeforeMethod
	public void setUp() {
	    feedscreenPage = new FeedscreenPage(driver);
	}

	
	@Test
	public void IntroScreenTest() throws InterruptedException {
		
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
		
		onboardingPage.verifyTheDisplayOfStayConnectedEveryDayDescription(softAssert);
		
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
	public void feedscreenValidationForNonRegisteredUsers() throws InterruptedException {
		
		FeedscreenWelcomeModalPage feedscreenWelcomeModalPage = onboardingPage.clickProceed();
		
		feedscreenWelcomeModalPage.validateWelcomeModal();
		
		//HomescreenSelectionPage homescreenSelectionPage = feedscreenWelcomeModalPage.clickContinue();
		
		//homescreenSelectionPage.validateFeedscreenPreviewModalImage();
		
		//FeedscreenWalkThroughPage feedscreenWalkThroughPage = homescreenSelectionPage.validateBibleScreenPreviewModalImage();
		
		FeedscreenWalkThroughPage feedscreenWalkThroughPage = feedscreenWelcomeModalPage.clickContinue();
		
		feedscreenWalkThroughPage.validateSalutationText();
		
		feedscreenWalkThroughPage.validateDailyBreadWalkThroughDescription();
	

		
		VodWalthroughNarrativePage vodWalthroughNarrativePage = feedscreenWalkThroughPage.validateVodWalkthrough();
		
		vodWalthroughNarrativePage.verifyVisibilityOfAllElements();
		
		FeedscreenPage feedscreenPage = vodWalthroughNarrativePage.clickIamAllDoneButton();
		
		feedscreenPage.scrollToTop();
		
		feedscreenPage.validateFaithStoriesTab();
		
		CalendarPage calendarPage =  feedscreenPage.validateCalendarTab();
		
		calendarPage.validateDisplayOfCalendarModal();
		
		
		
		feedscreenPage.validateDevotionalTabForNonRegisteredUsers();
		
		
		RequestPrayerPage requestPrayerPage = feedscreenPage.validateRequestAPrayerButtonForNonRegisteredUsers();
		
		
		
		requestPrayerPage.validateDisplayOfRequestPrayerWelcomeModalForNonRegisteredUsers();
		
		requestPrayerPage.validateRequestPrayerContinueButtonForNonRegisteredUsers();
		
		requestPrayerPage.validateLoginPageDisplay();
		
		AskGracePage askGracePage =  feedscreenPage.validateAskYohannaButtonForNonRegisteredUsers();
		
		
		
		askGracePage.validateDisplayOfAskYohannaWelcomePage();
		
		askGracePage.validateAskYohannaContinueButton();
		
		askGracePage.validateLoginPageDisplay();
		
		ChapterIntroPage chapterIntroPage = feedscreenPage.scrollToStartReading();
		
		chapterIntroPage.validateDisplayOfChapterIntroElements();
		
		chapterIntroPage.validateProceedToChapterButtonFunctionality();
		
		RecapPage recapPage = feedscreenPage.validateViewRecapButtonForNonRegisteredUsers();
		
		recapPage.validateDisplayOfRecapWelcomePage();
		
		recapPage.validateRecapContinueButton();
		
		recapPage.validateLoginPageDisplay();
		
		feedscreenPage.validateFaithStoriesSection();
		
		feedscreenPage.scrollToBottom();
		
		feedscreenPage.validateTheVodCard();
		
		feedscreenPage.scrollToTop();
				
		//feedscreenPage.validateVodFunctionalities();
		

		

	
}
	
	@Test 
	(dependsOnMethods = {"feedscreenValidationForNonRegisteredUsers"})
	public void ValidateProfileSection() throws InterruptedException {
		
		
		
		ProfilePage profilePage =  feedscreenPage.clickProfileIcon();
		
		profilePage.verifyProfilePageDisplay();
		
		profilePage.validateCreateAccountButton();
		
		BibleVersionPage bibleVersionPage = profilePage.validateBibleVersionDropdown(); 
		
		bibleVersionPage.validateDisplayOfBibleVersionPage();
		
		bibleVersionPage.navigatoProfilePage();
		
		LanguagePage languagePage =  profilePage.validateLanguageDropdown();
		
		languagePage.validateDisplayOfLanguagePage();
		
		profilePage = languagePage.navigatoProfilePage();
		
		PreferencePage preferencePage = profilePage.validatePreferencesSection();
		
		ApearanceThemePage apearanceThemePage = preferencePage.clickThemeButton();
		
		apearanceThemePage.verifyThemeOptionsDisplayed();
		
		feedscreenPage = apearanceThemePage.clickDoneButton();
		
		
		
		
	}
	
	@Test(dependsOnMethods = {"ValidateProfileSection"} )
	public void ValidateLanguageSynconSignUpPage() throws InterruptedException {
		
		ProfilePage profilePage = feedscreenPage.clickProfileIcon();
		
		LoginPageScreen loginPageScreen = profilePage.clickCreateAccountButton();
		
		SignUpPage signUpPage =  loginPageScreen.clickSignUpButton();
		
		signUpPage.verifySignUpPageDisplay();
		
		signUpPage.verifyPortugueseLanguageSelection();
		
		signUpPage.verifyEnglishLanguageSelection();
	}
	
	
	@Test(dependsOnMethods = {"ValidateLanguageSynconSignUpPage"}, dataProvider = "invalidEmailData")
	public void ValidateInvalidMailInputOnSignUpPage(String fullName, String invalidEmail) throws InterruptedException {
		SignUpPage signUpPage = new SignUpPage(driver);
		
		signUpPage.enterFullName(fullName);
		
		signUpPage.enterEmail(invalidEmail);
		
		//signUpPage.clickGetMeStartedButton();
		
		signUpPage.validateInvalidEmailErrorMessage();
		
		
		
		

		
	}
	@DataProvider
	public Object [][] invalidEmailData() {
		return new Object[][] {{"Saskia Zoe","saskia.zoe.com"}};
		
	}
	
	
	@Test(dependsOnMethods = {"ValidateInvalidMailInputOnSignUpPage"}, dataProvider = "validEmailData")
	public void ValidatevalidMailInputOnSignUpPage(String fullName, String Email) throws InterruptedException {
		SignUpPage signUpPage = new SignUpPage(driver);
		
		signUpPage.enterFullName(fullName);
		
		signUpPage.enterEmail(Email);
		
		signUpPage.clickGetMeStartedButton();
		
		signUpPage.validateVisibilityOfOtpField(softAssert);
		
		signUpPage.validateVisibilityOfResendCodeButton(softAssert);
		
		signUpPage.validateResendCodeFunctionality(softAssert);
		
		 feedscreenPage = signUpPage.validateSuccessfulSignUp(softAssert);
		 
		 feedscreenPage.validateSuccessfulLogin(fullName,softAssert);
		 
		 feedscreenPage.scrollDownUntilTodaysTaskVisible(4);
		 
		// feedscreenPage.navigateToTodaysTask(softAssert);
		
		
		
		
		

		
	}
	@DataProvider
	public Object [][] validEmailData() {
		return new Object[][] {{"wednesdaytesting","wednesdaytesting27@mailinator.com"}};
		
	}
	
	
	@Test(dependsOnMethods = {"ValidatevalidMailInputOnSignUpPage"},  dataProvider = "validEmailData")
	public void validateLogOutFunctionality(String fullName, String email) throws InterruptedException {
		
		
		feedscreenPage = new FeedscreenPage(driver);
		
		feedscreenPage.scrollToTop();
		
		ProfilePage profilePage =  feedscreenPage.clickProfileIcon();
		
		AccountManagementPage accountManagementPage = profilePage.clickAccountManagementButton();
		
		feedscreenPage = accountManagementPage.validateLogOutButtonFunctionality(softAssert);
		
		feedscreenPage.validateSalutionOfNonLoggedInUsers(softAssert);
		
		profilePage =  feedscreenPage.clickProfileIcon();
		
		
		LoginPageScreen loginPageScreen = profilePage.navigateToLoginPage(softAssert);
		
		loginPageScreen.validateValidSignin(  email, softAssert);
		
		
		softAssert.assertAll();

		
		
	
		
	}

	
}
