package twitterTests;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import twitterPageObjectModel.LoginPage;
import twitterPageObjectModel.HomePage;

public class Login {
	
	public static LoginPage login;
	public static HomePage home;
	public static WebDriver driver;
	
	public static final int TIMEOUT = 5;
	public static final String BASE_URL = "https://twitter.com/";
	public static final String EMAIL = "Dukaqa@gmail.com";
	public static final String PASSWORD = "kursadzije";
	
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
	
	@Test
	public void successfulLogin() {
		driver.get(BASE_URL);
        driver.manage().window().maximize();
        WebElement loginInput = driver.findElement(By.cssSelector(".LoginForm .LoginForm-username input"));
        WebElement passwordInput = driver.findElement(By.cssSelector(".LoginForm .LoginForm-password input"));
        WebElement logInButton = driver.findElement(By.cssSelector(".LoginForm input[type='submit']"));
        loginInput.sendKeys(EMAIL);
        passwordInput.sendKeys(PASSWORD);
        logInButton.click();
        WebElement userProfileButton = driver.findElement(By.cssSelector(".topbar .me .btn"));
        
        Assert.assertTrue(userProfileButton.isDisplayed());
		sleep(TIMEOUT);
	}
	
	@Test
	public void unsuccessfulLogin() {
		driver.get(BASE_URL);
        driver.manage().window().maximize();
        WebElement loginInput = driver.findElement(By.cssSelector(".LoginForm .LoginForm-username input"));
        WebElement passwordInput = driver.findElement(By.cssSelector(".LoginForm .LoginForm-password input"));
        WebElement logInButton = driver.findElement(By.cssSelector(".LoginForm input[type='submit']"));
        loginInput.sendKeys(EMAIL + "x");
        passwordInput.sendKeys(PASSWORD);
        logInButton.click();
        WebElement loginErrorMessage = driver.findElement(By.cssSelector(".alert-messages .message"));

        Assert.assertTrue(loginErrorMessage.isDisplayed());
		sleep(TIMEOUT);
	}

	
	@Test
	public void successfulLoginWithPOM() {
		driver.get(BASE_URL);
        driver.manage().window().maximize();
        login.getLoginEmailInput().sendKeys(EMAIL);
        login.getLoginPasswordInput().sendKeys(PASSWORD);
        login.getLoginButton().click();
        
        Assert.assertTrue(home.getProfileDropdownButton().isDisplayed());
		sleep(TIMEOUT);
	}
	
	@Test
	public void unsuccessfulLoginWithPOM() {
		driver.get(BASE_URL);
        driver.manage().window().maximize();
        login.getLoginEmailInput().sendKeys(EMAIL + "x");
        login.getLoginPasswordInput().sendKeys(PASSWORD);
        login.getLoginButton().click();
        
		sleep(TIMEOUT);
	}
	
	@Test
	public void logIn() {
		driver.get(BASE_URL);
        driver.manage().window().maximize();
        login.logMeIn(EMAIL, PASSWORD);
        
        Assert.assertTrue(home.getProfileDropdownButton().isDisplayed());
		sleep(TIMEOUT);
	}
}
