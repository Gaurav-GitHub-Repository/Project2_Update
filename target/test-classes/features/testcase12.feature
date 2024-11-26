@FunctionalTest
Feature: verify add product functionality

  Background: Launch google_chrome_browser and navigate to url

  Scenario: verify add products in cart and product details
    
    When: Verify Homepage is visible successfully
    And: click on products button
    When: hover over first product and click on add to cart
    And: click on continue shopping button
    When: hover over second product and click on add to cart
    And: click on view cart button
    Then: verify both products are added to cart
    Then: verify product details

