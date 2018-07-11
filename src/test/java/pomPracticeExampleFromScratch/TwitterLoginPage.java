package pomPracticeExampleFromScratch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TwitterLoginPage {
	
	public WebDriver driver;
	
	public TwitterLoginPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	private static By openLoginButtonLocator = By.cssSelector(".StaticLoggedOutHomePage-buttonLogin");

	private static By loginEmailInputLocator = By.cssSelector(".js-username-field.email-input");
	private static By loginPasswordInputLocator = By.cssSelector(".js-password-field");
	private static By loginSubmitButtonLocator = By.cssSelector("button[type='submit']");

	
	public WebElement getLoginEmailInput() {
		
		WebElement loginEmailInput = driver.findElement(loginEmailInputLocator);
		return loginEmailInput;
		
	}
	public WebElement getOpenLoginButton() {
		
		WebElement openLoginButton = driver.findElement(openLoginButtonLocator);
		return openLoginButton;
		
	}
	public WebElement getLoginPasswordInput() {
		
		WebElement loginPasswordInput = driver.findElement(loginPasswordInputLocator);
		return loginPasswordInput;
		
	}
	public WebElement getLoginSubmitButton() {
		
		WebElement loginSubmitButton = driver.findElement(loginSubmitButtonLocator);
		return loginSubmitButton;
		
	}


}
