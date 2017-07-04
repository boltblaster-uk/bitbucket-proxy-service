package com.capgemini.holly.bitbucket.apis;

import org.apache.camel.builder.RouteBuilder;
import org.eclipse.jetty.http.HttpStatus;

import com.google.common.net.MediaType;

public class HealthApi extends RouteBuilder { 

    @Override
    public void configure() throws Exception { 
    rest("/health")
        .get()
            .id("HealthApi")
            .description("HealthApi Check Endpoint for the Service")
          .produces(MediaType.PLAIN_TEXT_UTF_8.subtype())
          .responseMessage()
            .code(HttpStatus.OK_200)
            .message(HttpStatus.getMessage(HttpStatus.OK_200))
          .endResponseMessage()
          .route()
            .routeId("PingRoute")
            .transform(constant("pong"))
        .end();           
    }
}