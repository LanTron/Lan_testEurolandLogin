Feature: Reset password

  #scenario 1
  Scenario: The label for Email field will be hide once user input data
    Given The reset password page has been shown
    Then The field have placeholder with content "Email"

  #scenario 2
  Scenario: Show error message when user leave Email blank
    Given The reset password page has been shown
    When The user reset password with no email
    Then The error message "Required" is shown in red color below Email field

  #scenario 3
  Scenario Outline: Show error message when user reset password with invalid email
    Given The reset password page has been shown
    When The user reset password with an invalid email <value>
    Then The error message "Not a valid email" is shown in red color
    Examples:
      | value          |
      | -              |
      | lan            |
      | lan@           |
      | lan@gmail      |
      | lan@ gmail.com |

  #scenario 4
  Scenario: Show message when user reset password with an email not available on system
    Given The reset password page has been shown
    When The user reset password with "lan@gmail.com" not available on system
    Then The message "Not a valid email" is shown

  #scenario 5
  Scenario: Show message when user reset password with an email available on system
    Given The reset password page has been shown
    When The user reset password with "support@gmail.com" available on system
    Then The message "An email has been sent to your email address.Open the e-mail and select a link to reset your password" is shown

  #scenario 6
  Scenario: Redirect to login page when user click close button
    Given The reset password page has been shown
    When The user close reset password page
    Then It will redirect to login page
