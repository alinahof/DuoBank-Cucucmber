


Feature: API User Story 1 for API endpoint testing

  @API
  Scenario: The API should require a authentication key for access
    And "Accept" header is set to "application/json"
    And "x-api-key" header is set to "c8a912d7d1c5a5a99c508f865b5eaae14a5b484f5bfe2d8f48c40e46289b47f3"
    When I send a "GET" request to endpoint "/users"

  @API
  Scenario: The API should have fields in the body of the JSON
    And "Accept" header is set to "application/json"
    And "x-api-key" header is set to "c8a912d7d1c5a5a99c508f865b5eaae14a5b484f5bfe2d8f48c40e46289b47f3"
    When I send a "GET" request to endpoint "/users"
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

  @API
  Scenario: The API should complete a request under 500ms
    And "Accept" header is set to "application/json"
    And "x-api-key" header is set to "c8a912d7d1c5a5a99c508f865b5eaae14a5b484f5bfe2d8f48c40e46289b47f3"
    When I send a "GET" request to endpoint "/user?id=12"
    And response time should be less than 500 ms

  @API
  Scenario: The API should allow you to choose the amount of results on the request
    And "Accept" header is set to "application/json"
    And "x-api-key" header is set to "c8a912d7d1c5a5a99c508f865b5eaae14a5b484f5bfe2d8f48c40e46289b47f3"
    When I send a "GET" request to endpoint "/users"
    And "pages" query Parameter is set to "2"
    And response time should be less than 500 ms