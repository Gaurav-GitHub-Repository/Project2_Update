
@FunctionalTest
Feature: verify register user functionality
Scenario: verify register user with existing email

    Background: launch browser and navigate To Url
    
    When: verify that home page is visible successfully
    And: click on signuporlogin button
    When: verify newusersignup is visible
    When: enter name and already regsitered email address
    And: click on signup button
    Then: verify error email address already exist is visible

