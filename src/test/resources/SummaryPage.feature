Feature: Summary Page

  As a user I should be able to review and edit every section of the loan application on summary page section


  Background: Common for all steps
    Given I log in with valid credentials
    Then I click on the mortgage application section
    Then I fill out preapproval section
    Then I fill out personal information section
    Then I fill out the expenses section
    Then I fill out Employment and Income page
    Then I fill out credit report section
    Then I can fill out eConsent section
    Then i click on summary page section


#  Scenario: I'm on the summary page
#    When I choose summary section
#    Then I'm able to edit any section of the application
#    Then I'm able to submit the application
  @sum
    Scenario: PreApproval Inquiry Edit
      Given I click on the PreApproval edit button
      Then I make necessary changes in PreApproval
  @sum
    Scenario: Personal Details Edit
      Given I click on Personal Details edit button
      Then I make necessary changes in Personal Details
  @sum
  Scenario: Expenses Edit
    Given I click on Expenses edit button
    Then I make necessary changes in Expenses
  @sum
  Scenario: Employment & Income Edit
    Given I click on Employment & Income edit button
    Then I make necessary changes in Employment & Income
  @sum
  Scenario: Order Credit Edit
    Given I click on Order Credit edit button
    Then I make necessary changes in Order Credit
  @sum
  Scenario: eConsent Edit
    Given I click on eConsent edit button
    Then I make necessary changes in eConsent
    Then I am able to submit the application


