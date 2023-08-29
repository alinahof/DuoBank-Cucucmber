@api_only
@API

Feature: POST /login API endpoint features


  Scenario: Generate a JWT token

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








