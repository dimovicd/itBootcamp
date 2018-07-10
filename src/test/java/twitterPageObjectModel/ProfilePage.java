package twitterPageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

    public WebDriver driver;
	
    public ProfilePage (WebDriver driver){
        this.driver = driver;
    }
	
	private static By usernameLocator = By.cssSelector(".ProfileSidebar .ProfileHeaderCard h1 a");

	public WebElement getUsername() {
		WebElement username = driver.findElement(usernameLocator);
		return username;
	}
}