Feature: login
  We need to be able to sign in
  in the web application
  Scenario: Sign in the web application
    Given I want to login
    When I login with the user 'test' and password 'test'
    Then  I should see the welcome message in the page
