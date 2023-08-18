package Definition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Swag_Labs_Definition {
	WebDriver driver = null;
	Swag_Labs_POM pm;

	@Given("Browser is open")
	public void browser_is_open() {
		String userDirectory = System.getProperty("user.dir");
		System.out.println("Step 1 - Browser is open");
		System.setProperty("webdriver.chrome.driver", userDirectory + "/src/test/resources/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@And("Naviagte to login page")
	public void naviagte_to_login_page() {
		System.out.println("Step 2 - Naviagte to login page");
		driver.navigate().to("https://www.saucedemo.com/");
		pm = new Swag_Labs_POM(driver);
	}

	@When("Enter the username: {string} and password: {string}")
	public void enter_the_username_and_password(String username, String password) {
		System.out.println("Step 3 - Enter the user name and password");
		pm.enterUsername(username);
		pm.enterPassword(password);
	}

	@When("^List of users enter the (.*) and (.*)$")
	public void list_of_users_enter_the_username_and_password(String username, String password) {
		System.out.println("Step 3 - enter the username and password");
		pm.enterUsername(username);
		pm.enterPassword(password);
	}

	@And("Click on the login button")
	public void click_on_the_login_button() {
		Boolean buttonClicked = false;
		System.out.println("Step 4 - Click on the login button");
		buttonClicked = pm.verifyLoginCredentions("Products");
		if (buttonClicked)
			System.out.println("User has been login successfully");
		else
			Assert.fail("Invalid Credential has been entered");
	}

	@And("User navigate to the Home page")
	public void user_navigate_to_the_home_page() {
		System.out.println("Step 5 - User navigate to the Home page");
	}

	@When("^user buys several products$")
	public void user_buys_several_products(List<String> products) throws InterruptedException {

		BuyAndDenyProduct(driver, products, "add-to-cart-sauce-labs-", "remove-sauce-labs-", "Remove", "add");
	}

	@When("^User removes bought products$")
	public void user_removes_bought_products(List<String> products) throws InterruptedException {

		BuyAndDenyProduct(driver, products, "remove-sauce-labs-", "add-to-cart-sauce-labs-", "Add to cart", "remove");
	}

	@Then("Logout page")
	public void logout_page() {
		System.out.println("Step 5 - User logout the page");
		pm.clickLogout();
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public void BuyAndDenyProduct(WebDriver element, List<String> products, String buy, String deny, String buttonMode,
			String buyordenytext) throws InterruptedException {
		for (String productList : products) {
			String addButtonId   = buy + productList;
			String denyButtonId  = deny + productList;
			WebElement addButton = driver.findElement(By.id(addButtonId));
			addButton.click();
			WebDriverWait wait      = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement removeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(denyButtonId)));

			if (removeButton.getText().equals(buttonMode)) {
				System.out.println(productList + " has been " + buyordenytext + " successfully");
			} else {
				System.out.println("Failed to " + buyordenytext + " " + productList);
			}
		}
	}
}