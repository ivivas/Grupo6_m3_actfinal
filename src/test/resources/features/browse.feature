Feature: browse
  We need to be able to browse between
  the different categories
  Scenario: Browsing between the three categories
    Given I want to browse products
    When I want to visualize the three different categories
    Then  I should see the products in each category
