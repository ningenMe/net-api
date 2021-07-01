package ningenme.net.api.application.controller.applicationMetaGet;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.service.ApplicationMetaService;
import ningenme.net.api.domain.value.ApplicationMetaId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApplicationMetaGetController {

  private final ApplicationMetaService applicationMetaService;

  @ApiOperation(value = "ApplicationMetaGet")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
  })
  @GetMapping("/v1/application-metas/{applicationMetaId}")
  ResponseEntity<ApplicationMetaGetResponse> getApplicationMetaLatest(
          @PathVariable("applicationMetaId") String applicationMetaId) {
    return ResponseEntity
            .ok(
                    ApplicationMetaGetResponse.of(applicationMetaService.get(ApplicationMetaId.of(applicationMetaId)))
               );
  }

}