---
title: My First iOS Test
keywords: ios, tutorial
last_updated: May 22, 2017
tags: [ios,tutorials]
summary: "Get started with your first ios test"
sidebar: optimus_sidebar
permalink: ios_tutorial
folder: tutorial
---

Running tests on IOS platform is mostly similar to the tests running on Android Platform which you have learnt in [My First Android Test](/android_tutorial). 

# Build Test Feed 
Under resources folder create a new json file called `OptimusIOS.json`. You can copy below content in your newly created test feed.
```
{
  "executionDetails": {
    "appium_js_path": "/usr/local/bin/appium",
    "appium_node_path": "/usr/local/bin/node"
  },
  "testFeed": [
    {
      "belongsTo": "optimus",
      "runsOn": "simulator",
      "appDir": "app",
      "nativeApp":true,
      "optimusDesiredCapabilities": {
        "appiumServerCapabilities": {
          "app": "HelloOptimus.app",
          "platformName": "iOS",
          "deviceName":"iPhone 6",
          "platformVersion": "9.3",
          "automationName": "XCUITest"
        },
        "iOSOnlyCapabilities": {
          "launchTimeout": 300000
        }
      },
      "deviceState":{
        "captureVideo":true
      }
    }
  ]
}
```

Using this test feed you can run tests on IOS platform.

Run the below command

```
./gradlew runFragmentation -DtestFeed="helloOptimusIos" -Dtags=@helloOptimus
```

or

```
./gradlew runDistribution -DtestFeed="helloOptimusIos" -Dtags=@helloOptimus
```

In case you have a gradle distribution on local you can run below commands

```
gradle runFragmentation -DtestFeed="helloOptimusIos" -Dtags=@helloOptimus
```

or

```
gradle runDistribution -DtestFeed="helloOptimusIos" -Dtags=@helloOptimus
```

You will see that the `HelloOptimus` app is launched in IOS Simulator.

Kudos for your first successful iOS test with Optimus. Now that you have reached here, let us understand the basic features and building blocks of Optimus, the [TestFeed](/testfeed)