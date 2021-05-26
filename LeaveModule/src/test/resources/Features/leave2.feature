Feature: Leave module 
Scenario: Leave page musts be open 
	Given Users on the login page 
	When pages of the Title is OrangeHRM 
	Then enter userids  password 
	Then Clicks on the Login button 
	Then select leaves Module 
	
	
Scenario Outline: Assigns the entitlments for the employee 
	Given Admin is on Adds entilements page 
	Then enter "<employee>" name 
	Then Selects leaves type 
	Then Add number of entitlement 
	Then Clicks on the Save button 
	Examples: 
		|employee|
		|Aaliyah Haq|
		|Paul Collings|
		
		
Scenario Outline: 
	Cross checks that particular employee is eligable to take holidays 
	Given Admin is on Employees entitlement page 
	Then Enters "<employee>" name 
	Then Selects Leave type 
	Then Click on the Searchs button 
	Examples: 
		|employee|
		|John Smith|
		|tanish Garg|
		
Scenario: Assign leaves that for valid employee 
	Given admin is on assign leaves page 
	Then enters valid name of the employee 
	Then enter Leave types 
	Then selects Date (from) 
	Then select Dates (to) 
	Then write a comments 
	Then clicks on the assign button 
	
Scenario: Checking on the leave list 
	Given User on a Leave page 
	Then Selects Date (form) 
	Then Selects Date (to) 
	Then Select the check box 
	Then Enter employee name 
	Then Select sub unit 
	Then click on the Search 
	
	
Scenario: Checkings on the leave list for invalid date 
	Given Users on a Leave page 
	Then Selects Dates (form) 
	Then Selects Dates (to) 
	Then Selects the check box 
	Then Enters valid employee name 
	Then Select sub units 
	Then click on the Searchs 
	
Scenario: Checking The reports 
	Given User on leave Entitlement and usage 
	Then Selects Generate for 
	Then Enter  employee's' name 
	Then Select Date 
	Then click on the Search but 
	
Scenario: Check login user leave 
	Given user on the myb leave page 
	Then Select date from colum 
	Then  Select date to colum 
	Then Select status 
	Then Search the leave 
	
	#checking for my entitlement
	
