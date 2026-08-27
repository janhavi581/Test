Feature: Add New User 
Scenario: New User successful registration

		Given user is on selenium login page
		When user click on new user
		And user enter username "Karustub12"
		And user enter first name "Kaustubh"
		And user enter password "Ram123"
		And user enter last name "Patil"
		And user click on register
		Then new user should register successfully