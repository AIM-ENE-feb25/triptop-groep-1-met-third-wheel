package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class MockIdProvider {
  @PostMapping("")
  public ResponseEntity<Void> auth(@RequestParam String token, @RequestBody AuthRequest request) {
    System.out.println(request);
    System.out.println(token);
    if (request.application().equals("triptop")
        && request.username().equals("edevries")
        && token.equals("ju5fdqkszix8cud2")) {
      return ResponseEntity.ok(null);
    }
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
  }

  private record AuthRequest(String username, String application) {}
}
