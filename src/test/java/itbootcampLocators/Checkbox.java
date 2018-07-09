package itbootcampLocators;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	private static final String BASE_URL = "https://the-internet.herokuapp.com/";
	private static final int TIMEOUT = 5;
	private static WebDriver driver;
	public static void sleep(int seconds) {
		int milliseconds = seconds * 1000;
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	
	@BeforeClass
	public static void setChromedriver() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
    @AfterClass
    public static void quitDriver() {
    	driver.quit();
    }
    
    @Before
    public void setUp() {
    	driver.get(BASE_URL + "/checkboxes");
    	driver.manage().window().maximize();
    	sleep(TIMEOUT);
    }
    
    @Test
    public void byIndex() {
    	
    	List<WebElement> options = driver.findElements(By.cssSelector("#checkboxes input"));
    	options.get(0).click();
    	sleep(TIMEOUT);

    	
    }
}
