#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest;

import java.util.Optional;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;

import ${package}.amqp.Producer;

@Named
@Path ( "/" )
public class GreetingEndpoint {

    @Autowired
    Producer producer;

    @Path ( "{greeting}" )
    @GET
    public Boolean deliverGreeting( @PathParam ( "greeting" ) final String greeting ) {
        Optional<String> greetingValue = Optional.of( greeting );
        String newGreetingValue = greetingValue.map( f -> "Hello " + f ).orElse( "Hello World" );
        return producer.produce( newGreetingValue );
    }
}
