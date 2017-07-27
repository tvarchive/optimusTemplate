# Optimus Template  [![npm version](https://badge.fury.io/js/optimus-cli.svg)](https://badge.fury.io/js/optimus-cli) [![Gitter chat](https://badges.gitter.im/optimus_support/optimus.png)](https://gitter.im/optimus_support/optimus)

Optimus Template is the native framework for Optimus, designed to help you
to get started with your tests in the swiftest time possible. Read more about Optimus on our [wiki](https://github.com/testvagrant/optimusTemplate/wiki).

### Pre-requisites
* [HomeBrew](https://brew.sh/), [XCode 8.2 or above](https://developer.apple.com/xcode/) - Mac
* [LinuxBrew](http://linuxbrew.sh/) - Linux
* [Chocolatey](https://chocolatey.org/) - Windows



### Getting started with Optimus
Install the <b>optimus-cli</b> utilty

```
npm install -g optimus-cli
```

Verify if your system is ready for using Optimus

```
$ optimus doctor
```

Install if `optimus doctor` reported any missing dependencies.

```
$ optimus setup
```

To create a new Optimus project.

```
$ optimus new <project_name>
```
Once the project is created you can import the project into your favourite IDE. However we love [IntelliJ](https://github.com/testvagrant/optimusTemplate/wiki/Import-Optimus-Project---Intellij) though. 

### Import Project
* [IntelliJ](https://github.com/testvagrant/optimusTemplate/wiki/Import-Optimus-project-using-Intellij)
* [Eclipse](https://github.com/testvagrant/optimusTemplate/wiki/Import-Optimus-project-using-Eclipse)


### Run

In optimus you can run your code in any of the two modes, which are    
1. `Fragmentation`      
2. `Distribution`    

Suppose you have 5 feature files in your project and 5 devices connected, now in     
`Fragmentation`: All 5 features will run on all 5 devices.     
![](http://i.imgur.com/dGtTjEY.jpg)      
`Distributuion`: one feature will run on one device.        
![](http://i.imgur.com/7AhgPzi.jpg)     
 

Your new OptimusTemplate project gets created with a sample test for an example app `HelloOptimus` you can run your project as shown below.

#### Step 1: Connect devices(Android or IOs) or create an Android Emulator.
#### Step 2: Open your favourite terminal and navigate to the project folder.
#### Step 3: Check for Android Devices or Emulators by running
    gradle runFragmentation -DtestFeed=HelloOptimusAndroid -Dtags=@helloOptimus
Note: You will see that HelloOptimus app is launched on all the connected Android Devices and emulators.
#### Step 4: Check for IOS by running
    gradle runFragmentation -DtestFeed=HelloOptimusIOS -Dtags=@helloOptimus
Note: You will see that HelloOptimus app is launched on a IPhone6 Simulator. 

### First test
With optimus you can create tests either by creating custom steps or by using [Generic Steps](https://github.com/testvagrant/optimusTemplate/wiki/Generic-Steps) or a mix of both.
You can learn more about the test which ran on your devices by following our [Android Tutorial](https://github.com/testvagrant/optimusTemplate/wiki/My-First-Android-Test) or [IOS Tutorial](https://github.com/testvagrant/optimusTemplate/wiki/My-First-IOS-Test)

### Below are a few sample projects leveraging the power of Optimus framework
* [Swiggy](https://github.com/testvagrant/optimus_SwiggyTests)
* [Kik](https://github.com/testvagrant/optimus_KikTests)
* [Paytm](https://github.com/testvagrant/optimus_PaytmTests)
* [Scripbox](https://github.com/testvagrant/optimus_ScripboxTests)

### Contact
Our [FAQ](https://github.com/testvagrant/optimusTemplate/wiki/FAQ) covers most of the common issues. In case the issue you are facing is not available, you can reach out to us at optimus@testvagrant.com
