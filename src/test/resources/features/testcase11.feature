@FunctionalTest
Feature: verify subscription functionality

  Background: launch google_chrome_browser and navigate_to_url

  Scenario: verify subscription in cart page
    
    When: Verify homepage is visible Successfully
    And: click on cart button
    When: verify scroll down to footer
    When: Verify text subscription
    When: enter emailaddress in input and click on arrow button
    Then: verify success message

