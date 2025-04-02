package org.trip.top.auth;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.trip.top.auth.AuthStrategy;

@Component
public class AuthStrategyFactory {
  private final RestTemplate restTemplate = new RestTemplate();

  public AuthStrategy getStrategy(String authType) {
    return switch (authType) {
      case "mock" -> new MockAuthStrategy(restTemplate);
      case "google" -> new GoogleMockAuthStrategy(restTemplate);
      default -> throw new IllegalArgumentException("Unknown auth type: " + authType);
    };
  }
}
