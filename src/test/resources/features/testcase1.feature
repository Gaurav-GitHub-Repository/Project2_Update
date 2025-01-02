@FunctionalTest
Feature: verify register user functionality
Scenario: verify account is registered, created and deleted

Background: launch browser and navigate to URL
 
    When: verify that homepage is visible successfully
    And: click on signup or login button
    When: verify new user signup is visible
    When:  enter name and email address
    And: click on signup button
    When: verify that enter account information is visible
    When: fill details title, name, email, password, date of birth and checkbox
    When: fill details like firstname, lastname, company, address, address2, country, state, city, zipcode and mobilenumber
    And: click on create account button
    When: verify account created is visible
    And: click on continue button
    When: verify logged in username is visible
    Then: click on delete account button
    Then: verify that account deleted is visible

