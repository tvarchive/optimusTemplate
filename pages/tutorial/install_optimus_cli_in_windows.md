---
title: Install optimus-cli in Windows
keywords: windows, tutorial
last_updated: July 13, 2018
summary: "Steps to install optimus-cli in windows"
sidebar: optimus_sidebar
permalink: optimus_cli_windows_tutorial
folder: tutorial
---

Optimus Template is the native framework for Optimus, designed to help you
to get started with your tests in the swiftest time possible. Read more about Optimus on our [wiki](https://github.com/testvagrant/optimusTemplate/wiki), for videos watch [here](https://www.youtube.com/channel/UCy1OVZVChPLmnPySRhuaSrw) 

### Pre-requisites
* [Chocolatey](https://chocolatey.org/) - Windows
* [NodeJS](https://chocolatey.org/packages/nodejs) - NodeJS ( Recommended Node Version is 9.0 )

### Getting started with Optimus

* **Step 1**: Install the <b>optimus-cli</b> utilty

```
npm install -g optimus-cli
```

* **Step 2**: Verify if your system is ready for using Optimus

```
$ optimus doctor
```

* **Step 3**: Install if `optimus doctor` reported any missing dependencies.

```
$ optimus setup
```

* **Step 4**: Again try to execute `optimus doctor`, if some applications are not getting detected try setting path 
for which ever it is not detecting ( Java|Gradle|MongoDB|AndroidPlatformTools ).


* **Step 5**: <b>Configure Mongodb</b>     
If you have installed mongodb using optimus doctor command. You will have to manually create /Data/db folder.

    Here is how you do it in terminal
```
mkdir -p \data\db
icacls "C:\data" /grant Users:F
```
    try running mongod command in your terminal now, mongo instance should be up and running on port 27017

* **Step 6**: To create a <b>new Optimus project</b>.

```
$ optimus new <project_name>
```
* **Step 7**: Once the project is created you can import the project into your favourite IDE. However we love [IntelliJ](https://github.com/testvagrant/optimusTemplate/wiki/Import-Optimus-Project---Intellij) though. 

### Import Project
* [IntelliJ](https://github.com/testvagrant/optimusTemplate/wiki/Import-Optimus-project-using-Intellij)
* [Eclipse](https://github.com/testvagrant/optimusTemplate/wiki/Import-Optimus-project-using-Eclipse)

* <b>Change Appium & Node Path in HelloOptimusAndroid.json|HelloOptimusIOS.json</b>
Check manually by going to below mentioned paths. If the files are present, then you can use below paths. Otherwise you need to set the actual path of Appium&Node.

```
AppiumPath in json - "C:\\Users\\<UserName>\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"
NodePath in json - "C:\\Program Files\\nodejs\\node.exe"
```