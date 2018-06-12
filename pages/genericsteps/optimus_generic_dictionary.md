---
title: Generic Dictionary
keywords: genericdictionary
last_updated: May 22, 2017
tags: [genricdictionary]
summary: "Dictionary for commonly used step definitions"
sidebar: optimus_sidebar
permalink: genericdictionary
folder: genericsteps
---
Dictionary will consist of all the actions that can be performed on an element or on a set of elements.   


<a name="Tap"></a>**1. Tap**


Tap is used to tap an element only once/single tap.

to use this particular action you have to create a `feature` file and a `json` file.

* **example.feature** 
   
  ![](http://i.imgur.com/4nvD1u8.png)    
  where    
  `user` : the user who is using the app,   
  `home` : the current screen on which the user wants to work/where the elements are located,   
  `taps` : an event which can be performed on an element,   
  `plan` : the element on which an action will be performed. 
    

  ![](https://media.giphy.com/media/3ohzdMdWpnyZK6FzbO/giphy.gif)  
         

* [ScreenName].json(in this case `Planning.json`)
    
  ![](http://i.imgur.com/nc3wMIf.png)   
  where    
  `elements` : an array of all the different elements exists on a particular screen,    
  `elementsName` : user-defined name of an element,    
  `identifier` : the mean by which an element can be identified(i.e. id, xpath, classname),    
  `value`: value of element,      
  `waitFor` : defines on how to wait for the element.   
   
Here the user can perform all the tap actions by using the keywords 
  `tap`,
  `taps`,
  `double tap`,
  `double taps`,
  `doubletap`,
  `doubletaps`,
 
***

<a name="Slide"></a>**2. Slide**

This transition tracks changes to the visibility of target views in the start and end scenes and moves views in or out from one of the edges of the scene.  
  
* **example.feature**

  ![](http://i.imgur.com/RlvRKbz.png)

  where   
  `saveTax` : the current screen on which the user wants to work/where the elements are located,   
  `slides` : an event which can be performed on an element,   
  `annualCTC` : the element on which an action will be performed,   
  `60%` : the value upto which the slider will slide.          

  ![](https://media.giphy.com/media/xUA7b6Db2aH8wUMtNK/giphy.gif)

* **saveTax.json**    

  ![](http://i.imgur.com/PodW72r.png) .  

  here `referTo` will define this particular item is common in many places and we don't want to create a new 
  entry to use it every time, so in order, to that, we will use `referTo` which will refer this element to 
  `CommonElements.json` which will consist all the repeating elements having a same value and locator at more than one place.    
  `CommonElements.json`    
  ![](http://i.imgur.com/lZ1XnGp.png)    

The user can perform the slide actions by using these keywords `slide`, `slides`    


***

<a name="Scroll"></a>**3. Scroll Up/ Scroll Down**
  
Scrolling allows the user to scroll up or down until the targeted element is found on the page or else will throw an exception if the element is not found.     
          

![](https://media.giphy.com/media/xUOrwjZ6N5BZQetkLm/giphy.gif)                ![](https://media.giphy.com/media/xUOrwnpUgcwSYtParm/giphy.gif)
      
* **example.feature**  
![](http://i.imgur.com/R5Kwh2v.png)     

* **Home.json**     
![](http://i.imgur.com/Zk7KHM4.png)   

The user can perform all the swiping actions by using these keywords 
`scrollrightinelement`,
`scrollleftinelement`,
`scrolldowninelement`,
`scrollupinelement`,
`scrolls up`,
`scroll up`,
`scrollup`,
`scrolls-up`,
`scroll-up`,
`scrolls down`,
`scroll down`,
`scrolldown`,
`scrollsdown`,
`scrolls-down`,
`scroll-down `,   

***  

<a name="Assert"></a>**4. Assert**


Assert allows user to perform assert actions on a element, i.e element is visible, element is enabled, etc.
    
![](https://media.giphy.com/media/xUOrwfOaRHUwdvh0Os/giphy.gif)   

* **Example.feature**   

![](http://i.imgur.com/dYToXeY.png)
![](https://i.imgur.com/gMa2x3D.png)

* **Planning.json**   

![](http://i.imgur.com/3HiWLMa.png)

The user can perform all the assert actions by using these keywords 
`notvisible`,
`not-visible`,
`not visible`,
`not displayed`,
`visible`,
`displayed`,
`disabled`,
`not enabled`,
`textnotpresent`,
`text not present`,
`text-not-present`,
`textnotdisplayed`,
`textpresent`,
`text present`,
`text-present`,
`text displayed`

***

<a name="Swipe"></a>**5. Swipe**    
   

Swipe lets you to move the screen in a particular direction either in right direction or in left.    

![](https://media.giphy.com/media/l4FGE1RSp8mmNSXJe/giphy.gif)

* **Example.feature**  
![](http://i.imgur.com/BWr8Kmp.png)

* **Home.json**     

![](http://i.imgur.com/evcqGKv.png)    

The user can perform swiping by using these keywords
`swipe left`,
`swipeleft`,
`swipe-left`,
`swipes left`,
`swipesleft`,
`swipes-left`,
`swipe right`,
`swipe-right`,
`swiperight`,
`swipes right`,
`swipes-right`,
`swipesright`    

*** 

<a name="Type"></a>**6. Type**
 

Types let the user type anything in a `textbox`, and behind the scene, it is performing a `sendkeys()` operation.     


![](https://media.giphy.com/media/xUOrvY2xr31DURr6Kc/giphy.gif)    

* **Example.feature**   
![](http://i.imgur.com/JlEXzpe.png)    

* **Login.json**   
![](http://i.imgur.com/po6qAAI.png)   

The user can perform all the typing related actions by using the keywords:
`types`,
`type` 


***

<a name="Navigate"></a>**7. Navigate**


This lets the user to performs some navigation actions on the screen. Like `refresh`,`hideKeyboard` and `navigate back`. For navigation actions no need to pass the element. The following is the example of screen refresh.


![](https://media.giphy.com/media/8FPcrgSTHmPa730lBd/giphy.gif)    

* **Example.feature**   

![](https://i.imgur.com/1tOHZS1.png)    

The user can perform all the navigation-related actions by using the keywords:
`refresh`,
`refresh's`,
`hides keyboard`,
`hide-keyboard`,
`navigates back`,
`goes to back` 

*** 