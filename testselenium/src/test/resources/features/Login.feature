Feature: Login Orange Page
Scenario:  Login with valid data
	Given  User is on Orange Login Page
	When  User enters UserName "Admin"
	And  User enters Password "admin123"
	And  User click on Login button
	Then  User should be login successfully 