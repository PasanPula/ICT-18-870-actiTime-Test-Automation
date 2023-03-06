Feature: Create new user

  Scenario Outline: As a admin I should be able create new user
    Given I am on the Actitime Loging Page
    When I Enter my Username as  "<username>"
    And I Enter my Password as  "<password>"
    And I click on Loging button
    Then I should be able to successfuly loging to Actitime
    When I Click on the Users tab
    Then I should be able to successfuly switch Users Page
    When I Click on the  New User button
    Then I should see New user creation panel
    When I Enter my FirstName as  "<firstname>"
    And I Enter my LastName as  "<lastname>"
    And I Enter my Email as  "<email>"
    And I click on submit button
    Then I should be able to successfuly create new user
    And Close the browser

    Examples: 
      | username | password | firstname | lastname | email             |
      | admin    | manager  | Jhon      | Parker   | Jparker@gmail.com |
