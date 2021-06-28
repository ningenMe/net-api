package ningenme.net.api.application.controller.applicationMetaPost;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.application.OkResponse;
import ningenme.net.api.domain.service.ApplicationMetaService;
import ningenme.net.api.domain.value.ApplicationMetaId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApplicationMetaPostController {

  private final ApplicationMetaService applicationMetaService;

  @ApiOperation(value = "ApplicationMetaPost")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "OK"),
  })
  @PostMapping("/v1/application-metas/{applicationMetaId}")
  ResponseEntity<OkResponse> postApplicationMeta(
          @PathVariable("applicationMetaId") String applicationMetaId) {
    applicationMetaService.post(ApplicationMetaId.of(applicationMetaId));
    return ResponseEntity
            .ok(OkResponse.of());
  }

}
