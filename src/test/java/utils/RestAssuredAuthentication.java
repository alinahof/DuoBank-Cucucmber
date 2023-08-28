package utils;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;
import stepDefinitions.SharedData;

import java.util.List;

import static io.restassured.RestAssured.*;

public class RestAssuredAuthentication {



//    public RestAssuredAuthentication(SharedData sharedData) {
//        this.sharedData = sharedData;
//    }

    @Test
        public void basicAuth(){
        RestAssured.baseURI = ConfigReader.getProperty("api.base.uri");
            String username = "postman";
            String password = "password";

//        String base64Str = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
//        System.out.println(base64Str);

            given().
                    auth().basic(username, password).
//                header("Authorization" , "Basic " + base64Str).
        when().log().all().
                    get("/basic-auth").
                    then().log().all().
                    statusCode(200).
                    body("authenticated", Matchers.equalTo(true));
        }


        @Test
        public void apiKey(){
            RestAssured.baseURI = ConfigReader.getProperty("api.base.uri");
            given().

                    queryParam("id" , "12").
                    queryParam("api_key" , "c8a912d7d1c5a5a99c508f865b5eaae14a5b484f5bfe2d8f48c40e46289b47f3").
                    when().log().all().
                    get("/user").
                    then().log().all().
                    statusCode(200);
        }


        @Test
        public void bearerToken() {


            RestAssured.baseURI = ConfigReader.getProperty("api.base.uri");

            given().
                    queryParam("api_key", ConfigReader.getProperty("api.key.duobank")).
                    header("Accept", "application/vnd.github+json").

                    when().log().all().
                    get("/applications").

                    then().log().all().
                    assertThat().
                    statusCode((200));

        }



        @Test
        public void JWTToken() {

            baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";

            // Obtain the jwt token through /login endpoint
            String access_token = given()
                    .queryParam("api_key", ConfigReader.getProperty("api.key.duobank"))
                    .header("Accept", "application/json")
                    .header("Content-type", "application/json")
                    .body("""
        {
          "username": "123123example",
           "email": "123123123@mail.com",
          "password": "One23!example"
        }
    """)
                    .when().log().all()
                    .post("/login")
                    .then().log().all().statusCode(200)
                    .extract().path("access_token");



            List<String> user;
            user = given().
                    queryParam("api_key", ConfigReader.getProperty("api.key.duobank")).
                    header("Accept", "application/json").
                    header("Authorization", access_token).

                    when().log().all().
                    get("mortgage id").
                    then().log().all().statusCode(200).extract().path("mortgage.id");


            //
            //


        }


        @Test
        public void Oauth2() {


            // Obtain the code
            //obtain the access token from the authorization server

            String token =   given().
                    queryParam("client_id", "e5e0a681aac72c70b39e").
                    queryParam("client_secret", "f00f0b700dbe46150bd5c7b35840dd3a94acd33a").
                    queryParam("code", "11360500a31053943cc3"). // temporary code needs to be obtained every time
                            header("Accept", "application/json").
                    when().log().all().
                    post("https://github.com/login/oauth/access_token").

                    then().log().all().
                    statusCode(200).extract().path("access_token");


            // Sent a request to the API endpoint using the access token

            given().
                    header("Authorization", "Bearer " + token).
                    when().log().all().
                    get("https://api.github.com/user").
                    then().log().all().statusCode(200);
        }


    }


