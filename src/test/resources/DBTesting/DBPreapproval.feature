Feature: Preapproval Details page data

  @sprint5 @today
    Scenario: End-to-end UI testing
    Given I sign up as a new user
    And I log in with new credentials
    When I fill out the application completely and submit it
    Then I can verify the submission
    And I log out



   @DB @sprint5
Scenario: Verify Preapproval Details page information in DB
  Given I choose credit report option
  And I select agree and Next
  When I am able to submit the application
  Then My info stored in the database should be the following
    | id      |
    | realtor_status       |
    | realtor_info         |
    | loan_officer_status  |
    | purpose_loan         |
    | est_purchase_price   |
    | down_payment         |
    | down_payment_percent |
    | total_loan_amount    |
    | src_down_payment     |
    | add_fund_available   |



    @DB @sprint5
    Scenario: Verify that id column is auto-incrementing primary key
      Given I choose credit report option
      And I select agree and Next
      When I am able to submit the application
      Then id column is stored as an auto-incremented primary key


  @DB @sprint5
  Scenario: Verify that realtor_status and loan_officer_status column values stored as integers
    Given I choose credit report option
    And I select agree and Next
    When I am able to submit the application
    Then The values of the following fields are stored as integers
      | realtor_status | loan_officer_status |
      |1               |1                    |

  @DB @sprint5
  Scenario: Verify that realtor_info, purpose_loan and src_down_payment column values stored as strings
    Given I choose credit report option
    And I select agree and Next
    When I am able to submit the application
    Then The values of the following fields are stored as string


  @DB @sprint5
  Scenario: Verify that est_purchase_price, down_payment< down_payment_percent, total_loan_amount, add-fund_available column values stored as integers
    Given I choose credit report option
    And I select agree and Next
    When I am able to submit the application
    Then The values of the these fields are stored as integers
      | est_purchase_price | down_payment | down_payment_percent |total_loan_amount |add_fund_available|
      | 10000              | 1000         | 10.00                | 9000.00           |                 |