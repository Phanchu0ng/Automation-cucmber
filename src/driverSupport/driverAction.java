package driverSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class driverAction {
	WebDriver driver = null;
	WebDriverWait wait;

	public driverAction(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}

	public WebDriverWait getWait() {
		return wait;
	}

	public void waitForElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clearAndSendkeys(WebElement element, String text) {
		waitForElement(element);
		element.clear();
		element.sendKeys(text);
	}

	public void sendKeysElementWithValueAttribute(String text, String typeElement, String attribute, String value) {
		By by = By.xpath("//" + typeElement + "[@" + attribute + "='" + value + "']");
		WebElement element = driver.findElement(by);
		clearAndSendkeys(element, text);

	}

	public void clickElementWithvallueAttibute(String typeElement, String attribute, String value) {
		By by = By.xpath("//div/form//" + typeElement + "[@" + attribute + "='" + value + "']");
		driver.findElement(by).click();

	}
	//// div[starts-with(normalize-space(),'*This is not a valid email or phone')]

	public String getTextWithValueText(String typeElement, String value) {
		By by = By.xpath("//" + typeElement + "[starts-with(normalize-space(),"+"'" + value + "')]");
		return driver.findElement(by).getText().trim();
	}

	public boolean getelementdisplay(String typeElement, String attribute, String value) {
		By by = By.xpath("//" + typeElement + "[@" + attribute + "='" + value + "']");
		return driver.findElement(by).isDisplayed();
	}
	public void close() {
		driver.close();
	}
}