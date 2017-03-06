package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BookingPage extends BasePage {
    private AppiumDriver driver;

    public BookingPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void bookARide() {
        //code to book a ride
    }
}
