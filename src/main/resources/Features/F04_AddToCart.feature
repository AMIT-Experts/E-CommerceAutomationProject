Feature: Add to cart
  Background:
    Given   The user navigates list of products in home page
  Scenario: The user can add the product to the shopping cart directly
    When    User selects a product as "Nike Floral Roshe Customized Running Shoes" and chooses relevant options
    And     User opens the product and add to cart
    Then    The product is added to the shopping cart
    And     The user can confirm the addition in the shopping cart
    And     The user can update the quantity of the product in the shopping cart