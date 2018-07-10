package twitterPageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebDriver driver;
	
    public HomePage (WebDriver driver){
        this.driver = driver;
    }
	
	private static By profileDropdownButtonLocator = By.cssSelector(".topbar .me .btn");
	private static By profileButtonSelector = By.cssSelector(".DashUserDropdown li .Icon--me");

	public WebElement getProfileDropdownButton() {
		WebElement profileDropdownButton = driver.findElement(profileDropdownButtonLocator);
		return profileDropdownButton;
	}

	public WebElement getProfileButton() {
		WebElement profileButton = driver.findElement(profileButtonSelector);
		return profileButton;
	}
	
}
