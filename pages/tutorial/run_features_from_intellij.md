---
title: Running Features from Intellij
keywords: android, ios, tutorial
last_updated: May 22, 2017
tags: [android,ios,tutorial]
summary: "Learn how you can run features from intellij."
sidebar: optimus_sidebar
permalink: run_features
folder: tutorial
---

In order to run a feature file or a particular scenario from IntelliJ, you need to perform some basic steps, which are as follows:

1. Open IntelliJ and select **`Run/Debug Configuration`** and select **`Edit Configurations...`**

![](http://i.imgur.com/9S1Fr6z.png)

2. Now Select **`Defaults`** from the **`Run/Debug Configuration`** window and choose **`Cucumber Java`**

![](http://i.imgur.com/1VkwSYu.png)

3. On right-hand side in **`Before Launch`** section add a new configuration by clicking on it and selecting **`Run Gradle Task`**

![](http://i.imgur.com/o4FUq11.png)

4. In **`Select Gradle Task`** select a Gradle project (current project) and on **`Tasks`** type **`optimusSetup`** and click **`OK`**

![](http://i.imgur.com/1Qq2ZRU.png)

5. Add a VM option for this gradle task. **`-DtestFeed="Name of your json file/Test feed fileName"`**

![](http://i.imgur.com/ZJnwxUB.png)

6. Next on **`Run/Debug Configuration`** windows provide Glue as steps and VM Options as     
**`-DtestFeed="Name of your json file/Test feed fileName" -DrunMode="Fragmentation/Distribution"`**

![](http://i.imgur.com/v7IOBUI.png)