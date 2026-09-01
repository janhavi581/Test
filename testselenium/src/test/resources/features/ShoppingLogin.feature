Feature: login on shopping page
Scenario: Login with valid data
	Given user is on shopping page
	When user click on login link
	And user enter email
	And user enter password
	And user click on login button
	Then the login should be successful
	
	
	

Scenario: Login with invalid data
Given user is on shopping page
	When user click on login link
	And user enter invalid email "testbhdsjhjfh12@gmail.com"
	And user enter invalid password "wrong123"
	And user click on login button
	Then the invalid login error message should be displayed

	
	