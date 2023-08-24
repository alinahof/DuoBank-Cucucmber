@API
@api_only
Feature: Delete / User


Scenario: Create a new user and delete the user

Given the request is authenticated with a valid API key
And the request "Content-type" header is set to "application/json"
And the request body is set to the following payload as pojo
  | first_name | Jamal           |
  | last_name  | Owens           |
  | email      | owensj@mail.com |
  | password   | OJsmith123!     |

When I send a "POST" request to endpoint "/user"
Then the response log should be displayed
Then the response status code should be 201
Then the response body should have "message" field with value "The user has been created."
And the response "Content-Type" header should be "application/json"
And the response time should be less than 500 ms
And I delete the created user