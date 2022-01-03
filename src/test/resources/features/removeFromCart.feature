Feature: remove from cart
  We need to be able to remove products
  from the cart in the web application
  Scenario: remove products to the cart
    Given I have an "galaxy s6" in the cart
    When I remove the "galaxy s6" from the cart
    Then  I should not see any product in the cart
