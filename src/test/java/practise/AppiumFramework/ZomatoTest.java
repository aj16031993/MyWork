package practise.AppiumFramework;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


import pageObjects.ZomatoPage;
import pageObjects.ZomatoPage2;
import resources.StaticDataProvider;

public class ZomatoTest extends base {


	@Test()
	public void sampleTest() throws IOException,InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","src\\main\\java\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.close();
	}

//	@Test(dataProvider="excelDP",dataProviderClass=StaticDataProvider.class)
//	public void selectCountryTest(HashMap<String,String>data) throws IOException,InterruptedException
//	{
//		service=startServer();
//		AndroidDriver<AndroidElement> driver=capabilities();
//		ZomatoPage zom=new ZomatoPage(driver); //Thread.sleep(10000);
//		ZomatoPage2 zom2=new ZomatoPage2(driver);
//		zom2.tapOnContinueWithFacebook();
//		zom2.tapOnContinue();
//		zom.tapLocationButton(); zom.enterLocation(data.get("Location_key"));
//		zom.selectOptionFromSuggestionDropdown(data.get("Location"));
//		zom.tapConfirmLocation(); System.out.println(driver.getPageSource());
//		zom.enterValueInSearchRestraunt(data.get("Restraunt_key"));
//		zom.selectOptionFromSuggestionDropdown(data.get("Restraunt"));
//		service.stop();
//	}
//
//
//	@Test
//	public void uploadPhotoTest() throws IOException, InterruptedException
//	{
//		service=startServer();
//		AndroidDriver<AndroidElement> driver=capabilities();
//		ZomatoPage2 zom=new ZomatoPage2(driver);
//		zom.tapOnContinueWithFacebook();
//		zom.tapOnContinue();
//		zom.tapOnProfilePhoto();
//		zom.tapOnLayoutPhoto();
//		zom.tapOnEditProfile();
//		zom.tapOnButtonOK();
//		zom.tapOnEditPhoto();
//		zom.tapOnChangePhoto();
//		service.stop();
//	}


}


