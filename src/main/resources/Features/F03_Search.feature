
Feature: Test search for product
  Background:
    Given The user on Home page

  Scenario:The user can search for products and returns the correct results
    When The user enters "camera" on search field and clicks on search button
    And  The website returns some results that The user click on advanced search to get specific result
    Then The final results should match the selected filter and search keywords "camera"