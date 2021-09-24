package ningenme.net.api.application.controller.healthCheck;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ningenme.net.api.application.OkResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "HealthCheck")
@RestController
public class HealthCheckController {

  @ApiOperation(value = "HealthCheckGet")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
  })
  @GetMapping("/v1/healthcheck")
  ResponseEntity<OkResponse> getHealthCheck() {
    return ResponseEntity.ok(OkResponse.of());
  }
}
