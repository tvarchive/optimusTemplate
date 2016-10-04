Feature: As a smart template
  I want to demonstrate an example inter app feature
  So that users can reference this in future


  @interApp
  Scenario: complete workflow of user booking a ride
    Given the rider is logged in as "rider@yourapp.com"
    And the driver is logged in
    When the rider books a cab
    And the driver accepts the booking
    Then the rider gets a notification that driver is assigned

    When driver starts the trip
    And driver end the trip
    Then rider can rate the driver

