Feature: User Registration Story

  Scenario: User can register
    Given I am on the home page
    When I click on the register link
    And I fill in the registration form
    Then I should see the registration success message
