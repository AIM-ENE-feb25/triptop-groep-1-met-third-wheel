package org.trip.top.auth;

import java.util.Map;
import org.springframework.web.client.RestTemplate;

public abstract class AuthStrategy {
  protected final RestTemplate restTemplate;
  protected final String authApiLink;
  protected final String strategyName;

  protected AuthStrategy(RestTemplate restTemplate, String authApiLink, String strategyName) {
    this.restTemplate = restTemplate;
    this.authApiLink = authApiLink;
      this.strategyName = strategyName;
  }

  public abstract boolean authenticate(Map<String, String> requestParams);
}
