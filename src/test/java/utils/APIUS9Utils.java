package utils;

import io.restassured.RestAssured;
import org.junit.Test;
import stepDefinitions.SharedData;

import java.util.List;

import static io.restassured.RestAssured.given;

public class APIUS9Utils {




    @Test
    public void bearerToken() {

        RestAssured.baseURI = ConfigReader.getProperty("api.base.uri");

        given()
                .queryParam("api_key",ConfigReader.getProperty("api.key.duobank"))
                .header("Accept", "application/vnd.github+json")
                .when().log().all()
                .get("/applications")
                .then().log().all()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void JWTToken() {
    RestAssured.baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";


    String access_token = given()
            .queryParam("api_key", ConfigReader.getProperty("api.key.duobank"))
            .header("Accept", "application/json")
            .header("Content-type", "application/json")
            .body("""
            {
              "id": "1198",
              "email": "123123123@mail.com",
              "password": "One23!example"
            }
        """)
            .when().log().all()
            .post("/login")
            .then().log().all().statusCode(200)
            .extract().path("access_token");
    SharedData sharedData = new SharedData();

    sharedData.setJWTToken(access_token);
        System.out.println(access_token);

    String jwtToken = sharedData.getJWTToken();

    List<String> mortgageIds = given()
            .queryParam("api_key", ConfigReader.getProperty("api.key.duobank"))
            .header("Accept", "application/json")
            .header("Authorization", "Bearer " + jwtToken)
            .when().log().all()
            .get("mortgage id")
            .then().log().all().statusCode(200)
            .extract().path("mortgage.id");

    }
}

