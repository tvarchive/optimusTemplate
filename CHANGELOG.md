Optimus 3.0 (from 2.3.7-beta)
===================================

Optimus 3.0 has one big feature release


#### New features
* Supports iOS parallelisation


#### Fixes
* Resolved appium log path issue on windows
* Resolved issue when capabilities are passed as an array.

CHANGES IN VERSION 2.3.3-Beta (from 2.2.1)
===================================

Optimus 2.3.3-beta upgrades to latest version of underlying new features


#### New features
* Optimus-Services will handle all CRUD operations. This will help in writing to cloud
* User can define their own db name or start services on multiple ports for handle multi app products.


#### Fixes
* Intents will cascade exception to steps revealing cause of failure in reports.
* Fixed swipe and scroll to latest changes from cucumber.

CHANGES IN VERSION 2.2.1 (from 2.2.0)
===================================

Optimus 2.2.1 upgrades to latest version of underlying softwared plus a few bug fixes

#### Appium JAVA client
* udpated to version 5.0.4
* implentation of swipe updated based on the latest java client

#### Cucumber-jvm
* updated to version 2.1.0
* reporting updated wrt new cucumber implementation

#### cucmber report plugin
* update net.masterthought plugin version 3.11.0

#### New features
* No More mdb logs filling up your console
* Introducing DevMode that would allow users to not reset the app everytime while developing test script
* Can run any OS version, there is no constraint over it as long as it is supported by Appium
* Intents - Can pass specific params to DataIntent
* Stepdefs - Can override default explicit wait time


#### Fixes
* 17 - Cucumber reporter failed to embed screen capture to the final report
* 14 - Android 8.0 SDK API 26 Failed to Execute
