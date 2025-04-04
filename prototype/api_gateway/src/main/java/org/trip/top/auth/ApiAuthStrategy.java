package org.trip.top.auth;

import org.springframework.web.client.RestTemplate;

public abstract class ApiAuthStrategy implements IAuthStrategy {
  protected final RestTemplate restTemplate;
  protected final String authApiLink;

  protected ApiAuthStrategy(RestTemplate restTemplate, String authApiLink) {
    this.restTemplate = restTemplate;
    this.authApiLink = authApiLink;
  }
}
