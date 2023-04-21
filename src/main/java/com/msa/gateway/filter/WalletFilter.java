package com.msa.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class WalletFilter extends AbstractGatewayFilterFactory<Config> {
    public WalletFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            log.info("WalletFilter baseMessage: {}", config.getBaseMessage());
            if (config.isPreLogger()) {
                log.info("WalletFilter Start: {}", exchange.getRequest());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if (config.isPostLogger()) {
                    log.info("WalletFilter End: {}", exchange.getResponse());
                }
            }));
        };

    }
}
