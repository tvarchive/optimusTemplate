---
title: My First Android Test
keywords: android, tutorial
last_updated: May 22, 2017
tags: [android,tutorials]
summary: "Get started with your first android test"
sidebar: optimus_sidebar
permalink: android_tutorial
folder: mydoc
---

Writing tests in Optimus is no different than the tests you write everyday,
except that it does most of the heavy lifting, helping you to focus entirely on the test, 
thus the philosophy of Optimus

> Focus On Functionality

### Building Test Feed
If there is anything at your disposal to tame the mighty Optimus,
then it's your [TestFeed](https://github.com/testvagrant/optimusTemplate/wiki/Test-Feed). Let us build a simple test feed now.

Under `resources` folder create a new json file called `OptimusAndroid.json`. You can copy below content in your newly created test feed.

```json
{
  "executionDetails": {
    "appium_js_path": "/usr/local/bin/appium",
    "appium_node_path": "/usr/local/bin/node"
  },
  "testFeed":[
    {
      "belongsTo":"optimus",
      "runsOn": "any",
      "appDir": "app",
      "nativeApp":true,
      "optimusDesiredCapabilities": {
        "appiumServerCapabilities": {
          "app": "hellooptimus.apk",
          "platformName": "Android"
        },
        "androidOnlyCapabilities": {
          "appActivity": "com.testvagrant.hellooptimus.MainActivity",
          "appPackage": "com.testvagrant.hellooptimus",
          "avdLaunchTimeout": 300000,
          "useKeystore": false
        }
      }, 
      "deviceState": {
        "captureVideo": true
      }
    }
  ]
}
```

Optimus would generally read this test feed as 
<pre>
Create a driver which <b>belongsTo</b> <b>optimus</b> for an app <b>hellooptimus</b> running on
<b>emulator</b> on <b>Android</b> platform.
</pre>

You can create number of variations to this test feed matching your functionality.

### Feature file
Under package `features` create a new feature `HelloOptimus.feature`.

``` gherkin
Feature: Say Hello to Optimus

  @helloOptimus
  Scenario: Hello Optimus
    Given I have optimus hello application
    When I open it on either emulator, simulator or device on any platform
    Then I should be able to say a hello to optimus
```

Go ahead and create a step definition file for above feature under `steps` package.

``` java 
public class HelloOptimusSteps extends BaseSteps{
    @Given("^I have optimus hello application$")
    public void iHaveOptimusHelloApplication() throws Throwable {
        getDriverInstanceFor("optimus");
    }

    @When("^I open it on either emulator, simulator or device on any platform$")
    public void iOpenItOnEitherEmulatorSimulatorOrDeviceOnAnyPlatform() throws Throwable {

    }

    @Then("^I should be able to say a hello to optimus$")
    public void iShouldBeAbleToSayAHelloToOptimus() throws Throwable {

    }
}
```
To access the webDriver for your application, all you would need is `getDriverInstanceFor(<belongsTo>)`. This is a powerful approach when you do interApp testing.

Now you are all set to run your first test. Lets get a bit geeky here.
Bootup your favourite emulator.
Open your terminal and navigate to your project folder
and try below command.

```bash
./gradlew runFragmentation -DtestFeed="helloOptimus" -Dtags=@helloOptimus
```

or

```bash
./gradlew runDistribution -DtestFeed="helloOptimus" -Dtags=@helloOptimus

```

In case you have a gradle distribution on local you can run below commands

```bash
gradle runFragmentation -DtestFeed="helloOptimus" -Dtags=@helloOptimus
```
 or
 
```bash
gradle runDistribution -DtestFeed="helloOptimus" -Dtags=@helloOptimus
```
 
After all the initial setup process you will be able to see `optimushello` app appear on your emulator screen

![](https://github.com/testvagrant/optimusTemplate/blob/master/docs/HelloOptimus1.png)

Kudos for your first successful android test with Optimus. Now that you have reached here, let us understand the basic features and building blocks of Optimus, the [TestFeed](https://github.com/testvagrant/optimusTemplate/wiki/Test-Feed)