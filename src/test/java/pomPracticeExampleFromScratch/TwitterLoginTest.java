package pomPracticeExampleFromScratch;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.Util;

public class TwitterLoginTest {
	public WebDriver driver;
	public static TwitterLoginPage login;

	@Before
	public void setChromedriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        driver = new ChromeDriver();
        login = new TwitterLoginPage(driver);
	}
	
	@After
	public void quitDriver() {
		driver.quit();
	}
   
	@Test
	public void successfulLogin() {
		
		driver.get("https://twitter.com");
		driver.manage().window().maximize();
		
		login.getOpenLoginButton().click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		WebElement emailInput = login.getLoginEmailInput();
		emailInput.sendKeys("dukaqa@gmail.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		login.getLoginPasswordInput().sendKeys(Util.password);
		
		login.getLoginSubmitButton().click();
	}
	
}
