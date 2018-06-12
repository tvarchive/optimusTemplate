---
title: Generic Steps
keywords: genericsteps, tutorial
last_updated: May 22, 2017
tags: [genericsteps]
summary: "Automating scenarios without code"
sidebar: optimus_sidebar
permalink: genericsteps
folder: genericsteps
---

## What is a Generic Step
 Consider below simple example

***

## Login Scenario using custom steps
    Scenario: Login
    Given User is on Login screen
    When User enters email and password
    |ValidEmail|ValidPassword|
    Then User should be able to log in

Once a scenario is created, corresponding steps are defined and the respective implementation is created in pages. 

With Optimus, you can create a generic step using Optimus syntax without having to worry about creating step definitions and the implementations. 

## Login Scenario using generic steps
   Scenario: Valid Login
       
    Given user on Login screen types on email value validEmail
    And user on Login screen types on editTextList with index as 1 and value is validPassword
    And user on Login screen performs hides keyboard
    When user on Login screen taps on submit
    Then user on Home screen verifies welcomeMessage has textpresent value Welcome Message
    And user on Home screen taps on text value About Us
    And user on AboutUs screen taps on menuList with index as 1
    Then user on Home screen taps on logoutBtn
    
If you create this scenario in Optimus 2.0 project, you will find that cucumber doesn't throw the usual `Undefined Step Reference` and all steps have a step definition as below.

![Imgur](https://i.imgur.com/PNQwnSD.png)


***

## Generic step syntax 

If a step contains performing an action like tap, click etc.,

  _Syntax_

    Consumer on X screen (performs) action on (element) Y 
  
 _Example_

    User on Login screen taps on submit
    
If a step contains performing an action like tap, click on multiple list of elements etc.,

**Note:** Index value starts from 1.
  
  _Syntax_

    Consumer on X screen (performs) action on (elementList) Y with index as INDEX_VALUE
  
 _Example_

    User on Login screen taps on buttonList with index as 2
    
If a step contains performing an action like type, scroll with some value etc.,
    
 _Syntax_

    Consumer on X screen (performs) action on (element) Y (with) value Z
    
_Example_
    
    User on Login screen types on email value ValidEmail
    
If a step contains performing an action like type, scroll on multiple list of elements with some value etc.,
    
 _Syntax_

    Consumer on X screen (performs) action on (elementList) Y with index as (index) and value is Z
    
_Example_

    User on Login screen types on editTextList with index as 2 and value is secondText
    
If a step contains performing an action like tap on element using the text value
    
 _Syntax_

    Consumer on X screen (performs) action on (element) Y (with) value Z
    
_Example_

    User on Home screen taps on text value About Us
    
In the following `Example.feature` we are re-using the text element by changing the text value. 
    
**Example.feature**  

![](https://i.imgur.com/loxN2Uy.png)

We need to declare the `text` element in the following way. Here we can use the value as `//*[@text='%s']` or `//*[@text()='%s']` based on the `Html Attribute declaration`. Internally `%s` is replaced with the `value` and then it try to find the element in the screen.

**Home.json**

![](https://i.imgur.com/yBJSAMx.png)

***

From the outset Optimus Generic step syntax appears to be very verbose, however, this is very handy when you want to test the prototype of an application in the swiftest possible time. 

Optimus provides an option to reuse scenarios. You can read more about it from [Intents Page](/intents)

Read more about list of actions available and their usage from [Optimus Generic Dictionary](/genericdictionary)