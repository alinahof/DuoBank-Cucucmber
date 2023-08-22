@api_only
@API @smoke
Feature: GET /user API endpoint features


  Scenario: Retrieve a single user with valid id

    Given the request is authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    And the request "id" query parameter is set to "12"
    When I send a "GET" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 500 ms
    And the response body should have "id" field with value "12"
    And the response body should have "first_name" field with value "Mary"
    And the response body should have "last_name" field with value "Clinton"
    And the response body should have "email" field with value "Clinton@mail.com"
    And the response body should have "created_at" field with value "2023-04-18 18:31:09"




  Scenario Outline: Retrieve a single user data driven

    Given the request is authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    And the request "id" query parameter is set to "<id>"
    When I send a "GET" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 500 ms
    And the response body should have "id" field with value "<id>"
    And the response body should have "modified_at" field with value "<modified_at>"
    And the response body should have "first_name" field with value "<first_name>"
    And the response body should have "last_name" field with value "<last_name>"
    And the response body should have "email" field with value "<email>"
    And the response body should have "created_at" field with value "<created_at>"

    Examples:
      | id | email                   | first_name | last_name  | modified_at         | created_at           |
      | 12 | Clinton@mail.com        | Mary   | Clinton    | 2023-08-21 16:16:09 | 2023-04-18 18:31:09 |
      | 13 | russell.terry@gmail.com | Ethan      | Cartwright |                     | 2023-04-18 18:34:18 |


  Scenario: Retrieve a single user with invalid id, negative test with valid input

    Given the request is authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    And the request "id" query parameter is set to "1"
    When I send a "GET" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 404
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 500 ms
    And the response body should have "message" field with value "User not found."


  Scenario: Retrieve a single user with no id, negative test with invalid input, missing id

    Given the request is authenticated with a valid API key
    And the request "Content-type" header is set to "application/json"
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 422
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 500 ms
    And the response body should have "message" field with value "Missing or Invalid Required Fields!"