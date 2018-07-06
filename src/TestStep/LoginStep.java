package TestStep;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverSupport.driverAction;
import junit.framework.Assert;

public class LoginStep {
	driverAction myaction;
	WebDriver driver;

	@Given("^start application$")
	public void start_application() throws Throwable

	{

		System.setProperty("webdriver.chrome.driver", "D://Document//work//chromedriver.exe");
		driver = new ChromeDriver();
		myaction = new driverAction(driver);
		driver.manage().window().maximize();
		driver.get("https://dashboard.hottab.us/#!/login");
	}

	@When("^enter valid Email (.*)$")
	public void user_enter_a_to_has_is(String email) throws Throwable {
		myaction.sendKeysElementWithValueAttribute(email, "input", "name", "username");
		Thread.sleep(3000);

	}

	@When("^click button next$")
	public void click_button_next() throws Throwable {
		// driver.findElement(By.cssSelector(".btn.btn-lg")).click();
		// Thread.sleep(3000);
		myaction.clickElementWithvallueAttibute("button", "type", "submit");
		Thread.sleep(3000);
	}

	@When("^enter Password (.*)$")
	public void enter_Password(String password) throws Throwable {
		myaction.sendKeysElementWithValueAttribute(password, "input", "name", "password");
		Thread.sleep(3000);
	}

	@When("^click button login$")
	public void click_button_login() throws Throwable {
		myaction.clickElementWithvallueAttibute("button", "type", "submit");
		Thread.sleep(3000);

	}

	@Then("^login successfuly$")
	public void login_successfuly() throws Throwable {
		if (myaction.getelementdisplay("a", "e-name", "hotel_name")) {
			System.out.println("Login Successfully");
		} else {
			System.out.println("Login falied");
		}
	}
	
	@Then("^return message is \"([^\"]*)\"$")
	public void return_message_is(String value) throws Throwable{
	String errMsg = myaction.getTextWithValueText("div", value);
	Assert.assertEquals(value, errMsg);

	}
}