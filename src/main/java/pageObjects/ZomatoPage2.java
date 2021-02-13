package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import practise.AppiumFramework.CommonMethods;

public class ZomatoPage2 {

	CommonMethods cm;
	AndroidDriver<AndroidElement> driver;
	ExtentTest test;

	public ZomatoPage2(AndroidDriver<AndroidElement> driver)
	{
		this.driver=driver;
		cm=new CommonMethods(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[3]")
	private WebElement tab_profilePhoto;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Ayush']")
	private WebElement img_Photo;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Edit profile']")
	private WebElement lnk_Editprofile;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=' OK ']")
	private WebElement btn_OK;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Edit Photo']")
	private WebElement btn_editPhoto;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Change Photo']")
	private WebElement btn_changePhoto;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Continue with Facebook']")
	private WebElement btn_contwithFacebook;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Continue']")
	private WebElement btn_continue;
	
	public void tapOnContinueWithFacebook() {
		cm.tapWhenVisible(btn_contwithFacebook, 30);
	}
	
	public void tapOnContinue() {
		cm.tapWhenVisible(btn_continue, 30);
	}
	
	public void tapOnProfilePhoto() {
		cm.tapWhenVisible(tab_profilePhoto, 30);
	}
	
	public void tapOnLayoutPhoto() {
		cm.tapWhenVisible(img_Photo, 30);
	}
	
	public void tapOnEditProfile() {
		cm.tapWhenVisible(lnk_Editprofile, 30);
	}
	
	public void tapOnButtonOK() {
		cm.tapWhenVisible(btn_OK, 30);
	}
	
	public void tapOnEditPhoto() {
		cm.tapWhenVisible(btn_editPhoto, 30);
	}
	
	public void tapOnChangePhoto() {
		cm.tapWhenVisible(btn_changePhoto, 30);
	}
	
	

}
