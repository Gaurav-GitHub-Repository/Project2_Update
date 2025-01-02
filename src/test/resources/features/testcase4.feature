
@FunctionalTest
Feature: verify logout user functionality
Scenario Outline: verify logout user with valid credentials

    Background: launch browser and navigate to URL
    
    When: verify home page is visible successfully
    And: click on SignuporLoginButton
    When: Verify login to your account is visible
    When: enter valid correct <"emailaddress"> and <"password">
    And: click on loginbutton
    When: verify loggedinusername is visible
    And: click on logout button
    Then: verify user is navigated to login page

	Example:
	|emailaddress|password|
	|abc@123|Gaurav|
