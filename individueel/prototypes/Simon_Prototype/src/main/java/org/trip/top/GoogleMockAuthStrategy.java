package org.trip.top;

import java.util.Map;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GoogleMockAuthStrategy extends AuthStrategy {
  public GoogleMockAuthStrategy(RestTemplate restTemplate) {
    super(restTemplate, "http://localhost:8001/auth?token=", "googleMock");
  }

  @Override
  public boolean authenticate(Map<String, String> headers) {
    System.out.println("Strategy: " + strategyName);

    RequestBody requestBody = new RequestBody(headers.get("username"));

    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<RequestBody> request = new HttpEntity<>(requestBody, httpHeaders);

    ResponseEntity<Void> response =
        restTemplate.postForEntity(authApiLink + headers.get("token"), request, Void.class);

    return response.getStatusCode().is2xxSuccessful();
  }

  private record RequestBody(String username, String application) {
    public RequestBody {
      application = "triptop";
    }

    public RequestBody(String username) {
      this(username, null);
    }
  }
}
