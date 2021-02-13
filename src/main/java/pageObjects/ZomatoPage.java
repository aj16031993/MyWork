package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import practise.AppiumFramework.CommonMethods;

public class ZomatoPage {

	CommonMethods cm;
	AndroidDriver<AndroidElement> driver;

	public ZomatoPage(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		cm=new CommonMethods(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search for restaurants, cuisines…']")
	private WebElement txtbox_searchRestraunt;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Start typing…']")
	private WebElement txtbox_searchRestrauntPostClick;
	
	@AndroidFindBy(id="com.application.zomato:id/edittext")
	private WebElement txtbox_searchLocation;

	@AndroidFindBy(id="com.application.zomato:id/left_action")
	private WebElement locationTitle;

	@AndroidFindBy(id="com.application.zomato:id/skip_button")
	private WebElement skipbutn;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Confirm location']")
	private WebElement btn_confirmLocation;
	
	
	public void enterValueInSearchRestraunt(String value) {
		cm.tapWhenVisible(txtbox_searchRestraunt, 30);
		driver.hideKeyboard();
		cm.enterValueWhenVisible(txtbox_searchRestrauntPostClick, value, 30);
	}
	
	public void tapConfirmLocation() {
		cm.tapWhenVisible(btn_confirmLocation, 30);
	}

	public void clickSkipButton() {
		cm.moveToElement(skipbutn, 30);
	}

	public void tapLocationButton() {
		cm.tapWhenVisible(locationTitle, 30);
	}


	public void clickLocationButton() {
		cm.clickWhenVisible(locationTitle,30);
	}

	public void enterLocation(String location) {
		cm.clickWhenVisible(txtbox_searchLocation);
		driver.hideKeyboard();
		cm.enterValueWhenVisible(txtbox_searchLocation, location, 30);
	}


	public void selectOptionFromSuggestionDropdown(String value) {
		By city=By.xpath("//android.widget.TextView[@text='"+value+"']");
		cm.tapWhenVisible(city, 30);
	}



}
