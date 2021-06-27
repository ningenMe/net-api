package ningenme.net.api.application.controller.healthCheckGet;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "HealthCheck")
@RestController
public class HealthCheckGetController {

  @ApiOperation(value = "HealthCheckGet")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
  })
  @GetMapping("/v1/healthcheck")
  ResponseEntity<String> getHealthCheck() {
    return ResponseEntity.ok("ok");
  }
}
