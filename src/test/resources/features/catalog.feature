Feature: Product Catalog

  Scenario: See List of Available pastries
    Given the catalog contains 6 items
    When I navigate to the landing page
    Then I see a list of all 6 items with title and price