package Definition;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Swag_Labs_POM {

	WebDriver driver = null;

	@FindBy(id = "user-name")
	WebElement txt_username;

	@FindBy(id = "password")
	WebElement txt_password;

	@FindBy(id = "login-button")
	WebElement btn_login;

	@FindBy(id = "logout_sidebar_link")
	WebElement btn_logout;

	@FindBy(id = "react-burger-menu-btn")
	WebElement btn_menuitem;

	public Swag_Labs_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}

	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void clickLogout() {
		btn_menuitem.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		if ((driver.getPageSource().contains("Logout"))) {

			btn_logout.click();
		}

	}

	public Boolean verifyLoginCredentions(String pageHeader) {
		btn_login.click();
		if (!(driver.getPageSource().contains(pageHeader))) {
			return false;
		} else {
			return true;
		}

	}
}