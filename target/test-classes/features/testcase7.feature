@FunctionalTest
Feature: verify test case page functionality

  Background: launch googlechrome browser and navigate to URL

  Scenario: verify homepage and navigate to test case page
    
    When: Verify that homepage is visible successfully
    And: click on test cases button
    Then: verify that user is navigated to test case page successfully

