package practise.AppiumFramework;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import resources.ExtentTestManager;

public class CommonMethods {
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	TouchAction action;
	
	public CommonMethods(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		action =new TouchAction(driver);
	}
	
	public void clickWhenVisible(WebElement elem, int time) {
		wait=new WebDriverWait(this.driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		elem.click();
	}
	
	public void clickWhenVisible(WebElement elem) {
		wait=new WebDriverWait(this.driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		elem.click();
	}

	public void moveToElement(WebElement elem,int time) {
		wait=new WebDriverWait(this.driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		action.moveTo(element(elem)).perform();
	}
	
	public void tapWhenVisible(WebElement elem,int time) {
		wait=new WebDriverWait(this.driver,time);
		wait.until(ExpectedConditions.visibilityOf(elem));
		Assert.assertTrue(elem.isDisplayed(), elem +" is not  displayed");
		action.tap(tapOptions().withElement(element(elem))).perform();
		ExtentTestManager.getTest().log(Status.INFO, "Successfully clicked on "+elem);
	}
	
	public void tapWhenVisible(By locator,int time) {
		wait=new WebDriverWait(this.driver,time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement elem=driver.findElement(locator);
		Assert.assertTrue(elem.isDisplayed(), elem +" is not  displayed");
		action.tap(tapOptions().withElement(element(elem))).perform();
	}
	
	public void enterValueWhenVisible(WebElement elem,String text,int time) {
		wait=new WebDriverWait(this.driver,time);
		wait.until(ExpectedConditions.visibilityOf(elem));
		Assert.assertTrue(elem.isDisplayed(), elem +" is not  displayed");
		elem.sendKeys(text);
		ExtentTestManager.getTest().log(Status.INFO, "Successfully entered "+ text + " in "+elem);
	}
	
	
}
