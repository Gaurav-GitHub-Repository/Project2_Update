@FunctionalTest
Feature: verify scroll up without using arrow button and scroll down functionality
Scenario: verify user is scrolled up to full fledge practice website for automation engineer text on screen

Background: Launch browser And Navigate to Url

When: Verify Homepage Is Visible Successfully
When: verify Scroll Down Page To Bottom
When: verify Subscription Is Visible
When: verify scroll up page to top
Then: verify Page Is Scrolled Up To Mentioned Text On Screen 
