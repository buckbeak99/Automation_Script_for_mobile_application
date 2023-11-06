package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomatior2");
            capabilities.setCapability(MobileCapabilityType.UDID, "ce081718ab5a9732047e");
            capabilities.setCapability("appPackage", "com.nopstation.nopcommerce.nopstationcart");
            capabilities.setCapability("appActivity", "com.bs.ecommerce.main.MainActivity");
            capabilities.setCapability("app", "C:\\Users\\Dell\\Downloads\\nopstationCart_4.40.apk");

            // Driver Instance
          //  AppiumDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); // Update the URL as needed
            AppiumDriver<MobileElement> appiumDriver;

            // set up the appium server url to connect to
            URL appiumServer = new URL("http://127.0.0.1:4723/wd/hub");

            appiumDriver = new AppiumDriver<>(appiumServer, capabilities);

            // Assuming the app has loaded at this point

            // Automate the scenario
            MobileElement electronicsCategory = appiumDriver.findElementByXPath("xpath_of_electronics_category");
            electronicsCategory.click();
            MobileElement mattressProduct = appiumDriver.findElementByXPath("xpath_of_mattress_product");
            mattressProduct.click();

            // Increase the quantity by 2
            MobileElement plusButton = appiumDriver.findElementById("id_of_plus_button");
            plusButton.click();
            plusButton.click();

            MobileElement addToCartButton = appiumDriver.findElementById("id_of_add_to_cart_button");
            addToCartButton.click();
            appiumDriver.quit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
