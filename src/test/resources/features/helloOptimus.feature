Feature: Say Hello to Optimus

  @helloOptimus
  Scenario: Hello Optimus
    Given I have optimus hello application
    When I open it on either emulator, simulator or device on any platform
    Then I should be able to say a hello to optimus

  @helloOptimus
  Scenario: test two
    Given I have optimus hello application
    When I open it on either emulator, simulator or device on any platform
    Then I should be able to say a hello to optimus
    Then some pending step

  @helloOptimus
  Scenario: test three
    Given I have optimus hello application
    When I open it on either emulator, simulator or device on any platform
    Then I should be able to say a hello to optimus
    Then a failing step


  @helloOptimus
  Scenario Outline: test outline
    Given I have optimus hello application
    When I open it on either emulator, simulator or device on any platform
    Then I should be able to say a hello to optimus
    Examples:
      | varA | varB |
      | 1    | 2    |
      | 3    | 4    |
      | a    | b    |