Feature: Test login app
	
	Scenario Outline: Test login with valid value
	Given start application
	
	When enter valid Email <email>
	
	And click button next
	
	And enter Password <password>
	
	And click button login
	
	Then login successfuly
	
	Examples:
	
	|email                  |password     |
	
	|laundryjpn@gmail.com   |123456       |
	
	Scenario Outline: Test login Email invalid
	Given start application
	
	When enter valid Email <email>
	
	Then return message is "*This is not a valid email or phone"
	
	Examples:
	
	|email                  |password     |
	
	|laundryjpn             |123456       |
	
	
	
	Scenario Outline: Test login Email invalid
	Given start application
	
	When enter valid Email <email>
	
	And click button next
	
	And enter Password <password>
	
	And click button login
	
	Then return message is "Please enter a valid password"
	
	
	Examples:
	
	|email                  |password     |
	
	|laundryjpn@gmail.com            |1234567      |