Feature: Expense Page

  Background: Common for all steps
    Given I log in with credentials
    Then I click on the mortgage application
    Then I fill out preapproval section
    Then I fill out personal information section


    Scenario: Fill out Expense Page
      Given I fill out the expenses page