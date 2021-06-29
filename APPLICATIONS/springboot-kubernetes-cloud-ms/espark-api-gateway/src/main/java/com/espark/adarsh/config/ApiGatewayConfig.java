package com.espark.adarsh.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/*
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 9/7/20 12:12 AM#$
 */
@Slf4j
@Configuration
public class ApiGatewayConfig {

    @Autowired
    ServiceUrlConfig serviceUrlConfig;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        log.info("label=ApiGatewayConfig gatewayRoutes()");
        RouteLocatorBuilder.Builder routesBuilder = builder.routes();
        serviceUrlConfig.getServices().forEach(serviceUrl -> {
            List<ServiceUrlConfig.ServiceUrl.Header> requestHeaderList = serviceUrl.getRequestHeader();
            List<ServiceUrlConfig.ServiceUrl.Header> responseHeaderList = serviceUrl.getResponseHeader();
            routesBuilder.route(r -> r.path(serviceUrl.getUrlPattern())
                    .filters(filter -> addHeaders(filter, requestHeaderList, responseHeaderList))
                    .uri(serviceUrl.getForwardUrl())
                    .id(serviceUrl.getServiceId()));
        });
        return routesBuilder.build();
    }

    private static GatewayFilterSpec addHeaders(GatewayFilterSpec filterSpec,
                                                List<ServiceUrlConfig.ServiceUrl.Header> requestHeaderList,
                                                List<ServiceUrlConfig.ServiceUrl.Header> responseHeaderList) {
        log.info("label=ApiGatewayConfig addHeaders()");
        if (requestHeaderList != null && !requestHeaderList.isEmpty()) {
            requestHeaderList.forEach(requestHeader -> {
                filterSpec.addRequestHeader(requestHeader.getHeaderName(), requestHeader.getHeaderValue());
            });
        }

        if (responseHeaderList != null && !responseHeaderList.isEmpty()) {
            responseHeaderList.forEach(responseHeader -> {
                filterSpec.addResponseHeader(responseHeader.getHeaderName(), responseHeader.getHeaderValue());
            });
        }
        return filterSpec;
    }

}