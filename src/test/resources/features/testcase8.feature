@FunctionalTest
Feature: verify product details page functionality
Scenario: verify all products and product details page

    Background: launch browser and navigate to application
    
    When: Verify homepage is visible successfully
    And: click On Products button
    When: user is navigated to All Products page successfully
    When: The products list is visible
    And: click on view product of first product	
    Then: user is landed to product detail page
    Then: verify that detail is visible

