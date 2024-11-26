@FunctionalTest
Feature: verify cart functionality

  Background: Launch Browser and navigate to url

  Scenario: verify view category products
    
    When: enter details and click on login button
    When: click on products
    When: verify categories are visible on left side bar
    Then: verify women category products
    Then: verify men category products
 	

