package org.trip.top;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Order(1)
public class InboundRequestFilter implements GlobalFilter, Ordered {
  private final AuthStrategyFactory authStrategyFactory;

  public InboundRequestFilter(AuthStrategyFactory authStrategyFactory) {
    this.authStrategyFactory = authStrategyFactory;
  }

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    ServerHttpRequest request = exchange.getRequest();

    var parameterMap = request.getHeaders().toSingleValueMap();

    try {
      AuthStrategy authStrategy = authStrategyFactory.getStrategy(parameterMap.get("auth-type"));
      boolean isAuthenticated = false;
      isAuthenticated = authStrategy.authenticate(parameterMap);

      if (isAuthenticated) {
        return chain.filter(exchange);
      }
    } catch (Exception ignored) {
    }

    exchange.getResponse().setStatusCode(UNAUTHORIZED);
    return exchange.getResponse().setComplete();
  }

  @Override
  public int getOrder() {
    return Ordered.HIGHEST_PRECEDENCE;
  }
}
