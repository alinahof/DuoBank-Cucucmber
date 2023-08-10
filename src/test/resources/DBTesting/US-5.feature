Feature: Employment and income details

  @DB
  Scenario: verify column names for tbl_mortgage table
    When I retrieve the column names from the "tbl_mortagage" table
    Then it should have the following
      | employer_name          |
      | position               |
      | city                   |
      | state                  |
      | start_date             |
      | end_date               |
      | current_job            |
      | co_employer_name       |
      | co_position            |
      | co_city                |
      | co_state               |
      | co_start_date          |
      | co_end_date            |
      | co_current_job         |
      | gross_monthly_income   |
      | monthly_over_time       |
      | monthly_bonuses        |
      | monthly_commision    |
      | monthly_dividents      |
      | c_gross_monthly_income |
      | c_monthly_over_time     |
      | c_monthly_bonuses      |
      | c_monthly_commision  |
      | c_monthly_dividents    |
      | add_belong             |
      | income_source          |
      | amount                 |

  @DB
  Scenario: Verify income source
    When I send a query to retrieve income_source from the db
    Then The result should contain the following sources
      | Alimony/Child Support             |
      | Social Security/Disability Income |
      | Unemployment Benefits             |
      | Interest and Dividends            |
      | VA Compensation                   |
      | Royalty Payments                  |
      | Other Types of Income             |

    @DB @today
    Scenario Outline: Verify employer_name and gross_monthly_income columns should be required and not empty
      When I send a query to retrieve "<column>" from DB
      Then These columns should not be empty
      Examples:
        |column|
        |employer_name|
        |gross_monthly_income|


