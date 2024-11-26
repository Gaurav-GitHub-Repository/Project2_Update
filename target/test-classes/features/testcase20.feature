@FunctionalTest
Feature: verify searched products functionality

  Background: Launch browser And navigate to URL

  Scenario: verify searched products and ensure that products are visible in cart after login as well
    
    When: click On Products Button
    When: user is navigated to all products page successfully
    When: enter product name in search input and click on search button
    When: verify searched products is visible
    When: verify all products related to search are visible
    And: add products to cart
    And: click on cat button and verify that products are visible in cart
    And: click on signup or login button and submit login details
    Then: go to cart page
    Then: verify products are visible in cart after login as well

