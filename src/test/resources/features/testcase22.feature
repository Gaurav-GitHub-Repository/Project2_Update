@FunctionalTest
Feature: verify add to cart from recommended items functionality
Scenario: verify product is added from recommended items and check product is displayed in cart page

    Background: Launch Browser And navigate to url
    
    When: scroll to bottom of page
    When: verify recommended items are visible
    And: click on add to cart button in recommended product
    And: Click on View cart button
    Then: verify product is displayed in cart page

