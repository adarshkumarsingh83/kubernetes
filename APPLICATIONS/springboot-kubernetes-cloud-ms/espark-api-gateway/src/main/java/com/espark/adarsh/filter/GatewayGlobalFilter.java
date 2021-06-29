package com.espark.adarsh.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/*
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 9/7/20 12:12 AM#$
 */

@Slf4j
@Component
public class GatewayGlobalFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {
        log.info("label=GatewayGlobalFilter filter() request execution");
        Mono<Void> v = chain.filter(exchange);
        log.info("label=GatewayGlobalFilter filter() response execution");
        return v;
    }
}
