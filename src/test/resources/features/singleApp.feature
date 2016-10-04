Feature: As a smart template
  I want to demonstrate an example single app feature
  So that users can reference this in future


  @interApp
  Scenario: user books a ride on his app
    Given the rider is logged in as "rider@yourapp.com"
    When the rider books a cab

    Then the rider gets a notification that booking is confirmed
    Then the rider gets a notification that driver is assigned


