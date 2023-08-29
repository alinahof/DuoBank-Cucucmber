package utils;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import stepDefinitions.SharedData;

import java.util.List;

import static io.restassured.RestAssured.*;

public class RestAssuredAuthentication {
//    SharedData sharedData;
//
//
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
            SharedData sharedData = new SharedData();

            RestAssured.baseURI = "https://api.github.com";

            given()
                    .queryParam("api_key", ConfigReader.getProperty("api.key.duobank"))
                    .header("Authorization", "Bearer " + sharedData.getJWTToken())
                    .header("Accept", "application/json")
                    .when().log().all()
                    .get("/applications")
                    .then().log().all()
                    .assertThat()
                    .statusCode(200);
        }



        @Test
        public void JWTToken() {
            SharedData sharedData = new SharedData();

            baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";


            String access_token = given()
                    .queryParam("api_key", ConfigReader.getProperty("api.key.duobank"))
                    .header("Accept", "application/json")
                    .header("Content-type", "application/json")
                    .body("""
        {
          "username": "coolguy",
           "email": "coolguy@mail.com",
          "password": "coolGuy123!"
        }
    """)
                    .when().log().all()
                    .post("/login")
                    .then().log().all().statusCode(200)
                    .extract().path("access_token");

            sharedData.setJWTToken(access_token);

            String jwtToken = sharedData.getJWTToken();

            Response response = given()
                    .queryParam("api_key", ConfigReader.getProperty("api.key.duobank"))
                    .header("Accept", "application/json")
                    .header("Authorization",  jwtToken)
                    .when().log().all()
                    .get("/applications")
                    .then().log().all().statusCode(200)
                    .extract().response();

            String applicationInfo = response.path("applications.application");

            System.out.println(applicationInfo);
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


