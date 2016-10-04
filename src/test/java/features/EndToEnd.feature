Feature: Example for e2e


  Scenario Outline: Rider Driver workflow
    Given On Home Page I log in using details of <user> and tap on GO-RIDE
    When On Go-Car Driver Landing Page driver choose to log in with account
    When On Go-Ride Page I enter From location <location> and location details <loc_details>
    And  On Go-Ride Page I enter To location as <destination>
    And On Go-Ride Page I verify the total price and place order with cash
    Then On Go-Ride Confirmation Page I verify message <message>

    Examples:
      | user       | location                      | loc_details      | destination          | message       |
      | goRideUser | Oakwood Premier Cozmo Jakarta | 2333, 15th Floor | Jalan Doktor Saharjo | please wait.. |


  @interApp
  Scenario: User cancels after driver accepts
    Given On Home Page User makes Go-Ride booking with cash
    When On Go-Bis Landing Page I choose to log in with account "vagrantlab@gmail.com"
    And On Go-Bis Home Page driver accepts booking
    Then On Go-Ride Confirmation Page I see driver arriving
    And On Go-Ride Confirmation Page I cancel driver accepted booking and select I waited too long


#  @interApp
  Scenario: User cancels after driver accepts
    Given On Home Page User makes Go-Ride booking with cash
    When On Go-Bis Landing Page I choose to log in with account "vagrantlab@gmail.com"
    And On Go-Bis Home Page driver accepts booking
    And On Go-Bis Home Page driver2 accepts booking
    Then On Go-Ride Confirmation Page I see driver arriving
    And On Go-Ride Confirmation Page I cancel driver accepted booking and select I waited too long