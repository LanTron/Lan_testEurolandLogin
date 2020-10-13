Feature: login to Euroland IR Tools
#scenario 1
  Scenario: Labels for User Name and Password fields will be hide once user input data
    Given The login page has been shown
    Then The fields have placeholders with content "User Name" and "Password"
#scenario 2
  Scenario: Show error message when user login with blank User Name
    Given The login page has been shown
    When The user login with blank User Name
    Then The error message "Required" is shown in red color below User Name field
  #scenario 3
  Scenario Outline: Show error message when user login with invalid email
    Given The login page has been shown
    When The user login with an invalid email <value>
    Then The error message "Not a valid email" is shown in red color below User Name field


    Examples:
      | value          |
      | -              |
      | lan            |
      | lan@           |
      | lan@gmail      |
      | lan@ gmail.com |

  #scenario 4
  Scenario: Show error message when user login with blank Password
    Given The login page has been shown
    When The user login with blank Password and a valid email "lan@gmail.com"
    Then The error message "Required" is shown in red color below Password field

  #scenario 5
  Scenario: Show error message when user login with invalid credentials
    Given The login page has been shown
    When The user login with invalid credentials: email "lan@gmail.com" and password "123456"
    Then The error message "The username or password provided is incorrect" is shown in red color

  #scenario 6
  Scenario: The Customer Interface 2 will show when user login with valid credentials
    Given The login page has been shown
    When The user login with valid credentials: email "support@gmail.com" and password "123456"
    Then The Customer Interface 2 will show