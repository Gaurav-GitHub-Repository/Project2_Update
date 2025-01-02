@FunctionalTest
Feature: verify test case page functionality
Scenario: verify homepage and navigate to test case page

    Background: launch googlechrome browser and navigate to URL
    
    When: Verify that homepage is visible successfully
    And: click on test cases button
    Then: verify that user is navigated to test case page successfully

