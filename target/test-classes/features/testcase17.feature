@FunctionalTest
Feature: verify cart functionality

  Background: launch browser and navigate to url

  Scenario: verify remove products from cart
    
    When: verify Homepage is visible successfully
    When: enter credentials and click on login button
    When: add products to Cart
    And: click On Cart Button
    When: Verify Cart page is Displayed
    When: click X button corresponding to particular product
    Then: verify product is removed from cart

