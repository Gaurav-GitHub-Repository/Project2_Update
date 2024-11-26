@FunctionalTest
Feature: Verify login user functionality

Background: launch browser and navigate to URL

  Scenario Outline: Verify login user with correct email and password
    
    When: Verify homepage
    And: Click on Signup or Login button
    When: Verify Login to your account is visible
    When: Enter correct <"emailaddress"> and <"password">
    And: Click on login button
    When: Verify Logged in as username
    Then: Click on delete account button
    Then: Verify account deleted is visible
    
    Example:
    |emailaddress|Password|
    |abc@gmail.com|Gaurav|

