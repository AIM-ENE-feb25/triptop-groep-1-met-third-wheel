package org.trip.top.auth;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.trip.top.auth.IAuthStrategy;

@Component
public class AuthStrategyFactory {
  public IAuthStrategy getStrategy(String authType) {
    return switch (authType) {
      case "mock" -> new MockAuthStrategy();
      case "google" -> new GoogleMockAuthStrategy();
      case "local" -> new MockLocalAuthStrategy();
      default -> throw new IllegalArgumentException("Unknown auth type: " + authType);
    };
  }
}
