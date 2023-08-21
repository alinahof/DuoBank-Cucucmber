@API
@api_only
  Feature: POST /user API endpoint features


    Scenario: The API should require an authentication via API key

      Given the request is not authenticated with a valid API key
      And the request "Content-type" header is set to "application/json"
      When I send a "POST" request to endpoint "/user"
      Then the response log should be displayed
      Then the response status code should be 401
      Then the response body should have "message" field with value "Invalid or missing API Key. Provide a valid api key with 'api_key' query parameter."


    Scenario Outline: Create a new user negative scenario - empty fields

      Given the request is authenticated with a valid API key
      And the request "Content-type" header is set to "application/json"
      And the request body is set to the following payload
      """
      {
        "firstName": "<firstName>",
        "lastName": "<lastName>",
        "email": "<email>",
        "password": "<password>"
      }
      """

      When I send a "POST" request to endpoint "/user"
      Then the response log should be displayed
      Then the response status code should be 422
      Then the response body should have "message" field with value "Missing or Invalid Required Fields!"
      Examples:
        | firstName | lastName | email               | password  |
        |           |          |                     |           |
        | John      | Smith    | johnsmith@gmail.com |           |
        |           | Smith    | johnsmith@gmail.com | John123!  |
        | John      |          | johnsmith@gmail.com | John123!  |
        | John      | Smith    |                     | John123!  |



    Scenario Outline: Create a new user negative scenario - invalid email field

      Given the request is authenticated with a valid API key
      And the request "Content-type" header is set to "application/json"
      And the request body is set to the following payload
      """
      {
        "firstName": "<firstName>",
        "lastName": "<lastName>",
        "email": "<email>",
        "password": "<password>"
      }
      """

      When I send a "POST" request to endpoint "/user"
      Then the response log should be displayed
      Then the response status code should be 422
      Then the response body should have "message" field with value "Invalid Email Address!"
      Examples:
        | firstName | lastName | email               | password  |
        | John      | Smith    | johnsmith           | John123!  |



    Scenario: Create a new user positive scenario

      Given the request is authenticated with a valid API key
      And the request "Content-type" header is set to "application/json"
      And the request body is set to the following payload
      """
      {
        "firstName": "Johnkhbhk",
        "lastName": "Smithjjj",
        "email": "johhnjkknsmith@gmail.com",
        "password": "John123!"
      }
      """

      When I send a "POST" request to endpoint "/user"
      Then the response log should be displayed
      Then the response status code should be 201
      Then the response body should have "message" field with value "The user has been created."
      And the response "Content-Type" header should be "application/json"
      And the response time should be less than 500 ms
      And I delete the created user
#      Examples:
#        | firstName | lastName | email               | password  |
#        | Johnkhbhk      | Smithjjj    | johhnjkknsmith@gmail.com           | John123!  |



#        | John      | Smith    | johnsmith@gmail.com | John12    |
#        | John      | Smith    | johnsmith@gmail.com | john123!  |
#        | John      | Smith    | johnsmith@gmail.com | JOHN123!  |
#        | John      | Smith    | johnsmith@gmail.com | Johnjohn! |
#        | John      | Smith    | johnsmith@gmail.com | John1234  |
#        | J         | Smith    | johnsmith@gmail.com | John123!  |
#        | John      | S        | johnsmith@gmail.com | John123!  |
#        | John      | Smith    | Clinton@mail.com    | John1234! |


