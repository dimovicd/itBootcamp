package itbootcampSeleniumWebdriver;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * @author Dušan Dimović
 */
public class FirstWebdriverExamples {

	
	@Test
	public void openGooglePage() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
	}
	 
    @Test
    public void openAndQuitGooglePage() {
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.quit();
    }
    
    @Test
    public void openAndSearchOnGoogle() {
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.click();
        searchField.sendKeys("it bootcamp");
        driver.quit();
    }

}
