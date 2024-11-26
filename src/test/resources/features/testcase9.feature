@FunctionalTest
Feature: verify search product functionality

  Background: launch googlechrome_browser and navigate to URL

  Scenario: verify products related to search are visible
    
    When: Verify home_page is visible successfully
    And: Click on Products button
    When: verify user is navigated to all products page successfully
    When: enter product name in search input and click on search button
    Then: verify searched products is visible
    Then: verify products related to search are visible

