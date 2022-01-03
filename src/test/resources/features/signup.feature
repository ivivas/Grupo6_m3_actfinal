Feature: signup
  We need to be able to signup
  in the web application
  Scenario: Signing up in the web application
    Given I want to Sign up
    When I sign up with the user 'test' and password 'test'
    Then  I should see a success message
