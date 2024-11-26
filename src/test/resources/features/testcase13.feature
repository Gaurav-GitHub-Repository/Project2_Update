@FunctionalTest
Feature: verify product functionality

  Background: Launch google_chrome_browser and navigate_to_URL

  Scenario: verify product quantity is displayed in cart page with exact quantity
    
    When: verify homepage is visible successfully
    And: click on view product for any product on homepage
    When: verify product detail is opened	
    When: increase quantity to 4
    And: click on add to cart button
    And: Click on View Cart Button
    Then: verify product is displayed in cart page with exact quantity

