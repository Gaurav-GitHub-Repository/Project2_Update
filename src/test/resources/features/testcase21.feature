@FunctionalTest
Feature: verify review on product functionality

  Background: launch browser And navigate to url

  Scenario: verify review is added on product and check success message
    
    When: click on Products button
    When: verify user is navigated to all products page successfully
    And: click on view product button
    When: verify write your review is visible
    When: enter name, email and review
    And: click on submit button
    Then: verify success message

