package webserviceTest;

import connections.RestAssureConnections;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static connections.RestAssureConnections.getRequest;
import static connections.RestAssureConnections.postRequest;

public class WebServicetest {

    @Test
    void testPost(){
        //Request to send
        String jsonRequest = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
        //Calling service
        Response response = postRequest(jsonRequest, "http://dummy.restapiexample.com/create");

        response.prettyPrint();

        //testing that the response is not null
        Assertions.assertNotNull(response.getBody());

    }

    @Test
    void testGet(){

        //Calling service
        Response response = getRequest("http://dummy.restapiexample.com/api/v1/employees", null);

        response.prettyPrint();

        //testing that the response is not null
        Assertions.assertNotNull(response.getBody());
    }
}
