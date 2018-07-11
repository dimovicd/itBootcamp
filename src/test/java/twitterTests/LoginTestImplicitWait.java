package twitterTests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import twitterPageObjectModel.HomePage;
import twitterPageObjectModel.LoginPage;
import utils.Util;

public class LoginTestImplicitWait {
	public static WebDriver driver;
	public static LoginPage login;
	public static HomePage home;
	
	public static final int TIMEOUT = 5;
	public static final String BASE_URL = "https://twitter.com/";
	public static final String EMAIL = Util.username;
	public static final String PASSWORD = Util.password;

	/**
	 * After initializing the driver; Implicit wait can be set 
	 */
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		driver = new ChromeDriver();
        home = new HomePage(driver);
        login = new LoginPage(driver);
        
        // setup implicit wait
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
	}
	
	@After
	public void driverQuit() {
		driver.quit();
	}
	/**
	 * Examples below are same, but much stable - using Implicit wait
	 */
	
	
	
	@Test
	public void successfulLoginWithPOM() {
		driver.get(BASE_URL + "login");
        driver.manage().window().maximize();
        login.getLoginEmailInput().sendKeys(EMAIL);
        login.getLoginPasswordInput().sendKeys(PASSWORD);
        login.getLoginButton().click();
        
        Assert.assertTrue(home.getProfileDropdownButton().isDisplayed());
	}
	
	@Test
	public void unsuccessfulLoginWithPOM() {
		driver.get(BASE_URL + "login");
        driver.manage().window().maximize();
        login.getLoginEmailInput().sendKeys(EMAIL + "x");
        login.getLoginPasswordInput().sendKeys(PASSWORD);
        login.getLoginButton().click();
  
	}

}
