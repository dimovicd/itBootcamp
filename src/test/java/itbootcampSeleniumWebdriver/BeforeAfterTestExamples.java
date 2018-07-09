package itbootcampSeleniumWebdriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * @author Dušan Dimović
 */


public class BeforeAfterTestExamples {
	public static WebDriver driver;
	
	/**
	 * @Before and @After methods will be run before/after each test of the current class 
	 */
	@Before
	public void setChromedriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        driver = new ChromeDriver();
	}
    
    @Test
    public void openAndSearchItBootcamp() {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.click();
        searchField.sendKeys("it bootcamp");
        searchField.sendKeys(Keys.ENTER);
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    }
    
    
    @Test
    public void openAndSearchFacebook() {
        driver.get("https://www.google.com/");
        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.click();
        searchField.sendKeys("facebook");
        searchField.sendKeys(Keys.ENTER);
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    }
    
    @After
    public void quitDriver() {
        driver.quit();

    }

}
