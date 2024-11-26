@FunctionalTest
Feature: verify contact us form functionality

  Background: launch browser and navigate to URL

  Scenario: verify success message in contact us form
    
    When: Verify that home page is visible successfully
    And: click on contact us form
    When: verify get in touch is visible
    When: enter name, email, subject and message
    When: upload file
    And: click on submit button
    And: click on ok button
    Then: verify success message Success Your details have been submitted is visible
    Then: click on home button and verify that landed to homepage successfully

