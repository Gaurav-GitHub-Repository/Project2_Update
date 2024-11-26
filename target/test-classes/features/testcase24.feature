@FunctionalTest
Feature: verify download invoice after purchase order functionality

  Background: Launch browser and navigate to Url

  Scenario: verify download invoice after purchase order and check account is deleted
    
    When: verify homepage is visible successfully
    When: Add Products To Cart
    And: click on cart button
    When: verify cart page is displayed 
    And: click on proceed to checkout button
    And: click on register or login button
    When: fill details in signup and create account
    When: verify account is created and click on continue button
    When: verify logged in as username at top
    And: click on cart button
    And: click on proceed to checkout button
    When: verify address details and review your order
    When: enter description in comment text area and click on place order
    When: enter payment details NameonCard, CardNumber, CVC and ExpirationDate
    And: click on pay and confirm order button
    When: verify Success Message
    And: click on download invoice button and verify invoice is downloaded successfully
    And: click on continue button
    And: click on delete account button
    Then: verify account is deleted and click on continue button

