package Basics;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import  io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
public class Base {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stubpl
		AndroidDriver<AndroidElement> driver;
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi 4");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.bt.bms");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.movie.bms.splash.views.activities.SplashScreenActivity");
		driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElementById("language_malayalam").click();
		driver.findElementById("language_english").click();
		driver.findElementById("language_text_view_label").click();
		driver.findElementById("launcher_tv_for_skip").click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.findElementByXPath("//*[@id='permission_deny_button']").click();
		//new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(findElementByXPath("//*[@id='permission_deny_button']")));
       driver.findElementByXPath("//*[@text='DENY']").click();
       driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		//driver.findElementByClassName("android.widget.Button").click();
       
       TouchAction t = new TouchAction(driver);
       //WebElement we = driver.findElementByXPath("//*[@text='കൊച്ചി']");
       //System.out.println(driver.findElementByXPath("//android.widget.TextView[@text='Kochi']").isDisplayed());
      // WebElement we =driver.findElementByXPath("//android.widget.TextView[@text='Kochi']");
      // t.tap(tapOptions().withElement(element(we))).perform();
      // driver.findElementByXPath("//[@Class='android.widget.RelativeLayout]' and [@index=9]").click();
       t.tap(PointOption.point(435,1385)).perform();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      
       
       WebElement we1 = driver.findElementByXPath("//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@text='Kayamkulam Kochunni']]/*[@class='android.widget.ImageView' and @width>0 and @height>0])[2]");
		System.out.println(driver.findElementByXPath("//*[@class='android.view.ViewGroup' and ./parent::*[@class='android.view.ViewGroup'] and (./preceding-sibling::* | ./following-sibling::*)[@text='Kayamkulam Kochunni']]/*[@class='android.widget.ImageView' and @width>0 and @height>0])[2]").isDisplayed());
		t.tap(tapOptions().withElement(element(we1))).perform();
		
		driver.findElementById("movie_details_activity_img_play_trailer").click();
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.findElementById("player_control_play_pause_replay_button").click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"English\"));");
	}

}
