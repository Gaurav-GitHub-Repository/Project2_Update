@FunctionalTest
Feature: verify subscription functionality
Scenario: verify subscription in homepage and success message

    Background: Launch browser and navigate to URL
    
    When: verify home_page is visible successfully
    When: scroll down to footer
    When: verify text subscription
    When: enter email address in input and click arrow button
    Then: verify success message

