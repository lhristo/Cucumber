Feature: Create Account

  Scenario: The user should be able to create a non-existing account
    Given the user is on the register form page
    When the user enters a non existing username
    And the user enters a non existing email
    And enters a password
    And confirms the password
    And clicks on the Sign in button
    Then if the user is signed in they should be able to click on the profile link