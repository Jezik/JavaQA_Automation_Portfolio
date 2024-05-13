Feature: Test cases to verify user registration

  Background:
    Given User is on main page
    When User clicks on Login/Registration link
    Then User is on Login page

  Scenario: Registration of a new user
    When User provides registration data
    Then User is on Registration page
    When User fills in all necessary data
    Then Registration should be successful

  Scenario: Attempt to register a user with existing email
    When User provides registration data
    Then The message about existing email should be shown

  Scenario: Delete account
    When User logs in
    Then Main menu has an option to delete account
    When User removes account
    Then Account successfully removed