Feature: Login

  Scenario: Login with valid email and password
    Given user is on login page
    And user input username with "standard_user"
    And user input password with "secret_sauce"
    When user click login button
    Then user is on homepage

  Scenario: Login with invalid email and password
    Given user is on login page
    And user input username with "standard_userss"
    And user input password with "secret_sauceee"
    When user click login button
    Then show error message


