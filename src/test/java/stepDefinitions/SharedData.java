package stepDefinitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;

import java.util.List;

import static io.restassured.RestAssured.given;

@Data
public class SharedData {

    private String password;
    private String username;
    private String randomEmail;
    private String randomPlaylistName;
    private String first;
    private String last;
    private String email;
    private String passMD5;
    private List<String> dbColumnNames;
    private List<String> emailsColumn;

    private String firstNameEE;
    private String lastNameEE;
    private String emailEE;
    private String passwordEE;
    private List<String> income_source;
    private List<String> column;

    private RequestSpecification requestSpecification = given();
    private Response response;

    private String JWTToken;

    public String getJWTToken() {
        return JWTToken;
    }

    public void setJWTToken(String JWTToken) {
        this.JWTToken = JWTToken;
    }

    private List<Object> idList;
}

