---
title: Create Object Repository
keywords: android, ios, objectrepository, tutorial
last_updated: May 22, 2017
tags: [android,ios,objectrepository,tutorial]
summary: "Object repository is the place from where Optimus finds the elements and performs the action on these elements according to the test."
sidebar: optimus_sidebar
permalink: object_repository
folder: tutorial
---

### What is an object repository?  
Object repository is the place from where Optimus finds the elements and performs the action on these elements according to the test.

![](http://i.imgur.com/fEir7jd.png)

### Steps to create an object repository  
1. Under the resources folder of your project, create a new folder and name it __elements__.
2. You can either choose to group your _object repositories_ according to the screen or you could directly store     
them with the file name same as the _activity name_ in the case of Android.
3. For locating the elements via Appium Inspector, please follow these [steps](/).
4. After successfully locating the elements, store them in the _object repository_ as shown above.

### How to store elements inside the object repository?   
As you can see in the above image, the elements are stored in an object, to be specific, a JSON object.You have to specify the app name that is under test.Inside _elements_ array, you need to store the _name_ of the element, the _identifier_(xpath,id or class), the _value_ of locator and/or waitFor.

>Note : _waitFor_ is optional.You may or may not use it.

