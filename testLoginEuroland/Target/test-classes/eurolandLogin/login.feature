Feature: login to Euroland IR Tools
#scenario 1
  Scenario: Display username and password labels
    Given The login page has been shown
    Then The placeholder of username field is "User Name" and password field is "Password"

  #scenario 2
  Scenario Outline: Show error message when user try to login with invalid credential
    Given The login page has been shown
    When The user login with email is <email> and password is <password>
    Then The error <message> is shown in red color


    Examples:
      | email          	|password	|message			|
      | -             	|-  		|Required			|
      | lan@gmail.com	|-			|Required			|
      | lan            	|123356		|Not a valid email	|
      | lan@           	|123356		|Not a valid email	|
      | lan@gmail      	|123356		|Not a valid email	|
      | lan@ gmail.com 	|123356		|Not a valid email	|


  #scenario 3
  Scenario Outline: Show error message when user login with incorrect credential
    Given The login page has been shown
    When The user login with email is <email> and password is <password>
    Then The popup message "The username or password provided is incorrect" is shown in red color

    Examples:
      | email          		|password	|
      | support@gmail.com     |123@56		|
      | lan@gmail.com			|123456		|


  #scenario 4
  Scenario: Show list of Register tools after login with valid credentials
    Given The login page has been shown
    When The user login with valid credentials: email "support@gmail.com" and password "123456"
    Then The list of Tools dashboard is shown