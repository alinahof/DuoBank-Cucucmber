Feature: Preapproval Details page data


   @DB @sprint5
Scenario: Verify Preapproval Details page information in DB
  Given I choose credit report option
  And I select agree and Next
  When I am able to submit the application
  Then My info stored in the database should be the following
    | realtor_status | realtor_info                             | loan_officer_status | purpose_loan    | est_purchase_price | down_payment | down_payment_percent | total_loan_amount | src_down_payment                              | add_fund_available|
    | 1              | John Smith, 412-123-1234, john@gmail.com | 1                   | Purchase a Home | 10000              | 1000         | 10.00                | 9000.00           | Checking/Savings (most recent bank statement) ||



#    @DB @sprint5
#    Scenario: Verify that id column is auto-incrementing primary key
#      Given I choose credit report option
#      And I select agree and Next
#      When I am able to submit the application
#      Then


  @DB @sprint5
  Scenario: Verify that realtor_status and loan_officer_status column values stored as integers
    Given I choose credit report option
    And I select agree and Next
    When I am able to submit the application
    Then The values of the following fields are stored as integers
      | realtor_status | loan_officer_status |
      |1               |1                    |

  @DB @sprint5
  Scenario: Verify that realtor_info, purpose_loan and src_down_payment column values stored as integers
    Given I choose credit report option
    And I select agree and Next
    When I am able to submit the application
    Then The values of the following fields are stored as string
      | realtor_info                             | purpose_loan    | src_down_payment                              |
      | John Smith, 412-123-1234, john@gmail.com | Purchase a Home | Checking/Savings (most recent bank statement) |

  @DB @sprint5
  Scenario: Verify that est_purchase_price, down_payment< down_payment_percent, total_loan_amount, add-fund_available column values stored as integers
    Given I choose credit report option
    And I select agree and Next
    When I am able to submit the application
    Then The values of the these fields are stored as integers
      | est_purchase_price | down_payment | down_payment_percent |total_loan_amount |add_fund_available|
      | 10000              | 1000         | 10.00                | 9000.00           |                 |