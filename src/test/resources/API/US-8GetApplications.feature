@API
@api_only

Feature: GET /applications API endpoint features

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
    When I send a "GET" request to endpoint "/applications"
    Then the response log should be displayed
    Then the response status code should be 200
