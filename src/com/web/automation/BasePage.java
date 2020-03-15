package com.web.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	String parentWindow;

	// default constructor
	public BasePage() {
	}

	// All the other constructors of child classes, will call this constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void OpenUrl(String Url) {
		driver.get(Url);
	}

	/*********************************
	 * Utility Functions
	 ********************************/

	/** Managing Input fields and button **/
	public void type(WebElement locatorKey, String data) {

		locatorKey.sendKeys(data);
	}

	/** Managing Links **/
	public void click(WebElement locatorKey) {
		explicitWaitTillElementIsEnabled(locatorKey, 10);
		locatorKey.click();
	}

	/** Explicit Wait **/
	public void explicitWait(WebElement locatorKey, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(locatorKey));
	}

	public void stopTheScript(int timeInMillisec) {
		try {
			Thread.sleep(timeInMillisec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void explicitWaitTillElementIsEnabled(WebElement locatorKey, int time) {

		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(locatorKey));
	}

	public void mouseOver(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	public void getWindowHandle() {

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's
													// your newly opened window)
		}
	}

	public void compare(double x, double y) {
		int retResult = Double.compare(x, y);
		if (retResult > 0) {
			System.out.println("Flipkart has lesser price");
		} else if (retResult < 0) {
			System.out.println("Amazon has lesser price");
		} else {
			System.out.println("Flipkart and Amazon has same price");
		}
	}

}
