@FunctionalTest
Feature: verify scroll up using arrow button and scroll down functionality

  Background: Launch browser And navigate to url

  Scenario: verify user is scrolled up to full fledge practice website for automation engineer text on screen
    
    When: verify Homepage Is Visible Successfully
    When: scroll down page to bottom
    When: verify subscription is visible
    And: click on arrow button at bottom right side to move upward
    Then: verify page is scrolled up to mentioned text on screen

