@FunctionalTest
Feature: verify subscription functionality
Scenario: verify subscription in cart page

    Background: launch google_chrome_browser and navigate_to_url
    
    When: Verify homepage is visible Successfully
    And: click on cart button
    When: verify scroll down to footer
    When: Verify text subscription
    When: enter emailaddress in input and click on arrow button
    Then: verify success message

