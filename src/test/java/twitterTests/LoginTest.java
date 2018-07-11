package twitterTests;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Util;


public class LoginTest {
	
	public static WebDriver driver;
	
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
	}
	
	@After
	public void driverQuit() {
		driver.quit();
	}
	
	/**
	 * Tests below are without using Page object Model pattern
	 */
	
	@Test
	public void successfulLogin() {
		driver.get(BASE_URL + "login");
        driver.manage().window().maximize();
        WebElement loginInput = driver.findElement(By.cssSelector(".js-username-field.email-input"));
        WebElement passwordInput = driver.findElement(By.cssSelector(".js-password-field"));
        WebElement logInButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginInput.sendKeys(EMAIL);
        passwordInput.sendKeys(PASSWORD);
        logInButton.click();
        
        WebElement userProfileButton = driver.findElement(By.cssSelector(".topbar .me .btn"));
        
        Assert.assertTrue(userProfileButton.isDisplayed());
		sleep(5);
	}
	
	@Test
	public void unsuccessfulLogin() {
		driver.get(BASE_URL + "login");
        driver.manage().window().maximize();
        WebElement loginInput = driver.findElement(By.cssSelector(".js-username-field.email-input"));
        WebElement passwordInput = driver.findElement(By.cssSelector(".js-password-field"));
        WebElement logInButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginInput.sendKeys(EMAIL + "x");
        passwordInput.sendKeys(PASSWORD);
        logInButton.click();

        WebElement loginErrorMessage = driver.findElement(By.cssSelector(".alert-messages .message"));

        Assert.assertTrue(loginErrorMessage.isDisplayed());
		sleep(5);
	}


}