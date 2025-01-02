@FunctionalTest
Feature: verify place order functionality
Scenario: verify place order register while checkout

    Background: Launch google_chrome_browser and navigate_to_url
    
    When: Verify Homepage is Visible Successfully
    When: add products to cart
    And: Click on Cart Button
    When: verify cart page is displayed
    And: click proceed to checkout
    And: click register or login button
    And: fill details in signup and create account
    When: Verify account created and click on Continue button
    When: verify logged in as username at top
    And: Click on cart button
    And: click on proceed to checkout button
    When: verify address details and review your order
    When: enter description in comment text area and click place order
    When: enter paymentdetails: nameoncard, cardnumber, CVC, expiration date
    And: click on pay and confirm order button
    Then: verify success message
    Then: Click on Delete Account Button
    Then: verify account deleted and click on continue button

