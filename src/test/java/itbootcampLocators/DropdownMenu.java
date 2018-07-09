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

public class DropdownMenu {
		
	public static WebDriver driver;
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
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
    }
    
    @Test
    public void selectByValue() {
    	
    	WebElement dropdownLink = driver.findElement(By.cssSelector("#content ul a[href='/dropdown']"));
    	dropdownLink.click();
    	WebElement dropdownMenu = driver.findElement(By.cssSelector("#dropdown"));   	
    	dropdownMenu.click();
    	sleep(5);
    	WebElement option1 = driver.findElement(By.cssSelector("#dropdown [value='1']"));
    	WebElement option2 = driver.findElement(By.cssSelector("#dropdown [value='2']"));
    	option1.click();
    	sleep(5);
    	dropdownMenu.click();
    	sleep(5);
    	option2.click();
    	sleep(5);    	
    }
    
    @Test
    public void selectByIndex() {
    	
    	WebElement dropdownLink = driver.findElement(By.cssSelector("#content ul a[href='/dropdown']"));
    	dropdownLink.click();
    	WebElement dropdownMenu = driver.findElement(By.cssSelector("#dropdown"));   	
    	dropdownMenu.click();
    	sleep(5);
    	List<WebElement> options = driver.findElements(By.cssSelector("#dropdown option"));
    	options.get(1).click();
    	sleep(5);
    	dropdownMenu.click();
    	sleep(5);
    	options.get(2).click();
    	sleep(5);  
    	
    }
}
