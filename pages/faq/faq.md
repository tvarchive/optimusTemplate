---
title: Frequently Asked Questions
sidebar: faq_sidebar
keywords: faq
permalink: faq
toc: false
folder: faq
---

#### <a name="faq1"></a>Optimus doctor command fails throwing "Cannot find linux brew, install it manally from 'http://linuxbrew.sh/' update and try again"?
Please check if your machine is installed with [linuxbrew](http://linuxbrew.sh/) as below
Install brew by using
``` 
ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Linuxbrew/install/master/install)"
PATH="$HOME/.linuxbrew/bin:$PATH"
```
Edit your ~/.bash_profile to add ~/.linuxbrew/bin to your PATH:
```
echo 'export PATH="$HOME/.linuxbrew/bin:$PATH"' >>~/.bash_profile
```
Use doctor to Verify if you system is ready for using Optimus
```
optimus doctor 
```
***

#### <a name="faq2"></a>How to get app package and launch activity?

Use below commands to get

* Package name
```shell
aapt dump badging /path/to/apk | grep package:\ name
```
* Launchable Activity
```shell
aapt dump badging /path/to/apk  | grep launchable-activity:\ name
```

***
#### <a name="faq3"></a> How to install NPM on Linux platform?
Do not install nodejs through apt-get, which will need sudo rights and appium will not work if node is installed as sudo user. If you have already installed remove it using

```
sudo apt-get remove nodejs

sudo apt-get remove npm
```
Download latest nodejs linux binaries form [nodeJS](http://nodejs.org/download/)

Extract into a folder that doesn't need sudo rights to access, for example your home folder.

```
tar -xvf <downloaded_binary_tar.gz>
```
Add the following line to your `~/.bashrc` file.

```
export PATH=$PATH:<full_path_of_the_extracted_node_folder>/bin
```
Open a now terminal and do
```
npm install -g optimus-cli
```
Once Optimus-Cli gets downloaded, verify using 
```
optimus version
$ 1.5.2
```
***

#### <a name="faq4"></a>aapt is not found, when trying to get app package name and launchable activity
Check whether the following paths are added to your .bash_profile
```
  export ANDROID_HOME=/path/to/android-sdk
  export PATH=$ANDROID_HOME/platform-tools:$PATH
  export PATH=$ANDROID_HOME/tools:$PATH
  export PATH=$ANDROID_HOME/build-tools/25.0.2:$PATH
```

***

#### <a name="faq5"></a>My Scenario runs fine using gradle command but fails when running it from IntelliJ runner.
When running a scenario using IntelliJ runner you have to pass below parameters as part of VM Options and run the gradle task `optimusSetup` before running the scenario.
```
-DtestFeed = <your-testfeed-name>
-DrunMode = <Fragmentation/Distribution>
```

***

#### <a name="faq6"></a>Cannot run mongod as it cannot find /Data/db folder.
If you have installed mongodb using `optimus doctor` command. You will have to manually create `/Data/db` folder.

Here is how you do it in terminal

```
sudo mkdir -p /Data/db
sudo chmod 777 /Data/db
```
try running `mongod` command in your terminal now, mongo instance should be up and running on port 27017

***

#### <a name="faq7"></a>Unable to use xcodebuild or xcode is not detecting.
1. (Re) Install Xcode.      
2. Point xcode-select to the Xcode Developer Directory(by default `Applications` folder) using the following command:       
```
sudo xcode-select -switch /Applications/Xcode.app/Contents/Developer
```       

***