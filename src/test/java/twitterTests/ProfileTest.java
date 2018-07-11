package twitterTests;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import twitterPageObjectModel.LoginPage;
import twitterPageObjectModel.HomePage;
import twitterPageObjectModel.ProfilePage;
import utils.Util;
import twitterPageObjectModel.Browser;

public class ProfileTest {
	
	public static LoginPage login;
	public static HomePage home;
	public static ProfilePage profile;
	public static WebDriver driver;
	public static Browser browser;
	public static WebDriverWait wait;
	
	public static final int TIMEOUT = 5;
	public static final String BASE_URL = "https://twitter.com/";
	public static final String EMAIL = Util.username;
	public static final String PASSWORD = Util.password;
	public static final String USERNAME = "kursadzije2";
	public static final String FULL_NAME = "kursadzije";

	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
		driver = new ChromeDriver();
        home = new HomePage(driver);
        login = new LoginPage(driver);
        browser = new Browser(driver);
        profile = new ProfilePage(driver);
        wait = new WebDriverWait(driver, TIMEOUT);
	}
	
	@Before
	public void logIn() {
		browser.navigate(BASE_URL + "login");
        login.logMeIn(EMAIL, PASSWORD);
	}
	
	@After
	public void driverQuit() {
		browser.quit();
	}
		
	@Test
	public void checkUsernameVisible() {
        home.getProfileDropdownButton().click();
        home.getProfileButton().click();
        wait.until(ExpectedConditions.urlToBe(BASE_URL + USERNAME));
        wait.until(ExpectedConditions.visibilityOf(profile.getUsername()));
        
        Assert.assertTrue(profile.getUsername().getText().equals(FULL_NAME));
	}
}
