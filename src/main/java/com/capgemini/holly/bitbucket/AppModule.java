package com.capgemini.holly.bitbucket;

import org.apache.camel.guice.CamelModuleWithMatchingRoutes;
import org.apache.camel.guice.jndi.JndiBind;

import com.capgemini.holly.bitbucket.apis.HealthApi;
import com.capgemini.holly.bitbucket.apis.RestConfiguration;
import com.capgemini.holly.bitbucket.beans.QueryParamMapper;
import com.google.inject.Provides;

public class AppModule extends CamelModuleWithMatchingRoutes { 

    @Override
    protected void configure() { 
        super.configure(); 
        bind(RestConfiguration.class);
        bind(HealthApi.class);
    }

    @Provides
    @JndiBind("queryParameterMapper")
    QueryParamMapper queryParamMapper() {
        return new QueryParamMapper();
    }    
}