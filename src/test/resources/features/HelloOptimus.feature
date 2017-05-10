Feature: Say Hello to Optimus

  @helloOptimus
  Scenario: Hello Optimus
    Given I have optimus hello application
    When I open it on either emulator, simulator or device on any platform
    Then I should be able to say a hello to optimus
