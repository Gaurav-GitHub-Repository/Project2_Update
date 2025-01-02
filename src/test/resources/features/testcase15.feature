@FunctionalTest
Feature: verify place order functionality
Scenario: verify place order register before checkout

    Background: Launch google_chrome_browser and Navigate_to_url

    When: Verify homepage is Visible Successfully
    And: Click on signup or login Button
    When: fill all details in signup and create account
    When: Verify Account created and Click on Continue button
    When: verify logged in as username at top
    When: Add products to Cart
    And: Click on Cart button
    When: Verify cart page is Displayed
    And: click on proceed to checkout
    When: Verify Address details and Review your order
    When: enter description in comment text area and click on place order
    When: enter payment details nameoncard, cardnumber, cvc and expirationdate
    And: Click on pay and Confirm order button
    Then: Verify Success message
    Then: Click on Delete account Button
    Then: Verify account deleted and Click on continue button

