Feature: Test cases to verify user registration

  Scenario: Registration of a new user
    Given User is on main page
    When User clicks on Login/Registration link
    Then User is on Login page
    #When User provides new registration data
    #Then User is on Registration page
    #When User fills in all necessary data
    #Then Registration should be successful