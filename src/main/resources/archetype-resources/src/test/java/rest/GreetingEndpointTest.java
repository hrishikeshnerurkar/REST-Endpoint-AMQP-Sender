#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest;

import static com.jayway.restassured.RestAssured.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ${package}.App;
import com.jayway.restassured.RestAssured;

@RunWith ( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration ( classes = App.class )
@WebAppConfiguration
@IntegrationTest ( "server.port:0" )
public class GreetingEndpointTest {

    @Value ( "${symbol_dollar}{local.server.port}" )
    int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void testDeliverGreeting() throws Exception {
        when().get( "/{greeting}", "Spring Boot" ).then().equals( true );
    }
}
