package itbootcampSeleniumWebdriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Dušan Dimović
 */
public class BeforeAfterClassExamples {
	public static WebDriver driver;
	
	/**
	 * @BeforeClass method will be run before first test (when the suite is started)
	 */
	@BeforeClass
	public static void setChromedriver() {
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
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();
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
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();
        try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    }
    /**
	 * @AfterClass method will be run after the last test (when the suite is finished)
	 */
    @AfterClass
    public static void quitDriver() {
        driver.quit();

    }

}


