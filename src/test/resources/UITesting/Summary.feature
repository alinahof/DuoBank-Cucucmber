Feature: Summary page review & edit

      As a user I should be able to review and edit every section of the loan application

    Background: Common for all steps
      Given I log in with credentials
      Then I click on the mortgage application
      Then I fill out preapproval section
      Then I fill out personal information section
      Then I fill out the expenses page
      Then I fill out Employment&Income page
      Then I fill out credit report
      Then I can fill out eConsent with javascript

  @summary
  Scenario: Review Edit PreApproval Inquiry
    Given I click on the Preapproval
    Then I save loan application

  @summary
    Scenario: Review Personal Edit button
      Given I click on the personal
      Then I save loan application


  @summary
  Scenario: Review Expense Edit button
    Given I click on the expense
    Then I save loan application

  @summary
  Scenario: Review Employment and Income Edit button
    Given I click on the Employment and Income
    Then I save loan application

  @summary
  Scenario: Review Credit Report Edit button
    Given I click on the Credit Report
    Then I save loan application

  @summary
  Scenario: Review eConsent Edit button
    Given I click on the eConsent
    Then I save loan application


  Scenario: Complete Application Loan Process
      Given I save loan application