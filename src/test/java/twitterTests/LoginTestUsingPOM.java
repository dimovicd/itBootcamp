package twitterTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import twitterPageObjectModel.HomePage;
import twitterPageObjectModel.LoginPage;
import utils.Util;

public class LoginTestUsingPOM {
	
	public static LoginPage login;
	public static HomePage home;
	public static WebDriver driver;
	
	public static final int TIMEOUT = 5;
	public static final String BASE_URL = "https://twitter.com/";
	public static final String EMAIL = Util.username;
	public static final String PASSWORD = Util.password;
	
	
	
	public static void sleep(int seconds) {
		int milliseconds = seconds * 1000;
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		driver = new ChromeDriver();
        home = new HomePage(driver);
        login = new LoginPage(driver);
	}
	
	@After
	public void driverQuit() {
		driver.quit();
	}
	/**
	 * Examples below are same, but Using Page Object Model pattern
	 */
	
	
	
	@Test
	public void successfulLoginWithPOM() {
		driver.get(BASE_URL + "login");
        driver.manage().window().maximize();
        login.getLoginEmailInput().sendKeys(EMAIL);
        login.getLoginPasswordInput().sendKeys(PASSWORD);
        login.getLoginButton().click();
        
        Assert.assertTrue(home.getProfileDropdownButton().isDisplayed());
		sleep(TIMEOUT);
	}
	
	@Test
	public void unsuccessfulLoginWithPOM() {
		driver.get(BASE_URL + "login");
        driver.manage().window().maximize();
        login.getLoginEmailInput().sendKeys(EMAIL + "x");
        login.getLoginPasswordInput().sendKeys(PASSWORD);
        login.getLoginButton().click();
        
		sleep(TIMEOUT);
	}
	
	/**
	 * Login using logMeIn method
	 */
	@Test
	public void logIn() {
		driver.get(BASE_URL + "login");
        driver.manage().window().maximize();
        login.logMeIn(EMAIL, PASSWORD);
        
        Assert.assertTrue(home.getProfileDropdownButton().isDisplayed());
		sleep(TIMEOUT);
	}
}

