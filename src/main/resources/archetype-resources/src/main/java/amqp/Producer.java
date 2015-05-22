#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Producer.java
 * 
 * Copyright (c) 2015 by General Electric Company. All rights reserved.
 * 
 * The copyright to the computer software herein is the property of General Electric Company. The software may be used
 * and/or copied only with the written permission of General Electric Company or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the software has been supplied.
 */
package ${package}.amqp;

import javax.annotation.PostConstruct;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 502287061
 */
@Component
public class Producer {

    @Value ( value = "${symbol_dollar}{queueName}" )
    String queueName;
    
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @PostConstruct
    public void setUpQueue() {
        this.amqpAdmin.declareQueue( new Queue( "foo" ) );
    }

    public boolean produce( String message ) {
        try {
            this.rabbitTemplate.convertAndSend( queueName, message );
            return true;
        } catch ( AmqpException ae ) {
            System.err.println( ae );
            return false;
        }
    }
}
