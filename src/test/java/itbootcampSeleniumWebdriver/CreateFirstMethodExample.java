package itbootcampSeleniumWebdriver;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 * @author Dušan Dimović
 */
public class CreateFirstMethodExample {
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
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        driver = new ChromeDriver();
	}
    
    @Test
    public void openAndSearchItBootcamp() {
        driver.get("https://www.google.com/");

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.click();
        searchField.sendKeys("it bootcamp");
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();
        sleep(10);
    }
    @Test
    public void openAndSearchFacebook() {
        driver.get("https://www.google.com/");
        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.click();
        searchField.sendKeys("facebook");
        searchField.sendKeys(Keys.ENTER);
		sleep(10);
    }
	    
	@AfterClass
	 public static void quitDriver() {
	        driver.quit();

	    }

}
