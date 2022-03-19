package ningenme.net.api.application.controller.healthCheck;

import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.generated.api.HealthCheckApi;
import ningenme.net.api.application.generated.model.HealthCheckGetResponseView;
import ningenme.net.api.application.service.HealthCheckGetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthCheckController implements HealthCheckApi {

    private final HealthCheckGetService healthCheckGetService;

    @Override
    public ResponseEntity<HealthCheckGetResponseView> healthCheckGet() {
        return ResponseEntity.ok(
            healthCheckGetService.getHealthCheckGetResponseView()
        );
    }
}
