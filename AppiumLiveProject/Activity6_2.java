package testsActivities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Activity6_2 {
	AppiumDriver<MobileElement> driver = null;

	 WebDriverWait wait;

	 @BeforeClass
     
		// Set the Desired Capabilities

			public void beforeClass() throws MalformedURLException {
		        // Set the Desired Capabilities
		        DesiredCapabilities caps = new DesiredCapabilities();
		        caps.setCapability("deviceName", "Vivo1714");
		        caps.setCapability("platformName", "android");
		        caps.setCapability("automationNames", "UiAutomator2");
		        caps.setCapability("appPackage", "com.android.chrome");
		        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		        caps.setCapability("noReset", true);

		     // Instantiate Appium Driver
		        try { 		
		            // Initialize driver
		            URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
		            driver = new AndroidDriver<MobileElement>(appServer, caps);
		            System.out.println("Chrome is open");
		        } 
		        catch (MalformedURLException e) 
		        {
		            System.out.println(e.getMessage());
		  	
		        }
		        driver.get("https://www.training-support.net/selenium");
		    }

	 @Test

	 public void PopUpInValidLoginCredentials() {

	  driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

     //Scrolling

     driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollDescriptionIntoView(\"Popups Tooltips and Modals\")")).click();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     //SignIN

     MobileElement SigninButton =driver.findElement(By.xpath("//android.widget.Button[contains(@text, 'Sign In')]"));
     SigninButton.click();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     //enter username

     String UserName = "resourceId(\"username\")";
     driver.findElement(MobileBy.AndroidUIAutomator(UserName)).click();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     UserName = "resourceId(\"username\")";
     MobileElement addUsername = driver.findElement(MobileBy.AndroidUIAutomator(UserName));
     addUsername.sendKeys("admin");

     // enter invalid password 
     
     String Password = "resourceId(\"password\")";
     driver.findElement(MobileBy.AndroidUIAutomator(Password)).click();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     Password = "resourceId(\"password\")";
     MobileElement addPassword = driver.findElement(MobileBy.AndroidUIAutomator(Password));
     addPassword.sendKeys("pasord");
     
     // click login button
     
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     MobileElement LoginButton =driver.findElement(By.xpath("//android.widget.Button[contains(@text, 'Log in')]"));
     LoginButton.click();

     //Assertion

     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     MobileElement confirmation =driver.findElement(By.xpath("//android.view.View[contains(@text, 'Welcome Back, admin')]"));
	  String ActionConfirmation = confirmation.getText();
	  Assert.assertEquals(ActionConfirmation, "Welcome Back, admin");

	}

	@AfterClass
	public void afterClass() {
	driver.quit();
	}
}
