Feature: Optimus feature three

  @helloOptimus
  Scenario: test three
    Given I have optimus hello application
    When I open it on either emulator, simulator or device on any platform
    Then I should be able to say a hello to optimus
    Then a failing step

