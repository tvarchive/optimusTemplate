package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Runtime.getRuntime;


public class BasePage {

    private AppiumDriver driver;
    private WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 20);
    }


    public BasePage() {
    }

    private static ExpectedCondition<WebElement> elementToBeChecked(
            final WebElement element) {
        return new ExpectedCondition<WebElement>() {

            public ExpectedCondition<WebElement> visibilityOfElement =
                    ExpectedConditions.visibilityOf(element);

            @Override
            public WebElement apply(WebDriver driver) {
                WebElement element = visibilityOfElement.apply(driver);
                try {
                    if (element != null && element.getAttribute("checked").equals("true")) {
                        return element;
                    } else {
                        return null;
                    }
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return "element to be checked : " + element;
            }
        };
    }

    public boolean allowPermissionPopup() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        try {
            By allowXpath = By.xpath("//*[@text='Allow' or @name = 'Allow']");
            WebElement acceptElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(allowXpath));
            acceptElement.click();
            acceptElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(allowXpath));
            acceptElement.click();
            return true;
        } catch (TimeoutException e) {
        }
        return false;
    }

    public void waitForElementToBeVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementToBeVisible(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {

        }
    }

    public void click_last(List<WebElement> element) {
        waitForElementToBeClickable(getLast(element));
        getLast(element).click();
    }

    public WebElement getLast(List<WebElement> element) {
        return element.get(element.size() - 1);
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForTextToBePresentInElement(WebElement element, String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void waitForElementToBeSelected(WebElement element) {
        wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
    }

    public void waitForElementToBeRefreshed(WebElement element) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }

    public void waitForElementToBeRefreshed(By by) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
    }

    public void waitForElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitForPresenceOfElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForPresenceOfAllElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public boolean waitForTextToBePresentInElement(By by, String text) {
        try {
            if (wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text)))
                return true;
        } catch (TimeoutException e) {
            return false;
        }
        return false;
    }

    public boolean waitForTextToBeNonEmpty(final By by) {
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(by).getText().length() != 0;
            }
        });
        return false;
    }

    public void waitForInvisibilityOfElementByText(By by, String text) {
        wait.until(ExpectedConditions.invisibilityOfElementWithText(by, text));
    }

    public void waitForElementToBeInVisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementToBeInVisible(WebElement element, int timeout) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        webDriverWait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementToBeInvisible(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForElementToBeChecked(WebElement element) {
        wait.until(elementToBeChecked(element));
    }

    public void sendKeys(WebElement elem, String text) {
        waitForElementToBeClickable(elem);
        elem.click();
        if (text != null) {
            if (!elem.getText().isEmpty()) {
                elem.clear();
            }
            elem.sendKeys(text);
        } else {
            Assert.assertNotNull(elem.getText());
        }
        driver.getKeyboard();
        hideKeyboard();
    }

    public void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (WebDriverException e) {
        }
    }

//    public void scrollTo(String text) {
//        try {
//            riderDriver.scrollTo(text);
//        } catch (WebDriverException e) {
//
//        }
//    }

    public void scrollTo(String text) {
        scrollDownTo(text);
    }

    public void scrollDownTo(String text) {
        scrollDownTo(By.xpath("//*[@text=\'" + text + "\' or @name=\'" + text + "\']"));
    }

    public void tapOn(String text) {
        driver.findElement(By.xpath("//*[@text=\'" + text + "\']")).click();
    }

    public void scrollDownToContainsText(String text) {
        scrollDownTo(By.xpath("//*[contains(@text,\'" + text + "\') or contains(@name,\'" + text + "\')]"));
    }

    public void scrollDownTo(String attribute, String text) {

        switch(attribute) {
            case "content-desc":
                scrollDownWithoutFailTo(By.xpath("//*[@content-desc=\'" + text + "\']"));
                break;
        }
    }

    public void checkIsDisplayed(String text) throws Exception{
        driver.findElement(By.xpath("//*[@text=\'" + text + "\']")).isDisplayed();
    }

    public void scrollDownTo(By byOfElementToBeFound) {
        hideKeyboard();
        int i = 0;
        while (i < 12) {
            if (driver.findElements(byOfElementToBeFound).size() > 0)
                return;

            scrollDown();

            i++;
        }
        Assert.fail("Did not find : " + byOfElementToBeFound.toString());
    }

    public void scrollDownWithoutFailTo(By byOfElementToBeFound) {
        hideKeyboard();
        int i = 0;
        while (i < 4) {
            if (driver.findElements(byOfElementToBeFound).size() > 0)
                return;

            scrollDown();

            i++;
        }
    }

    public void scrollDownTo(WebElement element) {
        hideKeyboard();
        int i = 0;
        while (i < 12) {
            try {
                if (element.isDisplayed())
                    return;
            } catch (Exception e) {

            }

            scrollDown();

            i++;
        }
        Assert.fail("Did not find : " + element.toString());
    }

    // when locating the `element` is optional
    public void scrollDownWithoutFailTo(WebElement element) {
        hideKeyboard();
        int i = 0;
        while (i < 12) {
            try {
                if (element.isDisplayed())
                    return;
            } catch (Exception e) {

            }

            scrollDown();

            i++;
        }
    }

    // As Handling the `Start Investing` Button is a special case
    public void scrollDownWithoutFailStartInvesting(WebElement element) {
        hideKeyboard();
        int i = 0;
        while (i < 2) {
            try {
                if (element.isDisplayed())
                    return;
            } catch (Exception e) {

            }

            scrollDown();

            i++;
        }
    }

    public void scrollDownTo(List<WebElement> initSize) {
        hideKeyboard();
        int i = 0;
        int size = initSize.size();
        while (i < 12) {
            if (size < initSize.size()) {
                break;
            }
            scrollDown();
            i++;
        }
    }

    public void scrollDown() {
        int height = driver.manage().window().getSize().getHeight();

        PointOption pointOption = new PointOption();
        pointOption.withCoordinates(5, height * 2 / 3);

        PointOption moveToPointOption = new PointOption();
        moveToPointOption.withCoordinates(5, height / 3);
        WaitOptions waitOptions = new WaitOptions();
        waitOptions.withDuration(Duration.ofMillis(1000));
        new TouchAction(driver).press(pointOption)
                .waitAction(waitOptions)
                .moveTo(moveToPointOption)
                .release().perform();

    }

    public void scrollUp() {

        int height = driver.manage().window().getSize().getHeight();

//        new TouchAction(driver).press(5, height / 3)
//                .waitAction(Duration.ofMillis(1000))
//                .moveTo(5, height * 2 / 3)
//                .release().perform();
    }

    public void swipeLeftToRight() {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
//        new TouchAction(driver).press(width / 3, height / 2)
//                .waitAction(Duration.ofMillis(1000))
//                .moveTo(width * 2 / 3, height / 2)
//                .release().perform();
    }

    public void swipeRightToLeft() {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
//        new TouchAction(driver).press(width * 9 / 10, height / 2)
//                .waitAction(Duration.ofMillis(1000))
//                .moveTo(width / 10, height / 2)
//                .release().perform();
    }

    public void scrollUpTo(String text) {
        scrollUpTo(By.xpath("//*[@text=\"" + text + "\"]"));
    }

    public void scrollUpTo(By by) {
        hideKeyboard();
        int i = 0;
        while (i < 5) {
            if (driver.findElements(by).size() > 0)
                return;

            scrollUp();

            i++;
        }
        Assert.fail("Did not find : " + by.toString());
    }

    public void clickOnListUsingIndex(By by, int index) {
        waitForPresenceOfAllElements(by);
        List<WebElement> locationNames = driver.findElements(by);
        locationNames.get(index).click();
    }

    public void scrollDownToByAndTap(By by) {
        scrollDownTo(by);
        driver.findElement(by).click();
    }


    public void swipeRightToLeftToFindElementAndClick(By byOfElementToSwipeOn, By byOfElementToBeFound) {

        int height = driver.findElement(byOfElementToSwipeOn).getLocation().getY() + 50;
        int width = driver.manage().window().getSize().getWidth();

        System.out.println("Screen width ::" + width);


        int count = 0;
        while (count < 20) {
            if (driver.findElements(byOfElementToBeFound).size() > 0) {
                driver.findElement(byOfElementToBeFound).click();
                return;
            }
//            new TouchAction(driver).press(width * 6 / 7, height)
//                    .waitAction(Duration.ofMillis(1000))
//                    .moveTo(width / 7, height)
//                    .release().perform();
            count++;
        }
        Assert.fail("Could not find element with by - " + byOfElementToBeFound.toString());
    }

    public void swipeRtoLOnElementUsingCount(By by, int count) {

        Point p = driver.findElement(by).getLocation();
        System.out.println(by);
        int x_int = ((Integer) p.getX());
        int y_int = ((Integer) p.getY());


        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        System.out.println("x_int :: " + x_int);
        System.out.println("Screen width ::" + width);


        boolean flag = true;
        int _count = 0;
        while (flag) {
            try {
                if (_count == count) {
                    flag = false;
                } else {
//                    new TouchAction(driver).press(width - x_int, y_int)
//                            .waitAction(Duration.ofMillis(1000))
//                            .moveTo(x_int, y_int)
//                            .release().perform();

                    _count++;
                    System.out.println("Swipe Count :: " + _count);
                }
            } catch (Exception e) {
//                new TouchAction(driver).press(width - 100, y_int + 100)
//                        .waitAction(Duration.ofMillis(1000))
//                        .moveTo(x_int + 100, y_int + 100)
//                        .release().perform();

                _count++;
                System.out.println("Inside catch block");

            }
        }
    }


    public void clickBy(By by) {
        waitForElementToBeClickable(by);
        driver.findElement(by).click();
    }

    protected void swipeFromTo(WebElement startElement, WebElement stopElement) {
//        new TouchAction(driver).press(startElement.getLocation().getX(), startElement.getLocation().getY())
//                .waitAction(Duration.ofMillis(1000))
//                .moveTo(stopElement.getLocation().getX(), stopElement.getLocation().getY())
//                .release().perform();

    }

    public void swipeFromLeftToRight(WebElement webElement) {
        waitForElementToBeClickable(webElement);
        int xAxisStartPoint = webElement.getLocation().getX();
        int xAxisEndPoint = xAxisStartPoint + webElement.getSize().getWidth();
        int yAxis = webElement.getLocation().getY();
        TouchAction act = new TouchAction(driver);
        System.out.print(xAxisStartPoint + " " + yAxis);
//        act.longPress(xAxisStartPoint, yAxis).moveTo(xAxisEndPoint - 1, yAxis).release().perform();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean clickAny(By... bys) {
        for (By by : bys)
            if (!driver.findElements(by).isEmpty()) {
                driver.findElement(by).click();
                waitForElementToBeInvisible(by);
                return true;
            }
        return false;
    }

    protected void clickTwice(WebElement element) {
        element.click();
        element.click();
    }

    protected void clickLastElementFromList(List<WebElement> list) {
        list.get(0).click();
        AtomicBoolean isNotClicked = new AtomicBoolean(true);
        while (isNotClicked.get()) {
            AtomicInteger initSize = new AtomicInteger(list.size());
            initSize.set(list.size());
            list.forEach(element -> {
                try {
                    waitForElementToBeVisible(element);
                    element.click();
                    waitForElementToBeVisible(element);
                    if (initSize.get() < list.size() || list.size() == 0)
                        isNotClicked.set(false);
                } catch (Exception e) {
                    e.printStackTrace();
                    isNotClicked.set(false);
                }

            });
        }
    }

    public void executeCommand(String command) throws IOException, InterruptedException {
        Process process = getRuntime().exec(command);
        process.waitFor();
        System.out.println(process.exitValue());
    }

    protected <T> T getElementFile(Class<T> reference) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String name  = reference.getName();
        System.out.println(name);
        T obj = (T) Class.forName(name).newInstance();
        return obj;
    }
}
