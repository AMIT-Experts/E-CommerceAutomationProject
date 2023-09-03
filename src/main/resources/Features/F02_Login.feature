@Smoke
Feature: Test login functionality
  Scenario: Test login with valid email and valid password
    Given the user clicks on login
    When  the user fills email as "lara.sara2@gamil.com" and password "test123456789" and clicks on login
    Then  The user login successfully


  Scenario: Test login with invalid email and password
    Given the user clicks on login
    When  the user fills email as "lara.sara2@gamil.com" and password "test123" and clicks on login
    Then   Error message is displayed

