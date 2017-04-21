Feature: Optimus feature four

  @helloOptimus
  Scenario Outline: test outline
    Given I have optimus hello application
    When I open it on either emulator, simulator or device on any platform
    Then I should be able to say a hello to optimus
    Examples:
      | varA | varB |
      | 1    | 2    |
      | a    | b    |