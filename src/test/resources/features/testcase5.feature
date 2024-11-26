@FunctionalTest
Feature: verify register user functionality

  Background: launch browser and navigate To Url

  Scenario: verify register user with existing email
    
    When: verify that home page is visible successfully
    And: click on signuporlogin button
    When: verify newusersignup is visible
    When: enter name and already regsitered email address
    And: click on signup button
    Then: verify error email address already exist is visible

