@FunctionalTest
Feature: verify login user with invalid credentials
Scenario Outline: verify login user with incorrect email and password

    Background: launch browser and navigate to URL

    Given: launch google chrome browser and navigate to URL
    When: verify homepage is Visible Successfully
    And: Click on Signup or Login Button
    When: verify login to your account is visible
    When: enter incorrect <"email address"> and <"password">
    And: click on login button
    Then: verify error your email or password is incorrect is visible  
    
    Example:
    |email address|password|
    |abc@gmail.com|abc|

