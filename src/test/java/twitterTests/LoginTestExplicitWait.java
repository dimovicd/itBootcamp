package twitterTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import twitterPageObjectModel.HomePage;
import twitterPageObjectModel.LoginPage;
import utils.Util;

public class LoginTestExplicitWait {
	public static WebDriver driver;
	public static LoginPage login;
	public static HomePage home;
	public static WebDriverWait wait;
	
	public static final int TIMEOUT = 5;
	public static final String BASE_URL = "https://twitter.com/";
	public static final String EMAIL = Util.username;
	public static final String PASSWORD = Util.password;

	/**
	 * WebDriverWait class should be initialize first
	 */
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		driver = new ChromeDriver();
        home = new HomePage(driver);
        login = new LoginPage(driver);
        
        // initializing
        wait = new WebDriverWait(driver, TIMEOUT);
	}
	
	@After
	public void driverQuit() {
		driver.quit();
	}
	/**
	 * Examples below are same - using EXPLICIT wait
	 */
	
	@Test
	public void successfulLoginWithPOM() {
		driver.get(BASE_URL + "login");
        driver.manage().window().maximize();
        
        // wait for login email input to be VISIBLE  (import ExpectedConditions class)
        wait.until(ExpectedConditions.visibilityOf(login.getLoginEmailInput()));
        // then send keys
        login.getLoginEmailInput().sendKeys(EMAIL);
        
        // wait for login password input to be VISIBLE
        wait.until(ExpectedConditions.visibilityOf(login.getLoginPasswordInput()));
        login.getLoginPasswordInput().sendKeys(PASSWORD);
        
        // wait for login submit button to be CLICKABLE
        wait.until(ExpectedConditions.elementToBeClickable(login.getLoginPasswordInput()));
        login.getLoginButton().click();
        
        // wait for url to be: https://twitter.com/
        wait.until(ExpectedConditions.urlMatches(BASE_URL));

        Assert.assertTrue(home.getProfileDropdownButton().isDisplayed());
	}
}
