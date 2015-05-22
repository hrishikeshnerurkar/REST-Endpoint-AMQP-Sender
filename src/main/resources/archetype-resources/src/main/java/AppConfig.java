#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import ${package}.rest.GreetingEndpoint;

@Configuration
public class AppConfig {

    @Named
    static class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            register( GreetingEndpoint.class );
        }
    }
}
