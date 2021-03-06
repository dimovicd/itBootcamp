package twitterPageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;
	
    public LoginPage (WebDriver driver){
        this.driver = driver;
    }
    
	private static By openLoginButtonLocator = By.cssSelector(".StaticLoggedOutHomePage-buttonLogin");

	private static By loginEmailInputLocator = By.cssSelector(".js-username-field.email-input");
	private static By loginPasswordInputLocator = By.cssSelector(".js-password-field");
	private static By loginSubmitButtonLocator = By.cssSelector("button[type='submit']");
	
	private static By loginErrorMessageLocator = By.cssSelector(".alert-messages .message");

	public WebElement getLoginEmailInput() {
		WebElement loginEmailInput = driver.findElement(loginEmailInputLocator);
		return loginEmailInput;
	}

	public WebElement getLoginPasswordInput() {
		WebElement loginPasswordInput = driver.findElement(loginPasswordInputLocator);
		return loginPasswordInput;
	}

	public WebElement getLoginButton() {
		WebElement loginButton = driver.findElement(loginSubmitButtonLocator);
		return loginButton;
	}

	public WebElement getLoginErrorMessage() {
		WebElement loginErrorMessage = driver.findElement(loginErrorMessageLocator);
		return loginErrorMessage;
	}
	
	public void logMeIn(String email, String password) {
		getLoginEmailInput().sendKeys(email);
		getLoginPasswordInput().sendKeys(password);
		getLoginButton().click();
		
	}
	
}
