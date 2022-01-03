Feature: buy
  We need to be able buy products
  in the web application
  Scenario: Buy products
    Given I have a "galaxy s7" in the cart
    When I buy the product
    Then  I should see "Thank you for your purchase"

