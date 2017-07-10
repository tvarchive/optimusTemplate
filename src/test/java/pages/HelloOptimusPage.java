package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HelloOptimusPage extends BasePage {
    private AppiumDriver driver;

    @FindBy(id = "welcome_message")
    private WebElement welcomeMessage;

    public static final String MESSAGE = "Welcome to Optimus!! You are all ready to experience Automation like never before.";
    public HelloOptimusPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public String getWelcomeMessage() {
        waitForElementToBeVisible(welcomeMessage);
        return welcomeMessage.getText();
    }



}
