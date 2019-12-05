package connections;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class RestAssureConnections {

    private static final String APPLICATION_JSON = "application/json";

    public static Response postRequest(String jsonRequest, String URL){


        RequestSpecification requestSpecification = getBaseRequest(URL);

        //Post body is set
        requestSpecification.body(jsonRequest);

        //Making post request
        return given().spec(requestSpecification).when().post();

    }

    public static Response getRequest(String URL, String [] params){

        final RequestSpecification requestSpecification = getBaseRequest(URL);

        if(params != null){
            List <String> paramsList = Arrays.asList(params);
            //If there are parameter in the get call, you can set them here
            paramsList.forEach( param -> requestSpecification.pathParams(param, param));
        }

        return given().spec(requestSpecification).when().get();
    }

    /**
     * Generates a base request
     * @param url - The service to be hit
     * @return Request object to send by Rest Assured
     */
    private static RequestSpecification getBaseRequest(String url){
        return given().relaxedHTTPSValidation().urlEncodingEnabled(false).contentType(APPLICATION_JSON).accept(APPLICATION_JSON).baseUri(url);
    }

}
