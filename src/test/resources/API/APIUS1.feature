
@api_only
@API @smoke

Feature: API User Story 1 for API endpoint testing



 Scenario: Retrieve all users successfully

   Given the request is authenticated with a valid API key
   And the request "Content-type" header is set to "application/json"
   When I send a "GET" request to the endpoint "/users"
   Then the response log should be displayed
   Then the response status code should be 200
   And the response "Content-Type" header should be "application/json"
   And the response time should be less than 500 ms
   And the response should contain a list of all users with the following fields
     | id          |
     | email       |
     | first_name  |
     | last_name   |
     | phone       |
     | image       |
     | type        |
     | created_at  |
     | modified_at |
     | zone_id     |
     | church_id   |
     | active      |

  Scenario: Invalid api key

    Given the request is not authenticated with a valid API key
    And the request "Content-Type" header is set to "application/json"
    When I send a "GET" request to the endpoint "/users"
    Then the response log should be displayed
    Then the response status code should be 401
    Then the response body should have "message" field with value "Invalid or missing API Key. Provide a valid api key with 'api_key' query parameter."


  Scenario: Invalid method type

    Given the request is authenticated with a valid API key
    And the request "Content-Type" header is set to "application/json"
    When I send a "POST" request to the endpoint "/users"
    Then the response log should be displayed
    Then the response status code should be 405
    Then the response body should have "message" field with value "Invalid request method"


    Scenario: Return Users using "Pagination"
      Given the request is authenticated with a valid API key
      And the request "Content-Type" header is set to "application/json"
      When I send a "GET" request to the endpoint "/users"
      Then the response log should be displayed
      Then the response status code should be 200
      And the response "Content-Type" header should be "application/json"
      And the request "per_page" header is set to "2"

