package ningenme.net.api.application.controller.HealthCheckGetController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckGetController {

  @GetMapping("/v1/healthcheck")
  ResponseEntity<String> getHealthCheck() {
    return ResponseEntity.ok("ko");
  }
}
