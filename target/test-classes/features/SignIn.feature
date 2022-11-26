Feature: Sign In Feature

  @loginScenario
  Scenario: Verify user can sign in into Retail Application
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'shirin.khamisi@tekschool.us' and password 'Bayan1987$$'
    And User click on login button
    Then User should be logged in into Account

  @createAccountScenario
  Scenario: Verify user can create an account into Retail Website
    Given User is on retail website
    When User click on Sign in option
    And User click on Create New Account button
    And User fill the signUp information with below data
      | name     | email                   | password    | confirmPassword |
      | panthers | shirinkhamsi0@gamil.com | Bayan1987$$ | Bayan1987$$    |
    And User click on SignUp button
    Then User should be logged into account page
