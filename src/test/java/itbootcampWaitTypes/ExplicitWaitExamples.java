package itbootcampWaitTypes;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitExamples {
	public static WebDriver driver;

	
	 public static void waitForUrlContains(String partOfUrl) {
	        WebDriverWait wait = new WebDriverWait(driver, 20);
	        wait.until(ExpectedConditions.urlContains(partOfUrl));
	    }
	 public static void sleep(int milliseconds) {
	        try {
	            Thread.sleep(milliseconds);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

//	    ELEMENT RELATED

	 public void click(By selector) {
		 WebDriverWait wait = new WebDriverWait(driver, 10);
         wait.until(ExpectedConditions.elementToBeClickable(selector));
         driver.findElement(selector).click();
	 }
	    
	 public static void sendKeys(By selector, String keys) {
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
	        driver.findElement(selector).sendKeys(keys);
	    }
	 public static String getText(By selector) {
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
	        return driver.findElement(selector).getText();
	    }
	 public static Boolean isElementVisible(By selector) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, 3);
	            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
	
	@BeforeClass
	public static void setChromedriver() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        driver = new ChromeDriver();
	
        
	}
}
