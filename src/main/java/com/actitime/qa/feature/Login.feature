Feature: As a user I should be loging to the Actitime

  Scenario Outline: Sucessfully login with valid credentials
    Given I am on the Actitime Loging Page
    When I Enter my Username as  "<username>"
    And I Enter my Password as  "<password>"
    And I click on Loging button
    Then I should be able to successfuly loging to Actitime

    Examples: 
      | username | password |
      | admin    | manager  |
