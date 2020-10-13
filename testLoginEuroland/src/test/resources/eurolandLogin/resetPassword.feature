Feature: Reset password

  #scenario 1
  Scenario: Display Email label
    Given The reset password page has been shown
    Then The field have placeholder with content "Email"


  #scenario 2
  Scenario Outline: Show error message when user reset password with invalid email
    Given The reset password page has been shown
    When The user reset password with email is <email>
    Then The error message <message> is shown in red color below Email field
    Examples:
      | email          |message             |
      | -              |Required            |
      | lan            |Not a valid email   |
      | lan@           |Not a valid email   |
      | lan@gmail      |Not a valid email   |
      | lan@ gmail.com |Not a valid email   |

  #scenario 3
  Scenario Outline: Show message when user reset password with an valid email on system
    Given The reset password page has been shown
    When The user reset password with email is <email>
    Then The message <message> is shown

    Examples:
      |email				|message						|
      |lan@gmail.com		|Not a valid email				|
      |support@gmail.com	|An email has been sent to your email address.Open the e-mail and select a link to reset your password|



  #scenario 4
  Scenario: Redirect to login page when user click close button
    Given The reset password page has been shown
    When The user close reset password page
    Then It will redirect to login page
