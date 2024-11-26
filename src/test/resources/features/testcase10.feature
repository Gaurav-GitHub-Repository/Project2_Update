@FunctionalTest
Feature: verify subscription functionality

  Background: Launch browser and navigate to URL

  Scenario: verify subscription in homepage and success message
    
    When: verify home_page is visible successfully
    When: scroll down to footer
    When: verify text subscription
    When: enter email address in input and click arrow button
    Then: verify success message

