package test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
public class LaunchApp {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android"); // or "iOS" for iOS testing
        capabilities.setCapability("deviceName", "your_device_name");
        capabilities.setCapability("app", "path/to/your/app.apk"); // Provide the path to your NOP Commerce APK

        AppiumDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); // Update the URL as needed

        // Assuming the app has loaded at this point

        MobileElement topCartIcon = driver.findElement(By.id("id_of_top_cart_icon"));
        topCartIcon.click();

        // Click the checkout button
        MobileElement checkoutButton = driver.findElement(By.id("id_of_checkout_button"));
        checkoutButton.click();

        // Select checkout as guest
        MobileElement checkoutAsGuestButton = driver.findElement(By.id("id_of_checkout_as_guest_button"));
        checkoutAsGuestButton.click();

        // Input billing details and continue
        MobileElement firstNameField = driver.findElement(By.id("id_of_first_name_field"));
        firstNameField.sendKeys("Mike");

        // Add more fields for other billing details and input values as needed

        MobileElement continueBillingButton = driver.findElement(By.id("id_of_continue_billing_button"));
        continueBillingButton.click();

        // Select shipping method
        MobileElement nextDayAirOption = driver.findElement(By.id("id_of_next_day_air_option"));
        nextDayAirOption.click();

        // Click continue
        MobileElement continueShippingButton = driver.findElement(By.id("id_of_continue_shipping_button"));
        continueShippingButton.click();

        // Select payment method
        MobileElement checkMoneyOrderOption = driver.findElement(By.id("id_of_check_money_order_option"));
        checkMoneyOrderOption.click();

        // Click continue
        MobileElement continuePaymentButton = driver.findElement(By.id("id_of_continue_payment_button"));
        continuePaymentButton.click();

        // Click next button on payment information page
        MobileElement nextButton = driver.findElement(By.id("id_of_next_button"));
        nextButton.click();

        // Click confirm button to place the order
        MobileElement confirmButton = driver.findElement(By.id("id_of_confirm_button"));
        confirmButton.click();

        // Verify order placed successfully
        MobileElement successPopup = driver.findElement(By.id("id_of_success_popup"));
        String successMessage = successPopup.getText();
        if (successMessage.contains("Your order has been successfully processed!")) {
            System.out.println("Order placed successfully.");
        } else {
            System.out.println("Order placement failed.");
        }

        // Close the app
        driver.quit();
    }
}
