Feature: Say Hello to Optimus
  Using generic steps, I want read the welcome message


  @helloOptimus
  Scenario: generic step example
   Given optimus on Home screen verifies WelcomeMessage has textpresent value Welcome to Optimus!! You are all ready to experience Automation like never before.



  @helloOptimusIos
  Scenario: Hello Optimus IOS1
    Given I am running this scenario in parrallel on IOS
