package com.capgemini.holly.bitbucket.apis;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;

public class RestConfiguration extends RouteBuilder { 

    @Override
    public void configure() throws Exception { 
        restConfiguration()
            .component("spark-rest")
            .port(System.getProperty("port", "0"))
            .contextPath("/bitbucket-proxy-service")
            .skipBindingOnErrorCode(false)
            .apiContextPath("api-doc")
            .apiProperty("api.title", "Bitbucket Proxy Service")
            .apiProperty("api.version", "1.0")
            .apiProperty("cors", "true")
            .apiContextRouteId("doc-api")
            .bindingMode(RestBindingMode.json);
    }
}