package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

public class HelloOptimusPage extends BasePage {
    private AppiumDriver driver;

    public HelloOptimusPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public HelloOptimusPage doSomething() {
        return this;
    }

}
