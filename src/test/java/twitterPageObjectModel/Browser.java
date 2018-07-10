package twitterPageObjectModel;

import org.openqa.selenium.WebDriver;

public class Browser {

    public WebDriver driver;
	
    public Browser (WebDriver driver){
        this.driver = driver;
    }
	
	public void navigate(String url) {
		driver.get(url);
        driver.manage().window().maximize();
	}
	
	public void quit() {
		driver.quit();
	}
	
	public void sleep(int seconds) {
		int milliseconds = seconds * 1000;
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}
