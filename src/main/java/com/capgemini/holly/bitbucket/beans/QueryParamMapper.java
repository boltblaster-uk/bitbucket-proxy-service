package com.capgemini.holly.bitbucket.beans;

import java.util.Arrays;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Header;

import spark.utils.StringUtils;

public class QueryParamMapper { 
  public void mapQueryParameters(@Header(Exchange.HTTP_QUERY) final String queryParams, Exchange exchange) {
    if(StringUtils.isNotEmpty(queryParams)) {
      List<String> parameters = Arrays.asList(queryParams.split("&"));
      parameters.forEach(parameter -> {
        String[] parts = parameter.split("=");
        exchange.getIn().setHeader(parts[0], parts[1]);
      });
    }
  }      
}