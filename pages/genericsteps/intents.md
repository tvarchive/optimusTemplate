---
title: Intent
keywords: intents, tutorial
last_updated: May 22, 2017
tags: [intents]
summary: "Making scenarios reusable"
sidebar: optimus_sidebar
permalink: intents
folder: genericsteps
---
## What is an Intent?
An Intent is a small reusable action, similar to a scenario. However, it has no purpose, if it isn't used in a context. 
<br>
Eg:
     
          @Intent
          Scenario: Login
          Given User enters username as JohnNash
          And User enters password as NashJohn
          When User clicks on submit
          Then User is navigated to HomeScreen
     
Usage:
     
         Scenario: Book a cab
         Given  Intent: Login
         When  I enter to and from locations
         And   I click on BookACab
         Then  I should receive a booking confirmation
     
 
Sometimes it is needed to override default values as in the above example user would like to login other than 'JohnNash'. It is possible to modify the default values of Intent as below. Usage:
     
         Scenario: Book a cab
         Given   DataIntent: Login
         |Admin|pass@123|
         When I enter to and from locations
         And  I click on BookACab
         Then I should receive a booking confirmation
     
 
Using intent in code:
     
         String intentId = "Login";
         intentRunner(intentId).run();
     
 

If the default data is overridden, pass the datatable object to intent runner.
     
         String intentId = "Login";
         intentRunner(intentId).useDatatable(datatable).run();
     
 

If the step definitions are created in a package apart form the standard steps package, you can let Intent know about it as below.
     
         String intentId = "Login";
         String stepDefinitionsPackage = "com.example.exampleStepsPackage";
         intentRunner(intentId)
         .useDatatable(datatable)
         .locateStepDefinitionsAt(stepDefinitionsPackage)
         .run();
        
        
## Suggested Usage :
* Intents are like the helper methods, though they look like Scenarios, it is adviced that they aren't executed as a scenario.
* Choose any convenient tagname for Intents and ignore them while running Cucumber Features using `~`.
    
   Eg: In cucumber command line options pass
    
        --tags, "~@Intent"
* Create a common step definition matching your Intent and DataIntent.
    
    Eg: For an Intent, the step definition can be
            
        @Given("^(Intent):(.*)$")
        public void intent(String action, String intentId) throws Throwable {
            intentRunner(intentId).run();
        }
    Eg: For a DataIntent, the step definition can be
        
        @Given("^(DataIntent):(.*)$")
        public void intentWithDataTable(String action, String intentId, DataTable dataTables) throws Throwable {
            intentRunner(intentId).useDatatable(dataTables).run();
        }