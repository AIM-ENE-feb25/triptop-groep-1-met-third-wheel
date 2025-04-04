package org.trip.top.auth;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.trip.top.auth.IAuthStrategy;

@Component
public class AuthStrategyFactory {
  private final RestTemplate restTemplate = new RestTemplate();

  public IAuthStrategy getStrategy(String authType) {
    return switch (authType) {
      case "mock" -> new MockAuthStrategy(restTemplate);
      case "google" -> new GoogleMockAuthStrategy(restTemplate);
      case "local" -> new MockLocalAuthStrategy();
      default -> throw new IllegalArgumentException("Unknown auth type: " + authType);
    };
  }
}
