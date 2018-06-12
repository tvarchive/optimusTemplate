---
title: Testfeed
keywords: android, ios,testfeed
last_updated: May 22, 2017
tags: [testfeed,android]
summary: "Testfeed is the brain of optimus, it helps you in controlling your test runs"
sidebar: optimus_sidebar
permalink: testfeed
folder: testfeed
---

Optimus is extremely powerful yet fun to work with once you understand what to feed your tests, for a seamless automation experience.
Test Feed, typically a JSON format, will let you control all your tests from a single source of truth, giving you complete control of your tests execution. Any Test Feed will contain following sections

* Common Attributes
* Appium Server Capabilities
* Android or iOS Only Capabilities


#### Common Attributes
These attributes are set across all tests running on a common test feed.

<pre>
<b>Native App</b>: Sets the context for your test to run on a native app or mobile web
<b>Belongs To</b>: Assigns the test to a particular application.
<b>Runs On</b>: Assigns the test to user specific device. You can choose to run your tests either on device or emulator.
<b>Application Directory</b>: Specifies the folder name where the application under test is placed.
</pre>


#### Appium Server Capabilities 
Optimus by default supports all the capabilities that Appium provides, which you can refer from [here](https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/caps.md).
Since Optimus inherently possesses immense intelligence to handle all capabilities by default without troubling you much,
all it needs are a couple of capabilities.


<pre>
<b>App</b>: Name of application to test. Optimus will look for this app under the “appDir” folder specified as part of common attributes.
<b>Platform Name</b>: Specifies the platform to run the application on.
</pre>


##### Example 
```
"testFeed":[
    {
      "belongsTo":"optimus",
      "runsOn": "any",
      "appDir": "app",
      "nativeApp":true,
      "optimusDesiredCapabilities": {
        "appiumServerCapabilities": {
          "app": "HelloOptimus.apk",
          "platformName": "Android"
        },
        "androidOnlyCapabilities": {
          "appActivity": "com.testvagrant.hellooptimus.MainActivity",
          "appPackage": "com.testvagrant.hellooptimus",
          "avdLaunchTimeout": 300000,
          "useKeystore": false
        }
      }
    }
  ]
```

These capabilities will be sufficient enough to run most of the tests if not all.
Under which circumstances you may choose to provide additional
[Appium Server Capabilities](https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/caps.md).

#### Android only Capabilities 
Optimus supports all android related capabilities as specified [here](https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/caps.md).
Optimus does not enforce any of these capabilities to be set for running your tests.
However you are free to provide as many capabilities as you may need.

#### iOS only Capabilities 
Optimus supports all ios related capabilities as specified [here](https://github.com/appium/appium-xcuitest-driver#desired-capabilities).
Optimus does not enforce any of these capabilities to be set for running your tests.
However you are free to provide as many capabilities as you may need.

#### Supported Platforms
    
* Android - SDK Emulators, Genymotion Emulators and all devices
* IOS - Simulators and Devices