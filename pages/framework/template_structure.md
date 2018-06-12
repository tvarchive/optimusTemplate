---
title: Template Structure
keywords: templatestructue
last_updated: May 22, 2017
tags: [template]
summary: "Optimus Template Structure"
sidebar: optimus_sidebar
permalink: template_structure
folder: framework
---

Optimus Template is structured in the lines of Cucumber as shown below

``` java
optimustemplate/
+-- build.gradle
+-- app //Store Application Under Test for Android or Ios platforms.
    +-- hellooptimus.apk
    +-- hellooptimus.app
+-- src/test
    +-- java
    ¦   +-- pages 
    ¦        +-- BasePage.java 
    ¦   +-- steps 
    ¦       +-- BaseSteps.java
    ¦       +-- StartingSteps.java
    ¦   +-- utils 
            +-- OptimusImpl.java
    +-- resources
    ¦   +-- elements
    ¦   ¦  +--HelloOptimus
    ¦   ¦  ¦  +-- Home.elements
    ¦   ¦  ¦  +-- Home.json
    ¦   ¦  +-- HelloOptimus.xlsx
    ¦   +-- features
    ¦   ¦  +-- HelloOptimusCustom.feature
    ¦   ¦  +-- HelloOptimusGeneric.feature
    ¦   +-- META-INF
    ¦   ¦  +-- Optimus.yaml
    +-- HelloOptimusAndroid.json
    +-- HelloOptimusIOS.json
```

The template comes with few pre-defined classes. You can harness
the power of Optimus through them.

<pre>
<b>BasePage.java</b>: Any page you create can extend BasePage to perform most of the
actions required to test your functionality, without having to reinvent the wheel.
<b>BaseSteps.java</b>: Any Step definition can extend BaseSteps.
<b>StartingSteps.java</b>: For Optimus Template use only.
</pre>