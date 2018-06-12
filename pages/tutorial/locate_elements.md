---
title: Locate Elements using Appium Inspector
keywords: android, ios, objectrepository, elementlocator, tutorial
last_updated: May 22, 2017
tags: [android,ios,objectrepository,tutorial]
summary: "Learn how you can locate elements using appium inspector."
sidebar: optimus_sidebar
permalink: locate_elements
folder: tutorial
---

![](http://i.imgur.com/vXolszV.jpg)

## Steps to start Appium Inspector and inspect elements - 

1. First of all, you need to start Appium GUI and then start a new session with appropriate desired capabilities 
   for the AUT.
2. A new window will open up, as shown in the above image.
3. Now to locate the elements, do the following -    
    1. Click on any element on the image on the left-hand side of the screen.
    2. After clicking, you will find the XML hierarchy of the app source displayed on the screen.
    3. On the right-hand side of the screen, you will find the attributes of the selected element like id or 
       XPath of the element.
4. You can now use your preferable method of finding the element, either by XPath or by id or by class.

**For more ideas on how to locate elements using xpath, check out the following sites:**
* [Xpath locator examples](https://www.webperformance.com/load-testing-tools/blog/real-browser-manual/building-a-testcase/how-locate-element-the-page/xpath-locator-examples/)
* [How to locate XPath locators efficiently](https://bitbar.com/appium-tip-18-how-to-use-xpath-locators-efficiently/)