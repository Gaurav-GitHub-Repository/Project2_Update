@FunctionalTest
Feature: verify place order functionality

  Background: Launch google chrome browser And navigate to url

  Scenario: verify place order login before checkout
    
    When: verify Homepage is Visible Successfully
    And: Click on signup or login button
    When: fill email, password and click on login button
    When: verify Logged in as username at top
    When: Add products to cart
    And: click on Cart Button
    When: Verify Cart Page is displayed
    And: click on proceed to Checkout
    When: Verify address Details and Review your order
    When: Enter description in comment text area and click on place order
    When: Enter payment details nameoncard, cardnumber, cvc and expirationdate
    And: Click on Pay and Confirm Order Button
    Then: verify Success Message
    Then: click on Delete Account button
    Then: Verify Account Deleted and Click on Continue Button

