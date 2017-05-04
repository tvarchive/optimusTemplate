# Optimus Template  [![npm version](https://badge.fury.io/js/optimus-cli.svg)](https://badge.fury.io/js/optimus-cli) [![Gitter chat](https://badges.gitter.im/optimus_support/optimus.png)](https://gitter.im/optimus_support/optimus)

Optimus Template is the native framework for Optimus, designed to help you
to get started with your tests in the swiftest time possible.

## Pre-requisites
* [HomeBrew](https://brew.sh/) - Mac
* [LinuxBrew](http://linuxbrew.sh/) - Linux
* [Chocolatey](https://chocolatey.org/) - Windows



## Getting started with Optimus
Install the <b>optimus-cli</b> utilty

```
npm install -g optimus-cli
```

Verify if your system is ready for using Optimus

```
$ optimus ⏎
optimus$ doctor
```
To create a new Optimus project.

```
$ optimus ⏎
optimus$ create project <project_name>
```
Note: Project name is mandatory.

Once the project is created you can import it to your favourite IDE.

#### Template Structure
Optimus Template is structured in the lines of Cucumber as below

``` java
optimustemplate/
+-- build.gradle
+-- app //Store Application Under Test for Android or Ios platforms.
    +-- Example.apk
+-- src/test
    +-- java
    ¦   +-- pages 
    ¦        +-- BasePage.java 
    ¦   +-- steps 
    ¦       +-- BaseSteps.java
    ¦       +-- ExampleSteps.java
    ¦       +-- StartingSteps.java
    ¦   +-- utils 
            +-- OptimusImpl.java
    +-- resources
    ¦   +-- features
    ¦   ¦  +-- Example.feature
    +-- ExampleTestFeed.json
```

The template comes with few pre-defined classes. You can harness the power of Optimus through them.

   <pre>
    <b>BasePage.java</b>: Any page you create can extend BasePage to perform most of the
    actions required to test your functionality, without having to reinvent the wheel.
    <b>BaseSteps.java</b>: Any Step definition can extend BaseSteps.
    <b>StartingSteps.java</b>: For Optimus Template use only.
   </pre>

## Writing your first test
Write your first test by following our [tutorial](https://github.com/testvagrant/optimusTemplate/wiki/My-First-Test)

## Contact
Our [FAQ](https://github.com/testvagrant/optimusTemplate/wiki/FAQ) covers most of the common issues. In case the issue you are facing is not available, you can reach out to us at optimus@testvagrant.com




