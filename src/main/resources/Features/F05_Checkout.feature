Feature: Test Checkout and get payment
  Background:
    Given The guest user navigate to the shopping cart to buy "Leica T Mirrorless Digital Camera"
    And   The guest user agrees to the terms and conditions and click on the Check out button
  Scenario: The user can check out the products in his shopping cart and pay for them by money order
    When The guest user add his details: First and Last name, Email, Company
    And  The guest user select the country and state
    And  The guest user add city and address details and zipcode
    And  The user adds Phone number and Fax
    And  The user clicks on Continue
    And  The user selects the shipping method and clicks on Continue
    And  The user selects the payment method by money order and clicks on Continue
    And  The user add the payment method details for Money order
    And  The guest user clicks on Confirm
    Then The order is confirmed and the user can navigate to order details

  Scenario: The user can check out the products in his shopping cart and pay for them by credit card
    When The guest user add his details: First and Last name, Email, Company
    And  The guest user select the country and state
    And  The guest user add city and address details and zipcode
    And  The user adds Phone number and Fax
    And  The user clicks on Continue
    And  The user selects the shipping method and clicks on Continue
    And  The user selects the payment method by Credit card and clicks on Continue
    And  The user add the payment method details
    And  The guest user clicks on Confirm
    Then The order is confirmed and the user can navigate to order details






