@api_only
@API @smoke


Feature: User-7 Login API

  Scenario: Successful user login
    Given the request is authenticated with a valid API key
    Given the API endpoint accepts a "POST" request to "/login" resource
    And the API requires authentication via API key
    And the request contains a body payload with valid user "email" and "password"
    When the user makes a "POST" request to "/login"
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response log should contain "success": true
    And the response body should contain a non-empty "access_token" field
    And the response body should contain "token_type": "Bearer"
    And the response body should contain "expires_in" field
    And the response body should contain "message": "You've successfully logged in!"
    And the response time is less than 1000 ms

  Scenario: Unsuccessful user login due to missing API key
    Given the request is authenticated with a valid API key
    When the user makes a "POST" request to "/login" without an API key
    Then the response status code should be 401
    And the response body should contain "error" message: "Invalid Email Address!"


  Scenario Outline: Unsuccessful user login due to incorrect email format
    Given the API endpoint accepts a "POST" request to "/login" resource
    And the request contains a body payload with invalid email format
    When the user makes a "POST" request to "/login"
    Then the response status code should be 422
    And the response body should contain "error" message: "Invalid Email Address!"
    Examples:
    email  | password  |

    johnD.com | John123!  |

  Scenario: Unsuccessful user login due to missing fields
    Given the API endpoint accepts a "POST" request to "/login" resource
    And the request contains a body payload with missing email or password fields
    When the user makes a "POST" request to "/login"
    Then the response status code should be 422
    And the response body should contain "error" message: "Please fill in all required fields!"


  Scenario Outline: Unsuccessful user login due to incorrect password
    Given the API endpoint accepts a "POST" request to "/login" resource
    And the request contains a body payload with correct password but incorrect email
    When the user makes a "POST" request to "/login"
    Then the response status code should be 422
    And the response body should contain "error" message: "Invalid Password!"
    Examples:
    email  | password  |

    johndoe@gmail.com | 123455....  |

  Scenario: Unsuccessful user login due to server error
    Given the API endpoint accepts a "POST" request to "/login" resource
    And the request contains a body payload with valid user email and password
    When the user makes a "POST" request to "/login"
    And there's an error on the server side
    Then the response status code should be 500
    And the response body should contain "error" message: "Server Error"


