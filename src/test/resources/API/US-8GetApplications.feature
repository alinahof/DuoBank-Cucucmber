@API
@api_only

Feature: GET /applications API endpoint features

  Background:
    Given the request is authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    And the request body is set to the following payload as map
      | email  | rschwand0@soundcloud.com            |
      | password | aD2Z_oq+k'2b     |
    When I send a "POST" request to the endpoint "/login"
    Then the response log should be displayed
    Then the response status code should be 200
#    And the response time should be less than 1000 ms
    And the response access token is stored



  Scenario: The API should require an authentication via API key - negative scenario

    Given the request is not authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    When I send a "GET" request to endpoint "/applications"
    Then the response log should be displayed
    Then the response status code should be 401
    Then the response body should have "message" field with value "Invalid or missing API Key. Provide a valid api key with 'api_key' query parameter."


  Scenario: The API should require an authentication via API key

    Given the request is authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    And the JWT token is set in the header
    When I send a "GET" request to endpoint "/applications"
    Then the response log should be displayed
    Then the response status code should be 200

  @today
Scenario: Retrieve applications information
  Given the request is authenticated with a valid API key
  And the request "Content-type" header is set to "application/json"
  And the JWT token is set in the header
  When I send a "GET" request to endpoint "/applications"
  Then the response log should be displayed
  Then the response status code should be 200
    And the response "Content-Type" header should be "application/json; charset=UTF-8"
  And the response should contain a list of all applicants with the following fields
    | id                |
    | b_firstName       |
    | b_lastName        |
    | b_middleName      |
    | total_loan_amount |


