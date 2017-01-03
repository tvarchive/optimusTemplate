#Optimus Template
Optimus Template is the native framework for Optimus, designed to help you
to get started with your tests in the swiftest time possible. 

####First things first
Before you get your hands on Optimus Template, please make sure your system meets the desired
[prerequisites](Prerequisites.md)

##Features:
Now that you have reached till here, we assume that your system is ready to host Optimus successfully. Before we jump straight into writing your first test with Optimus, let us understand the prowess of it.
With Optimus, you will be able to write tests capable of running in below modes without ever having to worry about managing servers or device setup.
    
    * Distributed Mode
    * Parallel Mode
    
If this might sound obvious like any other framework, with Optimus you will be able to test

    * Single App
    * Inter App
    * Mobile Web

## Test Feed
Optimus is extremely powerful yet fun to work with
once you understand what to feed your tests, for a seamless automation experience.
Test Feed, typically a JSON format, will let you control all your tests from a single source of truth, 
giving you complete control of your tests execution. Any Test Feed will contain following sections

    * Common Attributes
    * Appium Server Capabilities
    * Android Only Capabilities
    * Device State

#### Common Attributes:
These attributes are set across all tests running on a common test feed.
   
    * Belongs To
    * Runs On
    * Application Directory
    
#####Example

![](/docs/CommonAttributes.png)



##Getting started with Optimus Template
Let us start by cloning Optimus Template repository into your workspace

```bash
git clone <Enter git clone link here>
```

Use your favourite IDE for building the project, however we love
IntelliJ though. 

![](ImportProject.gif)

###Your First Test
Writing tests in Optimus is no different than the tests you write everyday,
except that it does most of the heavy lifting for you, helping you to focus entirely on the test.

