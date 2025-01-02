@FunctionalTest
Feature: verify view & cart brand products functionality
Scenario: verify products and ensure user navigate to the brand page and can see products

    Background: Launch Browser And Navigate to url

    When: click on products button
    And: click on any brand name
    Then: on left side bar click on any brand link

