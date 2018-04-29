Feature: Verify funtionality of the Login Page

  Background: User is on the Login Page
    Given I am on the Login Page

  Scenario: Successful Login
    When I enter valid credentials
    And I click Login
    Then I see the users dashboard

  Scenario: Unsuccessful Login wrong password
    When I enter a valid username and invalid password
    And I click Login
    Then I see an unsuccessful login message

  Scenario: Unsuccessful Login invalid username
    When I enter a invalid username and valid password
    And I click Login
    Then I see an unsuccessful login message

  Scenario: Empty Login
    When I click Login without entering any information
    Then I see an unsuccessful login message

  Scenario: Accessing Help
    When I click Need Help
    Then The help information is displayed

  Scenario: I want to go back
    When I click the back arrow on the page
    Then I return to the Hudl homepage
