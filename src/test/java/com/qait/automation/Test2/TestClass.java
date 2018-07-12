package com.qait.automation.Test2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestClass {

	WebDriver driver;
	HomePageAction homeAction;
	ImagePageAction imageAction;
	ExitIntentAction exitAction;
	SortableDataAction dataTableAction;
	FormAuthAction formAction;
	HoverAction hoverAction;
	WysiwygEditorAction editorAction;
	StatusCodeAction statusAction;
	
	@BeforeClass
	public void init() {
//		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Downloads/chromedriver");
//		driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "/home/qainfotech/Downloads/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://10.0.31.161:9292/");
	}
	
	@Test
	public void verifyBasicAuthPromptDisplayed() {
		homeAction = new HomePageAction(driver);
		homeAction.clickOnBasicAuthLink();
		homeAction.testBasicPromptDisplayed();
	}
	
	@Test(dependsOnMethods= {"verifyBasicAuthPromptDisplayed"})
	public void verifySuccessfulAuthentication() {
		homeAction.performAuthentication();
	}
	
	@Test
	public void verifyBrokenImagesAreReported() {
		imageAction = new ImagePageAction(driver);
		imageAction.verifyImagesAreLoadedProperly();
	}
	
	@Test
	public void verifyExitIntentPageIsDisplayed() {
		exitAction = new ExitIntentAction(driver);
		exitAction.launchExitIntentPage();
	}
	
	@Test(dependsOnMethods= {"verifyExitIntentPageIsDisplayed"})
	public void verifyPopUpTitle() {
		exitAction.readPopUpTitle();
	}
	
	@Test
	public void verifyDataTablesPafeIsDisplayed() {
		dataTableAction = new SortableDataAction(driver);
		dataTableAction.openDataTablePage();
	}
	
	@Test(dependsOnMethods= {"verifyDataTablesPafeIsDisplayed"})
	public void verifyTableIsSortedByDueColumn() {
		dataTableAction.checkTableIsSorted();
	}
	
	@Test
	public void verifyLoginPageIsDisplayed() {
		formAction = new FormAuthAction(driver);
		formAction.launchLoginPage();
	}
	
	@Test(dependsOnMethods= {"verifyLoginPageIsDisplayed"})
	public void verifyErrorMsgIsDisplayedOnInvalidLogin() {
		formAction.verifyInvalidLogin();
	}
	
	@Test(dependsOnMethods= {"verifyLoginPageIsDisplayed"})
	public void verifySuccessMsgIsDisplayedOnValidLogin() {
		formAction.verifyValidLogin();
	}
	
	@Test(dependsOnMethods= {"verifySuccessMsgIsDisplayedOnValidLogin"})
	public void verifyLogOut() {
		formAction.verifyLogOut();
	}
	
	@Test
	public void verifyHoverPageIsDisplayed() {
		hoverAction = new HoverAction(driver);
		hoverAction.openHoverPage();
	}
	
	@Test(dependsOnMethods= {"verifyHoverPageIsDisplayed"})
	public void checkNumberOfImagesOnHoverPage() {
		hoverAction.verifyNumberOfImagesOnHoversPage();
	}
	
	@Test(dependsOnMethods= {"checkNumberOfImagesOnHoverPage"})
	public void verifyLinkAppearsOnHoverAction() {
		hoverAction.performHoverAction();
	}
	
	@Test(dependsOnMethods= {"verifyLinkAppearsOnHoverAction"})
	public void VerifyLinkDisappearsAfterHoverAction() {
		hoverAction.afterHoverAction();
	}
	
	/*@Test
	public void verifyWysiwygEditorIsDisplayed() {
		editorAction = new WysiwygEditorAction(driver);
		editorAction.openEditor();
	}
	
	@Test(dependsOnMethods= {"verifyWysiwygEditorIsDisplayed"})
	public void VerifyLinkDisappearsAfterHoverAction() {
		editorAction.performActions();
	}*/
	
	@Test
	public void verifyStatusCodesPageIsDisplayed() {
		statusAction = new StatusCodeAction(driver);
		statusAction.openStstusCodePage();
	}
	
	@Test(dependsOnMethods= {"verifyStatusCodesPageIsDisplayed"})
	public void verify404Msg() {
		statusAction.get404Msg();
	}
	
	@Test(dependsOnMethods= {"verify404Msg"})
	public void verifyStatusCodeOfPage() {
		statusAction.verifyHTTPStatusCode();
	}
	
	
	
	
}
