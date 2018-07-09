package itbootcampSeleniumWebdriver;

import org.junit.AfterClass;
import org.junit.Assert;
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
public class FirstAssertionExamples {
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
    /**
     * Check if first Google result for 'IT Bootcamp' search is as expected
     */
    @Test
    public void checkFirstGoogleResult() {
        driver.get("https://www.google.com/");

        WebElement searchField = driver.findElement(By.id("lst-ib"));
        searchField.click();
        searchField.sendKeys("it bootcamp");
        searchField.sendKeys(Keys.ENTER);
        sleep(5);
        WebElement firstResult = driver.findElement(By.xpath("//*[@id=\'rso\']/div/div/div[1]/div/div/h3/a"));
        String firstResultText = firstResult.getText();
        Assert.assertTrue(firstResultText.equals("ITBootcamp: Naslovna"));
        System.out.println("My first result is: " + firstResultText);
    }
       
    @AfterClass
    public static void quitDriver() {
        driver.quit();

    }

}
