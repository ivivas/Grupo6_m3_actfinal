Feature: add to cart
  We need to be able to add products
  into the cart in the web application
  Scenario: Add a products to the cart
    Given I want to add a products into the cart
    When I add a "galaxy s7", "galaxy s6" and "vaio i7"
    Then  I should see "galaxy s7", "galaxy s6" and "vaio i7" in the cart
